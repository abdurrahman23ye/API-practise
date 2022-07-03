package com.techproed.day_04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest01 {

    @Test
    public void test01() {


        String url = "https://restful-booker.herokuapp.com/booking/17379";


      Response response= given().
              accept("application/json").
              when().
              get(url);

      response.then().assertThat().statusCode(200).
              contentType(ContentType.JSON).
              header("Server", equalTo("Cowboy"));



      Assert.assertTrue(response.getTime()<5000);



        //Header'da statusline yok.

        //4. actual result hazırla(response)

      //  response.prettyPrint();



        // 5. doğrulama yap)
/*
        System.out.println(response.statusCode());
        System.out.println(response.getContentType());
        System.out.println(response.getStatusLine());
        System.out.println("response.getHeaders() = " + response.getHeaders());

        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals("application/json; charset=utf-8",response.getContentType());
        Assert.assertEquals("HTTP/1.1 200 OK",response.statusLine());

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");

 */


    }


}
