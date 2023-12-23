package org.example.xml;


import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class XMLSchemaValidatorTest {
//    https://www.liquid-technologies.com/online-xml-to-xsd-converter


    @Test
    void XMLSchemaValidatorTest() {
        given()
                .when().get("http://restapi.adequateshop.com/api/Traveler")
                .then().assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("travellerXMLSchema.xsd"));
    }

}
