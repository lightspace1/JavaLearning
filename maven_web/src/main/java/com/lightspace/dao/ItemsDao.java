package com.lightspace.dao;

import com.lightspace.domain.Items;

import java.sql.SQLException;
import java.util.List;

public interface ItemsDao {
    List<Items> findAll() throws Exception;

}
