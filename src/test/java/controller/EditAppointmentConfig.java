package controller;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.EditAppointmentConfigModel;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class EditAppointmentConfig {
    Properties prop;
    public EditAppointmentConfig(Properties prop) {
        this.prop = prop;
        RestAssured.baseURI = prop.getProperty("baseUrl2");
    }

    public Response editAppointmentConfig(EditAppointmentConfigModel editAppointmentConfigModel) {
        return given().contentType("application/json")
                .header("authid", prop.getProperty("authId"))
                .body(editAppointmentConfigModel)
                .when().put("/appointment-config/org/"+prop.getProperty("orgId")+"/doctors/"+prop.getProperty("docId"));
    }
}
