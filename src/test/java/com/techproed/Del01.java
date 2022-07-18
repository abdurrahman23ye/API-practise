package com.techproed;

import com.techproed.testBase.JsonPlaceHolderTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Del01 extends JsonPlaceHolderTestBase {

    /*
    delete_request
8:44
Given
            https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send DELETE Request to the Url
	 	Then
		 	Status code is 200
		 	And Response body is { }
     */

    @Test
    public void test01(){

        spec01.pathParams("p1","todos","p2","198");
        Response rp=given().contentType(ContentType.JSON).spec(spec01).when().delete("/{p1}/{p2}");
        Map<String,Object> expectedBody=new HashMap<>();
        Map<String,Object> actuelBody=rp.as(Map.class);

        Assert.assertEquals(200,rp.statusCode());
        Assert.assertEquals(expectedBody,actuelBody);

    }
}
