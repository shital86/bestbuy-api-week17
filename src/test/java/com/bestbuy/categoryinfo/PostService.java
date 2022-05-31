package com.bestbuy.categoryinfo;

import com.bestbuy.model.CategoryPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostService extends TestBase {
    @Test
    public void createANewService() {
        CategoryPojo categoriesPoJo = new CategoryPojo();
        categoriesPoJo.setName("Payment");
        categoriesPoJo.setId("abcat4545449");
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .when()
                .body(categoriesPoJo)
                .post("/categories");
        response.prettyPrint();
        response.then().statusCode(201);
    }
}
