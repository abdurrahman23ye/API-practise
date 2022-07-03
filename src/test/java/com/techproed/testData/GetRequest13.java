package com.techproed.testData;

import java.util.HashMap;
import java.util.Map;

public class GetRequest13 {

    public Map<String,Object> testSetUp(){

        Map<String,Object> expectedData=new HashMap<>();

        expectedData.put("enYuksekMaas",725000);
        expectedData.put("enYuksekIkinciMaas",675000);
        expectedData.put("endusukYas",19);
        expectedData.put("StatusCode",200);

        return expectedData;}
}
