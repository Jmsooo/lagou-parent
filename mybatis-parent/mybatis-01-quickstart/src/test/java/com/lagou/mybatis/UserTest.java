package com.lagou.mybatis;

import com.lagou.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserTest {

    @Test
    public void testDelete() throws IOException {
        // 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取 SqlSessionFactory 工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取 SqlSession 会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行 SQL
        sqlSession.insert("UserMapper.delete", 1);

        // DML 语句, 手动提交事务
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        // 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取 SqlSessionFactory 工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取 SqlSession 会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行 SQL
        User user = new User();
        user.setId(3);
        user.setUsername("luck");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("北京朝阳");
        sqlSession.insert("UserMapper.update", user);

        // DML 语句, 手动提交事务
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testSave() throws IOException {
        // 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取 SqlSessionFactory 工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取 SqlSession 会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行 SQL
        User user = new User();
        user.setUsername("jack");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("北京海淀");
        sqlSession.insert("UserMapper.save", user);

        // DML 语句, 手动提交事务
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testFindAll() throws IOException {
        // 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取 SqlSessionFactory 工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取 SqlSession 会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行 SQL
        List<User> list = sqlSession.selectList("UserMapper.findAll");
        for (User user : list) {
            System.out.println("user = " + user);
        }
        // 释放对象
        sqlSession.close();
    }

}
