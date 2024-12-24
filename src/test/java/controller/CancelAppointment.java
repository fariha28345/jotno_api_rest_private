package controller;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class CancelAppointment {
    Properties prop;
    public CancelAppointment(Properties prop) {
        this.prop = prop;
        RestAssured.baseURI = prop.getProperty("baseUrl2");
    }

    public Response cancelAppointment() {
        return given().contentType("application/json")
                .header("authid", prop.getProperty("authId"))
                .when().post("/appointments/"+prop.getProperty("appointmentId")+"/Cancel");
    }
}
