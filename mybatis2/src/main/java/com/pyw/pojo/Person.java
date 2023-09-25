package com.pyw.pojo;

public class Person {
    private int id;
    private String name;
    private int age;
    private String sex;
    private IdCard card;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public IdCard getCard() {
        return card;
    }

    public void setCard(IdCard card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return  "编号=" + id +
                ", 姓名='" + name + '\'' +
                ", 年龄=" + age +
                ", 性别='" + sex + '\n' +
                "身份证信息=" + card +
                '}';
    }
}
