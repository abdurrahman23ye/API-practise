package com.techproed;

import com.techproed.testBase.RestfulBookerTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ClassWork2 extends RestfulBookerTestBase {
  /*  Given
    https://restful-booker.herokuapp.com/booking/111
    When
    User send a GET request to the URL
    Then
    HTTP Status Code should be 200
    And
    Response content type is “application/json”
    And
    Response body should be like;
   {
    "firstname": "GGS",
    "lastname": "FINCH",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    }
}

   */

    @Test
    public void test01(){

        spec02.pathParams("p1","booking","p2",101);

        Response rp=given().contentType(ContentType.JSON).spec(spec02).when().get("/{p1}/{p2}");

        rp.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname", equalTo("GGS")).
                body("lastname", equalTo("FINCH")).
                body("totalprice", equalTo(111)).
                body("depositpaid", equalTo(true)).
                body("bookingdates.checkin", equalTo("2018-01-01")).
                body("bookingdates", hasEntry("checkin","2018-01-01")).
                body("bookingdates", hasEntry("checkout","2019-01-01"));

















    }
}
