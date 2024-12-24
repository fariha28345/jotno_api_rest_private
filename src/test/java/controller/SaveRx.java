package controller;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.SaveRxModel;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class SaveRx {
    Properties prop;
    public SaveRx(Properties prop) {
        this.prop = prop;
        RestAssured.baseURI = prop.getProperty("baseUrl2");
    }

    public Response saveRx(SaveRxModel saveRxModel) {
        return given().contentType("application/json")
                .header("authid", prop.getProperty("authId"))
                .body(saveRxModel)
                .when().post("/prescription/org/"+prop.getProperty("orgId")+"/doctor/"+prop.getProperty("docId")+"/save");
    }
}
