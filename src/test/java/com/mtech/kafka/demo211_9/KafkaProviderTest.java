package com.mtech.kafka.demo211_9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;
import org.junit.Test;

public class KafkaProviderTest {

	
	
	public static void main(String[] args) {
		
	}
	@Test
	 public void createProducer() {  
		 Properties props = new Properties();
		 props.put("bootstrap.servers", "kafka.mtech.com.cn:9092");
		 props.put("acks", "all");
		 props.put("retries", 0);
		 props.put("batch.size", 16384);
		 props.put("linger.ms", 1);
		 props.put("buffer.memory", 33554432);
		 props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		 props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		 Producer<String, String> producer = new KafkaProducer<String, String>(props);
		 for(int i = 0; i < 100; i++){
			 System.out.println(i);
		     producer.send(new ProducerRecord<String, String>("test10", Integer.toString(i), Integer.toString(i)));
		     System.out.println(i+"end");
		 }
		 producer.close();
	     }  
	
	@Test
	public void testComsumer(){
		
	    Properties props = new Properties();
	     props.put("bootstrap.servers", "kafka.mtech.com.cn:9092");
	     props.put("group.id", "testGroup");
	     props.put("enable.auto.commit", "true");
	     props.put("auto.commit.interval.ms", "1000");
	     props.put("session.timeout.ms", "30000");
	     props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	     props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	     KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
	     consumer.subscribe(Arrays.asList("test10"));
	     while (true) {
	         ConsumerRecords<String, String> records = consumer.poll(100);
	         for (ConsumerRecord<String, String> record : records){
	        	 System.out.printf("offset = %d, key = %s, value = %s", record.offset(), record.key(), record.value());
	         }
	     }
	}
	
	@Test
	public void testComsumer2(){
		
	    Properties props = new Properties();
	     props.put("bootstrap.servers", "kafka.mtech.com.cn:9092");
	     props.put("group.id", "testGroup2");
	     props.put("enable.auto.commit", "true");
	     props.put("auto.commit.interval.ms", "1000");
	     props.put("session.timeout.ms", "30000");
	     props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	     props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	     KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
	     consumer.subscribe(Arrays.asList("test10"));
	     while (true) {
	         ConsumerRecords<String, String> records = consumer.poll(100);
	         for (ConsumerRecord<String, String> record : records){
	        	 System.out.printf("offset = %d, key = %s, value = %s", record.offset(), record.key(), record.value());
	         }
	     }
	}
	/**
	 * 搜索已消费的消息，做离线处理等
	 */
	@Test
	public void testComsumer3(){
	    Properties props = new Properties();
	     props.put("bootstrap.servers", "kafka.mtech.com.cn:9092");
//	     props.put("group.id", "testGroup2");
	     props.put("enable.auto.commit", "true");
	     props.put("auto.commit.interval.ms", "1000");
	     props.put("session.timeout.ms", "30000");
	     props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	     props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	     KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
//	     consumer.subscribe(Arrays.asList("test10"));
	     List<PartitionInfo> partitionsFor = consumer.partitionsFor("test10");
	     
	     for(PartitionInfo p:partitionsFor){
	    	 System.out.println(p.partition());
	     }
	   
	     TopicPartition topicPartition = new TopicPartition("test10", 0);
	     //consumer.position(topicPartition);
	     List<TopicPartition> partitions=new ArrayList<TopicPartition>();
	     partitions.add(topicPartition);
	     consumer.assign(partitions);
	     consumer.seek(topicPartition, 1500);
	     ConsumerRecords<String, String> records = consumer.poll(100);
	     for (ConsumerRecord<String, String> record : records){
	    	
        	 System.out.printf("offset = %d, key = %s, value = %s, partition = %d", record.offset(), record.key(), record.value(), record.partition());
         }
	     consumer.close();
//	     while (true) {
//	         ConsumerRecords<String, String> records = consumer.poll(100);
//	         for (ConsumerRecord<String, String> record : records){
//	        	 System.out.printf("offset = %d, key = %s, value = %s", record.offset(), record.key(), record.value());
//	         }
//	     }
	}
	
}
