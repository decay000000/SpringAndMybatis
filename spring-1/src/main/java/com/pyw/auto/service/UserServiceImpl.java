package com.pyw.auto.service;

import com.pyw.auto.dao.UserDao;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    public void save(){
        userDao.save();
        System.out.println("Userservice");
    }
}
