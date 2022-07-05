package com.techproed.pojoAPITests;

import com.techproed.pojos.TodosPojo1;
import com.techproed.testBase.JsonPlaceHolderTestBase;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class TodosPojo extends JsonPlaceHolderTestBase {

     /*
    https://jsonplaceholder.typicode.com/todos url ‘ine bir request gönderildiğinde
 Request body{
 "userId": 21,
 "id": 201,
 "title": "Tidy your room",
 "completed": false
}
 Status kodun 201, response body ‘nin ise
{
 "userId": 21,
 "id": 201,
 "title": "Tidy your room",
 "completed": false
 }
     */

    @Test
    public void test() {

        spec01.pathParam("parametre1", "todos");

        TodosPojo1 requestExpected = new TodosPojo1(214, 201, "Tid your room", false);


        Response response = given().
                contentType(ContentType.JSON).
                spec(spec01).
                auth().basic("admin", "password123").
                body(requestExpected).when().post("/{parametre1}");

        response.prettyPrint();


        TodosPojo1 actualData2=response.as(TodosPojo1.class);



        Assert.assertEquals(requestExpected.getId(),actualData2.getId());
        Assert.assertEquals(requestExpected.getTitle(),actualData2.getTitle());
        Assert.assertEquals(requestExpected.isCompleted(),actualData2.isCompleted());
        Assert.assertEquals(requestExpected.getUserId(),actualData2.getUserId());

    }
}
