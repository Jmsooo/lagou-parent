package com.lagou.mybatis;

import com.lagou.mybatis.domain.User;
import com.lagou.mybatis.mapper.UserMapper;
import com.lagou.mybatis.mapper.impl.UserMapperImpl;
import org.junit.Test;

import java.util.List;

public class UserTest {
    @Test
    public void testFindAll() throws Exception{
        UserMapper userMapper = new UserMapperImpl();
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println("user = " + user);
        }
    }
}
