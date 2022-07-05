package com.techproed.testData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PostRequest03Data {

    public Map<String,Object> bodyRequest(){

        Map<String,Object> bodyRequest=new HashMap<>();

     bodyRequest.put("userId",55);
        bodyRequest.put("title","Tidy your room");
        bodyRequest.put("completed",false);

      return bodyRequest;}

    public JSONObject bodyRequest2(){

        JSONObject bodyRequest=new JSONObject();

       bodyRequest.put("userId",55);
        bodyRequest.put("title","Tidy your room");
        bodyRequest.put("completed",false);

        return bodyRequest;}
}
