package com.bestbuy.products;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductDelete extends TestBase {
    @Test
    public void deleteProduct() {
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .pathParam("id", 9999688)
                .when()
                .delete("/products/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
