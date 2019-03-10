package com.qakmak.eshop.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

/**
 * created by tapakkur on 2019/2/16
 */
// 报一个json数据转换失败
@JsonIgnoreProperties(value = {"handler"})
public class Order implements Serializable {

    private Integer id; // 订单id
    private String code; // 订单编号
    private double total; // 订单总金额
    private User user; // 订单和用户是多对一的，即一个订单只属于一个人
    private List<Product> products; // 订单和商品是多对多的，即一个订单可以拥有多个产品，反之亦然

    public Order () {
        //
    }

    public Order(Integer id, String code, double total) {
        this.id = id;
        this.code = code;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
