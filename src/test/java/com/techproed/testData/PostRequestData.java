package com.techproed.testData;

import java.util.HashMap;
import java.util.Map;

public class PostRequestData {

    public Map<String,String> setUpRequestBody(){

        Map<String,String> requestBody=new HashMap<>();

        requestBody.put("name","ecü");
        requestBody.put("salary","15000");
        requestBody.put("age","15");




    return requestBody; }



    public Map<String,Object> ExpectedData(){

        Map<String,Object> expectedData=new HashMap<>();
       /* Map<String,String> rbData=new HashMap<>();

        rbData.put("name","ecüm");
        rbData.put("salary","15000");
        rbData.put("age","15");

        */




        expectedData.put("status","success");
       // expectedData.put("data",rbData);
        expectedData.put("message","Successfully! Record has been added.");
        expectedData.put("statusCode",200);




        return expectedData; }
}
