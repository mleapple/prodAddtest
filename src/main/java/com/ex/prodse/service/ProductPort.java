package com.ex.prodse.service;

import com.ex.prodse.entity.Product;

import java.util.Optional;

/**
 * fileName:ProductPort
 * 작성날짜:2023-07-16
 * desc :
 **/
public interface ProductPort {
    public void save(final Product product);

    Product getProduct(long productId);
}
