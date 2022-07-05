package com.techproed.pojoAPITests;

import com.techproed.pojos.RestfulBookerPojo;
import com.techproed.testBase.RestfulBookerTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RestfulBooker extends RestfulBookerTestBase {

      /*
    https://restful-booker.herokuapp.com/booking
    request body {
                   "firstname": "Selim",
                   "lastname": "Ak",
                   "totalprice": 15000,
                   "depositpaid": true,
                   "bookingdates": {
                       "checkin": "2020-09-09",
                       "checkout": "2020-09-21"
                    }
                 }
   Status code is 200
    response body  {
                            "bookingid": 11,
                            "booking": {
                                "firstname": "Selim",
                                "lastname": "Ak",
                                "totalprice": 15000,
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

        RestfulBookerPojo bookingdates =new RestfulBookerPojo("2021-09-09","2020-09-21");

        RestfulBookerPojo bodyRequest=new
                RestfulBookerPojo("Slim","A",1500,true,bookingdates);

        Response rp=given().
                contentType(ContentType.JSON).
                spec(spec02).
                body(bodyRequest).
                when().
                post("/{p1}");

        rp.prettyPrint();


       RestfulBookerPojo actuelData=rp.as(RestfulBookerPojo.class);


        Assert.assertEquals(bodyRequest.getFirstname(),actuelData.getBooking().getFirstname());
        Assert.assertEquals(bodyRequest.getLastname(),actuelData.getBooking().getLastname());
        Assert.assertEquals(bodyRequest.getTotalprice(),actuelData.getBooking().getTotalprice());
        Assert.assertEquals(bodyRequest.isDepositpaid(),actuelData.getBooking().isDepositpaid());
        Assert.assertEquals(bodyRequest.getBookingdates().getCheckin(),actuelData.getBooking().getBookingdates().getCheckin());
        Assert.assertEquals(bodyRequest.getBookingdates().getCheckout(),actuelData.getBooking().getBookingdates().getCheckout());
        Assert.assertEquals(200,rp.statusCode());





    }


}
