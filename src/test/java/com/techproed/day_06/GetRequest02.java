package com.techproed.day_06;

import com.techproed.testBase.DummyRestAPIExampleTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest02  extends DummyRestAPIExampleTestBase {

    /*
    http://dummy.restapiexample.com/api/v1/employees url’inde bulunan
   1) Butun calisanlarin isimlerini consola yazdıralim
   2) 3. calisan kisinin ismini konsola yazdıralim
   3) Ilk 5 calisanin adini konsola yazdiralim
   4) En son calisanin adini konsola yazdiralim
 */

    @Test
    public void test01() {

       spec02.pathParam("para1","employees");

      Response rp= given().accept("application/json").spec(spec02).when().get("/{para1}");

        JsonPath jp=rp.jsonPath();

        System.out.println(jp.getList("data.employee_name"));

        System.out.println(jp.getString("data.employee_name[2]"));
        System.out.println(jp.getString("data[2].employee_name")); //farketmez

        System.out.println(jp.getString("data.employee_name[0,1,2,3,4,5]"));


        System.out.println(jp.getString("data.employee_name[-1]"));




    }
}