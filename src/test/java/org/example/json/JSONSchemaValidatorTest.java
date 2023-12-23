package org.example.json;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


//https://jsonformatter.org/json-to-jsonschema
//convert json to jsonschema this JsonSchema use for the vallidating the Json response Schema


public class JSONSchemaValidatorTest {
    @Test
    void JSONSchemaValidatorTest() {
        given()
                .when().get("http://localhost:3000/store")
                .then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storeJsonSchema.json"));
    }
}
