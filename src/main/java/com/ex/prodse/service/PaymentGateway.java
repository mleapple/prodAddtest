package com.ex.prodse.service;

import com.ex.prodse.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * fileName:PaymentGateway
 * 작성날짜:2023-07-19
 * desc :
 **/
@Slf4j
@Component
public class PaymentGateway {
    public void execute(final Payment payment) {
        // 결제하기
        System.out.println("payment =>>>>> " + payment);
       log.debug("결제 완료");
    }
}
