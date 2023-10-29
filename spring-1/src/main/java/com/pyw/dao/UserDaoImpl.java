package com.pyw.dao;

import com.pyw.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao{
    public void save(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext1.xml");
        User user=(User)ac.getBean("user");
        System.out.println(user);
        System.out.println("执行UserDaoImpl.save()");
    }
}
