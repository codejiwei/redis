import redis.clients.jedis.Jedis;

/**
 * @ClassName Jedis_string01
 * @Description TODO
 * @Author codejiwei
 * @Date 2020/12/15 23:56
 * @Version 1.0
 **/
public class Jedis_string01 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("hadoop102", 6379);

        //TODO mset 添加多个key-value
        jedis.mset("str1", "v1", "str2", "v2", "str3", "v3");
        //TODO mget 获取多个key的value
        System.out.println(jedis.mget("str1", "str2", "str3"));

        jedis.close();
    }
}
