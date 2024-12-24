package controller;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class DelSchedule {
    Properties prop;
    public DelSchedule(Properties prop) {
        this.prop = prop;
        RestAssured.baseURI = prop.getProperty("baseUrl2");
    }

    public Response delSchedule() throws IOException {
        System.out.println(prop.getProperty("scheduleId"));
        return given().contentType("application/json")
                .header("authid", prop.getProperty("authId"))
                .when().delete("/appointment-config/org/"+prop.getProperty("orgId")+"/doctors/"+prop.getProperty("docId")+"/schedules/"+prop.getProperty("scheduleId"));
    }
}
