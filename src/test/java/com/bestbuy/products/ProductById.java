package com.bestbuy.products;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductById extends TestBase {

    @Test
    public void findProductByID() {
        Response response = given()
                .pathParam("id", 9999682)
                .when()
                .get("/products/{id}");
        response.prettyPrint();
        response.then().statusCode(200);

    }
}