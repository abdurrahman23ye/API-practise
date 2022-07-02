package com.techproed.day_08;

import com.techproed.testBase.DummyRestAPIExampleTestBase;
import com.techproed.testData.DummyRestAPIExampleData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequest02 extends DummyRestAPIExampleTestBase {

    /*
    http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
    Status kodun 200 olduğunu,
      5. Çalışan isminin "Airi Satou" olduğunu ,
      çalışan sayısının 24 olduğunu,
    Sondan 2. çalışanın maaşının 106450 olduğunu
40,21 ve 19 yaslarında çalışanlar olup olmadığını
11. Çalışan bilgilerinin
    {
 “id”:”11”
        "employee_name": "Jena Gaines",
            "employee_salary": "90560",
            "employee_age": "30",
            "profile_image": "" }
} gibi olduğunu test edin.
*/
    @Test
    public void test01() {

        spec02.pathParam("p1","employees");

        Response rp=given().accept("application/json").spec(spec02).when().get("/{p1}");


        rp.then().assertThat().statusCode(200).body("data.employee_name[4]",
                equalTo("Airi Satou"),
                "data.id", hasSize(24));

        JsonPath js=rp.jsonPath();

       int a= Integer.parseInt(js.getString("data.employee_salary[-1]"));
       int b= Integer.parseInt(js.getString("data.employee_salary[-2]"));

       Assert.assertTrue(a+b==106450);
       Assert.assertTrue(js.getString("data.findAll{it.employee_age==40,21,19}."));










        DummyRestAPIExampleData obje=new DummyRestAPIExampleData();

        Map<String,Object> expectedData=obje.expectedData();



        Map<String,Object> actualData=rp.as(Map.class);

        actualData.put("statusCode",rp.statusCode());


        Assert.assertEquals(expectedData.get("statusCode"),actualData.get("statusCode"));


    }
}
