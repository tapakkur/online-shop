package com.qakmak.eshop.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
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
    public void deleteProduct(Integer productId) {
        productMapper.deleteProduct(productId);
    }

    @Override
    public Product queryProductById(Integer productId) {
        return productMapper.queryProductById(productId);
    }

    @Override
    public PageInfo<Product> queryProductByOrderId(int orderId,Integer page, Integer pageSize) {
        List<Product> resultList = productMapper.queryProductByOrderId(orderId);
        int count = resultList.size();
        // 封装返回值
        Page<Product> pageSetting = new Page<>(page,pageSize);
        pageSetting.setTotal (count);
        PageInfo<Product> pageInfo = new PageInfo<>( pageSetting);
        pageInfo.setList(resultList);
        return pageInfo;
    }

}
