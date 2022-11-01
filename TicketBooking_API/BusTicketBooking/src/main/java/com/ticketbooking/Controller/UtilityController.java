package com.ticketbooking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticketbooking.Service.UtilityService;
import com.ticketbooking.model.ManagementDetailModel;

@RestController
@RequestMapping("/util")
@CrossOrigin("http://localhost:4200")
public class UtilityController {
	@Autowired
	private UtilityService utilService;
	
	
	@GetMapping("/counts")
	public ResponseEntity<?> MangementCounts(){
		if(utilService.managementDetail() != null) {
			return new ResponseEntity<ManagementDetailModel>(utilService.managementDetail(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Details Not found",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
