package Practice;

import Practice.specs.RestFullBooker;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest02 extends RestFullBooker {

       /*
    https://restful-booker.herokuapp.com/booking/7 url'ine
accept type'i "application/json" olan GET request'i yolladigimda
gelen response'un
status kodunun 200
ve content type'inin "application/json"
ve firstname'in "Sally"
ve lastname'in "Ericsson"
ve checkin date'in 2018-07-26"
ve checkout date'in 2022-03-10 oldugunu test edin
     */

    @Test
    public void testGetRequest(){

        spec01.pathParams("first","booking","second",7);

        Response rp=given().spec(spec01).when().get("/{first}/{second}");

        //1
        rp.then().assertThat().statusCode(200).contentType("application/json").
                body("firstname",equalTo("Sally")).
                body("lastname",equalTo("Ericsson")).

                body("bookingdates.checkin",equalTo("2018-07-26")).
                body("bookingdates.checkout",equalTo("2022-03-10"));

        //2

        Map<String,String> bookingdates=new HashMap<>();
        bookingdates.put("checkin","2018-07-26");
        bookingdates.put("checkout","2022-03-10");

        Map<String,Object> expectedData=new HashMap<>();
        expectedData.put("firstname","Sally");
        expectedData.put("lastname","Ericsson");
        expectedData.put("bookingdates",bookingdates);

        JsonPath jp=rp.jsonPath();

        Assert.assertEquals(expectedData.get("firstname"),jp.getString("firstname"));
        Assert.assertEquals(expectedData.get("lastname"),jp.getString("lastname"));
        Assert.assertEquals(expectedData.get("bookingdates"),jp.getMap("bookingdates"));













    }
}
