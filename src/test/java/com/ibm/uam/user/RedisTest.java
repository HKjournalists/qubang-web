package com.ibm.uam.user;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

public class RedisTest {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("172.20.8.3", 6379);
		jedis.set("test", "testValue");
		
		String name = jedis.get("test");
		System.out.println(name);
		
	}
	@Test
	public void test1(){
		Jedis jedis = new Jedis("120.24.77.7", 6379);
        jedis.set("test", "testValue");
		
		String name = jedis.get("test");
		System.out.println(name);
		
	}
	
	//@Test
	public void testCluster(){
		
		Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
		//Jedis Cluster will attempt to discover cluster nodes automatically
		jedisClusterNodes.add(new HostAndPort("172.20.8.3", 6379));
		//jedisClusterNodes.add(new HostAndPort("120.24.77.7", 6379));
		JedisCluster jc = new JedisCluster(jedisClusterNodes);
		String name = jc.get("cmq");
		System.out.println(name);
	}
}
