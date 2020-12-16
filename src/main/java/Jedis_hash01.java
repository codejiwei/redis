import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Jedis_hash01
 * @Description TODO
 * @Author codejiwei
 * @Date 2020/12/16 0:14
 * @Version 1.0
 **/
public class Jedis_hash01 {
    public static void main(String[] args) {

        Jedis jedis = new Jedis("hadoop102", 6379);

        //TODO hset 创建hash，添加元素
        jedis.hset("hset-01", "f1", "v1");
        //TODO hmset 批量添加元素
        HashMap<String, String> map = new HashMap<>();
        map.put("id", "1001");
        map.put("name", "Tom");
        map.put("amount", "10000");
        map.put("city", "beijing");
        jedis.hmset("hset-01", map);

        //TODO hgetAll 获取hset中所有的元素
        Map<String, String> hgetAll = jedis.hgetAll("hset-01");
        for (Map.Entry<String, String> entry : hgetAll.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        jedis.close();
    }
}
