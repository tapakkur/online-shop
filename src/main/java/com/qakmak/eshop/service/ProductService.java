package com.qakmak.eshop.service;

import com.qakmak.eshop.common.Product;

import java.util.List;

/**
 * @author tapakkur
 * @ProjectName online-shop
 * @Date 2019/3/23 12:49
 */
public interface ProductService {

    public void saveProduct(Product product);
    public List<Product> queryProductByOrderId (int orderId);
}
