package com.pyw.pojo;

import java.util.List;

public class Product {
    private Integer id;
    private String name;
    private Double price;
    private List<Orders> ordersList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Orders> getOrders() {
        return ordersList;
    }

    public void setOrders(List<Orders> orders) {
        this.ordersList = orders;
    }

    @Override
    public String toString() {
        return "\n\t\tProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", ordersList=" + ordersList +
                '}';
    }
}
