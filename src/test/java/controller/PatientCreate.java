package controller;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.PatientCreateModel;
import model.PatientListModel;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class PatientCreate {
    Properties prop;
    public PatientCreate(Properties prop) {
        this.prop = prop;
        RestAssured.baseURI = prop.getProperty("baseUrl2");
    }

    public Response patientCreate(PatientCreateModel patientCreateModel) {
        return given().contentType("application/json")
                .header("authid", prop.getProperty("authId"))
                .body(patientCreateModel)
                .when().post("/doctor/orgs/"+prop.getProperty("orgId")+"/patients");
    }
}
