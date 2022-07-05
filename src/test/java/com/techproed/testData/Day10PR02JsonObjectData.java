package com.techproed.testData;

import com.google.gson.JsonObject;
import org.json.JSONObject;

public class Day10PR02JsonObjectData {


   /* { "firstname": "Selim",
            "lastname": "Ak",
            "totalprice": 11111,
            "depositpaid": true,
            "bookingdates": {
        "checkin": "2020-09-09",
                "checkout": "2020-09-21"
    }
    */

    public  JSONObject postRequest(){



        JSONObject bookingdates =new JSONObject();

        bookingdates.put("checkin","2020-09-09");
        bookingdates.put("checkout","2020-09-21");

        JSONObject postRequest =new JSONObject();

        postRequest.put("firstname","yusufa");
        postRequest.put("lastname", "oren");
        postRequest.put("totalprice",11111);
        postRequest.put("bookingdates",bookingdates);




    return postRequest;}

    public  JSONObject expectedData(){



        JSONObject bookingdates =new JSONObject();

        bookingdates.put("checkin","2020-09-09");
        bookingdates.put("checkout","2020-09-21");

        JSONObject expectedData =new JSONObject();

        expectedData.put("firstname","yusufa");
        expectedData.put("lastname", "oren");
        expectedData.put("totalprice",11111);
        expectedData.put("bookingdates",bookingdates);
        expectedData.put("statusCode",200);




        return expectedData;  }
}
