package com.techproed.testData;

import java.util.HashMap;
import java.util.Map;

public class PutRequestData {

    public Map<String,Object> putRequest(){

        Map<String,Object> putRequest=new HashMap<>();
        putRequest.put("userId",50);
        putRequest.put("title","quis eius est sint explicabo");
        putRequest.put("completed",true);



    return putRequest;}
}
