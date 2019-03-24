package com.qakmak.eshop.controller;

import com.github.pagehelper.PageInfo;
import com.qakmak.eshop.common.Order;
import com.qakmak.eshop.common.User;
import com.qakmak.eshop.service.OrderServiceImpl;
import com.qakmak.eshop.service.ProductServiceImpl;
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

import java.text.DecimalFormat;

/**
 * @author tapakkur
 * @ProjectName online-shop
 * @Date 2019/3/13 20:26
 */

@RestController
@Api(value = "订单信息管理", description = "管理订单信息，并提供相应服务的后台接口")
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ProductServiceImpl productService;

    @ApiOperation(value = "添加订单（下单）", notes = "预处理订单信息（将订单，用户，产品相互关联起来，形成一张订单信息）")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", name = "id", value = "订单id",required = true),
        @ApiImplicitParam(paramType = "query", name = "code", value = "订单编号",required = true),
//      @ApiImplicitParam(paramType = "query", name = "total", value = "总额",required = true),
        @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id",required = true),
        @ApiImplicitParam(paramType = "query", name = "productIds", value = "产品id集，以','隔开id",required = true)
    })
    @RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
    public void saveOrder(
        @RequestParam(value = "id") Integer id,
        @RequestParam(value = "code") String code,
//            @RequestParam(value = "total") double total,
        @RequestParam(value = "userId") Integer userId,
        @RequestParam(value = "productIds") String productIds
    ){
        Order order = new Order(); // 1.创建一个order对象
        order.setId(id); // id
        order.setCode(code); // code
        double totalPrice = 0;
        User user = userService.queryByUserId(userId); // 2.初始化订单的用户属性
        order.setUser(user); // user
        String[] array = productIds.split(",");
        for (int i = 0 ; i < array.length; i++){
            Integer productId = Integer.valueOf(array[i]);
            totalPrice += productService.queryProductById(productId).getPrice();
        }
        DecimalFormat df=new DecimalFormat("#.00"); // 保留小数点后2位
        String total = df.format(totalPrice);
        order.setTotal(Double.valueOf(total)); // total
        orderService.saveOrder(order);
        // 3.初始化订单下的产品信息（产品可多选）
        for (int i = 0; i < array.length; i++){
            Integer orderId = id;
            Integer productId = Integer.valueOf(array[i]);
            orderService.saveItem(orderId,productId);
        }
    }

    @ApiOperation(value = "按orderId查询订单", notes = "按订单id查询订单信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", name = "orderId", value = "订单id",required = true)
    })
    @RequestMapping(value = "/queryOrderByOrderId", method = RequestMethod.POST)
    public Order queryOrderByOrderId(
        @RequestParam(value = "orderId") Integer orderId
     ){
        return  orderService.queryOrderByOrderId(orderId);
    }

    @ApiOperation(value = "按userId分页查询订单", notes = "按用户id查询订单信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", name = "page", value = "当前页", defaultValue = "1"),
        @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页显示的记录数", defaultValue = "10"),
        @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id",required = true)
    })
    @RequestMapping(value = "/queryOrderByUserId", method = RequestMethod.POST)
    public PageInfo<Order> queryOrderByUserId(
         @RequestParam(value = "userId") Integer userId,
         @RequestParam(value = "page") Integer page,
         @RequestParam(value = "pageSize") Integer pageSize
    ){
        return orderService.queryOrderByUserId(userId,page,pageSize);
    }

}
