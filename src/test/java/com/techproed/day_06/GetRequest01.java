package com.techproed.day_06;

import com.techproed.testBase.RestfulBookerTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest01 extends RestfulBookerTestBase {

    @Test
    public void test01(){

        /*
        https://restful-booker.herokuapp.com/booking/5 url’ine bir request yolladigimda
    HTTP Status Code’unun 200
    ve response content type’inin “application/JSON” oldugunu
    ve response body’sinin asagidaki gibi oldugunu test edin
    {"firstname": Sally,
            "lastname": "Smith",
            "totalprice": 789,
            "depositpaid": false,
            "bookingdates": {
               "checkin": "2017-12-11",
                "checkout":"2020-02-20"
                 }
         */

        spec02.pathParams("para1","booking","para2",7);

        Response response=given().
                accept("application/json").
                spec(spec02).
                when().
                get("/{para1}/{para2}");

        JsonPath jsonPath=response.jsonPath();

        Assert.assertEquals("Sally",jsonPath.getString("firstname"));
        Assert.assertEquals("Jackson",jsonPath.getString("lastname"));
        Assert.assertEquals(true,jsonPath.getBoolean("depositpaid"));
        Assert.assertEquals("2019-09-07",jsonPath.getString("bookingdates.checkin"));
        Assert.assertEquals("2020-05-25",jsonPath.getString("bookingdates.checkout"));
        Assert.assertEquals(383,jsonPath.getInt("totalprice"));


        //matcher yöntemi

        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).body("firstname", equalTo("Sally"),
                        "lastname", equalTo("Jackson"),
                        "depositpaid",equalTo(true),"totalprice",equalTo(383),
                        "bookingdates.checkin",equalTo("2019-09-07"),
                        "bookingdates.checkout",equalTo("2020-05-25"));

    }
}
