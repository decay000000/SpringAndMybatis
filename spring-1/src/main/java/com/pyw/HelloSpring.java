package com.pyw;

public class HelloSpring {
    private String userName;

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void show(){
        System.out.println("欢迎" + userName);
    }
}
