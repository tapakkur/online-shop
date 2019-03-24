package com.qakmak.eshop.dao;

import com.qakmak.eshop.common.Order;
import com.qakmak.eshop.common.User;

import java.util.List;

/**
 * @author tapakkur
 * @ProjectName eshop
 * @Date 2019/2/17 18:06
 */
public interface OrderMapper {

    void saveOrder(Order order);
    Order queryOrderByOrderId(int orderId);
    List<Order> queryOrderByUserId(int userId);
    void saveItem(Integer orderId, Integer productId);
}
