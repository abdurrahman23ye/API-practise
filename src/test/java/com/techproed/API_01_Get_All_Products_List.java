package com.techproed;


import com.techproed.testBase.Automation_Exercise_TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class API_01_Get_All_Products_List extends Automation_Exercise_TestBase {

    @Test
    public void test01(){

        spec01.pathParam("p1","productsList");


        Response rp=given().
                contentType(ContentType.JSON).
                spec(spec01).
                when().
                get("/{p1}");

        System.out.println(rp.statusCode());
    }
}
