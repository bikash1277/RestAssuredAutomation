package org.example.json;


import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class createRequestPostUsingHashmap {
    String courseArr[] = {"C++", "Rest"};
    int id;

    @Test(priority = 1)
    public void testUsingHashMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("name", "scott");
        hashMap.put("location", "Germany");
        hashMap.put("phone", "7952626252");
        hashMap.put("course", courseArr);

        id = given().contentType("application/json")
                .body(hashMap)
                .when().post("http://localhost:3000/students")
                .jsonPath().getInt("id")
                /*.then().statusCode(201)
                .body("name", equalTo("scott"))
                .body("location", equalTo("Germany"))
                .body("course[0]", equalTo("C++"))
                .header("Content-Type", equalTo("application/json; charset=utf-8"))
                .log().all()*/
        ;
    }

    @Test(priority = 2)
    public void testDeleteRequest() {
        given()
                .when().delete("http://localhost:3000/students/" + id)
                .then()
                .statusCode(200)
                .log().all();

    }
}
