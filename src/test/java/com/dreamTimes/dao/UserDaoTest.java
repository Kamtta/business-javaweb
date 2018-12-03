package com.dreamTimes.dao;

import com.dreamTimes.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoTest {
    private UserDao userDao;
    @Before
    public void getUserDao() throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        userDao = sqlSession.getMapper(UserDao.class);
    }
    @Test
    public void sumCount(){
        Integer rlevel = 2;
        int i = userDao.sumCount(rlevel);
        System.out.println(i);
    }
    @Test
    public void findContent(){
        Integer rlevel = 1;
        Integer offset = 0;
        Integer num = 5;
        List<User> list = new ArrayList<User>();
        list = userDao.findContent(rlevel,offset,num);
        System.out.println(list);
    }
    @Test
    public void selectByRlevel(){
        Integer rlevel = 1;
        List<User> list = userDao.selectByRlevel(rlevel);
        System.out.println(list);
    }
    @Test
    public void selectByUname(){
        String uname = "15822869305";
        Integer rlevel = 1;
        User user = userDao.selectByUname(uname,rlevel);
        System.out.println(user);
    }
    @Test
    public void insertAdmin() throws ParseException {
        User user = new User();
        user.setUname("13532528878");
        user.setUpwd("12345");
        user.setUsex(1);
        user.setRtelephone("13432528878");
        user.setReceiver("father");
        user.setRaddress("Canteness");
        user.setUbirthday(DateFormat.getDateInstance().parse("2000-11-22"));
        userDao.insertAdmin(user);

    }
    @Test
    public void deleteAdmin(){
        String uname = "13532528878";
        userDao.deleteAdmin(uname);
    }
    @Test
    public void updateAdmin(){
        User user = new User();
        user.setUname("15822869305");
        user.setUpwd("123456");
        userDao.updateAdmin(user);
    }
}
