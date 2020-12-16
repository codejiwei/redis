import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @ClassName Test
 * @Description TODO
 * @Author codejiwei
 * @Date 2020/12/15 17:05
 * @Version 1.0
 **/
public class Jedis_key01 {
    public static void main(String[] args) {
        //获取Jedis连接
        Jedis jedis = new Jedis("hadoop102", 6379);

        //TODO 1 添加key-value
        jedis.set("key-01", "99");
        jedis.set("key-02", "87");
        jedis.set("key-03", "88");
        //TODO 2 获取所有的key
        Set<String> keys = jedis.keys("*");
        //TODO 3 获取key的数量
        System.out.println(keys.size());
        //TODO 4 遍历所有的key
        for (String key : keys) {
            System.out.println(key);
        }
        //TODO 5 exists
        System.out.println(jedis.exists("key-01"));

        //TODO 6 expire，给已有的key设置过期时间
        jedis.expire("key-03", 10);
        //TODO 7 ttl，已有key查看剩余的过期时间
        System.out.println(jedis.ttl("key-01"));
        //TODO 8 get，查看某个key的value值
        System.out.println(jedis.get("key-01"));


        //关闭Jedis连接
        jedis.close();
    }
}
