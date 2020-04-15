package com.lightspace.dao;

import com.lightspace.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
}
