package com.ex.prodse.service;

import com.ex.prodse.entity.Product;
import com.ex.prodse.repository.DataCrudType;
import com.ex.prodse.repository.JpaProductRepository;
import org.springframework.stereotype.Component;

/**
 * fileName:ProductAdapter
 * 작성날짜:2023-07-16
 * desc :
 **/
@Component
public class ProductAdapter implements ProductPort{
    //private final DataCrudType dataCrudType; 기존 메모리
    private final JpaProductRepository jpaProductRepository;

    //JpaProductRepositroy

// 생성자
    public ProductAdapter(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public void save(Product product) {
        jpaProductRepository.save(product);
    }



}
