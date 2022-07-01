package com.techproed.day_04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {

    @Test
    public void test01() {

        //1. url belirle(endpoint)

        String url = "https://restful-booker.herokuapp.com/booking/3";

        // 2. expected result hazırla

        // 3. request gönder

      Response response= given().
              accept("application/json").
              when().
              get(url);

        //4. actual result hazırla(response)

      //  response.prettyPrint();



        // 5. doğrulama yap)

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


    }


}
