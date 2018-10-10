package com.zyc.springbootjob.service.impl;

import com.zyc.springbootjob.dao.IUserDao;
import com.zyc.springbootjob.entity.User;
import com.zyc.springbootjob.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {

    //@Resource
    @Autowired
    private IUserDao userDao;

    @Override
    public User getUserById(int userId) {
        return this.userDao.selectByPrimaryKey(userId);
    }

    @Override
    public void insertUser(User user) { this.userDao.insert(user); }

}