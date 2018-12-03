package com.dreamTimes.dao;

import com.dreamTimes.pojo.Goods;
import com.dreamTimes.pojo.ShoppingCart;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ShoppingCartDaoTest {
    private ShoppingCartDao shoppingCartDao;
    @Before
    public void getShoppingCartDao() throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        shoppingCartDao = sqlSession.getMapper(ShoppingCartDao.class);
    }
    @Test
    public void addGoods(){
        Goods goods = new Goods();
        goods.setGphoto("122123555.jpg");
        goods.setGname("白菜");
        goods.setGprice(55);
        shoppingCartDao.addGoods(goods);
    }
    @Test
    public void delete(){
        String gname = "白菜";
        shoppingCartDao.delete(gname);
    }
    @Test
    public void selectAll(){
        List<ShoppingCart> list = shoppingCartDao.selectAll();
        System.out.println(list);
    }
    @Test
    public void selectByGname(){
        String gname = "白菜";
        ShoppingCart shoppingCart = shoppingCartDao.selectByGname(gname);
        System.out.println(shoppingCart);
    }
    @Test
    public void update(){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setGname("白菜");
        shoppingCart.setGprice(2);
        shoppingCartDao.update(shoppingCart);
    }
}
