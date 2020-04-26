package com.lightspace.test;

import com.lightspace.dao.IUserDao;
import com.lightspace.dao.impl.UserDaoImpl;
import com.lightspace.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {

    private InputStream in;
    private SqlSession sqlSession;
    private  IUserDao userDao;

    @Before
    public void init()  throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2. create SqlSessionFactory
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3. create object
        sqlSession = factory.openSession();
        //4. create Dao proxy object
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws IOException{
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll(){
        //1. read configuration file

        //5. execute
        List<User> users = userDao.findAll();
        for(User user : users) {
            System.out.println(user);
        }

        //6  release resource
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("aa");
        user.setAddress("this is address");
        user.setSex("M");
        user.setBirthday(new Date());
        userDao.saveUser(user);
        sqlSession.commit();

    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(50);


    }
}
