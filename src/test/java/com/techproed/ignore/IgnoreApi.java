package com.techproed.ignore;

import com.techproed.testBase.JsonPlaceHolderTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class IgnoreApi extends JsonPlaceHolderTestBase {

    /*
         Given
            https://jsonplaceholder.typicode.com/todos
            {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false
            }
        When
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    @Test
    public void pojo01(){

        spec01.pathParam("p1","todos");

        Ignore bodyRequest=new Ignore(55,"Tidy your room",false);

        Response rp=given().contentType(ContentType.JSON).spec(spec01).body(bodyRequest).post("/{p1}");

        rp.prettyPrint();

        Ignore expectedData=rp.as(Ignore.class);

        Assert.assertEquals(expectedData.getUserId(),bodyRequest.getUserId());
        Assert.assertEquals(expectedData.getTitle(),bodyRequest.getTitle());
        Assert.assertEquals(expectedData.getCompleted(),bodyRequest.getCompleted());

        //ID'i umursamadı !!!
    }

   /* {
        "status": "success",
            "data": {
        "name": "test",
                "salary": 1231111,
                "age": 13,
                "id": 2891
    },
        "message": "Successfully! Record has been added."
    }

    */
}
