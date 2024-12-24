package controller;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.Utils;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class CheckSchedule {
    Properties prop;
    public CheckSchedule(Properties prop) {
        this.prop = prop;
        RestAssured.baseURI = prop.getProperty("baseUrl2");
    }

    public Response checkSchedule() {
        String nextMondayDate = Utils.nextMondayDate();

        return given().contentType("application/json")
                .header("authid", prop.getProperty("authId"))
                .when().get("/appointments/org/"+prop.getProperty("orgId")+"/doctor/"+prop.getProperty("docId")+"/schedule/"+prop.getProperty("scheduleId")+"?dateInt="+nextMondayDate);
    }
}
