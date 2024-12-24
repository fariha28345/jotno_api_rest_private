package controller;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class SaveTemplate {
    Properties prop;
    public SaveTemplate(Properties prop) {
        this.prop = prop;
        RestAssured.baseURI = prop.getProperty("baseUrl2");
    }

    public Response saveTemplate(File filePath) {
        return given().contentType("application/json")
                .header("authid", prop.getProperty("authId"))
                .body(filePath)
                .when().post("prescription/doctor/"+prop.getProperty("docId")+"/rx-templates/save");
    }
}
