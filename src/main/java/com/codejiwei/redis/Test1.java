package com.codejiwei.redis;

import redis.clients.jedis.Jedis;

/**
 * @ClassName com.codejiwei.redis.Test
 * @Description TODO
 * @Author codejiwei
 * @Date 2020/12/15 17:05
 * @Version 1.0
 **/
public class Test1 {
    public static void main(String[] args) {
        //获取Jedis连接
        Jedis jedis = new Jedis("hadoop102", 6379);

        String ping = jedis.ping();
        System.out.println("测试连接结果：" + ping);

        //关闭Jedis连接
        jedis.close();
    }
}
