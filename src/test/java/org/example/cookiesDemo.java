package org.example;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.util.Strings.isNullOrEmpty;

public class cookiesDemo {


    @Test
    void testCookiesDemo() {
        given()

                .when()
                .get("https://www.google.com/")
                .then()
                .statusCode(200)
                .log().all()
        ;
    }

    @Test
    void getCookiesDemo() {
        Response getCookies = given()
                .when()
                .get("https://www.google.com/");
        String cookie_value = getCookies.getCookie("AEC");
        System.out.println("Cookies Value is :" + cookie_value);
        Map<String, String> getAllCookies = getCookies.getCookies();
        System.out.println("Cookies Value is :" + getAllCookies.keySet());
        for (String k : getAllCookies.keySet()) {
            String keySet = getCookies.getCookie(k);
            System.out.println(k + "  Cookies Value is :" + keySet);
        }
    }

}
