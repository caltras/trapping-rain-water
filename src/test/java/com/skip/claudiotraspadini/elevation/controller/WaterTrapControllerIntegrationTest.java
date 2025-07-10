package com.skip.claudiotraspadini.elevation.controller;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;


@QuarkusTest
public class WaterTrapControllerIntegrationTest {

    @Test
    void testCalculateTrappedWater() {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        given()
            .contentType(ContentType.JSON)
            .body(height)
        .when()
            .post("/water-trap")
        .then()
            .statusCode(200)
            .body(is("6"));
    }

    @Test
    void testNoTrappedWater() {
        int[] height = {0,1,2,3,4,5};
        given()
            .contentType(ContentType.JSON)
            .body(height)
        .when()
            .post("/water-trap")
        .then()
            .statusCode(200)
            .body(is("0"));
    }

    @Test
    void testEmptyArray() {
        int[] height = {};
        given()
            .contentType(ContentType.JSON)
            .body(height)
        .when()
            .post("/water-trap")
        .then()
            .statusCode(200)
            .body(is("0"));
    }
} 