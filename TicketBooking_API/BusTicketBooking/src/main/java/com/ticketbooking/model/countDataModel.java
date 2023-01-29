package com.ticketbooking.model;

import java.time.LocalDateTime;

import com.ticketbooking.Entity.Bus_Detail;
import com.ticketbooking.Repository.LoginRepo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class countDataModel {
	private String scheduleCount;
	private String totalBusCount;
	private String bookedSeatsCount;
	private String userNameCount;

}
