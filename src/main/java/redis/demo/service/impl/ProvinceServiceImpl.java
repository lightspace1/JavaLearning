package redis.demo.service.impl;

import redis.demo.dao.ProvinceDao;
import redis.demo.dao.impl.ProvinceDaoImp;
import redis.demo.domain.Province;
import redis.demo.service.ProvinceService;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {

    private ProvinceDao dao = new ProvinceDaoImp();
    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }
}
