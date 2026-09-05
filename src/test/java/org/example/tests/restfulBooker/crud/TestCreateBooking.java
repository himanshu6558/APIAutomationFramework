package org.example.tests.restfulBooker.crud;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.example.Endpoints.APIConstants;
import org.example.Pojos.Response.RestfulBooker.Common.BookingResponse;
import org.example.base.BaseTest;
import org.testng.annotations.Test;

public class TestCreateBooking extends BaseTest {

    @Test(groups = "reg", priority = 1)
    @Owner("Himanshu")
    @Description("TC#1 - Verify that the Booking can be Created")
    public void testCreateBookingPost_Positive(){
        requestSpecification.basePath(APIConstants.CREATE_BOOKING);
        response = RestAssured.given(requestSpecification)
                .when().body(payloadManager.createValidBookingPayload()).log().all().post();

        BookingResponse bookingResponse = payloadManager.bookingResponse(response.asString());

        assertActions.verifyStatusCode(response,200);
        assertActions.verifyStringKeyNotNull(bookingResponse.getBookingid());
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(),"Himanshu");
    }

    @Test(groups = "reg", priority = 2)
    @Owner("Himanshu")
    @Description("TC#2 - Verify that the Booking cannot be Created")
    public void testCreateBookingPost_Negative(){
        requestSpecification.basePath(APIConstants.CREATE_BOOKING);
        response = RestAssured.given(requestSpecification)
                .when().body("{}").log().all().post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(500);
    }

    @Test(groups = "reg", priority = 3)
    @Owner("Himanshu")
    @Description("TC#3 - Verify that the Booking can be Created with Chinese")
    public void testCreateBookingPost_PositiveChinese(){
        requestSpecification.basePath(APIConstants.CREATE_BOOKING);
        response = RestAssured.given(requestSpecification)
                .when().body(payloadManager.createValidBookingPayloadChinese()).log().all().post();

        BookingResponse bookingResponse = payloadManager.bookingResponse(response.asString());

        assertActions.verifyStatusCode(response,200);
        assertActions.verifyStringKeyNotNull(bookingResponse.getBookingid());
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(),"希曼舒");
    }

    @Test(groups = "reg", priority = 4)
    @Owner("Himanshu")
    @Description("TC#4 - Verify that the Booking can be Created with Faker Data")
    public void testCreateBookingPost_DummyData(){
        requestSpecification.basePath(APIConstants.CREATE_BOOKING);
        response = RestAssured.given(requestSpecification)
                .when().body(payloadManager.createPayloadBookingFakerJs()).log().all().post();

        BookingResponse bookingResponse = payloadManager.bookingResponse(response.asString());

        assertActions.verifyStatusCode(response,200);
        assertActions.verifyStringKeyNotNull(bookingResponse.getBookingid());
        assertActions.verifyStringKeyNotNull(bookingResponse.getBooking().getFirstname());
        assertActions.verifyStringKeyNotNull(bookingResponse.getBooking().getLastname());
    }

}
