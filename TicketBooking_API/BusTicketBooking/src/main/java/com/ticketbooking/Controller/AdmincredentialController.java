package com.ticketbooking.Controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ticketbooking.Entity.Admincrediential;
import com.ticketbooking.Service.Admincredientialservice;
import com.ticketbooking.Service.LoginService;
@CrossOrigin("http://localhost:4500")
@RestController
public class AdmincredentialController {
@Autowired
private Admincredientialservice admincredientialservice;


//   @GetMapping("/getadminlogin")
//   public ResponseEntity<?> Loginadmin(@PathParam("adminname")String adminname,@PathParam("adminpassword")String adminpassword)
//   {
//	   
//	if(admincredientialservice.Loginadmin(adminname,adminpassword)!=null)
//	{
//		return new ResponseEntity<>( admincredientialservice.Loginadmin(adminname, adminpassword),HttpStatus.OK);
//		
//	}else if(admincredientialservice.adminexist (adminname)!=true)
//			
//	{
//		return new ResponseEntity<>("ADMINNAME DOES NOT EXIST",HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//	else if(admincredientialservice.adminexist (adminpassword)!=true)
//	{
//		return new ResponseEntity<>("PASSWORD DOES NOT EXIST",HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//	
//	else
//	{
//		return new ResponseEntity<>("ADMIN DOES NOT EXIST",HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//   }
//}
@GetMapping("/admin/login")
public ResponseEntity<?> Loginadmin(@PathParam("adminName")String adminName,@PathParam("adminPswd")String adminPswd)
{
//	   System.out.println(adminName);
	if(admincredientialservice.Loginadmin(adminName,adminPswd)!=null)
	{
		return new ResponseEntity<>( admincredientialservice.Loginadmin(adminName, adminPswd),HttpStatus.OK);
		
	}else if(admincredientialservice.adminexist (adminName)!=true)
			
	{
		return new ResponseEntity<>("ADMINNAME DOES NOT EXIST",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	else if(admincredientialservice.adminexist (adminPswd)!=true)
	{
		return new ResponseEntity<>("PASSWORD DOES NOT EXIST",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	else
	{
		return new ResponseEntity<>("ADMIN DOES NOT EXIST",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}




@PostMapping("/adminregister")
public Admincrediential adminloginregistercntr(@RequestBody Admincrediential admincredential)
{
	
	return admincredientialservice.adminloginregister(admincredential);
}

@GetMapping("/getadmin")

	public List<Admincrediential> getalladmincntrl()
	{
	return admincredientialservice.getalladmin();
	}

@PutMapping("/detailAdminupdate/{id}")
public Admincrediential detailUpdatecntr(@PathVariable("id") String adminid,@RequestBody Admincrediential admincredential)
{
	return admincredientialservice.detailUpdateService(admincredential, adminid);
}

@DeleteMapping("/detailAdmindelete/{id}")
public String detailDeleteCntrl(@PathVariable("id") String adminid)
{
     admincredientialservice.detailDeleteService(adminid);
     return "delted successfully";
}















}