package Practice;

import Practice.specs.RestApi;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Day6_2 extends RestApi {

    /*
    http://dummy.restapiexample.com/api/v1/employees url’inde bulunan
   1) Butun calisanlarin isimlerini consola yazdıralim
   2) 3. calisan kisinin ismini konsola yazdıralim
   3) Ilk 5 calisanin adini konsola yazdiralim
   4) En son calisanin adini konsola yazdiralim
 */

    @Test
    public void restApiTest(){

        spec01.pathParam("first","employees");

        Response rp=given().spec(spec01).when().get("/{first}");

        JsonPath jp=rp.jsonPath();


        List<String> list= Collections.singletonList(jp.getString("data.employee_name"));

        System.out.println("list = " + list);

        String third= Collections.singletonList(jp.getString("data.employee_name[2]"));
    }
}
