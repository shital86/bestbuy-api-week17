package com.bestbuy.products;

import com.bestbuy.model.ProductPoJo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductPatch extends TestBase {

    @Test
    public void updateProduct() {
        ProductPoJo productsPoJo = new ProductPoJo();
        productsPoJo.setName("iphone");
        productsPoJo.setType("Smartphone");
        productsPoJo.setPrice(900);
        productsPoJo.setShipping(80);
        productsPoJo.setUpc("89787665654");
        productsPoJo.setDescription("/Asia");
        productsPoJo.setManufacturer("Apple");
        productsPoJo.setModel("i5");
        productsPoJo.setUrl("https://www.Apple.com/");
        productsPoJo.setImage("https://www.Apple.com/images/Apple-09.png");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(productsPoJo)
                .pathParam("id",  9999682)
                .when()
                .patch("/products/{id}");
        response.prettyPrint();
        response.then().statusCode(200);

    }
}

