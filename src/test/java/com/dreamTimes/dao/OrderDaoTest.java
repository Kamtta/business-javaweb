package com.dreamTimes.dao;

import com.dreamTimes.pojo.Order;
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
import java.util.List;

public class OrderDaoTest {
    private OrderDao orderDao;
    @Before
    public void getOrderDao() throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        orderDao = sqlSession.getMapper(OrderDao.class);
    }
    @Test
    public void addOrder() throws ParseException {
        Order order = new Order();
        order.setGnum(11);
        order.setGphoto("12151515.jpg");
        order.setoNum("12222255");
        order.setGid(12);
        order.setUid(11);
        order.setOcreatedate(DateFormat.getDateInstance().parse("2000-11-12"));
        orderDao.addOrder(order);
    }
    @Test
    public void selectAll(){
       List<Order> list = orderDao.selectAll();
        System.out.println(list);
    }
    @Test
    public void delete(){
        Integer oid = 14;
        orderDao.delete(oid);
    }
    @Test
    public void selectByUid(){
        Integer uid = 16;
        List<Order> list= orderDao.selectByUid(uid);
        System.out.println(list);
    }
}
