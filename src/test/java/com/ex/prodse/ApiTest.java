package com.ex.prodse;

import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

/**
 * fileName:ApiTest
 * 작성날짜:2023-07-17
 * desc :
 **/
@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiTest {

    @Autowired
    private DatabaseCleanup databaseCleanup;

    @LocalServerPort
    private int port;

    @BeforeEach
    void 초기설정하기(){
        if(RestAssured.port == RestAssured.UNDEFINED_PORT){
            RestAssured.port =port;
            databaseCleanup.afterPropertiesSet();
        }
        databaseCleanup.execute();

    }
}
