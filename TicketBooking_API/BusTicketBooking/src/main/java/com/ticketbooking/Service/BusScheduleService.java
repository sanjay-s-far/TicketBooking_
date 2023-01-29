package com.ticketbooking.Service;

import java.io.IOException;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.JobLauncherApplicationRunner;
import org.springframework.stereotype.Service;

import com.ticketbooking.Entity.BusSchedule;
import com.ticketbooking.Entity.Bus_Detail;
import com.ticketbooking.Repository.BusScheduleRepo;
import com.ticketbooking.Repository.Bus_Detailrepository;
import com.ticketbooking.model.BusCardModel;
import com.ticketbooking.model.BusModel;
import com.ticketbooking.model.randomModel;

import ch.qos.logback.classic.Logger;


@Service
public class BusScheduleService {
   @Autowired
   private BusScheduleRepo busschedulerepo;

   @Autowired
  private Bus_Detailrepository bus_detailrepository;
   
   public BusSchedule scheduledetails(BusSchedule busschedule)
   {
	   BusSchedule NewScheduledBus = new BusSchedule();
	   Bus_Detail bus_detail=bus_detailrepository.findById(busschedule.getBusId()).get();
	  System.out.print(bus_detail.getBusId());
	   NewScheduledBus.setScheduleID(UUID.randomUUID().toString());
	   NewScheduledBus.setBusId(bus_detail.getBusId());
	   NewScheduledBus.setBusName(bus_detail.getBusName());
	   NewScheduledBus.setNoOfSeats(bus_detail.getNoOfSeats());
	   NewScheduledBus.setDepartureArea(busschedule.getDepartureArea());
	   NewScheduledBus.setDistance(busschedule.getDistance());
	   NewScheduledBus.setFrom(busschedule.getFrom());
	   NewScheduledBus.setTo(busschedule.getTo());
	   NewScheduledBus.setFairPerSeat(busschedule.getFairPerSeat());
	   NewScheduledBus.setReachTime(busschedule.getReachTime());
	   NewScheduledBus.setStartingTime(busschedule.getStartingTime());
	   NewScheduledBus.setAvailable_status("available seats");
	   
	   System.out.println(busschedule.getStartingTime()); 
	   
	   Date date = new Date(); 
	  // System.out.println(date.getTime());

	   return busschedulerepo.save(NewScheduledBus);
	    
   }
   
   public List<BusSchedule> savemultiple(List<BusSchedule> busschedule )
   {
	   return busschedulerepo.saveAll(busschedule);
	    
   }
   
   public List<BusSchedule> getscheduledetail()
   {
	   return busschedulerepo.findAll();
   }
   
   
   public BusCardModel getscheduleid(String busId)
   
   {
	   BusCardModel cardModel = new BusCardModel();
	   BusSchedule bsschedule= busschedulerepo.findById(busId).get();
	   Bus_Detail bsdetail= bus_detailrepository.findById(busId).get();
	   cardModel.setBookedSeats(bsschedule.getBookedSeats());
	   cardModel.setBusName(bsschedule.getBusName());
	   cardModel.setDepartureArea(bsschedule.getDepartureArea());
	   cardModel.setDistance(bsschedule.getDistance());
	   cardModel.setFairPerSeat(bsschedule.getFairPerSeat());
	   cardModel.setFrom(bsschedule.getFrom());
	   cardModel.setTo(bsschedule.getTo());
	   cardModel.setNoOfSeats(bsschedule.getNoOfSeats());
	   cardModel.setReachTime(bsschedule.getReachTime());
	   cardModel.setStartingTime(bsschedule.getStartingTime());
	   cardModel.setMode(bsdetail.getBusModel());
	   cardModel.setSeatconfig(bsdetail.getSeatconfig());
	   System.out.println("seat configuration" + bsdetail.getSeatconfig());
	   return cardModel;
   }
   public BusSchedule updateschedule(BusSchedule busschedule,String scheduleID)
   {
	   BusSchedule scheduledetails=busschedulerepo.findById(scheduleID).get();
//	   scheduledetails.setDepartureArea(busschedule.getDepartureArea());
//	   scheduledetails.setFrom(busschedule.getFrom());
//	   scheduledetails.setTo(busschedule.getTo());
//	   scheduledetails.setNoOfSeats(busschedule.getNoOfSeats());
//	   scheduledetails.setStartingTime(busschedule.getStartingTime());
//	   scheduledetails.setReachTime(busschedule.getReachTime());
//	   scheduledetails.setFairPerSeat(busschedule.getFairPerSeat());
	   scheduledetails.setAvailable_status(busschedule.getAvailable_status());
	   return busschedulerepo.save(scheduledetails);
 }
   public void deleteschedule(String scheduleID)
   {
	    busschedulerepo.deleteById(scheduleID);
   }
   
