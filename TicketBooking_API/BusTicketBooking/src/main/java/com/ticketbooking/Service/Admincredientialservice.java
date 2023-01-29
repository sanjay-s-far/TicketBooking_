package com.ticketbooking.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.UUIDGenerator;
import com.ticketbooking.Controller.AdmincredentialController;
import com.ticketbooking.Entity.Admincrediential;
import com.ticketbooking.Entity.BusSchedule;
import com.ticketbooking.Entity.Bus_Detail;
import com.ticketbooking.Entity.Login;
import com.ticketbooking.Repository.AdmincredientialRepo;
import com.ticketbooking.Repository.BusScheduleRepo;
import com.ticketbooking.Repository.Bus_Detailrepository;
import com.ticketbooking.model.BusCardModel;
import com.ticketbooking.model.BusModel;


@Service

public class Admincredientialservice {


	
	@Autowired
	public AdmincredientialRepo admincredientialrepo;
	@Autowired
	public Bus_Detailrepository bus_detailrepository;
	@Autowired
	public BusScheduleRepo bus_schedlrepo;
	
	
	public Admincrediential Loginadmin(String adminName ,String adminPassword)
	{
		Admincrediential admincrediential = admincredientialrepo.findadminname(adminName);
		System.out.println(admincrediential);
		if(BCrypt.checkpw(adminPassword, admincrediential.getAdminpassword())) {
			return admincrediential;
		}else {
			return null;
		}
				//return admincredientialrepo.Loginadmin(adminName, adminPassword);
	}
	
	public boolean adminexist(String adminname)
	{
		if(admincredientialrepo.findadminname(adminname)!=null)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}

	///////////////admin based login
	public Admincrediential adminloginregister(Admincrediential admincredential)
	
	{
		String hashpw = BCrypt.hashpw(admincredential.getAdminpassword(), BCrypt.gensalt());
	
		admincredential.setAdminid(UUID.randomUUID().toString());
		admincredential.setAdminpassword(hashpw);
	return 	admincredientialrepo.save(admincredential);
	}
	
	public List<Admincrediential> getalladmin()
	{
		return admincredientialrepo.findAll();
	}
	
	
	public Admincrediential detailUpdateService(Admincrediential admincredential,String adminid)
	{
		Admincrediential admin_crediential=admincredientialrepo.findById(adminid).get();
		admin_crediential.setAdminname(admincredential.getAdminname());
		admin_crediential.setRollbase(admincredential.getRollbase());
		return admincredientialrepo.save(admin_crediential);
		
	}
	
  public void detailDeleteService(String adminid)
  {
	  admincredientialrepo.deleteById(adminid);
  }
  
}
