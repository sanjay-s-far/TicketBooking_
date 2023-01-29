package com.ticketbooking.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.UUIDGenerator;
import com.ticketbooking.Entity.Admincrediential;
import com.ticketbooking.Entity.BusSchedule;
import com.ticketbooking.Entity.Bus_Detail;
import com.ticketbooking.Repository.AdmincredientialRepo;
import com.ticketbooking.Repository.BusScheduleRepo;
import com.ticketbooking.Repository.Bus_Detailrepository;
import com.ticketbooking.Repository.LoginRepo;
import com.ticketbooking.Repository.TicketBookingRepo;
import com.ticketbooking.model.BusModel;
import com.ticketbooking.model.busDetailScheduleMode;
import com.ticketbooking.model.countDataModel;

@Service
public class Bus_Detailservice {
  @Autowired
  private Bus_Detailrepository bus_detailrepository;
  
  @Autowired
  private BusScheduleRepo BScheduleRepo;
  
  @Autowired
  private LoginRepo loginrepo;
  
  @Autowired
  private TicketBookingRepo bookingrepo;
  
  @Autowired
  private AdmincredientialRepo adminrepo;
  
  public Bus_Detail busdetail(Bus_Detail bus_detail)
  {
	  bus_detail.setBusId(UUID.randomUUID().toString());
//	  System.out.println(bus_detail.getBusId());
	  bus_detail.setCoverage(bus_detail.getCoverage().toLowerCase());
	  Admincrediential admincred = new Admincrediential();
//	  System.out.println(bus_detail.getBusId());
	  admincred.setAdminid(bus_detail.getBusId());
	  admincred.setAdminname(bus_detail.getBusName().replace(" ", ""));
	  String hashpw = BCrypt.hashpw(bus_detail.getBusNo().replace(" ", ""), BCrypt.gensalt());
	  admincred.setAdminpassword(hashpw);
	  admincred.setRollbase("OWNER");
	  adminrepo.save(admincred);
	  
	  return bus_detailrepository.save(bus_detail);
  }
  
  
  public List<Bus_Detail>getallbusdetail()
  {
	  return bus_detailrepository.findAll();
  }
  
  
  public BusModel getbyiddetail(String bus_id )
  {
	 Bus_Detail bus_detail= bus_detailrepository.findById(bus_id).get();
	  BusModel busmodel=new BusModel();
	  busmodel.setBusId(bus_detail.getBusId());
	  busmodel.setBusModel(bus_detail.getBusModel());
	  busmodel.setBusName(bus_detail.getBusName());
	  busmodel.setBusNo(bus_detail.getBusNo());
	  busmodel.setSeatconfig(bus_detail.getSeatconfig());
	  busmodel.setMode(bus_detail.getMode());
	  busmodel.setNoOfSeats(bus_detail.getNoOfSeats());
	  
	  String[] coverageNew = bus_detail.getCoverage().split(",");
//	  List<String> coverages=new ArrayList<>();
//	  for(String coverage:coverageNew)
//	  {
//		coverages.add(coverage);
//	  }
		  busmodel.setCoverage(coverageNew);
		  return busmodel;
  }
  
  public Bus_Detail updatebusdetail(Bus_Detail busdetail, String bus_id)
  
  {
	  Bus_Detail bus_detail=bus_detailrepository.findById(bus_id).get();
	  bus_detail.setBusName(busdetail.getBusName());
	  bus_detail.setBusNo(busdetail.getBusNo());
	  bus_detail.setBusModel(busdetail.getBusModel());
	  bus_detail.setMode(busdetail.getMode());
	  bus_detail.setNoOfSeats(busdetail.getNoOfSeats());
	  bus_detail.setCoverage(busdetail.getCoverage());
	  return bus_detailrepository.save(bus_detail);
  }
  
  public void deletebusdetail(String bus_id)
  {
	  bus_detailrepository.deleteById(bus_id);
	  
  }
   
  public List<String> listOfCoverage()
  {
	 List<String> coveragedata= bus_detailrepository.listofcoverage();
	 List<String> newCoverageData=new ArrayList<>();
	 
	 for(String covdata:coveragedata)
	 {
		 String[] revisedcovdata=covdata.split(",");
		 
		 for(String data:revisedcovdata)
		 {
			 
			 if(!newCoverageData.contains(data))
			 {
				 newCoverageData.add(data);
			 }		 
			 
		 }
	 }
	
	  return newCoverageData;
  }
	
  
  ////login for owner
  public Bus_Detail busdetail(String BusName,String busNo)
  {
	  System.out.println(busNo);
	  Bus_Detail busdetail=bus_detailrepository.findbus_name(BusName);
	  if (BCrypt.checkpw(busNo,busdetail.getBusNo())) {
		  return busdetail;
	  }
	  else
	  {
		  return null;
	  }
	  
  }
  
  public busDetailScheduleMode bdetailSchedule(String busId)
  {
	  Bus_Detail bsdetail= bus_detailrepository.findById(busId).get();
	  List<BusSchedule>bschedule=BScheduleRepo.findByBusid(busId);
	  busDetailScheduleMode busdetailModel=new  busDetailScheduleMode();
	  busdetailModel.setBsdetail(bsdetail);
	  busdetailModel.setBschedule(bschedule);
	  return busdetailModel;
	  
  }
  
  public countDataModel buscounts()
  {
	  String busCount=bus_detailrepository.countBusName();
	  String schedulecount=BScheduleRepo.countBusNames();
	  String usercount=loginrepo.countUserName();
	  String bookingcount=bookingrepo.countbooking();
	  countDataModel cntdata=new countDataModel();
	  cntdata.setUserNameCount(usercount);
	  cntdata.setScheduleCount(schedulecount);
	  cntdata.setTotalBusCount(busCount);
	  cntdata.setBookedSeatsCount(bookingcount);
	  return cntdata;
  }
  
  
}

  
  
  
  
  
  
  
  
