package com.pyw.auto.controller;

import com.pyw.auto.service.UserService;

public class UserController {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void save(){
        userService.save();
        System.out.println("Usercontroller");
    }
}
