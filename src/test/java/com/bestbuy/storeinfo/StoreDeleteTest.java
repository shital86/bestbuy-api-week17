package com.bestbuy.storeinfo;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class StoreDeleteTest extends TestBase {

    @Test
    public void deleteAstoreById(){
        Response response = given()
                .pathParam("id",4)
                .when()
                .delete("/stores/{id}");
        response.then().statusCode(204);
        response.prettyPrint();
    }

}
