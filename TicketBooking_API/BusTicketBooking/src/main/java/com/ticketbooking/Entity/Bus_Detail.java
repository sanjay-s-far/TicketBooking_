package com.ticketbooking.Entity;

import java.sql.Array;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bus_Detail {
	@Id
  private String busId;
  private String BusName;
  private String busNo;
  private String  busModel;
  private int noOfSeats;
  private String mode;
  private String coverage;
  private String seatconfig;
  
  

 }
