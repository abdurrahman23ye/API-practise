package com.techproed;

import com.techproed.testBase.JsonPlaceHolderTestBase;
import com.techproed.testBase.RestfulBookerTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ClassWork extends RestfulBookerTestBase {

    @Test
    public void get01() {
        // 1. Set the URL
        spec02.pathParams("first", "booking","second",887);
        // 2. Set the expected Data---> SKIPPED
        // 3. Send the request and get the response
        Response response = given().spec(spec02).when().get("/{first}/{second}");
        response.prettyPrint();
        //4. Do Assertion
        response.then().assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body(
                        "firstname",equalTo("Emely"),
                        "lastname", equalTo("Straver"),
                        "totalprice",equalTo(967),
                        "depositpaid",equalTo(false),
                        "bookingdates",hasEntry("checkin","2022-07-06"),
                        "bookingdates",hasEntry("checkout","2022-07-19"),
                        "additionalneeds",equalTo("Extra Pillow"));
    }
}

