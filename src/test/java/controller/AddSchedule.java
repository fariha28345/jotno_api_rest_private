package controller;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.AddScheduleModel;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class AddSchedule {
    Properties prop;
    public AddSchedule(Properties prop) {
        this.prop = prop;
        RestAssured.baseURI = prop.getProperty("baseUrl2");
    }

    public Response addSchedule(AddScheduleModel addScheduleModel) {
        return given().contentType("application/json")
                .header("authid", prop.getProperty("authId"))
                .body(addScheduleModel)
                .when().post("/appointment-config/org/"+prop.getProperty("orgId")+"/doctors/"+prop.getProperty("docId")+"/schedules");
    }
}
