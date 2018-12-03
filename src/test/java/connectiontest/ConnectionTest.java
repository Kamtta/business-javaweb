package connectiontest;






import com.dreamTimes.dao.GoodsDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class ConnectionTest {
    @Test
    public void conTest() throws IOException {
        /**
         * 1、文件的路径
         * 2、sqlSessionFactory
         * 3、sqlSession
         */
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsDao goodsDao = sqlSession.getMapper(GoodsDao.class);
        int i = goodsDao.sumCount();
        System.out.println(i);
    }
}
