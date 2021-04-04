package com.hzsun.test.kafka.controller;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Properties;

/**
 * @Description:
 * @Author: louph
 * @Date: 2020/2/12 0012
 */
@Controller
public class TestController {
	@RequestMapping("/addkafka")
	@ResponseBody
	public String addKafka( String message, String topic){
		return message;
	}

	@RequestMapping("/product")
	@ResponseBody
	public String product( String topic, String msg){
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
		kafkaProducer.send(new ProducerRecord<String, String>(topic, msg));
		return "success";
	}
}
