package com.ticketbooking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class BusModel {
	
	 private String busId;
	  private String BusName;
	  private String busNo;
	  private String  busModel;
	  private int noOfSeats;
	  private String mode;
	  private String[] coverage;
}
