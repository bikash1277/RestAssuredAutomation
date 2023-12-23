package org.example.json;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class headerDemo {


    @Test
    void testHeaderDemo() {
        given()
                .when()
                .get("https://www.google.com/")
                .then()
                .statusCode(200)
                .header("Content-Encoding", "gzip").and()
                .header("Content-Type", "text/html; charset=ISO-8859-1")
                .log().headers()
        ;
    }

    @Test
    void getHeaderDemo() {
        Response getHeader = given()
                .when()
                .get("https://www.google.com/");
        String header_value = getHeader.getHeader("Content-Type");
        System.out.println("Header Value is :" + header_value);
        Headers getAllHeaders = getHeader.getHeaders();

        for (Header k : getAllHeaders) {

            System.out.println(k.getName() + "  Cookies Value is :" + k.getValue());
        }
    }

}
