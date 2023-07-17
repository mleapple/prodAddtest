package com.ex.prodse;

import com.ex.prodse.dto.AddProductRequest;
import com.ex.prodse.em.DiscountPolicy;
import com.ex.prodse.entity.Product;
import com.ex.prodse.service.ProductAdapter;
import com.ex.prodse.service.ProductPort;
import com.ex.prodse.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * fileName:ProductServiceTest
 * 작성날짜:2023-07-16
 * desc :
 **/
@Slf4j
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

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
        //
    }


    @Test
    void update() {
       final Product product =  new Product("그렌져",7000,DiscountPolicy.NONE);

       product.update("수정",6700,DiscountPolicy.NONE);

       assertThat(product.getName()).isEqualTo("수정");
       assertThat(product.getPrice()).isEqualTo(2000);

       log.debug("=========> update");
    }
}
