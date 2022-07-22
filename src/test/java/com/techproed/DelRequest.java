package com.techproed;

import com.techproed.pojos.DummyApiPostRequestBody;
import com.techproed.pojos.ExpectedDataDummy;
import com.techproed.pojos.ExpectedDataDummyDel;
import com.techproed.testBase.DummyRestAPIExampleTestBase;
import com.techproed.utilities.JsonUtil;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DelRequest extends DummyRestAPIExampleTestBase {

    /*
    /*
    URL: https://dummy.restapiexample.com/api/v1/delete/2
   HTTP Request Method: DELETE Request
   Test Case: Type by using Gherkin Language
   Assert:     i) Status code is 200
           ii) "status" is "success"
          iii) "data" is "2"
           iv) "message" is "Successfully! Record has been deleted"
 */



    @Test
    public void test01(){

        spec02.pathParams("p1","delete","p2",2);


        Response rp=given().contentType(ContentType.JSON).spec(spec02).when().delete("/{p1}/{p2}");

        rp.prettyPrint();

        ExpectedDataDummyDel expectedData=new ExpectedDataDummyDel("success",2,"Successfully! Record has been deleted");
        ExpectedDataDummyDel actuelData= JsonUtil.convertJsonToJava(rp.asString(),ExpectedDataDummyDel.class);

        Assert.assertEquals(actuelData.getMessage(),expectedData.getMessage());
        Assert.assertEquals(actuelData.getData(),expectedData.getData());


    }


}
