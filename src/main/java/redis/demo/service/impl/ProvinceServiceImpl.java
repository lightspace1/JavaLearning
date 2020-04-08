package redis.demo.service.impl;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;
import redis.demo.dao.ProvinceDao;
import redis.demo.dao.impl.ProvinceDaoImp;
import redis.demo.domain.Province;
import redis.demo.service.ProvinceService;
import redis.demo.util.JedisPoolUtils;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {

    private ProvinceDao dao = new ProvinceDaoImp();
    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    @Override
    public String findAllJson() {
        //1. query from redis
        //1. connect to redis
        Jedis jedis = JedisPoolUtils.getJedis();
        String province_json = jedis.get("province");

        if (province_json == null || province_json.length() == 0) {
            System.out.println("query the database");
            List<Province> ps = dao.findAll();
            ObjectMapper mapper = new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString(ps);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedis.set("province", province_json);
            jedis.close();
        }else {
            System.out.println("without query from database");

        }

        return province_json;
    }
}
