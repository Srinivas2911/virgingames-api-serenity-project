package com.virgingames.testbase;

/*
Created by SP
*/

import com.virgingames.utils.PropertyReader;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase    {

    public static PropertyReader propertyReader;

    @BeforeClass
    public static void inIt() {
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("baseUrl");
        RestAssured.basePath = propertyReader.getProperty("basePath");
    }
}
