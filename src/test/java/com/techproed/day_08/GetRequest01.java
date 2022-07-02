package com.techproed.day_08;

import com.techproed.testBase.RestfulBookerTestBase;
import com.techproed.testData.RestFulBookerTestData;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class GetRequest01 extends RestfulBookerTestBase {

     /*
    https://restful-booker.herokuapp.com/booking/1 url ine bir istek gönderildiğinde
 dönen response body nin
{
 "firstname": "Eric",
 "lastname": "Smith",
 "totalprice": 555,
 "depositpaid": false,
 "bookingdates": {
 "checkin": "2016-09-09",
 "checkout": "2017-09-21"
 }
 } gibi olduğunu test edin
     */

    @Test
    public void test01() {

        RestFulBookerTestData rtd=new RestFulBookerTestData();

        spec02.pathParams("a","booking","b",2);

       Response rp= given().accept("application/json").spec(spec02).when().get("/{a}/{b}");

        HashMap<String,Object> actualData=rp.as(HashMap.class);

        //bu da olurmuş ama pratik değil.
      HashMap<String,Object> booking= (HashMap<String, Object>) actualData.get("bookingdates");

        Assert.assertEquals(rtd.setUpData().get("firstname"),actualData.get("firstname"));
        Assert.assertEquals(rtd.setUpData().get("lastname"),actualData.get("lastname"));
        Assert.assertEquals(rtd.setUpData().get("totalprice"),actualData.get("totalprice"));
        Assert.assertEquals(rtd.setUpData().get("depositpaid"),actualData.get("depositpaid"));
        Assert.assertEquals(rtd.setUpData().get("bookingdates"),actualData.get("bookingdates"));

        //Map'in içindeki mapin içine girmek gerekirse cast et ardından get kullan Assert.assertEquals(((Map)rtd.setUpData().get("bookingdates")),actualData.get("bookingdates"));


        //bu da olurmuş ama gerek yok
       // Assert.assertEquals(rtd.setUpData().get("checkin"),booking.get("checkin"));
       // Assert.assertEquals(rtd.setUpData().get("checkout"),booking.get("checkout"));

    }


}