   public List<BusCardModel> getschedulebus(String from,String to,String date)
   {
	   List<BusSchedule> ListOfBusScheduled = busschedulerepo.fetchBus(from, to, date);
	   List<BusCardModel> BusCardModel = new ArrayList<>();
	   
	   for (BusSchedule ScheduledBus: ListOfBusScheduled) {
		   Bus_Detail bsdetail= bus_detailrepository.findById(ScheduledBus.getBusId()).get();
		  
		   BusCardModel cardModel = new BusCardModel();
		   cardModel.setScheduleID(ScheduledBus.getScheduleID());
		  
		   cardModel.setBookedSeats(ScheduledBus.getBookedSeats());
		   cardModel.setBusName(ScheduledBus.getBusName());
		   cardModel.setDepartureArea(ScheduledBus.getDepartureArea());
		   cardModel.setDistance(ScheduledBus.getDistance());
		   cardModel.setFairPerSeat(ScheduledBus.getFairPerSeat());
		   cardModel.setFrom(ScheduledBus.getFrom());
		   cardModel.setTo(ScheduledBus.getTo());
		   cardModel.setNoOfSeats(ScheduledBus.getNoOfSeats());
		   cardModel.setReachTime(ScheduledBus.getReachTime());
		   cardModel.setStartingTime(ScheduledBus.getStartingTime());
		   cardModel.setMode(bsdetail.getBusModel());
		   cardModel.setSeatconfig(bsdetail.getSeatconfig());
		   BusCardModel.add(cardModel);
		   
	   }
	    
	   return BusCardModel ;
	   
   }
   
   
   
  public BusSchedule randomdata(BusSchedule scheduleData)
  {
	  Bus_Detail bus_detail=bus_detailrepository.findById(scheduleData.getBusId()).get();
	  scheduleData.setScheduleID(UUID.randomUUID().toString());
	  scheduleData.setBusId(bus_detail.getBusId());
	  scheduleData.setBusName(bus_detail.getBusName());
	  String[] from = {"chennai","pondy","madurai","kanchi"};
		String[] to = {"andhra","vellore","trichy","tirelveli"};
		String[]departureArea= {"cmbt","newbusstand","dhanksha","norway","jetland"};
		int[]noOfSeats= {60,50,80,70,50,40};
		int[]fairPerSeats= {600,500,800,700,500,400};
		
		 Random rand = new Random();
		   String fromData=from[rand.nextInt(from.length)];
		   String toData=to[rand.nextInt(to.length)];
		   String departureData=departureArea[rand.nextInt(departureArea.length)];
		   int seatsData=noOfSeats[rand.nextInt(noOfSeats.length)];
		   int fairData=fairPerSeats[rand.nextInt(fairPerSeats.length)];
		   scheduleData.setFrom(fromData);
		   scheduleData.setTo(toData);
		   scheduleData.setDepartureArea(departureData);
		   scheduleData.setNoOfSeats(seatsData);
		   scheduleData.setFairPerSeat(fairData);
		
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		   LocalDateTime now = LocalDateTime.now();
		   scheduleData.setStartingTime(now);
		   
	    	DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		   LocalDateTime now2 = LocalDateTime.now().plusHours(9);
		   scheduleData.setReachTime(now2);
	
		   System.out.println(scheduleData);
		   System.out.println("nm");
		   return busschedulerepo.save(scheduleData);
    
	  
  }
  
  ////////csvexport
  
//  public List<BusSchedule>csvExport()
//  {
//	  
////	  List<BusSchedule> bschedule=busschedulerepo.getcsvreport();
//	  
////	  System.out.println(startingTime);
////	  System.out.println(reachTime);
////	return bschedule;
//	
//	  
//	  return busschedulerepo.findAll();
//  }
//  
  
  
  
  public List<BusSchedule> excelExportSchedule(String date1,String date2)
  {
	  return busschedulerepo.getcsvreport(date1, date2);
  }

 
  
}
