package com.ticketbooking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ticketbooking.Entity.TicketBooking;

public interface TicketBookingRepo extends JpaRepository<TicketBooking, String> {
//@Query("select count(no_of_booking_seats) from TicketBooking bookseats")
//String countbooking();
	
	 @Query("select count(no_of_booking_seats) from TicketBooking bsdetail")
	   String countbooking();
		
}
