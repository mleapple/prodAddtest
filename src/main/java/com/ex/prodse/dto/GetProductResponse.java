package com.ex.prodse.dto;

import com.ex.prodse.em.DiscountPolicy;
import lombok.Data;
import org.springframework.util.Assert;

/**
 * fileName:GetProductResponse
 * 작성날짜:2023-07-17
 * desc :
 **/

public  class GetProductResponse {


    private long id;
    private final String name;
    private final int price;
    private final DiscountPolicy discountPolicy;


    public GetProductResponse(long id, String name, int price, DiscountPolicy discountPolicy) {
        Assert.notNull(id, "id 는 필수 입니다");
        Assert.hasText(name, "상품은 필수 입니다");
        Assert.isTrue(price > 0, "상품 가격은 0 보다 커야 합니다");
        Assert.notNull(discountPolicy, "할인 정책은 필수 입니다");

        this.id = id;
        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public String toString() {
        return "GetProductResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discountPolicy=" + discountPolicy +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public DiscountPolicy getDiscountPolicy() {
        return discountPolicy;
    }
}
