package com.qakmak.eshop.service;

import com.qakmak.eshop.common.Product;
import com.qakmak.eshop.dao.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tapakkur
 * @ProjectName online-shop
 * @Date 2019/3/23 12:50
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public void saveProduct(Product product) {
        productMapper.saveProduct(product);
    }

    @Override
    public List<Product> queryProductByOrderId(int orderId) {
        return null;
    }
}
