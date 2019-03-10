package com.qakmak.eshop.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

/**
 * created by tapakkur on 2019/2/16
 */
@JsonIgnoreProperties(value = {"handler"})
public class Product  implements Serializable {

    private Integer id; // 商品id
    private String name; // 商品名称
    private double price; // 商品单价
    private String description; // 商品描述
    private List<Order> orders; // 商品和订单多对多关系，即一个商品可以被多个订单下单

    public Product () {
        //
    }

    public Product(Integer id, String name, double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDiscription() {
        return description;
    }

    public void setDiscription(String discription) {
        this.description = discription;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
