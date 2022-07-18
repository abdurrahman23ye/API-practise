package com.techproed;

import com.techproed.pojos.Classwork002pojo;
import com.techproed.testBase.JsonPlaceHolderTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ClassWork002 extends JsonPlaceHolderTestBase {

   /* Given
	        1) https://jsonplaceholder.typicode.com/todos/198
            2) {
        "userId": 21,
                "title": "Wash the dishes",
                "completed": false
    }
    When
    I send PUT Request to the Url
            Then
    Status code is 200
    And response body is like   {
        "userId": 21,
                "title": "Wash the dishes",
                "completed": false
    }
     */

    @Test
    public void test01(){

        spec01.pathParams("p1","todos","p2",198);

        Classwork002pojo bodyRequest=new Classwork002pojo(25,"Wash the dishes",false);

        Response rp=given().contentType(ContentType.JSON).spec(spec01).body(bodyRequest).when().put("/{p1}/{p2}");

        rp.prettyPrint();

        Classwork002pojo expectedData=bodyRequest;

        Map actuelData=rp.as(Map.class);

        Assert.assertEquals(expectedData.getUserId(),actuelData.get("userId"));
        Assert.assertEquals(expectedData.getTitle(),actuelData.get("title"));
        Assert.assertEquals(expectedData.isCompleted(),actuelData.get("completed"));




    }
}
