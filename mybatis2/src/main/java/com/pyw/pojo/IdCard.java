package com.pyw.pojo;

public class IdCard {
    private int id;
    private String code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return  "{编号=" + id +
                ", 身份证号='" + code + '\'' +
                '}';
    }
}
