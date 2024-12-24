package controller;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class DelTemplate {
    Properties prop;
    public DelTemplate(Properties prop) {
        this.prop = prop;
        RestAssured.baseURI = prop.getProperty("baseUrl2");
    }

    public Response delTemplate() throws IOException {
        return given().contentType("application/json")
                .header("authid", prop.getProperty("authId"))
                .when().delete("/prescription/doctor/"+prop.getProperty("docId")+"/rx-templates/"+prop.getProperty("templateId")+"/delete");
    }
}
