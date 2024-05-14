package com.dk.demo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.dk.demo1.mapper.UserMapper;
import com.dk.demo1.pojo.User;
import com.dk.demo1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2023-10-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void add(User user) {
        userMapper.add(user);
    }

    @Override
    public List<User> queryBatch(List<String> list) {
        return userMapper.queryBatch(list);
    }

    @Override
    public List<User> queryUsers(User user) {
        return userMapper.queryUsers(user);
    }

    @Override
    public void delete() {

    }

    @Override
    public boolean update(String id) {
        return false;
    }

    @Override
    public User query(String id) {
        return null;
    }

    @Override
    public List<User> queryLateUser() {
        return null;
    }
}
