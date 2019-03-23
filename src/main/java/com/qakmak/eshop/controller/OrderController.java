package com.qakmak.eshop.controller;

import com.github.pagehelper.PageInfo;
import com.qakmak.eshop.common.Order;
import com.qakmak.eshop.common.User;
import com.qakmak.eshop.service.OrderServiceImpl;
import com.qakmak.eshop.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    private UserServiceImpl userService;

    @ApiOperation(value = "添加订单信息", notes = "预处理订单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "订单id",required = true),
            @ApiImplicitParam(paramType = "query", name = "code", value = "订单编号",required = true),
            @ApiImplicitParam(paramType = "query", name = "total", value = "总额",required = true),
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id",required = true)
    })
    @RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
    public void saveOrder(
            @RequestParam(value = "id") Integer id,
            @RequestParam(value = "code") String code,
            @RequestParam(value = "total") double total,
            @RequestParam(value = "userId") Integer userId
    ){
        Order order = new Order(id,code,total); // 1.初始化订单属性值
        User user = userService.queryByUserId(userId); // 2.配置订单的用户
        order.setUser(user);
        // 3.配置订单中相关产品信息，待补。。。。
        orderService.saveOrder(order);
    }

    @ApiOperation(value = "按订单id查询订单", notes = "按订单id查询订单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "orderId", value = "订单id",required = true)
    })
    @RequestMapping(value = "/queryOrderByOrderId", method = RequestMethod.POST)
    public Order queryOrderByOrderId(@RequestParam(value = "orderId") Integer orderId
                                     ){
        return  orderService.queryOrderByOrderId(orderId);
    }

    @ApiOperation(value = "按用户id查询订单", notes = "按用户id查询订单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", value = "当前页", defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页显示的记录数", defaultValue = "10"),
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id",required = true)
    })
    @RequestMapping(value = "/queryOrderByUserId", method = RequestMethod.POST)
    public PageInfo<Order> queryOrderByUserId(@RequestParam(value = "userId") Integer userId,
                                              @RequestParam(value = "page") Integer page,
                                              @RequestParam(value = "pageSize") Integer pageSize
                                    ){
        return orderService.queryOrderByUserId(userId,page,pageSize);
    }

}
