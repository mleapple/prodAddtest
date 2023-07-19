package com.ex.prodse.contoller;

import com.ex.prodse.dto.AddProductRequest;
import com.ex.prodse.dto.CreateOrderRequest;
import com.ex.prodse.service.OrderService;
import com.ex.prodse.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * fileName:OrderController
 * 작성날짜:2023-07-19
 * desc :
 **/
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final ProductService productService;
    private final OrderService orderService;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> createOrder(@RequestBody final CreateOrderRequest createOrderRequest){

        orderService.create(createOrderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
