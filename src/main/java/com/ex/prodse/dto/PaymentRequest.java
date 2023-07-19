package com.ex.prodse.dto;

import lombok.extern.slf4j.Slf4j;

/**
 * fileName:PaymentRequest
 * 작성날짜:2023-07-19
 * desc :
 **/
@Slf4j
public class PaymentRequest {

    private final Long orderId ;
    private final Ipay ipay;

    public  PaymentRequest(long orderId , Ipay ipay) {
        this.ipay = ipay;
        this.orderId = orderId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Ipay getIpay() {
        return ipay;
    }


}
