package com.codejiwei.redis_ms;

import com.codejiwei.JedisUtils;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @ClassName JedisTest01
 * @Description TODO
 * @Author codejiwei
 * @Date 2020/12/17 9:19
 * @Version 1.0
 **/
public class JedisTest01 {
    public static void main(String[] args) {
        //TODO 从哨兵池中获取redis
        Jedis jedis = JedisUtils.getJedisFromSentinel();
        //TODO 测试ping
        String ping = jedis.ping();
        System.out.println(ping);

        //TODO 获取当前库中的key的值
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
        //TODO 关闭资源
        jedis.close();
    }
}
