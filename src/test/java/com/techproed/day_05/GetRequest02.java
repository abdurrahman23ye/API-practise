package com.techproed.day_05;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class GetRequest02 {

     /*
    accept type'i "application/json" olan GET request'i yolladigimda
    gelen response'un
    status kodunun 200
    ve content type'inin "application/json"
    ve firstname'in “Jim"
    ve totalprice’in 600
    ve checkin date'in 2015-06-12"oldugunu test edin
    */

    @Test
    public void test01(){

        String uri="https://restful-booker.herokuapp.com/booking/6";

        Response response=given().accept("application/json").when().get(uri);

        response.then().statusCode(200).contentType(ContentType.JSON).
                body("firstname", equalTo("Eric")).
                body("totalprice", equalTo(714)).
                body("bookingdates.checkin", equalTo("2021-02-27"));
    }
}
