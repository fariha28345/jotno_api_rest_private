package controller;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class DelLeave {
    Properties prop;
    public DelLeave(Properties prop) {
        this.prop = prop;
        RestAssured.baseURI = prop.getProperty("baseUrl2");
    }

    public Response delLeave() throws IOException {
        return given().contentType("application/json")
                .header("authid", prop.getProperty("authId"))
                .when().delete("/appointment-config/org/"+prop.getProperty("orgId")+"/doctors/"+prop.getProperty("docId")+"/leaves/"+prop.getProperty("leaveId"));
    }
}
