package controller;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class AppointmentConfig {
    Properties prop;
    public AppointmentConfig(Properties prop) {
        this.prop = prop;
        RestAssured.baseURI = prop.getProperty("baseUrl2");
    }

    public Response appointmentConfig() {
        return given().contentType("application/json")
                .header("authid", prop.getProperty("authId"))
                .when().get("/appointment-config/org/"+prop.getProperty("orgId")+"/doctors/"+prop.getProperty("docId"));
    }
}
