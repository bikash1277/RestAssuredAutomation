package org.example.json;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class ParsingJsonResponseData {
    @Test
    void testJsonResponse() {
        given()
                .contentType(ContentType.JSON)
                .when().get("http://localhost:3000/store")
                .then().statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                .body("book[0].author", equalTo("Ross Taylor"))
        ;
    }

    @Test
    void testAssertionResponse() {
        Response res = given()
                .contentType(ContentType.JSON)
                .when().get("http://localhost:3000/store");
        Assert.assertEquals(res.getStatusCode(), 200);
        Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
        String bookName = res.jsonPath().get("book[0].author").toString();
        Assert.assertEquals(bookName, "Ross Taylor");
    }


    @Test
    void testAssertionJsonResponse() {
        Response res = given()
                .contentType(ContentType.JSON)
                .when().get("http://localhost:3000/store");
        JSONObject jsonObject = new JSONObject(res.asString());
        for (int i = 0; i < jsonObject.getJSONArray("book").length(); i++) {
            String bookTitle = jsonObject.getJSONArray("book").getJSONObject(i).get("title").toString();

            if (bookTitle.equals("A Love tale")) {
                System.out.println(bookTitle);
                break;
            }
        }

    }


    @Test
    void testAssertionJsonValue() {
        Response res = given()
                .contentType(ContentType.JSON)
                .when().get("http://localhost:3000/store");
        JSONObject jsonObject = new JSONObject(res.asString());
        double totalPrice=0;
        for (int i = 0; i < jsonObject.getJSONArray("book").length(); i++) {
            String bookPrice = jsonObject.getJSONArray("book").getJSONObject(i).get("price").toString();
            totalPrice=totalPrice+Double.parseDouble(bookPrice);
        }
        System.out.println(totalPrice);
    }


}
