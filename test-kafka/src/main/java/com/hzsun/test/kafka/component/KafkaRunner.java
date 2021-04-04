package com.hzsun.test.kafka.component;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.TopicPartition;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.*;

/**
 * @Description:
 * @Author: louph
 * @Date: 2020/2/20 0020
 */
@Component
@Order(1)
public class KafkaRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		consumer();
		producer();
	}

	//自动提交offset值
	private void consumer() {
		new Thread(() -> {
			// 1\连接集群
			Properties props = new Properties();
			props.put("bootstrap.servers", "aliyun:9092,aliyun:9093,aliyun:9094");
			props.put("group.id", "test");

			//以下两行代码 ---消费者自动提交offset值
			props.put("enable.auto.commit", "true");
			props.put("auto.commit.interval.ms", "1000");

			props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
			props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
			KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(props);
//  2、发送数据 发送数据需要，订阅下要消费的topic。  order
			kafkaConsumer.subscribe(Arrays.asList("louphtest3"));
			while (true) {
				ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(100);
				// jdk queue offer插入、poll获取元素。 blockingqueue put插入原生，take获取元素
				for (ConsumerRecord<String, String> record : consumerRecords) {
					System.out.println("消费的数据为：" + record.value());
				}
			}

		}).start();
	}

	//手动提交offset
	/*
	*如果Consumer在获取数据后，需要加入处理，数据完毕后才确认offset，需要程序来控制offset的确认？
	关闭自动提交确认选项
	props.put("enable.auto.commit", "false");
	手动提交offset值
	kafkaConsumer.commitSync();
	* */
	private void consumer2() {
		new Thread(() -> {
			Properties props = new Properties();
			props.put("bootstrap.servers", "aliyun:9092,aliyun:9093,aliyun:9094");
			props.put("group.id", "test");
			//关闭自动提交确认选项
			props.put("enable.auto.commit", "false");
			props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
			props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
			KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
			consumer.subscribe(Arrays.asList("louphtest3"));
			final int minBatchSize = 200;
			List<ConsumerRecord<String, String>> buffer = new ArrayList<>();
			while (true) {
				ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis((long)100));
				for (ConsumerRecord<String, String> record : records) {
					buffer.add(record);
				}
				if (buffer.size() >= minBatchSize) {

					//insertIntoDb(buffer);

					// 手动提交offset值
					consumer.commitSync();
					buffer.clear();
				}
			}
		}).start();
	}

	private void consumer3() {
		new Thread(() -> {
			Properties props = new Properties();
			props.put("bootstrap.servers", "aliyun:9092,aliyun:9093,aliyun:9094");
			props.put("group.id", "test");
			//关闭自动提交确认选项
			props.put("enable.auto.commit", "false");
			props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
			props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
			KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
			consumer.subscribe(Arrays.asList("louphtest3"));
			try {
				while (true) {
					ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis((long)Long.MAX_VALUE));
					for (TopicPartition partition : records.partitions()) {
						List<ConsumerRecord<String, String>> partitionRecords = records.records(partition);
						for (ConsumerRecord<String, String> record : partitionRecords) {
							System.out.println(record.offset() + ": " + record.value());
						}
						long lastOffset = partitionRecords.get(partitionRecords.size() - 1).offset();
						consumer.commitSync(Collections.singletonMap(partition, new OffsetAndMetadata(lastOffset + 1)));
					}
				}
			} finally {
				consumer.close();
			}
		}).start();
	}

	//手动指定分区
	private void consumer4() {
		new Thread(() -> {
			Properties props = new Properties();
			props.put("bootstrap.servers", "aliyun:9092,aliyun:9093,aliyun:9094");
			props.put("group.id", "test");

			//以下两行代码 ---消费者自动提交offset值
			props.put("enable.auto.commit", "true");
			props.put("auto.commit.interval.ms", "1000");

			props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
			props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
			KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(props);
			//手动指定消费指定分区的数据---start
			String topic = "foo";
			TopicPartition partition0 = new TopicPartition(topic, 0);
			TopicPartition partition1 = new TopicPartition(topic, 1);
			kafkaConsumer.assign(Arrays.asList(partition0, partition1));
			//手动指定消费指定分区的数据---end
			while (true) {
				ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis((long)100));
				// jdk queue offer插入、poll获取元素。 blockingqueue put插入原生，take获取元素
				for (ConsumerRecord<String, String> record : records) {
					System.out.println("消费的数据为：" + record.value());
				}
			}
		}).start();
	}

	private void producer() {
		new Thread(() -> {
			Properties props = new Properties();
			props.put("bootstrap.servers", "aliyun:9092,aliyun:9093,aliyun:9094");
			props.put("acks", "all");
			props.put("retries", 0);
			props.put("batch.size", 16384);
			props.put("linger.ms", 1);
			props.put("buffer.memory", 33554432);
			props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
			props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
			KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(props);
			kafkaProducer.send(new ProducerRecord<String, String>("louphtest3", "330681"));
		}).start();
	}
}
