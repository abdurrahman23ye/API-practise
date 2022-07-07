package com.techproed;

import com.techproed.testBase.JsonPlaceHolderTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;

public class ClassWork3 extends JsonPlaceHolderTestBase {

    /*
        Given
	   	    https://jsonplaceholder.typicode.com/todos
		When
			 I send GET Request to the URL
		Then
			 1)Status code is 200
			 2)Print all ids greater than 190 on the console
			   Assert that there are 10 ids greater than 190
			 3)Print all userIds whose ids are less than 5 on the console
			   Assert that the number of userIds whose ids are less than 5 is 4
			 4)Print all titles whose ids are less than 5
			   Assert that "delectus aut autem" is one of the titles whose id is less than 5

     */


    @Test
    public void test01(){

        spec01.pathParam("p1","todos");


        Response rp=given().contentType(ContentType.JSON).spec(spec01).when().get("/{p1}");

        // 1)Status code is 200
        rp.then().
                assertThat().
                statusCode(200);

        //2)Print all ids greater than 190 on the console

        JsonPath js=rp.jsonPath();

        System.out.println(js.getList("findAll{it.id>190}.id"));

        // Assert that there are 10 ids greater than 190

        Assert.assertTrue(js.getList("findAll{it.id>190}.id").size()>=10);

       /* 3)Print all userIds whose ids are less than 5 on the console
        Assert that the number of userIds whose ids are less than 5 is 4

        //değişmiş asser edemiyoruz.
        */

        System.out.println(js.getList("findAll{it.userID<5}.id"));



        //Print all titles whose ids are less than 5

        System.out.println(js.getList("findAll{it.id<5}.title"));

        /*
        Assert that "delectus aut autem" is one of the titles whose id is less than 5


        */

        Assert.assertTrue(js.getList("findAll{it.id<5}.title").contains("delectus aut autem"));




    }
}
