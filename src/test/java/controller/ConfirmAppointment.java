package controller;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class ConfirmAppointment {
    Properties prop;
    public ConfirmAppointment(Properties prop) {
        this.prop = prop;
        RestAssured.baseURI = prop.getProperty("baseUrl2");
    }

    public Response confirmAppointment() {
        return given().contentType("application/json")
                .header("authid", prop.getProperty("authId"))
                .when().post("/appointments/"+prop.getProperty("appointmentId")+"/Confirm");
    }
}
