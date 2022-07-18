package com.techproed;

import com.techproed.pojos.BookingDates;
import com.techproed.pojos.Classwork001Pojo;
import com.techproed.testBase.RestfulBookerTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Classwork001 extends RestfulBookerTestBase {

  /*  Given
            1) https://restful-booker.herokuapp.com/booking
            2) {
        "firstname": "John",
                "lastname": "Doe",
                "totalprice": 11111,
                "depositpaid": true,
                "bookingdates": {
            "checkin": "2021-09-09",
                    "checkout": "2021-09-21"
        }
    }
    When
    I send POST Request to the Url
            Then
    Status code is 200
    And response body should be like {
        "bookingid": 5315,
                "booking": {
            "firstname": "John",
                    "lastname": "Doe",
                    "totalprice": 11111,
                    "depositpaid": true,
                    "bookingdates": {
                "checkin": "2020-09-09",
                        "checkout": "2020-09-21"
            }
        }
    }

   */

    @Test
    public void test01(){

        spec02.pathParam("p1","booking");

        Map<String,String> bookingDates=new HashMap<>();

        bookingDates.put("checkin","2020-09-09");
        bookingDates.put("checkout","2020-09-21");

        Classwork001Pojo requestData=new Classwork001Pojo("John","Doe",1111,true,bookingDates);



        Response rp=given().
                contentType(ContentType.JSON).
                spec(spec02).
                body(requestData).
                when().
                post("/{p1}");

        rp.prettyPrint();


     //   Classwork001Pojo actuelData=rp.as(Classwork001Pojo.class);

       // Assert.assertEquals(requestData.getFirstname(),actuelData.getFirstname());







    }

}
