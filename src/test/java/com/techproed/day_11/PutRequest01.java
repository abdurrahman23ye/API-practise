package com.techproed.day_11;

import com.techproed.testBase.JsonPlaceHolderTestBase;
import com.techproed.testData.JsonPlaceHolderTestData;
import com.techproed.testData.PutRequestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PutRequest01 extends JsonPlaceHolderTestBase {

    /*
    https://jsonplaceholder.typicode.com/todos/198 URL ine aşağıdaki body gönerdiğimde
 {
 "userId": 21,
 "title": "Wash the dishes",
 "completed": false
 }
 Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
 {
 "userId": 21,
 "title": "Wash the dishes",
 "completed": false,
 "id": 198
 }
     */

    @Test
    public void test01() {

        spec01.pathParams("parametre1","todos",
                "parametre2",198);

        JsonPlaceHolderTestData testObje=new JsonPlaceHolderTestData();
        JSONObject expectedRequest= testObje.setUpPutData();
     //   System.out.println(expectedRequest);

        Response response=given().
                contentType("application/json").
                spec(spec01).
               auth().basic("admin","password123").
                body(expectedRequest.toString()).
                when().
                put("/{parametre1}/{parametre2}");
        response.prettyPrint();




    }

}
