package Practice.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class RestApi {




    protected RequestSpecification spec01;

    @Before
    public void test01(){

        spec01=new RequestSpecBuilder().setBaseUri("http://dummy.restapiexample.com/api/v1/").build();
    }
}
