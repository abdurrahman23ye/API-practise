package com.techproed.day_11;

import com.techproed.testBase.JsonPlaceHolderTestBase;
import com.techproed.testData.PostRequest03Data;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostRequest03 extends JsonPlaceHolderTestBase {

     /*
    https://jsonplaceholder.typicode.com/todos URL ine aşağıdaki body gönderildiğinde,
     {
     "userId": 55,
     "title": "Tidy your room",
     "completed": false
   }
Dönen response un Status kodunun 201 ve response body nin aşağıdaki gibi olduğunu test edin
   {
     "userId": 55,
     "title": "Tidy your room",
     "completed": false,
     "id": …
    }
     */

    @Test
    public void test01() {

        PostRequest03Data obje=new PostRequest03Data();
        Map<String,Object> bodyRequest=obje.bodyRequest();
        JSONObject bodyRequest2=obje.bodyRequest2();

        spec01.pathParam("p1","todos");

        Response rp=given().
                accept(ContentType.JSON).
                spec(spec01).
                auth().basic("admin","password123").
                body(bodyRequest2.toString()).
                when().
                post("/{p1}");

        System.out.println(rp.statusCode());

     //   rp.prettyPrint();

        JsonPath jp=rp.jsonPath();

        System.out.println(jp.getString("title"));


    }
    }

