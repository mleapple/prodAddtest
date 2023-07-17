package com.ex.prodse;

import com.ex.prodse.dto.AddProductRequest;

import com.ex.prodse.dto.GetProductResponse;
import com.ex.prodse.dto.UpdateProductRequest;
import com.ex.prodse.em.DiscountPolicy;
import com.ex.prodse.entity.Product;
import com.ex.prodse.service.ProductPort;
import com.ex.prodse.service.ProductService;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import lombok.extern.slf4j.Slf4j;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Slf4j
class ProdSeApiTest extends ApiTest{

    @Autowired
    private ProductService productService ;
    @Test
    void 상품등록API_톄스트하기(){
        final String name ="상품명";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final var addProductRequest = new AddProductRequest(name, price , discountPolicy);

        // api  테스트
       final var response = 상품_등록_요청생성(addProductRequest); // 로그

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    private static ExtractableResponse<Response> 상품_등록_요청생성(AddProductRequest addProductRequest) {
        return RestAssured.given().log()
                .all()
                .contentType(APPLICATION_JSON_VALUE) // 헤더 정보
                .body(addProductRequest) // 응답 데이터
                .post("/products")// api path
                .then()
                .log().all().extract();
    }

    @Test
    void 상품조회(){

        // 상품등록
        final String name ="상품명";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final var addProductRequest = new AddProductRequest(name, price , discountPolicy);

        final long productId = 1L; // 가져올 아이디

        // api  테스트
        final var response = 상품_등록_요청생성(addProductRequest); // 로그

        // 상품조회
        final GetProductResponse getProductResponse = productService.getProduct(productId);//상품조회요청서비스(productId); //
        System.out.println("getProductResponse.toString() = " + getProductResponse.toString());

        log.debug("========> "+getProductResponse.toString());

        // 상품의 응답을 검증
        assertThat(getProductResponse).isNotNull(); // 일단 널체크
    }
  

    private static ExtractableResponse<Response> 상품_조회_요청(long productId) {
        return   RestAssured.given().log().all()
                .when()
                .get("/products/{productId}" , productId)
                .then().log().all()
                .extract();


    }

    @Test
    void 상품등록API_조회톄스트하기(){
        // 상품등록
        final String name ="자전거";
        final int price = 2000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final var addProductRequest = new AddProductRequest(name, price , discountPolicy);
        final long productId = 1L; // 가져올 아이디
        // api  테스트
        // 등록
        final var response = 상품_등록_요청생성(addProductRequest); // 로그 상품등록요청생성(addProductRequest); // 로그
        final var getResponse = 상품_조회_요청(productId);

        log.debug("getResponse.jsonPath={}",getResponse.jsonPath());
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(getResponse.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(getResponse.jsonPath().getString("name")).isEqualTo("자전거");
    }


    void 초기데이터설정(){

    }
    @Test
    void 삼품_수정_요청(){
       final Long productId = 1L;
       final UpdateProductRequest request = new UpdateProductRequest("상품수정",3333,DiscountPolicy.NONE);
       final Product product = new Product("상품명",1000,DiscountPolicy.NONE);


        final ProductPort productPort = new ProductPort() {
            @Override
            public void save(Product product) {

            }

            @Override
            public Product getProduct(long productId) {
                return product;
            }
        };

        productService = new ProductService(productPort);

        productService.updateProduct(productId , request);

        log.debug("=================>수정");
        assertThat(product.getName()).isEqualTo("상품수정");
    }

}
