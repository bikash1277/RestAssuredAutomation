package org.example.xml;


import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class ParsingXMLResponse {
    @Test
    void testXMLResponse() {
        given()
                .when().get("http://restapi.adequateshop.com/api/Traveler?page=1")
                .then().statusCode(200)
                .header("Content-Type", "application/xml; charset=utf-8")
                .body("TravelerinformationResponse.totalrecord", equalTo("22532"))
                .body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Developer"))
                .log().body();
    }

    @Test
    void testXMLAssertionResponse() {
        Response res = given()
                .when().get("http://restapi.adequateshop.com/api/Traveler?page=1");
        Assert.assertEquals(res.getStatusCode(), 200);
        Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
        String pageNo = res.xmlPath().get("TravelerinformationResponse.page").toString();
        Assert.assertEquals(pageNo, 1);

        String name = res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[1].name").toString();
        Assert.assertEquals(name, "AS");
    }


    @Test
    void testXMLAssertionValue() {
        Response res = given()
                .when().get("http://restapi.adequateshop.com/api/Traveler?page=1");
        XmlPath xmlPath = new XmlPath(res.asString());
        List<String> traveller = xmlPath.getList("TravelerinformationResponse.travelers.Travelerinformation");
        Assert.assertEquals(traveller.size(), 10);

        List<String> travellerName = xmlPath.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
        for (String t : travellerName) {
            System.out.println(t);
            if (t.equals("AS")) ;
            break;
        }
    }
}
