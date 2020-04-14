package com.lightspace.dao.impl;

import com.lightspace.dao.ItemsDao;
import com.lightspace.domain.Items;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemsDaoImpl implements ItemsDao {
    @Override
    public List<Items> findAll() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Items> list = new ArrayList<>();
        try {
            connection =  DriverManager.getConnection("jdbc:mysql:///maven", "root", "root");
            pst = connection.prepareCall("select * from items");
            rs = pst.executeQuery();

            while (rs.next()) {
                Items items = new Items();
                items.setId(rs.getInt("id"));
                items.setName(rs.getString("name"));
                list.add(items);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            rs.close();
            pst.close();
            connection.close();

        }
        return list;
    }
}
