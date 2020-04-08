package redis.demo.dao;

import redis.demo.domain.Province;

import java.util.List;

public interface ProvinceDao {
    public List<Province> findAll();
}
