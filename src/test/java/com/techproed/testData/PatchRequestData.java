package com.techproed.testData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PatchRequestData {

    public Map<String,Object> request(){

        Map<String,Object> request=new HashMap<>();

        request.put("userId",10);
        request.put("title","API caliszxzmaliyim");
        request.put("completed",true);
        request.put("id",198);




   return request; }

    public JSONObject request2(){

        JSONObject request=new JSONObject();

        request.put("userId",11);
        request.put("title","API calismaxxcxcliyim");
        request.put("completed",false);
        request.put("id",198);




        return request; }
}
