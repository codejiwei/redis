import redis.clients.jedis.Jedis;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Jedis_list01
 * @Description TODO
 * @Author codejiwei
 * @Date 2020/12/16 0:00
 * @Version 1.0
 **/
public class Jedis_list01 {
    public static void main(String[] args) {

        Jedis jedis = new Jedis("hadoop102", 6379);

        //TODO lpush 创建列表，添加元素
        jedis.lpush("list-01", "v1", "v2", "v3", "v4");
        //TODO rpush 右边添加元素
        jedis.rpush("list-01", "b1", "b2", "b3");

        //TODO lpop 从左边取出元素
        System.out.println(jedis.lpop("list-01"));
        //TODO rpop 从右边取出元素
        System.out.println(jedis.rpop("list-01"));

        //TODO lrange 查看列表中的元素
        List<String> lrange = jedis.lrange("list-01", 0, -1);
        System.out.println(Arrays.toString(lrange.toArray()));

        //TODO lindex 根据索引下标查看元素
        System.out.println(jedis.lindex("list-01", 1));

        //TODO llen 查看列表的长度
        System.out.println(jedis.llen("list-01"));

        jedis.close();
    }
}
