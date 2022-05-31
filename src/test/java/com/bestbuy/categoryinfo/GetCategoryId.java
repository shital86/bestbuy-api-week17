package com.bestbuy.categoryinfo;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetCategoryId extends TestBase {
    @Test
    public void getAServiceOfID() {
        Response response = given()
                .pathParam("id", "abcat0020004")
                .when()
                .get("/categories/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
