package com.lightspace.dao.impl;

import com.lightspace.dao.IUserDao;
import com.lightspace.domain.QueryVo;
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
        session.close();
        return users;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(Integer id) {

    }

    @Override
    public User findById(Integer userId) {
        return null;
    }

    @Override
    public List<User> findByName(String name) {
        return null;
    }

    @Override
    public List<User> findUserByvo(QueryVo vo) {
        return null;
    }

}
