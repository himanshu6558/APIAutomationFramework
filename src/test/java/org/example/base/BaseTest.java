package org.example.base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.example.Endpoints.APIConstants;
import org.example.Modules.PayloadManager;
import org.example.asserts.AssertActions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public AssertActions assertActions;
    public PayloadManager payloadManager;
    public JsonPath jsonPath;
    public RequestSpecification requestSpecification;
    public Response response;
    public ValidatableResponse validatableResponse;

    @BeforeTest
    public void setup(){

        System.out.println("Starting the test");
        payloadManager = new PayloadManager();
        assertActions = new AssertActions();
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri(APIConstants.BASE_URL);
        requestSpecification.contentType(ContentType.JSON).log().all();
    }

    @AfterTest
    public void tearDown(){
        System.out.println("Finished the test");
    }

}
