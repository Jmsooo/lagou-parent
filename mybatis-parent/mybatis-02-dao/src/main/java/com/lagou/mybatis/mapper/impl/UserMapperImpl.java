package com.lagou.mybatis.mapper.impl;

import com.lagou.mybatis.domain.User;
import com.lagou.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class UserMapperImpl implements UserMapper {
    @Override
    public List<User> findAll() throws Exception {
        // 加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取 SqlSessionFactory 工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取 SqlSession 会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行 SQL
        List<User> list = sqlSession.selectList("UserMapper.findAll");
        // 释放资源
        sqlSession.close();
        return list;
    }
}
