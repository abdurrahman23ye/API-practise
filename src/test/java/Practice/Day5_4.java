package Practice;

import Practice.specs.JsonPlaceHolder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Day5_4 extends JsonPlaceHolder {

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
    public void JsonTest(){

        spec01.pathParams("first","todos","second",123);

        Response rp=given().spec(spec01).when().get("/{first}/{second}");

        rp.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                header("Server","cloudflare").
                body("userId", Matchers.equalTo(7)).
                body("title", Matchers.equalTo("esse et quis iste est earum aut impedit")).
                body("completed", Matchers.equalTo(false));

        JsonPath jp=rp.jsonPath();

        Map<String,Object> expectedData=new HashMap<>();
        expectedData.put("userId",7);
        expectedData.put("title","esse et quis iste est earum aut impedit");
        expectedData.put("completed",false);

        Assert.assertEquals(expectedData.get("userId"),jp.getInt("userId"));
        Assert.assertEquals(expectedData.get("title"),jp.getString("title"));
        Assert.assertEquals(expectedData.get("completed"),jp.getBoolean("completed"));






    }


}
