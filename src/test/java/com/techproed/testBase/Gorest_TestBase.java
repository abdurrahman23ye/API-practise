package com.techproed.testBase;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class Gorest_TestBase {

    protected RequestSpecification spec;

    @Before
    public void test01(){

        spec=new RequestSpecBuilder().setBaseUri("https://gorest.co.in/public/v1").build();

    }
}
