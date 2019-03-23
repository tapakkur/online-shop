package com.qakmak.eshop.dao;

import com.qakmak.eshop.common.Product;

import java.util.List;

/**
 * @author tapakkur
 * @ProjectName eshop
 * @Date 2019/2/17 18:26
 */
public interface ProductMapper {

    void saveProduct(Product product);
    void deleteProduct(Integer productId);
    Product queryProductById(Integer productId);
    List<Product> queryProductByOrderId (int orderId);

}
