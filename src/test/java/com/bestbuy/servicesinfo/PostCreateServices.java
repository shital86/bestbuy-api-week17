package com.bestbuy.servicesinfo;

import com.bestbuy.model.ServicePojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostCreateServices extends TestBase {
    @Test
    public void createService(){

            ServicePojo servicesPojo = new ServicePojo();
            servicesPojo.setName("Api Tester");
            Response response = given()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .when()
                    .body(servicesPojo)
                    .post("/services");
            response.prettyPrint();
            response.then().statusCode(201);
    }
}
