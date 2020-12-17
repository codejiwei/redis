package com.codejiwei.redis;

import redis.clients.jedis.Jedis;

import java.util.Arrays;
import java.util.Set;

/**
 * @ClassName com.codejiwei.redis.Jedis_set01
 * @Description TODO
 * @Author codejiwei
 * @Date 2020/12/16 0:08
 * @Version 1.0
 **/
public class Jedis_set01 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("hadoop102", 6379);

        //TODO 创建set，并添加值
        jedis.sadd("set-01", "v1", "v1", "v2", "v2", "v3");
        //TODO smembers 查看set的所有元素
        Set<String> smembers = jedis.smembers("set-01");
        System.out.println(Arrays.toString(smembers.toArray()));

        //TODO sismember 判断set是否包含value
        System.out.println(jedis.sismember("set-01", "v1"));

        //TODO scard 返回set的元素个数
        System.out.println(jedis.scard("set-01"));

        //TODO srem 删除set中的元素
        jedis.srem("set-01", "v2", "v3");

        Set<String> smembers1 = jedis.smembers("set-01");
        System.out.println(Arrays.toString(smembers1.toArray()));

        jedis.close();
    }
}
