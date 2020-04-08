package redis.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import redis.demo.domain.Province;

import java.util.List;

public interface ProvinceService {
    List<Province> findAll();
    String findAllJson() throws JsonProcessingException;
}
