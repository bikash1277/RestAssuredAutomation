package org.example;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class httpRequest {
    int id;

    @Test(priority = 1)
    public void getListUser() {
        given()
                .when().get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("page", equalTo(2))
                .log().all();
    }

    @Test(priority = 4, enabled = false)
    public void createUser() {
        HashMap hashMap = new HashMap<>();
        hashMap.put("name", "shaun");
        hashMap.put("job", "Maintainer");
        given()
                .contentType("application/json")
                .body(hashMap)
                .when().post("https://reqres.in/api/users")

                .then()
                .statusCode(201)
                .log().all();
    }

    @Test(priority = 2)
    public void createUserGetId() {
        HashMap hashMap = new HashMap<>();
        hashMap.put("name", "shaun");
        hashMap.put("job", "Maintainer");
        id = given()
                .contentType("application/json")
                .body(hashMap)
                .when().post("https://reqres.in/api/users")
                .jsonPath().getInt("id");
                /*.then()
                .statusCode(201)
                .log().all();*/
    }

    @Test(dependsOnMethods = {"createUserGetId"}, priority = 3)
    public void updateUser() {
        HashMap hashMap = new HashMap<>();
        hashMap.put("name", "shaun");
        hashMap.put("job", "Developer");
        given()
                .contentType("application/json")
                .body(hashMap)
                .when().put("https://reqres.in/api/users/" + id)

                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 4)
    public void deleteUser() {
        given()
                .when().delete("https://reqres.in/api/users/" + id)
                .then()
                .statusCode(204)
                .log().all();
    }
}
