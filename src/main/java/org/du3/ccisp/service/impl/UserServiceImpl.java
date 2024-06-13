package org.du3.ccisp.service.impl;

import org.du3.ccisp.mapper.UserMapper;
import org.du3.ccisp.pojo.User;
import org.du3.ccisp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void add(User user) {
        userMapper.add(user);
    }

    @Override
    public User match(User user) {
        return userMapper.match(user);
    }

    @Override
    public void delete(Integer userId) {
        userMapper.delete(userId);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public User queryById(Integer userId) {
        return userMapper.queryById(userId);
    }

    @Override
    public List<User> queryAll() {
        return userMapper.queryAll();
    }
}

