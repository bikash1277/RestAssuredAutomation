package org.example.json;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class createRequestPostUsingPOJO {
    String courseArr[] = {"C++", "Rest"};
    int id;

    @Test(priority = 1)
    public void testUsingHashMap() {
        POJO_PostRequest data = new POJO_PostRequest();
        data.setName("Tiger");
        data.setLocation("France");
        data.setPhone("789789789");
        data.setCourse(courseArr);

        given().contentType("application/json")
                .body(data)
                .when().post("http://localhost:3000/students")
                .then().statusCode(201)
                .body("name", equalTo("Tiger"))
                .body("location", equalTo("France"))
                .body("course[0]", equalTo("C++"))
                .header("Content-Type", equalTo("application/json; charset=utf-8"))
                .log().all()
        ;
    }

    @Test(priority = 2)
    public void testDeleteRequest() {
        given()
                .when().delete("http://localhost:3000/students/11")
                .then()
                .statusCode(200)
                .log().all();

    }
}
