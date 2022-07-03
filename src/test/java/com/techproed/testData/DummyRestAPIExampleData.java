package com.techproed.testData;

import java.util.*;

public class DummyRestAPIExampleData {

    public Map<String,Object> expectedData(){

        Map<String,Object> expectedData=new HashMap<>();
        Set<Integer> arananyaslar= new HashSet<>();

        arananyaslar.add(40);
        arananyaslar.add(21);
        arananyaslar.add(19);
        Map<String,Object> onBirinciCalisan=new HashMap<>();

        onBirinciCalisan.put("employee_name","Jena Gaines");
        onBirinciCalisan.put("employee_salary",90560);
        onBirinciCalisan.put("employee_age",30);
        onBirinciCalisan.put("profile_image","");
        onBirinciCalisan.put("id",11);



        expectedData.put("statusCode",200);
        expectedData.put("calisanSayisi",24);
        expectedData.put("sonIkiCalisaninMaasToplami",192050);
        expectedData.put("arananYaslar",arananyaslar);
        expectedData.put("id[10]",onBirinciCalisan);
        expectedData.put("besinciCalisan","Airi Satou");






    return expectedData;}
}

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
