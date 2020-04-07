package redis;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
        //test the key set
        Set<String> keySet = user.keySet();

        for  (String key : keySet) {
            String value = user.get(key);
            System.out.println(key + ":" + value);
        }

        //test the list
        jedis.lpush("thelist", "a", "b", "c");
        jedis.rpush("thelist", "a","b","c");
        List<String> thelist = jedis.lrange("thelist", 0 , -1);

        String element1 = jedis.lpop("thelist");
        System.out.println(element1);
        String element2 = jedis.rpop("thelist");
        System.out.println(element2);

        //retrieve the element by scope
        List<String> thelist2 = jedis.lrange("thelist", 0, -1);
        System.out.println(thelist2);


        //test the set
        jedis.sadd("theSet", "java", "PHP", "C++");
        Set<String> theSet = jedis.smembers("theSet");
        System.out.println(theSet);

        // test the sort Set
        jedis.zadd("thesortedset", 3, "a");
        jedis.zadd("thesortedset", 30, "b");
        jedis.zadd("thesortedset",55, "c");

        //get the elements in the set
        Set<String> thesortedset = jedis.zrange("thesortedset", 0, -1);
        System.out.println(thesortedset);



        jedis.close();
    }
}
