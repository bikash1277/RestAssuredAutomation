package org.example.json;


import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class createRequestPostUsingJsonLib {
    String courseArr[] = {"C++", "Rest"};
    int id;

    @Test(priority = 1)
    public void testCreateRequest() {
        JSONObject jsonObject = new JSONObject();


        jsonObject.put("name", "scott");
        jsonObject.put("location", "Germany");
        jsonObject.put("phone", "7952626252");
        jsonObject.put("course", courseArr);


        given().contentType("application/json")
                .body(jsonObject.toString())
                .when().post("http://localhost:3000/students")
//                .jsonPath().getInt("id")
                .then().statusCode(201)
                .body("name", equalTo("scott"))
                .body("location", equalTo("Germany"))
                .body("course[0]", equalTo("C++"))
                .header("Content-Type", equalTo("application/json; charset=utf-8"))
                .log().all()
        ;
    }

    @Test(priority = 2)
    public void testDeleteRequest() {
        given()
                .when().delete("http://localhost:3000/students/4")
                .then()
                .statusCode(200)
                .log().all();

    }
}
