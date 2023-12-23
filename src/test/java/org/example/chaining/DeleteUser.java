package org.example.chaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteUser {


    @Test
    void deleteUserTest(ITestContext context) {

        String bearerToken = "a1d248a1d1c837bd6e0c74c7fba0e36ea2cf4b38cf23fe6f6d6c23c3e1f9fb8d";
        int id = (int) context.getAttribute("user_id");
        given().header("Authorization", "Bearer " + bearerToken)
                .contentType("application/json")
                .pathParam("id", id)
                .when().delete("https://gorest.co.in/public/v2/users/{id}")
                .then().statusCode(204).log().all();
    }
}
