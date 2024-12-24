package controller;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class GetRxNumber {
    Properties prop;
    public GetRxNumber(Properties prop) {
        this.prop = prop;
        RestAssured.baseURI = prop.getProperty("baseUrl2");
    }

    public Response getRxNumber() {
        return given().contentType("application/json")
                .header("authid", prop.getProperty("authId"))
                .when().get("/prescription/doctor/"+prop.getProperty("docId")+"/rxNumber");
    }
}
