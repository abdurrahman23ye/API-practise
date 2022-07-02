package com.techproed.testData;

import java.util.HashMap;

public class RestFulBookerTestData {

    public HashMap<String,Object>  setUpData() {

        HashMap<String, Object> expectedData = new HashMap<>();

        HashMap<String, Object> bookingdates = new HashMap<>();

        bookingdates.put("checkin","2021-03-28");
        bookingdates.put("checkout","2021-08-06");

        expectedData.put("firstname","Sally");
        expectedData.put("lastname", "Brown");
        expectedData.put("totalprice",770);
        expectedData.put("depositpaid",true);
        expectedData.put("bookingdates",bookingdates);





    return expectedData;
    }

    /* Gerek yok

    public HashMap<String,Object>  setUpData2() {


        HashMap<String, Object> bookingdates = new HashMap<>();

        bookingdates.put("checkin","2021-03-28");
        bookingdates.put("checkout","2021-08-06");


        return bookingdates;
    }

     */
}
