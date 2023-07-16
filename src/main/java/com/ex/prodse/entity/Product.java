package com.ex.prodse.entity;

import com.ex.prodse.em.DiscountPolicy;
import org.springframework.util.Assert;

/**
 * fileName:Product
 * 작성날짜:2023-07-16
 * desc :
 **/
public class Product {
    private   Long id;
    private final String name;
    private final int price;
    private final DiscountPolicy discountPolicy;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discountPolicy=" + discountPolicy +
                '}';
    }

    public int getPrice() {
        return price;
    }

    public DiscountPolicy getDiscountPolicy() {
        return discountPolicy;
    }

    public Product(String name, int price, DiscountPolicy discountPolicy) {
        Assert.hasText(name , "상품명은필수 입니다");
        Assert.isTrue(price >0, "가격은 0보다 커야 합니다");
        Assert.notNull(discountPolicy ,"할인 정책은 필수 입니다");

        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
      //  throw new UnsupportedOperationException("Umsuperted Product");
    }

    public void assignId(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
}
