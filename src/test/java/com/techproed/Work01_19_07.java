package com.techproed;

import com.techproed.testBase.RestfulBookerTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Work01_19_07 extends RestfulBookerTestBase {

    @Test
    public void test01(){

        spec02.pathParams("p1","booking","p2",18);

        Response rp=given().contentType(ContentType.JSON).spec(spec02).when().get("/{p1}/{p2}");

        rp.prettyPrint();

        Work01_Pojo_19_07 actualData=rp.as(Work01_Pojo_19_07.class);

        BookingDatesPojo bookingdates=new BookingDatesPojo("2018-01-01","2019-01-01");
        Work01_Pojo_19_07 expectedData=new Work01_Pojo_19_07("omto","nena",112,true,bookingdates,"Breakfast");

        Assert.assertEquals(expectedData.getFirstname(),actualData.getFirstname());
        Assert.assertEquals(expectedData.getLastname(),actualData.getLastname());
        Assert.assertEquals(expectedData.getAdditionalneeds(),actualData.getAdditionalneeds());
        Assert.assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
        Assert.assertEquals(expectedData.isDepositpaid(),actualData.isDepositpaid());
        Assert.assertEquals(expectedData.getBookingdates().toString(),actualData.getBookingdates().toString());
        Assert.assertEquals(expectedData.getBookingdates().getCheckin(),actualData.getBookingdates().getCheckin());


    }


}
