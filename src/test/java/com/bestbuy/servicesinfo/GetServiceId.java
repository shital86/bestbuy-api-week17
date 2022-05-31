package com.bestbuy.servicesinfo;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetServiceId extends TestBase {
    @Test
    public void getAllServices() {
        Response response = given()
                .pathParam("id",1)
                .when()
                .get("/services/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
