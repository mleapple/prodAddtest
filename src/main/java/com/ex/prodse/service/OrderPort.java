package com.ex.prodse.service;

import com.ex.prodse.entity.Product;
import com.ex.prodse.entity.Order;
import com.ex.prodse.repository.OrderRepository;
import com.ex.prodse.repository.ProductRepository;
import org.springframework.stereotype.Component;

/**
 * fileName:OrderPort
 * 작성날짜:2023-07-18
 * desc :
 **/
@Component
public class OrderPort {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderPort(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public Product getProuctById(final Long productId){
        return productRepository.findById(productId).orElseThrow(()->new IllegalArgumentException("상품이존재하지 않습니다"));
        //return Optional.of(productRepository.findById(productId)).orElseThrow(()->new IllegalArgumentException("상품이존재하지 않습니다"));
    }
    public void save(final Order order){
        orderRepository.save(order);
    }
}
