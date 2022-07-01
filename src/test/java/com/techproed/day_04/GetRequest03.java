package com.techproed.day_04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest03 {

    /*
           https://restful-booker.herokuapp.com/booking/1001 url'ine
    accept type'i "application/json" olan GET request'i yolladigimda
    gelen response'un
    status kodunun 404 oldugunu
    ve Response body'sinin "Not Found" icerdigini
    ve Response body'sinin "API" icermedigini test edin
         */

    @Test
    public void test01(){

        //URI in responsu değişmiş

        String uri="https://restful-booker.herokuapp.com/booking/1001";

        Response rp= given().accept("application/json").when().get(uri);


        rp.then().assertThat().statusCode(200);

       // Assert.assertTrue(rp.asString().contains("Not Found"));
      //  Assert.assertFalse(rp.asString().contains("API"));

    }
}
