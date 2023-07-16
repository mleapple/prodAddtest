package com.ex.prodse.service;

import com.ex.prodse.entity.Product;
import com.ex.prodse.repository.ProductRepositroy;

/**
 * fileName:ProductAdapter
 * 작성날짜:2023-07-16
 * desc :
 **/
public class ProductAdapter implements ProductPort{
    private final ProductRepositroy productRepositroy;

// 생성자
    public ProductAdapter(ProductRepositroy productRepositroy) {
        this.productRepositroy = productRepositroy;
    }

    @Override
    public void save(Product product) {
        productRepositroy.save(product);
    }



}
