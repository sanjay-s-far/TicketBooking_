package com.ticketbooking.Service;

import java.security.Timestamp;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class TestClass {

	public static void main(String[] args) {
		String[] from = {"chennai","pondy","madurai","kanchi"};
		String[] to = {"andhra","vellore","trichy","tirelveli"};
		
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		   LocalDateTime now = LocalDateTime.now().plusHours(9);
		   System.out.println(dtf.format(now));
		   
		   
	     Random rand = new Random();
	   String dd=from[rand.nextInt(from.length)];
	   String dd1=to[rand.nextInt(to.length)];
	   System.out.println(dd);
	   System.out.println(dd1);
		}
		
       
	}


