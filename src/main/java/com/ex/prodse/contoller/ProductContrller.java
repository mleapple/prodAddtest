package com.ex.prodse.contoller;

import com.ex.prodse.dto.AddProductRequest;
import com.ex.prodse.dto.GetProductResponse;
import com.ex.prodse.entity.Product;
import com.ex.prodse.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    @Transactional
    public ResponseEntity<Void> addProduct(@RequestBody final AddProductRequest addProductRequest){

        productService.addProduct(addProductRequest);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<GetProductResponse> getProductResponse(@PathVariable("productId") final long productId) {

        final GetProductResponse response = productService.getProduct(productId);

       // return new ResponseEntity(response, HttpStatus.OK);

        return  ResponseEntity.ok(response);
    }
}
