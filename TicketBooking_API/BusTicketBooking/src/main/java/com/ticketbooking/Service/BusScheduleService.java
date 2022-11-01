package com.ticketbooking.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbooking.Entity.BusSchedule;
import com.ticketbooking.Entity.Bus_Detail;
import com.ticketbooking.Repository.BusScheduleRepo;
import com.ticketbooking.Repository.Bus_Detailrepository;
import com.ticketbooking.model.BusCardModel;

@Service
public class BusScheduleService {
   @Autowired
   private BusScheduleRepo busschedulerepo;

   @Autowired
  private Bus_Detailrepository bus_detailrepository;
   
   public BusSchedule scheduledetails(BusSchedule busschedule )
   {
	   BusSchedule NewScheduledBus = new BusSchedule();
	   Bus_Detail bus_detail=bus_detailrepository.findById(busschedule.getBusId()).get();
	   NewScheduledBus.setScheduleID(UUID.randomUUID().toString());
	   NewScheduledBus.setBusId(busschedule.getBusId());
	   NewScheduledBus.setBusName(bus_detail.getBusName());
	   NewScheduledBus.setNoOfSeats(bus_detail.getNoOfSeats());
	   NewScheduledBus.setDepartureArea(busschedule.getDepartureArea());
	   NewScheduledBus.setDistance(busschedule.getDistance());
	   NewScheduledBus.setFrom(busschedule.getFrom());
	   NewScheduledBus.setTo(busschedule.getTo());
	   NewScheduledBus.setFairPerSeat(busschedule.getFairPerSeat());
	   NewScheduledBus.setReachTime(busschedule.getReachTime());
	   NewScheduledBus.setStartingTime(busschedule.getStartingTime());
	   NewScheduledBus.setAvailable_status("SCHEDULED_FOR_TRAVEL");
	   
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
	   return cardModel;
   }
   public BusSchedule updateschedule(BusSchedule busschedule,String scheduleID)
   {
	   BusSchedule scheduledetails=busschedulerepo.findById(scheduleID).get();
	   scheduledetails.setDepartureArea(busschedule.getDepartureArea());
	   scheduledetails.setFrom(busschedule.getFrom());
	   scheduledetails.setTo(busschedule.getTo());
	   scheduledetails.setNoOfSeats(busschedule.getNoOfSeats());
	   scheduledetails.setStartingTime(busschedule.getStartingTime());
	   scheduledetails.setReachTime(busschedule.getReachTime());
	   scheduledetails.setFairPerSeat(busschedule.getFairPerSeat());
	   scheduledetails.setAvailable_status(busschedule.getAvailable_status());
	   return busschedulerepo.save(scheduledetails);
 }
   public BusSchedule updateStatus(String scheduleID,String Status) {
	   BusSchedule schedules = busschedulerepo.findById(scheduleID).get();
	   schedules.setAvailable_status(Status);
	   return busschedulerepo.save(schedules);
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
		   BusCardModel.add(cardModel);
		   
	   }
	
	   return BusCardModel ;
	
   }
   
   
   
}
