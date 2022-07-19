package com.techproed;

import com.techproed.testBase.Gorest_TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Gorest_19_07 extends Gorest_TestBase {

    /*
    {
    "meta": null,
    "data": {
        "id": 2508,
        "name": "Akshita Nehru",
        "email": "nehru_akshita@jast.info",
        "gender": "female",
        "status": "active"
    }
}
     */

    @Test
    public void test001(){

        spec.pathParams("p1","users","p2",25);

        Response response = given().spec(spec).when().get("/{p1}/{p2}");

        response.prettyPrint();


    }
}
