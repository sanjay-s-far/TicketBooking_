package com.ticketbooking.Entity;



import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "busSchedule")
public class BusSchedule {
	@Id
	private String scheduleID;
	
	@Column(name="busId")
	private String busId;
	
	private String busName;
	private String from;
	private String to;
	private String distance;
	private String departureArea;
	private int noOfSeats;
	private int bookedSeats;
	private LocalDateTime startingTime;
	private LocalDateTime reachTime;
	private int fairPerSeat;
	private String available_status;
	
	
	
		

}
