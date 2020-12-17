package com.codejiwei.redis;

import redis.clients.jedis.Jedis;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * @ClassName com.codejiwei.redis.Jedis_zset01
 * @Description TODO
 * @Author codejiwei
 * @Date 2020/12/16 0:21
 * @Version 1.0
 **/
public class Jedis_zset01 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("hadoop102", 6379);
        //TODO zadd 创建zset，添加元素
        jedis.zadd("zset-01", 100, "m1");
        //TODO zadd 批量添加元素
        HashMap<String, Double> map = new HashMap<>();
        map.put("m2", 150.0);
        map.put("m3", 80.9);
        map.put("m4", 50.0);
        jedis.zadd("zset-01", map);
        //TODO zrange 查看zset中所有的元素
        Set<String> zrange = jedis.zrange("zset-01", 0, -1);
        System.out.println(Arrays.toString(zrange.toArray()));
        //TODO zrevrangeByScore 按照score降序排序
        Set<String> set = jedis.zrevrangeByScore("zset-01", 100, 10);
        System.out.println(Arrays.toString(set.toArray()));
        jedis.close();
    }
}
