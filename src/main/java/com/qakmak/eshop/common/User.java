package com.qakmak.eshop.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

/**
 * created by tapakkur on 2019/2/16
 */
@JsonIgnoreProperties(value = {"handler"})
public class User implements Serializable {

    private Integer id;
    private String name;
    private String loginName;
    private String password;
    private String phone;
    private String address;
    private List<Order> orders;

    public User () {
        //
    }

//    添加用户时用这个
    public User(Integer id, String name, String loginName, String password,
                String phone, String address) {
        this.id = id;
        this.name = name; // 用户姓名
        this.loginName = loginName; // 用户登录名
        this.password = password; // 登录密码
        this.phone = phone; // 用户联系方式
        this.address = address; // 用户地址
    }
//    修改用户信息时用这个
    public User(String name, String loginName, String password,
                String phone, String address) {
        this.name = name; // 用户姓名
        this.loginName = loginName; // 用户登录名
        this.password = password; // 登录密码
        this.phone = phone; // 用户联系方式
        this.address = address; // 用户地址
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

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
