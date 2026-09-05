package org.example.Pojos.Response.RestfulBooker.GetBookingIds;

import java.util.List;

public class BookingResponse{
	private List<BookingResponseItem> bookingResponse;

	public void setBookingResponse(List<BookingResponseItem> bookingResponse){
		this.bookingResponse = bookingResponse;
	}

	public List<BookingResponseItem> getBookingResponse(){
		return bookingResponse;
	}
}