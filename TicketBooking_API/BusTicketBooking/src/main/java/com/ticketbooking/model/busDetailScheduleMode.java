package com.ticketbooking.model;

import java.util.List;

import com.ticketbooking.Entity.BusSchedule;
import com.ticketbooking.Entity.Bus_Detail;
import com.ticketbooking.Repository.Bus_Detailrepository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class busDetailScheduleMode {
	
	public Bus_Detail bsdetail;
	public List<BusSchedule> bschedule;

}
