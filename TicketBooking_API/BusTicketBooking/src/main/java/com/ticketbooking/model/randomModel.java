package com.ticketbooking.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class randomModel {

private String busName;
private String from;
private String to;
private String distance;
private String departureArea;
private int noOfSeats;
private LocalDateTime startingTime;
private LocalDateTime reachTime;
private int fairPerSeat;

}
