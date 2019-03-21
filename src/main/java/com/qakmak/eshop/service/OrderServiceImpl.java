package com.qakmak.eshop.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.qakmak.eshop.common.Order;
import com.qakmak.eshop.dao.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tapakkur
 * @ProjectName online-shop
 * @Date 2019/3/13 20:22
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order queryOrderByOrderId(int orderId) {
        return orderMapper.queryOrderByOrderId(orderId);
    }

    @Override
    public PageInfo<Order> queryOrderByUserId(int userId,Integer page, Integer pageSize) {
        List<Order> resultList = orderMapper.queryOrderByUserId(userId); // 查询结果
        Integer count = resultList.size(); // 数量

        // 封装返回结果
        Page<Order> pageSetting =  new Page<>(page, pageSize);
        pageSetting.setTotal(count);
        PageInfo<Order> pageInfo = new PageInfo<>(pageSetting);
        pageInfo.setList(resultList);
        return pageInfo;
    }
}
