package com.dreamTimes.dao;

import com.dreamTimes.pojo.Goods;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoTest {
    private SqlSession sqlSession;
    @Before
     public void getSqlSession() throws IOException {
         String resource = "mybatis.xml";
         InputStream inputStream = Resources.getResourceAsStream(resource);
         SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
         sqlSession = sqlSessionFactory.openSession();
     }
    @Test
    public void findContent(){
        int offset = 0;
        int num = 4;
        GoodsDao goodsDao = sqlSession.getMapper(GoodsDao.class);
        List<Goods> list = goodsDao.findContent(offset,num);
        System.out.println(list);
    }
    @Test
    public void addGoods(){
        Goods goods = new Goods();
        goods.setGname("土豆");
        goods.setGprice(5);
        goods.setGrepertory(50);
        goods.setGstandard("小");
        GoodsDao goodsDao = sqlSession.getMapper(GoodsDao.class);
        goodsDao.addGoods(goods);
        sqlSession.commit();
    }
    @Test
    public void deleteGoods(){
        int gid = 18;
        GoodsDao goodsDao = sqlSession.getMapper(GoodsDao.class);
        goodsDao.deletegoods(gid);
        sqlSession.commit();
    }
    @Test
    public void updateGoods(){
        Goods goods = new Goods();
        goods.setGid(19);
        goods.setGrepertory(100);
        GoodsDao goodsDao = sqlSession.getMapper(GoodsDao.class);
        goodsDao.updategoods(goods);
        sqlSession.commit();
    }
    @Test
    public void select(){
        Integer gid = 15;
        GoodsDao goodsDao = sqlSession.getMapper(GoodsDao.class);
        Goods goods = goodsDao.select(gid);
        System.out.println(goods);
    }
    @Test
    public void selectAll(){
        String gname = "白菜";
        List<Goods> list = new ArrayList<Goods>();
        GoodsDao goodsDao = sqlSession.getMapper(GoodsDao.class);
        list = goodsDao.selectAll(gname);
        System.out.println(list);
    }
}
