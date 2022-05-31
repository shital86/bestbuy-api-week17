package com.bestbuy.servicesinfo;

import com.bestbuy.model.ServicePojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteService extends TestBase {
    @Test
    public void deleteAService() {
        ServicePojo servicesPojo = new ServicePojo();
        Response response = given()
                .pathParam("id",20)
                .when()
                .delete("/services/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
