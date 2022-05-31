package com.bestbuy.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class StoreExtraction {
    public static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;

        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);

    }

    @Test
    public void test001() {
//Extract the limit
        int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test002() {
        //Extract the total
        int total = response.extract().path("total");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of total is : " + total);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test003() {
        //Extract the name of 5th store
        String name = response.extract().path("data[4].name");
        System.out.println(" Extract the name of 5th store");
        System.out.println(" The name of 5th store is " + name);
        System.out.println("**************************************************************");
    }

    @Test
    public void test004() {
        //Extract the names of all the store
        List<String> stores = response.extract().path("data.name");
        System.out.println(" Extract the name of all the stores");
        System.out.println(" The name of all stores are: ");
        System.out.println("**************************************************************");
        for (String allAtores : stores
        ) {
            System.out.println(allAtores);
        }
    }

    @Test
    public void test005() {
        //Extract the storeId of all the store
        List<Integer> storeId = response.extract().path("data.id");
        System.out.println(" Extract the storeId of all the store");
        System.out.println(" The storeId of all the store: ");
        System.out.println("**************************************************************");
        for (Integer allStoreId : storeId
        ) {
            System.out.println(allStoreId);
        }
    }

    @Test
    public void test006() {
        //Print the size of the data list
        List<String> data = response.extract().path("data");
        System.out.println(" Print the size of the data list");
        System.out.println(" The size of the data list is " + data.size());
        System.out.println("***************************************");

    }

    @Test
    public void test007() {
        //Get all the value of the store where store name = St Cloud
        List<String> storeNames = response.extract().path("data.findAll{it.name == 'St Cloud'}");
        System.out.println(" Get all the value of the store where store name = St Cloud");
        System.out.println(" The value of the store where store name = St Cloud is: " + storeNames);

    }

    @Test
    public void test008() {
        //Get the address of the store where store name = Rochester
        List<String> address = response.extract().path("data.findAll{it.name == 'Rochester'}.address");
        System.out.println(" Print the address of the store where store name = Rochester");
        System.out.println(" The address of the store where store name = 'Rochester' is: " + address);
        System.out.println("**************************************************************");
    }

    @Test
    public void test009() {
        //Get all the services of 8th store
        List<String> services = response.extract().path("data[7].services");
        System.out.println("Get all the services of 8th store ");
        System.out.println(" Get all the services of 8th store: " + services);
        System.out.println("**************************************************************");
    }

    @Test
    public void test010() {
        //Get storeservices of the store where service name = Windows Store
        List<String> serviceName = response.extract().path("data.findAll{it.services.findAll{it.name=='Windows Store'}}.services.storeservices");
        System.out.println("Get storeservices of the store where service name = Windows Store");
        System.out.println("Get storeservices of the store where service name = Windows Store: " + serviceName);
        System.out.println("**************************************************************");

    }

    @Test
    public void test011() {
        //Get all the storeId of all the store
        List<Integer> storeIds = response.extract().path("data.services.storeservices.storeId");
        System.out.println("Get all the storeId of all the stores");
        System.out.println("The storeId of all the stores are: " + storeIds);
        System.out.println("**************************************************************");

    }

    @Test
    public void test012() {
        //Get id of all the store
        List<Integer> storeIds = response.extract().path("data.id");
        System.out.println(" Get all the storeId of all the stores");
        System.out.println("The storeId of all the stores are: " + storeIds);
        System.out.println("**************************************************************");
    }

    @Test
    public void test013() {
        //Find the store names Where state = ND
        List<String> storeNames = response.extract().path("data.findAll{it.state == 'ND'}.name");
        System.out.println(" Find the store names Where state = ND");
        System.out.println(" The store names Where state = ND is: " + storeNames);
        System.out.println("**************************************************************");
    }

    @Test
    public void test014() {
        //14. Find the Total number of services for the store where store name = Rochester
        List<List<String>> services = response.extract().path("data.findAll{it.name=='Rochester'}.services.name");
        System.out.println("Find the Total number of services for the store where store name = Rochester");
        System.out.println("The total number of services for the store where store name = Rochester are : " + services.size());
        System.out.println("**************************************************************");
    }
    @Test
    public void test015(){
        //15. Find the createdAt for all services whose name = “Windows Store”
        List<List<String>> createdat = response.extract().path("data.findAll{it.services.findAll{it.name=='Windows Store'}}.services.createdAt");
        System.out.println("Find the createdAt for all services whose name = Windows Store");
        System.out.println("The createdAt for all services whose name = Windows Store : " + createdat);
        System.out.println("**************************************************************");

    }

    @Test
    public void test016() {
        //16. Find the name of all services Where store name = “Inver Grove Heights”
        List<String> servicesName = response.extract().path("data.findAll{it.name=='Inver Grove Heights'}.services.name");
        System.out.println("Find the createdAt for all services whose name = Windows Store");
        System.out.println("The name of all services Where store name = “Inver Grove Heights” are : " + servicesName);
        System.out.println("**************************************************************");
    }

    @Test
    public void test017() {
        //17. Find the zip of all the store
        List<String> zip = response.extract().path("data.zip");
        System.out.println(" Find the zip of all the store");
        System.out.println("The zip of all the stores are : " + zip);
        System.out.println("**************************************************************");
    }

    @Test
    public void test018() {
        //18. Find the zip of store name = Fargo
        List<String> zip = response.extract().path("data.findAll{it.name=='Fargo'}.zip");
        System.out.println(" Find the zip of store name = Fargo");
        System.out.println(" The zip of store name = Fargo : " + zip);
        System.out.println("**************************************************************");
    }

    @Test
    public void test019() {
        //19. Find the storeservices details of the service name = Samsung Experience
        List<String> storeServices = response.extract().path("data.findAll{it.services.findAll{it.name=='Samsung Experience'}}.services.storeservices");
        System.out.println(" Find the storeservices details of the service name = Samsung Experience");
        System.out.println("The storeservices details of the service name = Samsung Experience : " + storeServices);
        System.out.println("**************************************************************");
    }

    @Test
    public void test020() {
        //20. Find the lat of all the stores
        List<String> lat = response.extract().path("data.lat");
        System.out.println(" Find the lat of all the stores");
        System.out.println(" The latitude of all the stores " + lat);
        System.out.println("**************************************************************");
    }


}


