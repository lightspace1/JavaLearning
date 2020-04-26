package com.lightspace.dao;

import com.lightspace.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {
    //@Select("select * from user")
    List<User> findAll();

    void saveUser(User user);
    void updateUser(User user);
}
