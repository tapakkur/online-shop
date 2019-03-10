package com.qakmak.eshop.dao;

import com.qakmak.eshop.common.Order;

import java.util.List;

/**
 * @author tapakkur
 * @ProjectName eshop
 * @Date 2019/2/17 18:06
 */
public interface OrderMapper {

    public List<Order> queryOrderByOrderId (int orderId);
    public List<Order> queryOrderByUserId (int userId);

}
