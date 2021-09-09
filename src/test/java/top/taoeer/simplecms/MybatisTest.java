package top.taoeer.simplecms;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import top.taoeer.simplecms.domain.Clazz;
import top.taoeer.simplecms.domain.Student;
import top.taoeer.simplecms.domain.User;
import top.taoeer.simplecms.mapper.StudentMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    private SqlSession sqlSession;

    @Before
    public void getSqlSession() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();
        this.sqlSession = sqlSession;
    }

    @Test
    public void simpleTest() throws IOException {
        User user = new User();
        user.setName("taoeer");
        user.setAge(25);
        user.setSex("男");
        sqlSession.insert("top.taoeer.simplecms.mapper.UserMapper.save", user);
        System.out.println(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void queryUser() throws IOException {
        User user = sqlSession.selectOne("top.taoeer.simplecms.mapper.UserMapper.select", 10);
        System.out.println(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void update() throws IOException {
        User user = sqlSession.selectOne("top.taoeer.simplecms.mapper.UserMapper.select", 10);
        user.setName("taoeersss");
        sqlSession.update("top.taoeer.simplecms.mapper.UserMapper.update", user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void delete() {
        sqlSession.delete("top.taoeer.simplecms.mapper.UserMapper.delete", 9);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectStudent() {
        Student student = sqlSession.selectOne("top.taoeer.simplecms.mapper.StudentMapper.select", 3);
        System.out.println(student);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void listClazz() {
        List<Clazz> clazzes = sqlSession.selectList("top.taoeer.simplecms.mapper.ClazzMapper.select");
        System.out.println(clazzes);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectStudentByInterface() {
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.select(4);
        System.out.println(student);
        sqlSession.commit();
        sqlSession.close();
    }
}
