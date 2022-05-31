package com.bestbuy.storeinfo;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class StoresGetTest extends TestBase {

    @Test
    public void getAllStores() {
        Response response = given()
                .when()
                .get("/stores");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void getSingleProductInfo() {
        Response response = given()
                .pathParam("id",8)
                .when()
                .get("/stores/{id}");
        response.then().statusCode(200);
        response.prettyPrint();


    }

}
