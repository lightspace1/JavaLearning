package com.lightspace.test;

import com.lightspace.dao.IUserDao;
import com.lightspace.dao.impl.UserDaoImpl;
import com.lightspace.domain.QueryVo;
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


import java.util.ArrayList;
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
        //sqlSession = factory.openSession();
        //4. create Dao proxy object
        //userDao = sqlSession.getMapper(IUserDao.class);
        userDao = new UserDaoImpl(factory);
    }

    @After
    public void destroy() throws IOException{
        //sqlSession.close();
        //sqlSession.commit();
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


    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(50);
        user.setUsername("mybatis");
        user.setAddress("aa");
        user.setSex("male");
        user.setBirthday(new Date());
        userDao.updateUser(user);


    }

    @Test
    public void testFindOne() {

        User user = userDao.findById(1);
        System.out.println(user);

    }
    @Test
    public void testFindByName() {

        List<User> users = userDao.findByName("%cc%");
        for (User user : users) {
            System.out.println(user);
        }


    }
    @Test
    public void testFindByVo() {
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%cc%");
        List<User> users = userDao.findUserByvo(vo);
        vo.setUser(user);
        for (User u : users) {
            System.out.println(u);
        }


    }
    @Test
    public void testFindByCondition(){
        //1. read configuration file

        //5. execute
        User u = new User();
        u.setUsername("aa");
        List<User> users = userDao.findUserByCondition(u);
        for(User user : users) {
            System.out.println(user);
        }

        //6  release resource
    }

    @Test
    public void testFindInIds(){
        //1. read configuration file
        QueryVo vo = new QueryVo();
        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(12);
        list.add(13);
        vo.setIds(list);
        //5. execute
        User u = new User();
        u.setUsername("aa");
        List<User> users = userDao.findUserIds(vo);
        for(User user : users) {
            System.out.println(user);
        }

        //6  release resource
    }
}
