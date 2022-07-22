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

public class Work002 extends DummyRestAPIExampleTestBase {

    /*
   URL: https://dummy.restapiexample.com/api/v1/update/21
  HTTP Request Method: PUT Request
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
                       "employee_name": "Tom Hanks",
                       "employee_salary": 111111,
                       "employee_age": 23,
                       "profile_image": "Perfect image"
                   },
                   "message": "Successfully! Record has been updated."
               }
*/

    /*Given
    URL: https://dummy.restapiexample.com/api/v1/update/21
    When

      User send put request
       {
                   "status": "success",
                   "data": {
                       "employee_name": "Tom Hanks",
                       "employee_salary": 111111,
                       "employee_age": 23,
                       "profile_image": "Perfect image"
                   },

      Then

      Assert Status code is 200

      And
      Assert Response body should be like the following
     */

    @Test
    public void test01(){

        spec02.pathParams("p1","update","p2",21);

        DummyApiPostRequestBody requestBody=new DummyApiPostRequestBody("ali",11,21,"veli");

        Response rp=given().contentType(ContentType.JSON).spec(spec02).body(requestBody).when().put("/{p1}/{p2}");

        rp.prettyPrint();

        ExpectedDataDummy expectedData=new ExpectedDataDummy("success",requestBody,"Successfully! Record has been updated.");
        ExpectedDataDummy actuelData= JsonUtil.convertJsonToJava(rp.asString(),ExpectedDataDummy.class);

        Assert.assertEquals(actuelData.getMessage(),expectedData.getMessage());
        Assert.assertEquals(actuelData.getData().getEmployee_age(),expectedData.getData().getEmployee_age());


    }

}
