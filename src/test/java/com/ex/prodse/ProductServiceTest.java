package com.ex.prodse;

import com.ex.prodse.dto.AddProductRequest;
import com.ex.prodse.dto.CreateOrderRequest;
import com.ex.prodse.em.DiscountPolicy;
import com.ex.prodse.entity.Product;
import com.ex.prodse.repository.DataCrudType;
import com.ex.prodse.repository.OrderRepository;
import com.ex.prodse.repository.ProductRepository;
import com.ex.prodse.repository.ProductRepository2;
import com.ex.prodse.service.OrderPort;
import com.ex.prodse.service.OrderService;
import com.ex.prodse.service.ProductPort;
import com.ex.prodse.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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


    private OrderService orderService;

    @BeforeEach
    void setup(){
        // ===>초기화 하가ㅣ
        final OrderPort orderPort =  null;
        final ProductPort productPort = null;

        OrderRepository orderRepository = new OrderRepository() {
            private final Map<Long , com.ex.prodse.entity.Order> persistence = new HashMap<>();
            private  Long sequence = 0L;

            public void save(final com.ex.prodse.entity.Order order){
                order.assignId(++sequence);
                persistence.put(order.getId(),order);
            }
            public void mString(){
             this.persistence.forEach((t , y)-> System.out.println("msg t.toString() = " + y.toString()));
            }

            @Override
            public String toString() {
                mString();
                return super.toString();
            }
        };
        ProductRepository2 productRepository = new ProductRepository2(){

            @Override
            public void save(Product product) {

            }

            @Override
            public Product getProductById(Long productId) {
                return new Product("BMW",1000,DiscountPolicy.NONE);
            }

            @Override
            public Product findById(Long productId) {
                return new Product("BMW",2000,DiscountPolicy.NONE);
            }
        };
        orderService = new OrderService(new OrderPort(orderRepository, productRepository));
    }
    @Test
    void 상품주문(){
        // 상품주문하기
        final Long productId    = 1L;
        final int quantity      = 2;
        final CreateOrderRequest request = new CreateOrderRequest(productId , quantity);

        // 주문생성서비스
        orderService.create(request);
    }

}
