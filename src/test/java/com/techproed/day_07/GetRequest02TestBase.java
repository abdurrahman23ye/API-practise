package com.techproed.day_07;

import com.techproed.testBase.JsonPlaceHolderTestBase;
import com.techproed.testData.JsonPlaceHolderTestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest02TestBase extends JsonPlaceHolderTestBase {

    @Test
    public void test01() {

        JsonPlaceHolderTestData expd=new JsonPlaceHolderTestData();

        HashMap<String,Object> expectedData= (HashMap<String, Object>) expd.setUpTestData();

        spec01.pathParams("p1", "todos", "p2", 2);



        Response rp = given().accept("application/json").spec(spec01).when().get("/{p1}/{p2}");


        //matcher class ile


        rp.then().assertThat().statusCode((Integer) expectedData.get("statusCode")).
                header("via", equalTo(expectedData.get("via"))).
                header("Server", equalTo(expectedData.get("Server"))).
                body("userId", equalTo(expectedData.get("userId"))).
                body("title", equalTo(expectedData.get("title"))).
                body("completed", equalTo(expectedData.get("completed")));

        // jason path

        JsonPath jp = rp.jsonPath();


        Assert.assertEquals(jp.getInt("userId"), expectedData.get("userId"));
        Assert.assertEquals(jp.getString("title"), expectedData.get("title"));
        Assert.assertEquals(jp.getBoolean("completed"), expectedData.get("completed"));
        Assert.assertEquals(rp.header("Server"), (expectedData.get("Server")));
        Assert.assertEquals(rp.header("via"), (expectedData.get("via")));
        Assert.assertEquals(rp.getStatusCode(), (expectedData.get("statusCode")));


        //3. yol

        HashMap<String,Object> actualData=rp.as(HashMap.class);

        Assert.assertEquals(expectedData.get("userId"),actualData.get("userId"));
        Assert.assertEquals(expectedData.get("title"),actualData.get("title"));
        Assert.assertEquals(expectedData.get("completed"),actualData.get("completed"));


        //mapsiz yol

        rp.then().assertThat().statusCode(200).body("userId", equalTo(1),
                        "completed", equalTo(false),
                        "title", equalTo("quis ut nam facilis et officia qui")).
                header("Server", equalTo("cloudflare"))
                .header("Via", equalTo("1.1 vegur"));


    }
}
