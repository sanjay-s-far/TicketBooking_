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

import com.ticketbooking.Service.LoginService;
import com.ticketbooking.Entity.Login;

@RestController
public class LoginCtrlr {
	
    @Autowired
    private LoginService loginservice;
    
    @CrossOrigin("http://localhost:4200")
    @PostMapping("/login")
    public Login Login(@RequestBody Login login) {
    	if(loginservice.UserExist(login.getUsername())) {
    		return null;
    	}else {
        	return  loginservice.saveuserdetail(login);
    	}
    	
    }
    
    @GetMapping("/getuser")
    public List<Login> UserDetail() {
    	return loginservice.getuserdetail();	 
    }
    
    @CrossOrigin("http://localhost:4200")
    @GetMapping("/signup")
    public ResponseEntity<?> signup(@PathParam("username") String username,@PathParam("password") String password ) {
    	if(loginservice.LoginINUser(username, password)!= null) {
    	return new ResponseEntity<>( loginservice.LoginINUser(username, password),HttpStatus.OK);
    }else{
    	return new ResponseEntity<>("USER DOES NOT EXIST, TRY REGISTERING",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }
    
    @PutMapping("/update/{userId}")
    public String UpdateUser(@RequestBody Login login,@PathVariable("userId") String userId) {
    	loginservice.updateuserdetail(login, userId);
    	return "Updated Sucessfully";
    }
    
    @GetMapping("/user/{userId}")
    public Login GetUserById(@PathVariable("userId") String userId) {
    	return loginservice.GetUserById(userId);
    }
	
    @DeleteMapping("/user/{userId}")
    public String DeleteUserById(@PathVariable("userId") String userId) {
    	loginservice.DeleteById(userId);
    	return "Deleted Successfully";
    }
}
