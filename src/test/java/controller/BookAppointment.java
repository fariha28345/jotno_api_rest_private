package controller;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.BookAppointmentModel;
import model.PatientCreateModel;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class BookAppointment {
    Properties prop;
    public BookAppointment(Properties prop) {
        this.prop = prop;
        RestAssured.baseURI = prop.getProperty("baseUrl2");
    }

    public Response bookAppointment(BookAppointmentModel bookAppointmentModel) {
        return given().contentType("application/json")
                .header("authid", prop.getProperty("authId"))
                .body(bookAppointmentModel)
                .when().post("/appointments");
    }
}
