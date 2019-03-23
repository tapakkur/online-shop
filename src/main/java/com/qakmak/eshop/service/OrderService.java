package com.qakmak.eshop.service;

import com.github.pagehelper.PageInfo;
import com.qakmak.eshop.common.Order;

/**
 * @author tapakkur
 * @ProjectName online-shop
 * @Date 2019/3/13 20:21
 */
public interface OrderService {
    void saveOrder(Order order);
    public Order queryOrderByOrderId (int orderId);
    public PageInfo<Order> queryOrderByUserId (int userId, Integer page, Integer pageSize);
}
