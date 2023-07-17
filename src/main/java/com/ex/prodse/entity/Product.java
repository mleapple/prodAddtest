package com.ex.prodse.entity;

import com.ex.prodse.em.DiscountPolicy;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.util.Assert;

import javax.persistence.*;

/**
 * fileName:Product
 * 작성날짜:2023-07-16
 * desc :
 **/
@Entity
@Table(name="product")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String name;
    private  int price;
    private  DiscountPolicy discountPolicy;

    public String getName() {
        return name;
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


}
