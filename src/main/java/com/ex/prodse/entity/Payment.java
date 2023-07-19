package com.ex.prodse.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * fileName:Payment
 * 작성날짜:2023-07-19
 * desc :
 **/

@Entity
@Table(name="Paymenttb")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paytype;
    @OneToOne
    private Order order;

    private Long amoutOfpayment;


    public Payment(Order order , String  paytype){
        this.order = order;
        this.paytype = paytype;

    }

}
