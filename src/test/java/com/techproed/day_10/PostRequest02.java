package com.techproed.day_10;

import com.techproed.testBase.DummyRestAPIExampleTestBase;
import com.techproed.testData.Day10PR02JsonObjectData;
import com.techproed.testData.PostRequestData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostRequest02 extends DummyRestAPIExampleTestBase {

     /*
    https://restful-booker.herokuapp.com/booking
    { "firstname": "Selim",
               "lastname": "Ak",
               "totalprice": 11111,
               "depositpaid": true,
               "bookingdates": {
                   "checkin": "2020-09-09",
                   "checkout": "2020-09-21"
                }
 }
 gönderildiğinde, Status kodun 200 olduğunu ve dönen response body nin ,
 "booking": {
         "firstname": " Selim ",
         "lastname": " Ak ",
         "totalprice":  11111,
         "depositpaid": true,
         "bookingdates": {
             "checkin": "2020-09-01",
              "checkout": " 2020-09-21”
         },
        }
olduğunu test edin
     */


    @Test
    public void test01() {

        spec02.pathParam("p1", "create");



        //JSon Object

        Day10PR02JsonObjectData day10=new Day10PR02JsonObjectData();
        JSONObject postRequest=day10.postRequest();
        JSONObject expectedData2=day10.expectedData();

        Response rp2=  given().
                accept(ContentType.JSON).
                spec(spec02).
                body(postRequest).
                when().post("/{p1}");

        rp2.prettyPrint();


       JsonPath jp =rp2.jsonPath();




   /*   Assert.assertEquals(expectedData2.getString("firstname"),jp.getString("booking.firstName"));
      Assert.assertEquals(expectedData2.getString("lastname"),jp.getString("booking.lastname"));
      Assert.assertEquals(expectedData2.getInt("totalprice"),jp.getInt("booking.totalprice"));
      Assert.assertEquals(expectedData2.getString("bookingdates.checkin"),jp.getString("booking.bookingdates.checkin"));
      Assert.assertEquals(expectedData2.getString("bookingdates.checkout"),jp.getString("booking.bookingdates.checkout"));
       Assert.assertEquals(expectedData2.getInt("statusCode"),rp2.statusCode());

    */











        //* klasik yol
/*
        PostRequestData obje=new PostRequestData();

        Map<String,String> bodyRequest=obje.setUpRequestBody();
        Map<String,Object> expectedData=obje.ExpectedData();

      Response rp=  given().accept("application/json").spec(spec02).auth().basic("admin","password123").body(bodyRequest).when().post("/{p1}");

      rp.prettyPrint();

        Map<String,Object> actuelData=rp.as(Map.class);
        actuelData.put("statusCode",rp.statusCode());

        Assert.assertEquals(expectedData.get("status"),actuelData.get("status"));
        Assert.assertEquals(expectedData.get("message"),actuelData.get("message"));
        Assert.assertEquals(expectedData.get("statusCode"),actuelData.get("statusCode"));

 */


    }
}
