package com.techproed.day_07;

import com.techproed.testBase.JsonPlaceHolderTestBase;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest02 extends JsonPlaceHolderTestBase {

      /*
https://jsonplaceholder.typicode.com/todos/2 url ‘ine istek gönderildiğinde,
 Dönen response un
 Status kodunun 200, dönen body de,
 "completed": değerinin false
"title”: değerinin “quis ut nam facilis et officia qui”
"userId" sinin 1 ve
header değerlerinden
 "Via" değerinin “1.1 vegur” ve
 "Server" değerinin “cloudflare” olduğunu test edin…
 */

    @Test
    public void test01() {

        spec01.pathParams("p1","todos","p2",2);


        HashMap<String,Object> expectedData=new HashMap<String, Object>();

        expectedData.put("statusCode",200);
        expectedData.put("via","1.1 vegur");
        expectedData.put("Server","cloudflare");
        expectedData.put("userId",1);
        expectedData.put("title","quis ut nam facilis et officia qui");
        expectedData.put("completed",false);

        Response rp=given().accept("application/json").spec(spec01).when().get("/{p1}/{p2}");


        //matcher class ile


        rp.then().assertThat().statusCode((Integer) expectedData.get("statusCode")).
                header("via", equalTo(expectedData.get("via"))).
                header("Server", equalTo(expectedData.get("Server"))).
                body("userId",  equalTo(expectedData.get("userId"))).
                body("title", equalTo( expectedData.get("title"))).
                body("completed", equalTo( expectedData.get("completed")));

        // jason path

        JsonPath jp=rp.jsonPath();


       Assert.assertEquals(jp.getInt("userId"),expectedData.get("userId"));
        Assert.assertEquals(jp.getString("title"), expectedData.get("title"));
        Assert.assertEquals(jp.getBoolean("completed"), expectedData.get("completed"));
        Assert.assertEquals(rp.header("Server"),(expectedData.get("Server")));
        Assert.assertEquals(rp.header("via"),(expectedData.get("via")));
        Assert.assertEquals(rp.getStatusCode(),(expectedData.get("statusCode")));




        //mapsiz yol

        rp.then().assertThat().statusCode(200).body("userId", equalTo(1),
                "completed", equalTo(false),
                "title", equalTo("quis ut nam facilis et officia qui")).
                header("Server",equalTo("cloudflare"))
                .header("Via",equalTo("1.1 vegur"));






    }


}
