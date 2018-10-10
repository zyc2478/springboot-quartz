package com.zyc.springbootjob.service;

import com.zyc.springbootjob.entity.User;

public interface IUserService {

    User getUserById(int userId);
    void insertUser(User user);
}