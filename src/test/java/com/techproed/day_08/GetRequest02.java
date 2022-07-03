package com.techproed.day_08;

import com.techproed.testBase.DummyRestAPIExampleTestBase;
import com.techproed.testData.DummyRestAPIExampleData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

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

        DummyRestAPIExampleData obje=new DummyRestAPIExampleData();

        JsonPath js=rp.jsonPath();

        int sonuncuCalisanMaas=js.getInt("data[-1].employee_salary");
        int sondanOncekiCalisanMaas=js.getInt("data[-2].employee_salary");

       List<Integer> yaslar=js.getList("data.employee_age");


        Set<Integer> actualYaslar=new HashSet<>();


       for (Integer each : yaslar
                )
        { if(each==19){actualYaslar.add(each);}
         if(each==21){actualYaslar.add(each);}
        if(each==40){actualYaslar.add(each);}

        }


        String besinciCalisan=js.getString("data.employee_name[4]");
        Map<String,Object>id=
            js.getMap("data[10]");



        Map<String,Object> expectedData=obje.expectedData();

        Map<String,Object>actualData=new HashMap<>();

        actualData.put("statusCode",rp.statusCode());
        actualData.put("calisanSayisi",js.getList("data.id").size());
        actualData.put("sonIkiCalisaninMaasToplami",(sondanOncekiCalisanMaas+sonuncuCalisanMaas));
        actualData.put("arananYaslar",actualYaslar);
        actualData.put("besinciCalisan",besinciCalisan);
        actualData.put("id[10]",id);



        Assert.assertEquals(expectedData.get("statusCode"),actualData.get("statusCode"));
        Assert.assertEquals(expectedData.get("calisanSayisi"),actualData.get("calisanSayisi"));
        Assert.assertEquals(expectedData.get("sonIkiCalisaninMaasToplami"),actualData.get("sonIkiCalisaninMaasToplami"));
        Assert.assertEquals(expectedData.get("arananYaslar"),actualData.get("arananYaslar"));
        Assert.assertEquals(expectedData.get("besinciCalisan"),actualData.get("besinciCalisan"));
        Assert.assertEquals(expectedData.get("id[10]"),actualData.get("id[10]"));


    }
}
