package com.lightspace.test;

import com.lightspace.dao.IUserDao;
import com.lightspace.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {


    public static void main(String[] args) throws IOException {
        //1. read configuration file
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2. create SqlSessionFactory
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3. create object
        SqlSession session = factory.openSession();
        //4. create Dao proxy object
        IUserDao userDao = session.getMapper(IUserDao.class);
        //5. execute
        List<User> users = userDao.findAll();
        for(User user : users) {
            System.out.println(user);
        }

        //6  release resource
        session.close();
        in.close();


    }
}
