package com.lagou.mybatis.mapper;

import com.lagou.mybatis.domain.User;

import java.util.List;

public interface UserMapper {
    public List<User> findAll() throws Exception;
}
