package controller;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.OldRxListModel;
import model.PatientListModel;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class OldRxList {
    Properties prop;
    public OldRxList(Properties prop) {
        this.prop = prop;
        RestAssured.baseURI = prop.getProperty("baseUrl2");
    }

    public Response oldRxList(OldRxListModel oldRxListModel) {
        return given().contentType("application/json")
                .header("authid", prop.getProperty("authId"))
                .body(oldRxListModel)
                .when().post("/prescription/org/"+prop.getProperty("orgId")+"/doctor/"+prop.getProperty("docId")+"/page");
    }
}
