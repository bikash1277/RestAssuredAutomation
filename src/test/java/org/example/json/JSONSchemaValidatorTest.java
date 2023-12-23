package org.example.json;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class JSONSchemaValidatorTest {
    @Test
    void JSONSchemaValidatorTest() {
        given()
                .when().get("http://localhost:3000/store")
                .then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storeJsonSchema.json"));
    }
}
