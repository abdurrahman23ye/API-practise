package com.techproed;

import com.techproed.pojos.Work01Pojo;
import com.techproed.testBase.DummyRestAPIExampleTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Work01 extends DummyRestAPIExampleTestBase {

    /*
    https://dummy.restapiexample.com/api/v1/create
    {"name":"test","salary":1231111,"age":13}
    result:

    {
    "status": "success",
    "data": {
        "name": "test",
        "salary": 1231111,
        "age": 13,
        "id": 2891
    },
    "message": "Successfully! Record has been added."
}
     */

    @Test
    public void test01(){

        spec02.pathParam("p1","create");

        Work01Pojo bodyRequest=new Work01Pojo("ali",22323,2323232);

        Response rp=given().
               contentType(ContentType.JSON).
                spec(spec02).
                body(bodyRequest).
                when().
                post("/{p1}");

        rp.prettyPrint();

        Map<String,Object> actuelData=rp.as(Map.class);

        Assert.assertEquals(((Map)actuelData.get("data")).get("name"),bodyRequest.getName());
        Assert.assertEquals(((Map)actuelData.get("data")).get("salary"),bodyRequest.getSalary());
        Assert.assertEquals(((Map)actuelData.get("data")).get("age"),bodyRequest.getAge());
        Assert.assertTrue(actuelData.get("status").equals("success"));
        Assert.assertTrue(actuelData.get("message").equals("Successfully! Record has been added."));




    }
}
