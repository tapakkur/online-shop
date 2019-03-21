package com.qakmak.eshop.controller;

import com.github.pagehelper.PageInfo;
import com.qakmak.eshop.common.Order;
import com.qakmak.eshop.service.OrderServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author tapakkur
 * @ProjectName online-shop
 * @Date 2019/3/13 20:26
 */

@RestController
@Api(value = "订单信息管理", description = "管理平台上用户预定下来的订单信息，并提供相应的服务")
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @ApiOperation(value = "按订单id查询订单", notes = "按订单id查询订单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "orderId", value = "orderId")
    })
    @RequestMapping(value = "/queryOrderByOrderId", method = RequestMethod.POST)
    public Order queryOrderByOrderId(@RequestParam(value = "orderId", required = true) Integer orderId
                                     ){
        return  orderService.queryOrderByOrderId(orderId);
    }

    @ApiOperation(value = "按用户id查询订单", notes = "按用户id查询订单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", value = "userId")
    })
    @RequestMapping(value = "/queryOrderByUserId", method = RequestMethod.POST)
    public PageInfo<Order> queryOrderByUserId(@RequestParam(value = "userId", required = true) Integer userId,
                                              @RequestParam(value = "Page", required = false, defaultValue = "1") Integer page,
                                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize
                                    ){
        return orderService.queryOrderByUserId(userId,page,pageSize);
    }

}
