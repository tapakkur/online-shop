package com.qakmak.eshop.controller;

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
@Api(value = "产品信息管理", description = "管理商城里的产品信息，并提供相应的服务")
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
}
