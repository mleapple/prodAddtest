package com.ex.prodse.repository;

import com.ex.prodse.entity.Product;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * fileName:ProductRepositroy
 * 작성날짜:2023-07-16
 * desc :
 **/
@Component
public class MemoryProductRepositroy implements DataCrudType{
/*
 */

    private Map<Long , Product> persistence = new HashMap<>();
    private Long sequence = 0L;
    public void save(final Product product){
      //  product.assignId(++sequence);
      //  persistence.put(product.getId(),product);
     //   persistence.forEach((i,p)->System.out.println(" i "+i +"="+p.toString()));
    }

    @Override
    public Product getProductById(Long productId) {
        return null;
    }

    @Override
    public Product findById(Long productId) {
        return null;
    }

}
