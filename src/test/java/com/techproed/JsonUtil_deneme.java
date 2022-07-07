package com.techproed;

import com.techproed.utilities.JsonUtil;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class JsonUtil_deneme {

    /*{
        "firstname": "Emely",
            "lastname": "Straver",
            "totalprice": 967,
            "depositpaid": false,
            "bookingdates": { "checkin": "2022-07-06",
            "checkout":"2022-07-19"
    },
        "additionalneeds": "Extra Pillow"
    }

     */

    @Test
    public void jutil(){

        Response response = given().when().get(" https://restful-booker.herokuapp.com/booking/887");





        String json="{\n" +
                "                \"firstname\": \"Emely\",\n" +
                "                \"lastname\": \"Straver\",\n" +
                "                \"totalprice\": 967,\n" +
                "                \"depositpaid\": false,\n" +
                "                \"bookingdates\": { \"checkin\": \"2022-07-06\",\n" +
                "                                  \"checkout\":\"2022-07-19\"\n" +
                "                },\n" +
                "                \"additionalneeds\": \"Extra Pillow\"\n" +
                "            }";

        Map<String,Object> expectedData= JsonUtil.convertJsonToJava(json, Map.class);
        Map<String,Object> actuelData= JsonUtil.convertJsonToJava(response.asString(), Map.class);

        Assert.assertEquals(expectedData,actuelData);
    }
}
