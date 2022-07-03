package com.techproed.day_09;

import com.techproed.testBase.DummyRestAPIExampleTestBase;
import com.techproed.testData.GetRequest13;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest01 extends DummyRestAPIExampleTestBase {

       /*
    http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
Status kodun 200 olduğunu,
En yüksek maaşın 725000 olduğunu,
En küçük yaşın 19 olduğunu,
İkinci en yüksek maaşın 675000
olduğunu test edin.
     */

    @Test
    public void test01() {

        spec02.pathParam("p1", "employees");

        Response response=given().accept("application/json").spec(spec02).when().get("/{p1}");

        JsonPath jp=response.jsonPath();

       List<Integer> salaries= jp.getList("data.employee_salary");
       List<Integer> ages= jp.getList("data.employee_age");

        Collections.sort(salaries);
        Collections.sort(ages);


        GetRequest13 obje=new GetRequest13();

        Map<String,Object> expectedData=obje.testSetUp();
        Map<String,Object> actuelData=obje.testSetUp();

        actuelData.put("enYuksekMaas",salaries.get(salaries.size()-1));
        actuelData.put("enYuksekIkinciMaas",salaries.get(salaries.size()-2));
        actuelData.put("endusukYas",ages.get(0));
        actuelData.put("StatusCode",response.getStatusCode());



        Assert.assertEquals(expectedData.get("enYuksekMaas"),actuelData.get("enYuksekMaas"));
        Assert.assertEquals(expectedData.get("enYuksekIkinciMaas"),actuelData.get("enYuksekIkinciMaas"));
        Assert.assertEquals(expectedData.get("StatusCode"),actuelData.get("StatusCode"));
        Assert.assertEquals(expectedData.get("endusukYas"),actuelData.get("endusukYas"));






    }

}