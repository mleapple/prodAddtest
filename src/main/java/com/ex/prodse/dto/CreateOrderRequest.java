package com.ex.prodse.dto;

import org.springframework.util.Assert;

/**
 * fileName:CreateOrderRequest
 * 작성날짜:2023-07-18
 * desc :
 **/
public class CreateOrderRequest {
    private Long productId = 1L;
    private int quantity = 2;

    public CreateOrderRequest(){}

    public CreateOrderRequest(Long productId, int quantity) { // 주문 생성하기
        Assert.notNull(productId, "productId 는 null 아닙니다");
        Assert.isTrue(quantity > 0, "quantity 는 0보다 커야 합니다");
    }
    public Long getProductId() {
        return productId;
    }
    public int getQuantity() {
        return quantity;
    }
}
