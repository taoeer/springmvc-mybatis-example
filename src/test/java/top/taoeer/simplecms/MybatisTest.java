package top.taoeer.simplecms;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import top.taoeer.simplecms.domain.User;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
    @Test
    public void simpleTest() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();
        User user = new User();
        user.setName("taoeer");
        user.setAge(25);
        user.setSex("男");
        sqlSession.insert("top.taoeer.simplecms.mapper.UserMapper.save", user);
        sqlSession.commit();
        sqlSession.close();
    }
}
