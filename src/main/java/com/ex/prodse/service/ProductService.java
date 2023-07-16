package com.ex.prodse.service;

import com.ex.prodse.dto.AddProductRequest;
import com.ex.prodse.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * fileName:ProductService
 * 작성날짜:2023-07-16
 * desc :
 **/
@Component
public class ProductService {
    private final ProductPort productPort;

    public ProductService(final ProductPort productPort) {
        this.productPort = productPort;
    }

    public void addProduct(AddProductRequest addProductRequest) {
        //throw new UnsupportedOperationException("unsupperted addProduct");
        final Product product = new Product(addProductRequest.getName(), addProductRequest.getPrice(), addProductRequest.getDiscountPolicy());
        productPort.save(product);
    }
}
