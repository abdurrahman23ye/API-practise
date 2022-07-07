package com.techproed;

import com.techproed.testBase.JsonPlaceHolderTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class selStudy extends JsonPlaceHolderTestBase {

    /*
        1) Create a class and name it as you wish :)
        2) When
             I send a GET Request to https://jsonplaceholder.typicode.com/todos
           Then
             HTTP Status code should be "200"
             And Content type should be in "JSON" format
             And there should be 200 "title"
             And "dignissimos quo nobis earum saepe" should be one of the "title"s
             And 111, 121, and 131 should be among the "id"s
             And 4th title is "et porro tempora"
             And last title is "ipsam aperiam voluptates qui"
    */

    @Test
    public void test01(){

        spec01.pathParam("p1","todos");

       Response rp= given().contentType("application/json").spec(spec01).when().get("/{p1}");

        System.out.println(rp.contentType());




      List<Integer>idContains=new ArrayList<>();
       idContains.add(111);
       idContains.add(121);
       idContains.add(131);

        Map<String,Object>expectedData=new HashMap<>();
        expectedData.put("statusCode",200);
        expectedData.put("contentType","application/json; charset=utf-8");
        expectedData.put("titleSize",200);
        expectedData.put("titleContains",true);
        expectedData.put("lastTitle","ipsam aperiam voluptates qui");
        expectedData.put("forthTitle","et porro tempora");
        expectedData.put("idContains",true);

        JsonPath js=rp.jsonPath();
        List<String>title= js.getList("title");

        System.out.println("title = " + title);


        Map<String,Object>actuelData=new HashMap<>();

        actuelData.put("statusCode",rp.statusCode());
        actuelData.put("contentType",rp.contentType());
        actuelData.put("titleSize",title.size());
        actuelData.put("titleContains",title.contains("dignissimos quo nobis earum saepe"));
        actuelData.put("lastTitle", js.getString("title[-1]"));
        actuelData.put("forthTitle",js.getString("title[3]"));
        actuelData.put("idContains",js.getList("id").containsAll(idContains));

        Assert.assertEquals(expectedData.get("statusCode"),actuelData.get("statusCode"));
        Assert.assertEquals(expectedData.get("contentType"),actuelData.get("contentType"));
        Assert.assertEquals(expectedData.get("titleSize"),actuelData.get("titleSize"));
        Assert.assertEquals(expectedData.get("titleContains"),actuelData.get("titleContains"));
        Assert.assertEquals(expectedData.get("lastTitle"),actuelData.get("lastTitle"));
        Assert.assertEquals(expectedData.get("forthTitle"),actuelData.get("forthTitle"));
        Assert.assertEquals(expectedData.get("idContains"),actuelData.get("idContains"));





    }
}
