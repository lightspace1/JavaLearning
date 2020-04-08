package redis.demo.service;

import redis.demo.domain.Province;

import java.util.List;

public interface ProvinceService {
    public List<Province> findAll();
}
