package org.example;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class pathAndQueryParams {
    @Test
    void testPathParam() {
        given()
                .pathParams("mypath", "users")
                .queryParam("page", "2")
                .queryParam("id", "5")
                .when()
                .get("https://reqres.in/api/{mypath}")
                .then()
                .statusCode(200)
                .log().all()
        ;
    }
}
