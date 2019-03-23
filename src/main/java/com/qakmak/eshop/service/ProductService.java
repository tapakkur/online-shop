package com.qakmak.eshop.service;

import com.github.pagehelper.PageInfo;
import com.qakmak.eshop.common.Product;

import java.util.List;

/**
 * @author tapakkur
 * @ProjectName online-shop
 * @Date 2019/3/23 12:49
 */
public interface ProductService {

    void saveProduct(Product product);
    void deleteProduct(Integer productId);
    Product queryProductById(Integer productId);
    PageInfo<Product> queryProductByOrderId(int orderId,Integer page, Integer pageSize);
}
