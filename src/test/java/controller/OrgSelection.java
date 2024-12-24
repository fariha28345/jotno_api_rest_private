package controller;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class OrgSelection {
    Properties prop;
    public OrgSelection(Properties prop) {
        this.prop = prop;
        RestAssured.baseURI = prop.getProperty("baseUrl2");
    }

    public Response orgSelection() {
        return given().contentType("application/json")
                .header("authid", prop.getProperty("authId"))
                .when().get("/doctor-workspaces/" + prop.getProperty("docId"));
    }
}
