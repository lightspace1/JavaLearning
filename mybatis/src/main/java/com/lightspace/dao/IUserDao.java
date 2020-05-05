package com.lightspace.dao;

import com.lightspace.domain.QueryVo;
import com.lightspace.domain.User;
import org.apache.ibatis.annotations.Select;

import javax.management.Query;
import java.util.List;
import java.util.Queue;

public interface IUserDao {
    //@Select("select * from user")
    List<User> findAll();

    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Integer id);
    User findById(Integer userId);
    List<User> findByName(String name);

    List<User> findUserByvo(QueryVo vo);
}
