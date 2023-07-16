package com.ex.prodse;

import com.ex.prodse.dto.AddProductRequest;
import com.ex.prodse.em.DiscountPolicy;
import com.ex.prodse.repository.ProductRepositroy;
import com.ex.prodse.service.ProductAdapter;
import com.ex.prodse.service.ProductPort;
import com.ex.prodse.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

/**
 * fileName:ProductServiceTest
 * 작성날짜:2023-07-16
 * desc :
 **/
public class ProductServiceTest {

    private ProductService productService;
    private ProductPort productPort;
    private ProductRepositroy productRepositroy;

    @BeforeEach
    void 서비스생성(){
        productRepositroy   = new ProductRepositroy();
        productPort         = new ProductAdapter(productRepositroy);
        productService      = new ProductService(productPort);
    }
    @Test
    @Order(3)
    void 상품등록(){
        final String name ="상품명";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final AddProductRequest addProductRequest = new AddProductRequest(name, price , discountPolicy);
        productService.addProduct(addProductRequest);
    }
    @Test
    @Order(2)
    void 상품등록2(){
        final String name ="피자";
        final int price = 2000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final AddProductRequest addProductRequest = new AddProductRequest(name, price , discountPolicy);
        productService.addProduct(addProductRequest);
    }


}
