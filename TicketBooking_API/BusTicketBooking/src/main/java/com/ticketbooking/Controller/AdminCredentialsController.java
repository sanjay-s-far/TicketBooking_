package com.ticketbooking.Controller;

import javax.swing.text.html.HTML;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ticketbooking.Entity.AdminCredentials;
import com.ticketbooking.Service.AdminService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminCredentialsController {
	
	@Autowired
	private AdminService adminService;
	
	
	
	@GetMapping("/login")
	public ResponseEntity<?> LoginAdmin(@PathParam("adminName") String adminName,@PathParam("adminPswd") String adminPswd){
//		System.out.println(adminName);
		if(adminService.OnLoginOwner(adminName, adminPswd) != null) {
			AdminCredentials admincredentials = adminService.OnLoginOwner(adminName, adminPswd); 
			return new ResponseEntity<>(admincredentials,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("USER CREDENTIALS IS NOT FOUND", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/management")
	public ResponseEntity<?> FetchDetailByRole(@PathParam("role1") String role1,@PathParam("role2") String role2){
		if(adminService.ListOfAdmins(role1,role2).size() > 0) {
			return new ResponseEntity<>(adminService.ListOfAdmins(role1,role2),HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("THERE IS NO ADMIN CURRENTY TO SHOW",HttpStatus.NO_CONTENT);
		}
		
	}
	
	@PostMapping("/management")
	public ResponseEntity<?> addAdmin(@RequestBody AdminCredentials admincred){
		if(admincred.getAdminName() != null && admincred.getPassword() != null && admincred.getRole() != null) {
			AdminCredentials  admincredentials =  adminService.addingAdmin(admincred);
			return new ResponseEntity<>(admincredentials,HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("SOMETHING WENT WRONG WHILE ADDING ADMIN", HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/delete/{Id}")
	public void DeleteAdmin(@PathVariable("Id") String Id){
		adminService.DeleteAdmin(Id);
		//return new ResponseEntity<String>("THE ADMIN HAS BEEN DELETED SUCESSFULLY", HttpStatus.OK);
	}
	@PutMapping("edit/{Id}")
	public ResponseEntity<?> EditingAdminDetail(@PathVariable("Id") String Id,@RequestBody AdminCredentials privilages){
		if(adminService.checkAdminPrivilages(Id)) {
			adminService.EditingAdminPrivilages(Id, privilages);
			return new ResponseEntity<>("ADMIN DETAIL EDITED SUCESSFULLY",HttpStatus.OK);
		}else{
			return new ResponseEntity<>("ERROR ACCQUIRED",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
 }
