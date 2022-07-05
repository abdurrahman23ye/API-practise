package com.techproed.pojoAPITests;

import com.google.gson.Gson;
import com.techproed.pojos.PojoGetRequest1;
import com.techproed.pojos.PojoGetRequest2;
import com.techproed.testBase.DummyRestAPIExampleTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequestPojoAndSerilization extends DummyRestAPIExampleTestBase {

        /*
GET Request to the URL http://dummy.restapiexample.com/api/v1/employee/1
                            Status code is 200
                                 {
                                  "status": "success",
                                  "data": {
                                      "id": 1,
                                      "employee_name": "Tiger Nixon",
                                      "employee_salary": 320800,
                                      "employee_age": 61,
                                      "profile_image": ""
                                  },
                                  "message": "Successfully! Record has been fetched."
                                 }
 */

    @Test
    public void test01(){

        spec02.pathParams("p1","employee","p2",1);

        PojoGetRequest1 data=new
                PojoGetRequest1(1,"Tiger Nixon",320800,61,"");
        PojoGetRequest2 expectedRequest=new
                PojoGetRequest2("success","Successfully! Record has been fetched.",data);

        Response rp=given().contentType(ContentType.JSON).spec(spec02).when().get("/{p1}/{p2}");




        PojoGetRequest2 actualData=rp.as(PojoGetRequest2.class);




        Assert.assertEquals(expectedRequest.getMessage(),actualData.getMessage());
        Assert.assertEquals(expectedRequest.getStatus(),actualData.getStatus());
    //   Assert.assertEquals(expectedRequest.getData(),actualData.getData());
        //Bütün içeriği assert ediyor ama datayı datayla assert etmiyor
        Assert.assertEquals(expectedRequest.getData().getId(),actualData.getData().getId());
        Assert.assertEquals(expectedRequest.getData().getEmployee_age(),actualData.getData().getEmployee_age());
        Assert.assertEquals(expectedRequest.getData().getEmployee_salary(),actualData.getData().getEmployee_salary());
        Assert.assertEquals(expectedRequest.getData().getEmployee_name(),actualData.getData().getEmployee_name());
        Assert.assertEquals(expectedRequest.getData().getProfile_image(),actualData.getData().getProfile_image());
        Assert.assertEquals(200,rp.statusCode());

        //****************************************************************************************************
        //****************************************************************************************************
        //****************************************************************************************************
        //****************************************************************************************************

        Gson gson=new Gson();
        String jsonFromJava=gson.toJson(actualData);
        System.out.println("jsonFromJava = " + jsonFromJava);

    }


}
