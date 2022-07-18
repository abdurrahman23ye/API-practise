package com.techproed.testBase;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class Automation_Exercise_TestBase {

    protected RequestSpecification spec01;

    @Before
    public void test01(){

        spec01=new RequestSpecBuilder().setBaseUri("https://automationexercise.com/api").build();
    }
}
