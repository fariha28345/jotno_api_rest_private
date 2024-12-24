package controller;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.PatientListModel;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class PatientList {
    Properties prop;
    public PatientList(Properties prop) {
        this.prop = prop;
        RestAssured.baseURI = prop.getProperty("baseUrl2");
    }

    public Response patientList(PatientListModel patientListModel) {
        return given().contentType("application/json")
                .header("authid", prop.getProperty("authId"))
                .body(patientListModel)
                .when().post("/doctor/orgs/"+prop.getProperty("orgId")+"/patients/list");
    }
}
