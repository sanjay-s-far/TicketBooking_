package com.ticketbooking.model;

import java.util.List;

import com.ticketbooking.Entity.BusSchedule;
import com.ticketbooking.Entity.Bus_Detail;
import com.ticketbooking.Service.BusScheduleService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BusDetailWithSchedules {
	
	private Bus_Detail busDetail;
	
	private List<BusSchedule> busSchedules;

}
