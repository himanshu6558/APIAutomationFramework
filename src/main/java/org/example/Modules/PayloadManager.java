package org.example.Modules;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.example.Pojos.Request.RestfulBooker.Common.Booking;
import org.example.Pojos.Request.RestfulBooker.Common.Bookingdates;
import org.example.Pojos.Response.RestfulBooker.Common.BookingResponse;

public class PayloadManager {

    Gson gson = new Gson();
    Faker faker = new Faker();
    //Serialization

    public String createValidBookingPayload(){
        Booking booking = new Booking();
        Bookingdates bookingdates = new Bookingdates();

        booking.setFirstname("Himanshu");
        booking.setLastname("Bhandari");
        booking.setAdditionalneeds("Breakfast");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);
        bookingdates.setCheckin("2026-05-05");
        bookingdates.setCheckout("2026-07-06");
        booking.setBookingdates(bookingdates);

        return gson.toJson(booking);
    }

    public String createValidBookingPayloadChinese(){
        Booking booking = new Booking();
        Bookingdates bookingdates = new Bookingdates();

        booking.setFirstname("希曼舒");
        booking.setLastname("班达里");
        booking.setAdditionalneeds("早餐");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);
        bookingdates.setCheckin("9999-05-05");
        bookingdates.setCheckout("1452-07-06");
        booking.setBookingdates(bookingdates);

        return gson.toJson(booking);
    }

    public String createPayloadBookingFakerJs(){
        Booking booking = new Booking();
        Bookingdates bookingdates = new Bookingdates();

        booking.setFirstname(faker.name().firstName());
        booking.setLastname(faker.name().lastName());
        booking.setAdditionalneeds("Breakfast");
        booking.setTotalprice(faker.random().nextInt(1, 1000));
        booking.setDepositpaid(faker.random().nextBoolean());
        bookingdates.setCheckin("2026-05-05");
        bookingdates.setCheckout("2026-07-06");
        booking.setBookingdates(bookingdates);

        return gson.toJson(booking);
    }

    //De-serialization

    public BookingResponse bookingResponse (String responseString){
        BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
        return bookingResponse;
    }

}
