package controller;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class GetFollowUp {
    Properties prop;
    public GetFollowUp(Properties prop) {
        this.prop = prop;
        RestAssured.baseURI = prop.getProperty("baseUrl2");
    }

    public Response getFollowUp() {
        return given().contentType("application/json")
                .header("authid", prop.getProperty("authId"))
                .when().get("/prescription/orgs/"+prop.getProperty("orgId")+"/find/"+prop.getProperty("rxNumber")+"?type=FOLLOW_UP");
    }
}
