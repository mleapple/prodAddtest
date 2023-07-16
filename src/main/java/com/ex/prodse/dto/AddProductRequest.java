package com.ex.prodse.dto;

import com.ex.prodse.em.DiscountPolicy;
import org.springframework.util.Assert;

/**
 * fileName:AddProductRequest
 * 작성날짜:2023-07-16
 * desc :
 **/
public class AddProductRequest {
    private final String name;
    private final int price;
    private final DiscountPolicy discountPolicy;
    public  AddProductRequest(final String name, final int price, final DiscountPolicy discountPolicy) {

        Assert.hasText(name             , "상품은 필수 입니다");
        Assert.isTrue(price >0 , "상품 가격은 0 보다 커야 합니다");
        Assert.notNull(discountPolicy   , "할인 정책은 필수 입니다");

        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
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
