package controller;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.AddLeaveModel;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class AddLeave {
    Properties prop;
    public AddLeave(Properties prop) {
        this.prop = prop;
        RestAssured.baseURI = prop.getProperty("baseUrl2");
    }

    public Response addLeave(AddLeaveModel addLeaveModel) {
        return given().contentType("application/json")
                .header("authid", prop.getProperty("authId"))
                .body(addLeaveModel)
                .when().post("/appointment-config/org/"+prop.getProperty("orgId")+"/doctors/"+prop.getProperty("docId")+"/leaves");
    }
}
