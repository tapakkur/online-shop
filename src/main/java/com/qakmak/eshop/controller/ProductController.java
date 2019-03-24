package com.qakmak.eshop.controller;

import com.github.pagehelper.PageInfo;
import com.qakmak.eshop.common.Product;
import com.qakmak.eshop.service.ProductService;
import com.qakmak.eshop.service.ProductServiceImpl;
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
 * @Date 2019/3/23 12:53
 */

@RestController
@Api(value = "产品信息管理", description = "管理产品信息，并提供相应服务的后台接口")
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @ApiOperation(value = "添加产品", notes = "添加产品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "产品id", required = true),
            @ApiImplicitParam(paramType = "query", name = "name", value = "产品名称", required = true),
            @ApiImplicitParam(paramType = "query", name = "price", value = "产品单价", required = true),
            @ApiImplicitParam(paramType = "query", name = "description", value = "产品描述", required = true)
    })
    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
    public void saveProduct(
        @RequestParam("id") Integer id,
        @RequestParam("name") String name,
        @RequestParam("price") double price,
        @RequestParam("description") String description
        ){
        Product product = new Product(id,name,price,description);
        productService.saveProduct(product);
    }

    @ApiOperation(value = "按productId查询产品", notes = "按产品id查询产品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "产品id", required = true)
    })
    @RequestMapping(value = "/queryProductById", method = RequestMethod.POST)
    public Product queryProductById(
            @RequestParam(value = "id") Integer id
    ){
        return productService.queryProductById(id);
    }

    @ApiOperation(value = "删除产品", notes = "删除产品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "productId", value = "产品id", required = true)
    })
    @RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
    public void deleteProduct(
            @RequestParam("productId") Integer productId
    ){
        productService.deleteProduct(productId);
    }

    @ApiOperation(value = "按orderId分页查询产品", notes = "按订单id查询产品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "订单id", required = true),
            @ApiImplicitParam(paramType = "query", name = "page", value = "当前页", defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页显示的记录数", defaultValue = "10")
    })
    @RequestMapping(value = "/queryProductByOrderId", method = RequestMethod.POST)
    public PageInfo<Product> queryProductByOrderId(
            @RequestParam(value = "id") Integer id,
            @RequestParam(value = "page") Integer page,
            @RequestParam(value = "pageSize") Integer pageSize
    ){
        return productService.queryProductByOrderId(id,page,pageSize);
    }
}
