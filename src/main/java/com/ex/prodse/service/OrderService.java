package com.ex.prodse.service;

import com.ex.prodse.dto.CreateOrderRequest;
import com.ex.prodse.entity.Order;
import com.ex.prodse.entity.Product;
import org.springframework.stereotype.Service;

/**
 * fileName:OrderService
 * 작성날짜:2023-07-18
 * desc :
 **/
@Service
public class OrderService {
    private final  OrderPort orderPort;

    public OrderService(OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    // 주문생성
    public void create(CreateOrderRequest request) { //
        final Product product = orderPort.getProuctById(request.getProductId()); // 주문 상품  가져오기
        final Order order = new Order(product , request.getQuantity()); // 주문상품 생성
        orderPort.save(order);
    }
}
