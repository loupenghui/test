package com.hzsun.test.kafka.util;

/**
 * @Description:
 * @Author: louph
 * @Date: 2020/2/24 0024
 */

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

/**
 * 实现自定义的生产者分区
 */
public class MyPartitioner implements Partitioner {


	/**
	 * 手机号码分区——区分移动，联通，电信
	 * <p>
	 * 135开头---->移动运营商---->0号分区
	 * 130开头---->联通运营商---->1号分区
	 * 180开头---->电信运营商---->2号分区
	 *
	 * @param topic      主题
	 * @param key
	 * @param keyBytes   key的字节数组
	 * @param value
	 * @param valueBytes
	 * @param cluster    集群信息
	 * @return
	 */
	public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
		//拿到主题下有几个分区
		//如果分区数不为3，那么可以进入0
		Integer count = cluster.partitionCountForTopic(topic);
		//分区值为;[0-count-1]

		String keyString = key.toString();

		if (count == 3 && keyString != null) {
			if (keyString.startsWith("135")) {
				return 0;
			} else if (keyString.startsWith("130")) {
				return 1;
			} else if (keyString.startsWith("180")) {
				return 2;
			}

		}
		return 0;
	}


	/**
	 * 关闭-如果不需要，就不要实现它
	 */
	public void close() {

	}


	/**
	 * 配置项--如果不需要，就不要实现它
	 *
	 * @param configs
	 */
	public void configure(Map<String, ?> configs) {

	}
}
