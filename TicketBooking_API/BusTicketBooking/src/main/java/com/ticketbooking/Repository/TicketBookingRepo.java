package com.ticketbooking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbooking.Entity.TicketBooking;

public interface TicketBookingRepo extends JpaRepository<TicketBooking, String> {

}
