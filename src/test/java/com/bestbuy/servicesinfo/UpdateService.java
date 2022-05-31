package com.bestbuy.servicesinfo;

import com.bestbuy.model.ServicePojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UpdateService extends TestBase {
    @Test
    public void updateService(){
        ServicePojo servicePojo=new ServicePojo();
        servicePojo.setName("QA Manager");
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .pathParam("id",23)
                .when()
                .body(servicePojo)
                .patch("/services/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
