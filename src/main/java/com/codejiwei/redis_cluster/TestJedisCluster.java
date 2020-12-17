package com.codejiwei.redis_cluster;

import com.codejiwei.JedisUtils;
import redis.clients.jedis.JedisCluster;

import java.util.Set;

/**
 * @ClassName TestJedisCluster
 * @Description TODO
 * @Author codejiwei
 * @Date 2020/12/17 14:40
 * @Version 1.0
 **/
public class TestJedisCluster {
    public static void main(String[] args) {

        JedisCluster jedisCluster = JedisUtils.getJedisCluster();

        jedisCluster.set("k10086", "v10086");
        System.out.println(jedisCluster.get("k10086"));

        Set<String> keys = jedisCluster.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }


    }
}
