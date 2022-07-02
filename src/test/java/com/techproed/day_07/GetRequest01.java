package com.techproed.day_07;

import com.techproed.testBase.DummyRestAPIExampleTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static io.restassured.RestAssured.given;

public class GetRequest01 extends DummyRestAPIExampleTestBase {

    /*
     /*
    http://dummy.restapiexample.com/api/v1/employees
url ine bir istek gönderildiğinde
Dönen response un
 Status kodunun 200,
 1)10’dan büyük tüm id’leri ekrana yazdırın ve
10’dan büyük 14 id olduğunu,
 2)30’dan küçük tüm yaşları ekrana yazdırın ve
  bu yaşların içerisinde en büyük yaşın 23 olduğunu
 3)Maası 350000 den büyük olan tüm employee name’leri ekrana yazdırın ve
  bunların içerisinde “Charde Marshall” olduğunu test edin
     */

    @Test
    public void test01() {

        spec02.pathParam("para1","employees");

        Response rp=given().accept("application/json").spec(spec02).when().get("/{para1}");

        JsonPath jp=rp.jsonPath();

        //1)10’dan büyük tüm id’leri ekrana yazdırın ve
        //10’dan büyük 14 id olduğunu,


        List<Integer> idliste2=jp.getList("data.findAll{it.id>10}.id");

        System.out.println("idliste2 = " + idliste2);

        Assert.assertTrue(idliste2.size()==14);

        //2)30’dan küçük tüm yaşları ekrana yazdırın ve
        //  bu yaşların içerisinde en büyük yaşın 23 olduğunu

        List<Integer> yasListe2=jp.getList("data.findAll{it.employee_age<30}.employee_age");

        Integer otuzdankucukenBuyuk=Integer.MIN_VALUE;

        for (Integer each: yasListe2
             ) { if(each>otuzdankucukenBuyuk){otuzdankucukenBuyuk=each;}

        }

        Assert.assertTrue(otuzdankucukenBuyuk==23);

        // 3)Maası 350000 den büyük olan tüm employee name’leri ekrana yazdırın ve
        //  bunların içerisinde “Charde Marshall” olduğunu test edin

        List<String> emNameList=jp.getList("data.findAll{it.employee_salary>350000}.employee_name");

        System.out.println("emNameList = " + emNameList);

        Assert.assertTrue(emNameList.contains("Charde Marshall"));






        //Java yolu
        rp.then().assertThat().statusCode(200);



        List<Integer> idListe=jp.getList("data.id");
        List<Integer> ondanBuyukIdListe=new ArrayList<>();

         ;

        for (Integer each:idListe) {if(each>10){ondanBuyukIdListe.add(each);}
        }

       // 1)10’dan büyük tüm id’leri ekrana yazdırın ve 10’dan büyük 14 id olduğunu,

        System.out.println("idListe = " + idListe);

        Assert.assertEquals(14,ondanBuyukIdListe.size());

        System.out.println("ondanBuyukIdListe = " + ondanBuyukIdListe);


        //  2)30’dan küçük tüm yaşları ekrana yazdırın ve
        //  bu yaşların içerisinde en büyük yaşın 23 olduğunu

        List<Integer> ageListe=jp.getList("data.employee_age");
        Integer otuzdanKucukEnYuksekYas=Integer.MIN_VALUE;



        System.out.println("YasListe = " + ageListe);

        for (Integer each: ageListe
             ) {
            if (each < 30) {
                if (otuzdanKucukEnYuksekYas < each) {
                    otuzdanKucukEnYuksekYas = each;
                }
            }

        }

            Assert.assertTrue(23==otuzdanKucukEnYuksekYas);


        //3)Maası 350000 den büyük olan tüm employee name’leri ekrana yazdırın ve
       // bunların içerisinde “Charde Marshall” olduğunu test edin

        List<Integer> salaryList=jp.getList("data.employee_salary");
        List<String> nameList=jp.getList("data.employee_name");
        List<String> control=new ArrayList<>();

        for (int i = 0; i < salaryList.size() ; i++) {

            if (salaryList.get(i)>35000){
                System.out.println(nameList.get(i));

                control.add(nameList.get(i));
            }

        }

        Assert.assertTrue(nameList.contains("Charde Marshall"));













    }



}
