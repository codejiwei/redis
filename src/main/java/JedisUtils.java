import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.swing.*;

/**
 * @ClassName JedisUtils
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
}
