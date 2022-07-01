package com.techproed.day_05;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class GetRequest01 {


    @Test
    public void test01(){

         /*
    https://restful-booker.herokuapp.com/booking/7 url'ine
accept type'i "application/json" olan GET request'i yolladigimda
gelen response'un
status kodunun 200
ve content type'inin "application/json"
ve firstname'in "Mary"
ve lastname'in "Jones"
ve checkin date'in 2018-10-07"
ve checkout date'in 2020-09-30 oldugunu test edin
     */


        String uri="https://restful-booker.herokuapp.com/booking/7";
        Response rp= given().
                accept("application/json").
                when().
                get(uri);

        rp.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname",equalTo("Sally"))
        .body("lastname", equalTo("Jackson"))
        .body("totalprice", equalTo(383))
        .body("depositpaid", equalTo(true)).
                body("bookingdates.checkin", equalTo("2019-09-07")).
                body("bookingdates.checkout", equalTo("2020-05-25")).
                body("bookingdates.checkout", equalTo("2020-05-25")).
                body("additionalneeds", equalTo("Breakfast"));

        //daha kısası

        rp.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname", equalTo("Sally"),
                        "lastname", equalTo("Jackson"),
                        "totalprice", equalTo(383),"depositpaid",
                        equalTo(true),
                        "bookingdates.checkin", equalTo("2019-09-07"),
                        "bookingdates.checkout", equalTo("2020-05-25"),
                        "bookingdates.checkout", equalTo("2020-05-25"),
                        "additionalneeds", equalTo("Breakfast"));








    }
}
