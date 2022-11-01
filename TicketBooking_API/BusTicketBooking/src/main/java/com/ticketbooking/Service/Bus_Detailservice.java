package com.ticketbooking.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.UUIDGenerator;
import com.ticketbooking.Entity.AdminCredentials;
import com.ticketbooking.Entity.BusSchedule;
import com.ticketbooking.Entity.Bus_Detail;
import com.ticketbooking.Repository.AdminRepo;
import com.ticketbooking.Repository.BusScheduleRepo;
import com.ticketbooking.Repository.Bus_Detailrepository;
import com.ticketbooking.model.BusDetailWithSchedules;
import com.ticketbooking.model.BusModel;

@Service
public class Bus_Detailservice {
  @Autowired
  private Bus_Detailrepository bus_detailrepository;
  
  @Autowired 
  private AdminRepo adminRepo;
  
  @Autowired
  private BusScheduleRepo busScheduleRepo;
  
  public Bus_Detail busdetail(Bus_Detail bus_detail)
  {
	  bus_detail.setBusId(UUID.randomUUID().toString());
	  bus_detail.setCoverage(bus_detail.getCoverage().toLowerCase());
	  AdminCredentials  adminCredentials = new AdminCredentials();
	  adminCredentials.setAdminId(bus_detail.getBusId());
	  adminCredentials.setAdminName(bus_detail.getBusName().replace(" ", ""));
	  String hashMapedBusNo = BCrypt.hashpw(bus_detail.getBusNo().replace(" ", ""), BCrypt.gensalt());
	  adminCredentials.setContactMail(bus_detail.getContactMail());
	  adminCredentials.setPassword(hashMapedBusNo);
	  adminCredentials.setRole("OWNER");
	  adminRepo.save(adminCredentials);
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
	  
	  busmodel.setMode(bus_detail.getMode());
	  busmodel.setNoOfSeats(bus_detail.getNoOfSeats());
	  
	  String[] coverageNew = bus_detail.getCoverage().split(",");
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
//	 System.out.println(newCoverageData);
	  return newCoverageData;
  }
	
  
  public BusDetailWithSchedules BusDetailWithschedules(String AdminBusId){
	  Bus_Detail bsDetail = bus_detailrepository.findById(AdminBusId).get();
	  List<BusSchedule> bsSchedule = busScheduleRepo.FetchByBusId(AdminBusId);
	  BusDetailWithSchedules busdetailModel = new BusDetailWithSchedules();
	 busdetailModel.setBusDetail(bsDetail);
	 busdetailModel.setBusSchedules(bsSchedule);
	  return busdetailModel;
  }
  
 
  
}
