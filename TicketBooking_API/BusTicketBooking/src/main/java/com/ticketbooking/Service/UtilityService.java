package com.ticketbooking.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbooking.Entity.Bus_Detail;
import com.ticketbooking.Repository.BusScheduleRepo;
import com.ticketbooking.Repository.Bus_Detailrepository;
import com.ticketbooking.Repository.LoginRepo;
import com.ticketbooking.Repository.TicketBookingRepo;
import com.ticketbooking.model.ManagementDetailModel;

@Service
public class UtilityService {
	
	@Autowired
	private LoginRepo userRepo;
	
	@Autowired
	private Bus_Detailrepository BusRepo;
	
	@Autowired
	private BusScheduleRepo busScheduleRepo;
	
	@Autowired
	private TicketBookingRepo bookings;
	
	public ManagementDetailModel managementDetail() {
		ManagementDetailModel details = new ManagementDetailModel();
		details.setUserCount(userRepo.findAll().size());
		details.setBusCount(BusRepo.findAll().size());
		details.setSchedules(busScheduleRepo.findAll().size());
		details.setBookings(bookings.findAll().size());
		return details;
	}

}
