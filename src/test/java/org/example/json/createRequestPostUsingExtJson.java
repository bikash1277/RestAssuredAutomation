package org.example.json;


import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class createRequestPostUsingExtJson {
    String courseArr[] = {"C++", "Rest"};
    int id;

    @Test(priority = 1)
    public void testCreate() throws FileNotFoundException {
        File file = new File(".\\body.json");
        FileReader reader = new FileReader(file);
        JSONTokener jsonTokener = new JSONTokener(reader);
        JSONObject jsonObject = new JSONObject(jsonTokener);

        given().contentType("application/json")
                .body(jsonObject.toString())
                .when().post("http://localhost:3000/students")
                .then().statusCode(201)
                .body("name", equalTo("Stef"))
                .body("location", equalTo("Poland"))
                .body("course[0]", equalTo("C++"))
                .header("Content-Type", equalTo("application/json; charset=utf-8"))
                .log().all()
        ;
    }

    @Test(priority = 2)
    public void testDeleteRequest() {
        given()
                .when().delete("http://localhost:3000/students/12")
                .then()
                .statusCode(200)
                .log().all();

    }
}
