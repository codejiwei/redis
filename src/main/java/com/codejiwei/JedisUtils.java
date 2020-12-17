package com.codejiwei;

import redis.clients.jedis.*;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName com.codejiwei.JedisUtils
 * @Description TODO
 * @Author codejiwei
 * @Date 2020/12/16 0:30
 * @Version 1.0
 **/
public class JedisUtils {
    private static JedisPool jedisPool = null;
    public static Jedis getJedisFromPool(){
        if (jedisPool == null){
            JedisPoolConfig jedisPoolConfig =new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(10); //最大可用连接数
            jedisPoolConfig.setMaxIdle(5); //最大闲置连接数
            jedisPoolConfig.setMinIdle(2); //最小闲置连接数
            jedisPoolConfig.setBlockWhenExhausted(true); //连接耗尽是否等待
            jedisPoolConfig.setMaxWaitMillis(2000); //等待时间
            jedisPoolConfig.setTestOnBorrow(true); //取连接的时候进行一下测试 ping pong

            jedisPool = new JedisPool(jedisPoolConfig, "hadoop102", 6379);

            return jedisPool.getResource();
        }else{

            return jedisPool.getResource();
        }
    }


    //TODO 步骤1 声明一个JedisSentinelPool 哨兵池
    public static JedisSentinelPool jedisSentinelPool = null;

    public static Jedis getJedisFromSentinel(){
        if (jedisSentinelPool == null) {
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(10);    //最大可用连接数
            jedisPoolConfig.setMaxIdle(5);      //最大闲置连接数
            jedisPoolConfig.setMinIdle(2);      //最小闲置连接数
            jedisPoolConfig.setBlockWhenExhausted(true);    //连接耗尽是否等待
            jedisPoolConfig.setMaxWaitMillis(2000);     //等待时机
            jedisPoolConfig.setTestOnBorrow(true);      //取连接的时候进行一下测试 ping pong
            //TODO 步骤2 new一个HashSet里面放哨兵的ip + port
            Set sentineSet = new HashSet();
            sentineSet.add("hadoop102:26379");
            //TODO 步骤3 new哨兵池，参数1是哨兵配置内的别名，参数2是哨兵集合，参数3是Jedis池配置
            jedisSentinelPool = new JedisSentinelPool("mymaster", sentineSet, jedisPoolConfig);

            return jedisSentinelPool.getResource();
        }else {
            return jedisSentinelPool.getResource();
        }
    }

    public static JedisCluster jedisCluster = null;
    public static JedisCluster getJedisCluster(){

        if (jedisCluster == null){
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(10);
            jedisPoolConfig.setMaxIdle(5);
            jedisPoolConfig.setMinIdle(5);
            jedisPoolConfig.setBlockWhenExhausted(true);
            jedisPoolConfig.setMaxWaitMillis(2000);
            jedisPoolConfig.setTestOnBorrow(true);


            Set<HostAndPort> hostAndPortSet = new HashSet<>();
            hostAndPortSet.add(new HostAndPort("hadoop102", 6379));
            hostAndPortSet.add(new HostAndPort("hadoop102", 6380));

            jedisCluster = new JedisCluster(hostAndPortSet, jedisPoolConfig);
            return jedisCluster;

        }else {
            return jedisCluster;
        }
    }
}
