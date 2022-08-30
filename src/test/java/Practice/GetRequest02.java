package Practice;

import Practice.specs.RestFullBooker;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

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




    }
}
