package org.example.chaining;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateUser {


    @Test
    void updateUserTest(ITestContext context) {
        Faker faker = new Faker();
        JSONObject data = new JSONObject();
        data.put("name", faker.name().fullName());
        data.put("gender", "Female");
        data.put("email", faker.internet().emailAddress());
        data.put("status", "active");

        String bearerToken = "a1d248a1d1c837bd6e0c74c7fba0e36ea2cf4b38cf23fe6f6d6c23c3e1f9fb8d";
        int id = (int) context.getAttribute("user_id");
        given().header("Authorization", "Bearer " + bearerToken)
                .contentType("application/json")
                .body(data.toString())
                .pathParam("id", id)
                .when().put("https://gorest.co.in/public/v2/users/{id}")
                .then().statusCode(200).log().all();
    }
}
