package controller;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.SignInModel;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class SignIn {
    Properties prop;
    public SignIn(Properties prop) {
        this.prop = prop;
        RestAssured.baseURI = prop.getProperty("baseUrl");
    }

    public Response signIn(SignInModel signInModel) {
        return given().contentType("application/json")
                .body(signInModel)
                .when().post("/login");
    }
}
