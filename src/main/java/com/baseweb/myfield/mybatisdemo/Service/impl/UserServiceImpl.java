package com.baseweb.myfield.mybatisdemo.Service.impl;

import com.baseweb.myfield.mybatisdemo.Service.UserService;
import com.baseweb.myfield.mybatisdemo.mapper.UserMapper;
import com.baseweb.myfield.mybatisdemo.model.User;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public List<User> findAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectAllUser();
    }

    @Override
    public User queryUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
