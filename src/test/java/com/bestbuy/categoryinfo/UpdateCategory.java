package com.bestbuy.categoryinfo;

import com.bestbuy.model.CategoryPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UpdateCategory extends TestBase {

    @Test
    public void updateANewService() {
        CategoryPojo categoriesPoJo = new CategoryPojo();
        categoriesPoJo.setName("Payment-GiftCard");
        categoriesPoJo.setId("abcat4545449");
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .pathParam("id","abcat4545449")
                .when()
                .body(categoriesPoJo)
                .patch("/categories/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
