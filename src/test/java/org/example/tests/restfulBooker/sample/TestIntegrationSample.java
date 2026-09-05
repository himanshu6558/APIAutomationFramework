package org.example.tests.restfulBooker.sample;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestIntegrationSample {

    @Test(groups = "qa", priority = 1)
    @Owner("Himanshu")
    @Description("TC#INT1 - Step 1. Verify that the Booking can be created")
    public void testCreateBooking(){
        Assert.assertTrue(true);
    }

    @Test(groups = "qa", priority = 2)
    @Owner("Himanshu")
    @Description("TC#INT1 - Step 2. Verify that the Booking by ID")
    public void testVerifyBookingId(){
        Assert.assertTrue(true);
    }

    @Test(groups = "qa", priority = 3)
    @Owner("Himanshu")
    @Description("TC#INT1 - Step 3. Verify Updated Booking by ID")
    public void testUpdateBookingId(){
        Assert.assertTrue(true);
    }

    @Test(groups = "qa", priority = 4)
    @Owner("Himanshu")
    @Description("TC#INT1 - Step 4. Delete the Booking by ID")
    public void testDeleteBookingId(){
        Assert.assertTrue(true);
    }


}
