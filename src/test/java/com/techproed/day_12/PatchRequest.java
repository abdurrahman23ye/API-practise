package com.techproed.day_12;

import com.techproed.testBase.JsonPlaceHolderTestBase;
import com.techproed.testData.PatchRequestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class PatchRequest extends JsonPlaceHolderTestBase {

     /*
    https://jsonplaceholder.typicode.com/todos/198 URL ine aşağıdaki body gönderdiğimde
   {
      "title": "API calismaliyim"
     }
Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
{
 "userId": 10,
 "title": "API calismaliyim"
 "completed": true,
 "id": 198
}
     */

    @Test
    public void test01(){

        spec01.pathParams("p1","todos","p2",198);

        https://www.facebook.com/search/people/?q=yegen%20oyun%20%C3%A7ok%20b%C3%BCy%C3%BCk

        spec01.pathParams("p1","search","p2","people").
                queryParam("q","yegen oyun coğ büyük diyen dayi");

        PatchRequestData obj=new PatchRequestData();

        JSONObject request2=obj.request2();
        Map<String,Object> request=obj.request();



        Response rp=given().contentType("application/json").
                spec(spec01).
                body(request2.toString()).
                when().
                patch("/{p1}/{p2}");

        rp.prettyPrint();
    }
}
