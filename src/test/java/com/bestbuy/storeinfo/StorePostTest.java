package com.bestbuy.storeinfo;

import com.bestbuy.model.StoresPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class StorePostTest extends TestBase {

@Test
  public void postCreateNewStore(){
  StoresPojo storePojo=new StoresPojo();
  storePojo.setName("Kim");
  storePojo.setType("abc");
  storePojo.setAddress("3 Avenue");
  storePojo.setAddress2("A Close");
  storePojo.setCity("Ahemdabad");
  storePojo.setState("Gujarat");
  storePojo.setZip("380024");
  storePojo.setLat(22.1234);
  storePojo.setLng(56.345);
  storePojo.setHours("Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8");
 Response response= given()
          .contentType(ContentType.JSON)
          .body(storePojo)
          .when()
          .post("/stores");
  response.then().statusCode(201);
  response.prettyPrint();

}
  }

