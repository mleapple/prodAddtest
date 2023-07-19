package com.ex.prodse.entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import javax.persistence.*;

/**
 * fileName:Order
 * 작성날짜:2023-07-18
 * desc :
 **/
@Slf4j

@Entity
@Table(name="ordertb")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Product product;
    private int qunantity;
    public Order(Product product, int quantity) {
        // 주문 생성 ;
        this.qunantity  = quantity;
        this.product    = product;
        Assert.notNull(product , "상품은 필수입니다");
        Assert.isTrue(quantity >0);
    }
    public void assignId(final  Long id){ //
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getQunantity() {
        return qunantity;
    }
}
