package org.example.authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class AuthTest {

    @Test
    void BasicAuthTest() {
        given().auth().basic("postman", "password")
                .when().get("https://postman-echo.com/basic-auth")
                .then().statusCode(200).body("authenticated", equalTo(true))
                .log().all();

    }

    @Test
    void DigestAuthTest() {
        given().auth().digest("postman", "password")
                .when().get("https://postman-echo.com/basic-auth")
                .then().statusCode(200).body("authenticated", equalTo(true))
                .log().all();

    }

    @Test
    void PreemptiveAuthTest() {
        given().auth().preemptive().basic("postman", "password")
                .when().get("https://postman-echo.com/basic-auth")
                .then().statusCode(200).body("authenticated", equalTo(true))
                .log().all();

    }

    @Test
    void BearerTokenAuthTest() {
        String bearerToken = "";
        given().header("Authorization", "Bearer" + bearerToken)
                .when().get("https://postman-echo.com/basic-auth")
                .then().statusCode(200).body("authenticated", equalTo(true))
                .log().all();
    }


    @Test
    void OAuth1Test() {
        given().auth().oauth("consumerKey", "ConsumerSecret", "accessToken", "tokenSecret")
                .when().get("https://postman-echo.com/basic-auth")
                .then().statusCode(200).body("authenticated", equalTo(true))
                .log().all();
    }

    @Test
    void OAuth2Test() {
        given().auth().oauth2("")
                .when().get("https://postman-echo.com/basic-auth")
                .then().statusCode(200).body("authenticated", equalTo(true))
                .log().all();
    }

    @Test
    void ApiKeyTest() {
        given().queryParam("appid", "")//appid is apikey
                .when().get("https://postman-echo.com/basic-auth")
                .then().statusCode(200).body("authenticated", equalTo(true))
                .log().all();
    }


}
