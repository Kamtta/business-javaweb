package com.dreamTimes.dao;

import com.dreamTimes.pojo.Type;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TypeDaoTest {
    private TypeDao typeDao;
    @Before
    public void getTypeDao() throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        typeDao = sqlSession.getMapper(TypeDao.class);
    }
    @Test
    public void selectAll(){
        List<Type> list= typeDao.selectAll();
        System.out.println(list);
    }
}
