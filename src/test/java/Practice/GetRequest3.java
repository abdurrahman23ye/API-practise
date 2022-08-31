package Practice;

import Practice.specs.RestApi;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest3 extends RestApi {

     /*
    "http://dummy.restapiexample.com/api/v1/employees" url'ine
    accept type'i "application/json" olan GET request'i yolladigimda
    gelen response'un
    status kodunun 200
    ve content type'inin "application/json"
   ve employees sayisinin 24
   ve employee'lerden birinin "Ashton Cox"
   ve gelen yaslar icinde 21, 61, ve 23 degerlerinden birinin oldugunu test edin
     */

    @Test
    public void restTest(){

        spec01.pathParam("first","employees");

        Response rp=given().spec(spec01).when().get("/{first}");

        rp.then().assertThat().statusCode(200).contentType("application/json").
                body("data", Matchers.hasSize(24)).
                body("data.employee_name", Matchers.hasItem("Ashton Cox"));

        JsonPath jp=rp.jsonPath();

        Assert.assertFalse(jp.
                getString("data.findAll{it.employee_age==21 ||it.employee_age==23 || it.employee_age==61}.employee_age").isEmpty());







    }
}
