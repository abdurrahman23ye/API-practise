package com.techproed.day_05;

import com.techproed.testBase.JsonPlaceHolderTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequest04 extends JsonPlaceHolderTestBase {

    /*
    https://jsonplaceholder.typicode.com/todos/123 url'ine
    accept type'i "application/json" olan GET request'i yolladigimda
    gelen response’un
    status kodunun 200
    ve content type'inin "application/json"
    ve Headers'daki "Server" in "cloudflare"
    ve response body'deki "userId"'nin 7
    ve "title" in "esse et quis iste est earum aut impedit"
    ve "completed" bolumunun false oldugunu test edin
    */

    @Test
    public void test01(){

       // String uri="https://jsonplaceholder.typicode.com/todos/123";

        spec01.pathParams("firstparam","todos",
                "secondparam",123);

        Response rp=given().accept("application/json"). // API sadece json gönderiyorsa accept kısmı kullanılmayabilir.
                spec(spec01).when().get("/{firstparam}/{secondparam}");

        rp.then().assertThat().statusCode(200).contentType(ContentType.JSON).
                header("server", equalTo("cloudflare")).
                body("userId",equalTo(7),"title",
                        equalTo("esse et quis iste est earum aut impedit"),"completed",
                        equalTo(false));




    }
}
