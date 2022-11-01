package com.ticketbooking.Entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketBooking {
	@Id
  private String bookingId;
  private String busId;
  private String scheduleID;
  private String userName;
  private LocalDateTime bookingDateTime;
  private int noOfBookingSeats;
  private String bookingStatus;
  private int fare;
 
}
