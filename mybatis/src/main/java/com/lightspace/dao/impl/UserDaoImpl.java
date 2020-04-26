package com.lightspace.dao.impl;

import com.lightspace.dao.IUserDao;
import com.lightspace.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao {
    private SqlSessionFactory factory;
    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }
    @Override
    public List<User> findAll() {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("com.lightspace.dao.IUserDao.findAll");
        return users;
    }

    @Override
    public void saveUser(User user) {

    }


}
