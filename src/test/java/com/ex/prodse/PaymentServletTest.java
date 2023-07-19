package com.ex.prodse;

import com.ex.prodse.dto.AddProductRequest;
import com.ex.prodse.dto.CreateOrderRequest;
import com.ex.prodse.dto.Ipay;
import com.ex.prodse.dto.PaymentRequest;
import com.ex.prodse.em.DiscountPolicy;
import com.ex.prodse.service.OrderService;
import com.ex.prodse.service.PaymentService;
import com.ex.prodse.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * fileName:PaymentServletTest
 * 작성날짜:2023-07-19
 * desc :
 **/
@SpringBootTest
public class PaymentServletTest {

    @Autowired
    private ProductService productService;


    @Autowired
    private PaymentService paymentService;

    @Autowired
    private OrderService orderService;

    @Test
    void 상품주문(){

        //상품 등록
        final String name ="피자";
        final int price = 2000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final AddProductRequest addProductRequest = new AddProductRequest(name, price , discountPolicy);
        productService.addProduct(addProductRequest);

        // 상품주문하기
        final Long productId    = 1L;
        final int quantity      = 2;
        final CreateOrderRequest request = new CreateOrderRequest(productId , quantity);
        // 주문생성서비스
        orderService.create(request);
    }

    @Test
    void 상품주문결제하기(){


        //상품 등록
        final String name ="피자";
        final int price = 2000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final AddProductRequest addProductRequest = new AddProductRequest(name, price , discountPolicy);
        productService.addProduct(addProductRequest);

        // 상품주문하기
        final Long productId    = 1L;
        final int quantity      = 2;
        final CreateOrderRequest request = new CreateOrderRequest(productId , quantity);
        // 주문생성서비스
        orderService.create(request);

        long orderId = 1L;
        Ipay ipay = new Ipay() {
            private long amontOfpayment = 0;
            @Override
            public boolean paymentConfirmation(long amontOfpayment) {
                this.amontOfpayment =  amontOfpayment;
                return false;
            }

            @Override
            public boolean paymentConfirmation() {
                return false;
            }

            @Override
            public boolean paymentConfirmation(String paymentTyoe, long amontOfpayment) {
                // 결제가 이뤄어 졌는지 확인 하고 결과를 리턴한다
                return false;
            }

            @Override
            public long getamontOfpayment() {
                return amontOfpayment;
            }
            @Override
            public void setAmontOfpayment(long amontOfpayment) {
                this.amontOfpayment =  amontOfpayment;

            }

        };
        ipay.paymentConfirmation("카드결제" ,3000); // 결제 하기
        ipay.setAmontOfpayment(3000);

        final PaymentRequest requestPay = new PaymentRequest(orderId , ipay);   //

        paymentService.payment(requestPay);

    }

}
