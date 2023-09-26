package com.pyw.pojo;

import java.util.List;

public class Ordersitem {
    private Integer id;
    private String number;
    private List<Product> productList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Ordersitem{" +
                "id=" + id +
                ", number='" + number + '\'' +
                "\n\tproductList=" + productList +
                "\n}";
    }
}
