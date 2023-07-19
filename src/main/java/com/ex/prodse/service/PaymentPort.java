package com.ex.prodse.service;

import com.ex.prodse.em.DiscountPolicy;
import com.ex.prodse.entity.Order;
import com.ex.prodse.entity.Payment;
import com.ex.prodse.entity.Product;
import com.ex.prodse.repository.OrderRepository;
import com.ex.prodse.repository.PayRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * fileName:PaymentPort
 * 작성날짜:2023-07-19
 * desc :
 **/
@Component
public class PaymentPort {

    private PaymentGateway paymentGateway;

    private PayRepository payRepository;

    private OrderRepository orderRepository;

    public PaymentPort(PaymentGateway paymentGateway, PayRepository payRepository, OrderRepository orderRepository) {
        this.paymentGateway = paymentGateway;
        this.payRepository = payRepository;
        this.orderRepository = orderRepository;
    }

    public Order getOrder(Long orderId) {
        //return // 오더가가져오기
        //조회한 오더가 와야 함
        //return new Order(new Product("bmw",3000, DiscountPolicy.NONE),1);
         return orderRepository.findById(orderId).orElseThrow(()-> new IllegalArgumentException("샘플이 존재하지 않습니다"));
    }
    public void pay(Payment payment) {
        // 결제 시키기 PG
        paymentGateway.execute(payment);
    }
    public void save(Payment payment) {
       // 결제전 정보 저장 하기
        payRepository.save(payment);
    }
}
