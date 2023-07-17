package com.ex.prodse;

import com.ex.prodse.dto.AddProductRequest;
import com.ex.prodse.em.DiscountPolicy;
import com.ex.prodse.service.ProductService;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.awt.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;


class ProdSeApiTest extends ApiTest{


    @Test
    void 상품등록API_톄스트하기(){
        final String name ="상품명";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final var addProductRequest = new AddProductRequest(name, price , discountPolicy);

        // api  테스트
       final var response = 상품등록요청생성(addProductRequest); // 로그

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    private static ExtractableResponse<Response> 상품등록요청생성(AddProductRequest addProductRequest) {
        return RestAssured.given().log()
                .all()
                .contentType(APPLICATION_JSON_VALUE) // 헤더 정보
                .body(addProductRequest) // 응답 데이터
                .post("/products")// api path
                .then()
                .log().all().extract();
    }
}
