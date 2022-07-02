package com.techproed.day_05;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequest03 {

    /*
    http://dummy.restapiexample.com/api/v1/employees url'ine
    accept type'i "application/json" olan GET request'i yolladigimda
    gelen response'un
    status kodunun 200
    ve content type'inin "application/json"
   ve employees sayisinin 24
   ve employee'lerden birinin "Ashton Cox"
   ve gelen yaslar icinde 21, 61, ve 23 degerlerinden birinin oldugunu test edin
     */

    @Test
    public void test01(){



        String uri="http://dummy.restapiexample.com/api/v1/employees";

        Response rp=given().accept("application/json").when().get(uri);

        rp.then().assertThat().statusCode(200).contentType(ContentType.JSON).
                body("data",hasSize(24),"data.employee_name",hasItem("Ashton Cox"),"data.employee_age",hasItems(21,23,61));



    }
}
