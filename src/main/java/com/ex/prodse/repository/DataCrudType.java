package com.ex.prodse.repository;

import com.ex.prodse.entity.Product;

/**
 * fileName:DataCrudType
 * 작성날짜:2023-07-17
 * desc :
 **/
public interface DataCrudType {

    void save(final Product product);

    Product getProductById(Long productId);

    Product findById(Long productId);


}
