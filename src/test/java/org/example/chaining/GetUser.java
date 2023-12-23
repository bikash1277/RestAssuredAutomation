package org.example.chaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUser {

    @Test
    void getUserTest(ITestContext context) {
        int id = (int) context.getAttribute("user_id");
        String bearerToken = "a1d248a1d1c837bd6e0c74c7fba0e36ea2cf4b38cf23fe6f6d6c23c3e1f9fb8d";
        given().header("Authorization", "Bearer " + bearerToken)
                .pathParam("id", id)
                .when().get("https://gorest.co.in/public/v2/users/{id}")
                .then().statusCode(200).log().all();
        System.out.println("ID is : " + id);
    }
}
