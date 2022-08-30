package Practice;

import Practice.specs.RestFullBooker;
import io.restassured.response.Response;
import org.apache.http.entity.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest extends RestFullBooker {

     /* https://restful-booker.herokuapp.com/booking url'ine
    accept type'i "application/json" olan GET request'i yolladigimda
    gelen response'un
    status kodunun 200
    content type'inin "application/json" oldugunu test edin

    */

    @Test
    public void test01ismiKoymakiOverridingOlmasin(){

        spec01.pathParams("first","booking");

        Response rp=given().spec(spec01).when().get("/{first}");

        rp.then().assertThat().statusCode(200).contentType("application/json");
    }


}
