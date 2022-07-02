package com.techproed.day_06;

import com.techproed.testBase.DummyRestAPIExampleTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequest03 extends DummyRestAPIExampleTestBase {

     /*
    http://dummy.restapiexample.com/api/v1/employees
url ine bir istek gönderildiğinde,
status kodun 200,
gelen body de,
5. çalışanın isminin "Airi Satou" olduğunu ,
6. çalışanın maaşının "372000" olduğunu ,
Toplam 24 tane çalışan olduğunu,
"Rhona Davidson" ın employee lerden biri olduğunu
"21", "23", "61" yaşlarında employeeler olduğunu test edin
     */

    @Test
    public void test01() {

        spec02.pathParam("para1","employees");

       Response rp= given().accept("application/json").spec(spec02).when().get("/{para1}");

       rp.then().assertThat().statusCode(200).body("data.employee_name[4]",
              equalTo("Airi Satou"),"data.employee_salary[5]",
               equalTo(372000),"data.id",
               hasSize(24),"data.employee_name",hasItem("Rhona Davidson"),"data.employee_age",hasItems(21,23,61));

        JsonPath jp=rp.jsonPath();



        Assert.assertEquals("Airi Satou",jp.getString("data.employee_name[4]"));
        Assert.assertEquals(372000,jp.getInt("data.employee_salary[5]"));
        Assert.assertEquals(24,jp.getList("data.id").size());
        Assert.assertTrue(jp.getString("data.employee_name").contains("Rhona Davidson"));

        List<Integer> yas=new ArrayList<>();
        yas.add(21);
        yas.add(23);
        yas.add(61);
        Assert.assertTrue(jp.getList("data.employee_age").containsAll(yas));



    }


}
