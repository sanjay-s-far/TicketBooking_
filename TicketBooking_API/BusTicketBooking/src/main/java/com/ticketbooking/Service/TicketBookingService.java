package com.ticketbooking.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbooking.Entity.BusSchedule;
import com.ticketbooking.Entity.TicketBooking;
import com.ticketbooking.Repository.BusScheduleRepo;
import com.ticketbooking.Repository.Bus_Detailrepository;
import com.ticketbooking.Repository.TicketBookingRepo;

@Service
public class TicketBookingService {
	@Autowired
	private TicketBookingRepo ticketbookingrepo;
	@Autowired
	private BusScheduleRepo busschedulerepo;
	@Autowired
	private Bus_Detailrepository busdetailrepo;

	public TicketBooking ticket(TicketBooking ticketbooking)
	{
		ticketbooking.setBookingDateTime(LocalDateTime.now());
		ticketbooking.setBookingId(UUID.randomUUID().toString());
		BusSchedule scheduledetails=busschedulerepo.findById(ticketbooking.getScheduleID()).get();
		int fair=scheduledetails.getFairPerSeat();
		int totalfair=fair*ticketbooking.getNoOfBookingSeats();
		ticketbooking.setBusId(scheduledetails.getBusId());
		ticketbooking.setFare(totalfair);
		ticketbooking.setBookingStatus("BeingBooked");
		return  ticketbookingrepo.save(ticketbooking);

	}

	public List <TicketBooking> getbooking()
	{
		return ticketbookingrepo.findAll();
	}
	public TicketBooking bookingbyid(String bookingId)
	{
		return ticketbookingrepo.findById(bookingId).get();
	}
	public void deletebooking(String bookingId)
	{
		ticketbookingrepo.deleteById(bookingId);
	}




}
