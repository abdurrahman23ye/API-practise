package Practice.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class RestFullBooker {


    protected RequestSpecification spec01;

    @Before
    public void test01(){

        spec01=new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com/").build();
    }
}
