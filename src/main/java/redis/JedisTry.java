package redis;

import redis.clients.jedis.Jedis;

import java.util.Map;

public class JedisTry {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set("username", "zhangsan");
        String username = jedis.get("username");
        jedis.setex("test", 20 , "xixi");

        //test the hash
        jedis.hset("user", "name", "peter");
        jedis.hset("user", "age", "15");
        jedis.hset("user", "gender", "female");
        String name = jedis.hget("user", "name");
        System.out.println(name);


        Map<String, String> user = jedis.hgetAll("user");
        jedis.close();
    }
}
