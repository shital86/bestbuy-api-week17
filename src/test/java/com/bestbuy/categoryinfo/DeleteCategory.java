package com.bestbuy.categoryinfo;

import com.bestbuy.model.ServicePojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteCategory extends TestBase {
    @Test
    public void deleteAService() {
        ServicePojo servicesPojo = new ServicePojo();
        Response response = given()
                .pathParam("id","abcat4545449")
                .when()
                .delete("/categories/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
