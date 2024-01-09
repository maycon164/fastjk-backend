package com.deadlock.fastjk.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

class ProductControllerTest {

    @Test
    void givenInvalidBodyRequest_thenReturns400() {
        String bodyRequest = """
                {
                    "name": "product A",
                    "price": -10,
                    "quantity": -1
                }
                """;

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(bodyRequest)
                .when()
                .post("/products")
                .then()
                .statusCode(400);
    }
}
