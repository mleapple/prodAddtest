package com.ex.prodse.service;

import com.ex.prodse.dto.PaymentRequest;
import com.ex.prodse.entity.Order;
import com.ex.prodse.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * fileName:PaymentService
 * 작성날짜:2023-07-19
 * desc :
 **/

@Slf4j
@Service
public class PaymentService {

    private PaymentPort paymentPort;

    public PaymentService(PaymentPort paymentPort) {
        this.paymentPort = paymentPort;
    }

    public void payment(PaymentRequest request) {
        //주문한 상품 확인 하기
        //주문한 상품,수량,할인 과  결제한금액 비교

        Order order             = paymentPort.getOrder(request.getOrderId()); // 가져온 주문
        long valiprice          = order.getProduct().getPrice() * order.getQunantity();
        if (request.getIpay().getamontOfpayment() == valiprice){

            final Payment payment  = new Payment(order , "카드");
            paymentPort.pay(payment); // pg 결제
            paymentPort.save(payment);
        }
    }
}
