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
        //TODO 获取Jedis集群对象
        JedisCluster jedisCluster = JedisUtils.getJedisCluster();
        //通过集群对象操作key-value
        jedisCluster.set("k10086", "v10086");
        System.out.println(jedisCluster.get("k10086"));

//        Set<String> keys = jedisCluster.keys("*");
//        for (String key : keys) {
//            System.out.println(key);
//        }
        //TODO 不用释放资源~因为这是一个池子，池子不用关，会自动分配资源~
    }
}
