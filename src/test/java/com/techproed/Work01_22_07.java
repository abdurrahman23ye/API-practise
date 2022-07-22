package com.techproed;

import com.techproed.pojos.DummyApiPostRequestBody;
import com.techproed.pojos.ExpectedDataDummy;
import com.techproed.testBase.DummyRestAPIExampleTestBase;
import com.techproed.utilities.JsonUtil;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Work01_22_07 extends DummyRestAPIExampleTestBase {

    /*
       URL: https://dummy.restapiexample.com/api/v1/create
       HTTP Request Method: POST Request
       Request body: {
                        "employee_name": "Tom Hanks",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                     }
       Test Case: Type by using Gherkin Language
       Assert:
                i) Status code is 200
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Ali Can",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image",
                            "id": 6344
                        },
                        "message": "Successfully! Record has been added."
                    }
     */

    @Test
    public void test01(){

        /*
        given
         URL: https://dummy.restapiexample.com/api/v1/create
       HTTP Request Method: POST Request
       Request body: {
                        "employee_name": "Tom Hanks",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                     }

      When

      User send post request

      Then

      Assert Status code is 200

      And
      Assert Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Ali Can",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image",
                            "id": 6344
                        },
                        "message": "Successfully! Record has been added."
                    }


         */

        spec02.pathParam("p1","create");

        DummyApiPostRequestBody bodyRequest=new DummyApiPostRequestBody("Tom Hanks",1111,23,"Perfect image");

        Response rp=given().contentType(ContentType.JSON).spec(spec02).body(bodyRequest).when().post("/{p1}");

        rp.prettyPrint();

        ExpectedDataDummy expectedData=new ExpectedDataDummy("success",bodyRequest,"Successfully! Record has been added.");

        ExpectedDataDummy actualData= JsonUtil.convertJsonToJava(rp.asString(),ExpectedDataDummy.class);

        System.out.println(actualData);

        Assert.assertEquals(expectedData.getMessage(),actualData.getMessage());
        Assert.assertEquals(expectedData.getData().getEmployee_age(),actualData.getData().getEmployee_age());


    }
}
