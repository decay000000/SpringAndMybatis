package com.pyw.pojo;

public class User {
    private int uid;
    private String uname;
    private int uage;
    private String position;

    public User() {
    }

    public User(int uid, String uname, int uage, String position) {
        this.uid = uid;
        this.uname = uname;
        this.uage = uage;
        this.position = position;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getUage() {
        return uage;
    }

    public void setUage(int uage) {
        this.uage = uage;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "编号=" + uid +
                ", 姓名='" + uname + '\'' +
                ", 年龄=" + uage +
                ", 职位='" + position + '\'';
    }
}
