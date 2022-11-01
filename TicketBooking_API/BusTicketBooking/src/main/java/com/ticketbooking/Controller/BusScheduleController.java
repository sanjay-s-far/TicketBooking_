package com.ticketbooking.Controller;

import java.util.List;

import javax.transaction.Transactional;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ticketbooking.Entity.BusSchedule;
import com.ticketbooking.Service.BusScheduleService;
import com.ticketbooking.model.BusCardModel;

@RestController
@CrossOrigin("http://localhost:4200")
public class BusScheduleController {
  
	@Autowired
	private BusScheduleService busscheduleservice;
	
	@PostMapping("/busschedule")
	public BusSchedule scheduledetails(@RequestBody BusSchedule busschedule)
	{
		
		return busscheduleservice.scheduledetails(busschedule);
	}
	
	@PostMapping("/allschedule")
	public List<BusSchedule> savemultiple(@RequestBody List<BusSchedule> busschedule)
	{
		System.out.println(busschedule);
		return busscheduleservice.savemultiple(busschedule);
	}
	
	@GetMapping("/getbusschedule")
	
		public List<BusSchedule> getscheduledetail()
		{
			return busscheduleservice.getscheduledetail();
		}
	
	@GetMapping("/getidschedule/{id}")
	    public BusCardModel getscheduleid(@PathVariable("id") String busId)
	    {
		   return busscheduleservice.getscheduleid(busId);
	    }
	@PutMapping("/updateidschedule/{id}")
	    public BusSchedule updateschedule(@PathVariable("id") String scheduleID, @RequestBody BusSchedule busschedule)
	    {
		return busscheduleservice.updateschedule(busschedule,scheduleID);
	    }
	
	@DeleteMapping("/deleteschedule/{id}")
	   public void deleteschedule(@PathVariable("id") String scheduleID)
	   {
		busscheduleservice.deleteschedule(scheduleID);
		
	   }
	@GetMapping("/from={from}/to={to}/{date}")
	    public List<BusCardModel> fetchallbusdetail (@PathVariable("from")String from,@PathVariable("to")String to,@PathVariable("date")String date)
	    {
		return busscheduleservice.getschedulebus(from, to, date);
	    }
	
	  @PostMapping("/update/{schId}")
	     public void UpadateScheduleAvailStatus(@PathVariable("schId") String scheduleId,@RequestBody String status){
		  if(scheduleId != null & status != null) {
			  
			   busscheduleservice.updateStatus(scheduleId, status);
//			  return new ResponseEntity<String>("Updated Sucessfully",HttpStatus.OK);
		  }
	  }
	
	}

