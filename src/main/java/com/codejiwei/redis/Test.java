package com.codejiwei.redis;

import redis.clients.jedis.Jedis;

/**
 * @ClassName com.codejiwei.redis.Test
 * @Description TODO
 * @Author codejiwei
 * @Date 2020/12/15 17:05
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {

        Jedis jedis = new Jedis("hadoop102", 6379);

        String ping = jedis.ping();
        System.out.println("连接成功" + ping);


        jedis.close();


    }
}
