package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class LearnJedisPoll {
    public static void main(String[] args) {
        //setup config
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);
        //create pool object
        JedisPool jedisPool = new JedisPool(config, "localhost", 6379);

        // get the connection
        Jedis jedis = jedisPool.getResource();

        // use the connection
        jedis.set("pooltest", "confirm");
        jedis.close();

        Jedis jedis2 = JedisPoolUtils.getJedis();
        System.out.println(jedis2.get("pooltest"));
        jedis2.close();
    }
}
