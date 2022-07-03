package com.techproed.day_10;

import com.techproed.testBase.DummyRestAPIExampleTestBase;
import com.techproed.testData.PostRequestData;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostRequest01 extends DummyRestAPIExampleTestBase {

     /*
    http://dummy.restapiexample.com/api/v1/create url ine, Request Body olarak
{
 "name":"Ahmet Aksoy",
 "salary":"1000",
 "age":"18",
  }
gönderildiğinde,Status kodun 200 olduğunu ve dönen response body nin ,
{
 "status": "success",
 "data": {
 “id”:…
 },
 "message": "Successfully! Record has been added."
 }
olduğunu test edin
     */

    @Test
    public void test01() {

        spec02.pathParam("p1", "create");

        PostRequestData obje=new PostRequestData();

        Map<String,String> bodyRequest=obje.setUpRequestBody();
        Map<String,Object> expectedData=obje.ExpectedData();

      Response rp=  given().accept("application/json").spec(spec02).body(bodyRequest).when().post("/{p1}");

      rp.prettyPrint();

        Map<String,Object> actuelData=rp.as(Map.class);
        actuelData.put("statusCode",rp.statusCode());

        Assert.assertEquals(expectedData.get("status"),actuelData.get("status"));
        Assert.assertEquals(expectedData.get("message"),actuelData.get("message"));
        Assert.assertEquals(expectedData.get("statusCode"),actuelData.get("statusCode"));


    }
}
