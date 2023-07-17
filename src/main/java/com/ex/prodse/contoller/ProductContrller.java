package com.ex.prodse.contoller;

import com.ex.prodse.dto.AddProductRequest;
import com.ex.prodse.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * fileName:ProductContrller
 * 작성날짜:2023-07-17
 * desc :
 **/
@RestController
@RequestMapping("/products")
public class ProductContrller {

    private final ProductService productService;

    public ProductContrller(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Void> addProduct(@RequestBody final AddProductRequest addProductRequest){

        productService.addProduct(addProductRequest);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
