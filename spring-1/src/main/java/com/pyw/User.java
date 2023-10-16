package com.pyw;

public class User {
    private int id;
    private String name;
    private String password;

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
        System.out.println("正在通过set设置id");
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public User() { System.out.println("使用默认构造器"); }

    public User(int id, String name, String password) {
        System.out.println("使用全参构造器");
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User(int id, String name) {
        System.out.println("使用含参构造器");
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
