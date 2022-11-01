package com.ticketbooking.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ticketbooking.Entity.Bus_Detail;
import com.ticketbooking.Service.Bus_Detailservice;
import com.ticketbooking.model.BusDetailWithSchedules;
import com.ticketbooking.model.BusModel;
@CrossOrigin("http://localhost:4200")
@RestController
public class Bus_Detailcontroller {
	@Autowired
	private Bus_Detailservice bus_detailservice;
	
	
     @PostMapping("/entry/busdetail")
     public Bus_Detail busdetail(@RequestBody Bus_Detail bus_detail)
     {
    	
    	 return  bus_detailservice.busdetail(bus_detail);
     }
//	@CrossOrigin("http://localhost:4200")
     @GetMapping("/getall/getbusdetail")
     public List<Bus_Detail> getallbusdetail()
     {
    	 return bus_detailservice.getallbusdetail();
     }
     
     @GetMapping("/busdetail/{id}")
     public BusModel getbyiddetail(@PathVariable("id") String bus_id)
     {
    	 return bus_detailservice.getbyiddetail(bus_id);
     }
     
       
     @PutMapping("/updatedetail/{id}")
     public String updatebusdetail(@PathVariable("id") String bus_id, @RequestBody  Bus_Detail busdetail)
     {
    	 bus_detailservice.updatebusdetail( busdetail,bus_id);
    	 return "update success";
     }
     
     @DeleteMapping("/deletedetail/{id}")
     public String deletebusdetail(@PathVariable("id") String bus_id)
     {
    	 bus_detailservice.deletebusdetail(bus_id);
    	 return "delete success";
     }
     
     @GetMapping("/getcoverage")
     public List<String> listOfCoveragectrl()
     {
    	 return bus_detailservice.listOfCoverage();
     }
     
     @GetMapping("/details/{busId}")
     public BusDetailWithSchedules listOfDetailWithSchedules(@PathVariable("busId") String BusId){
    	 return bus_detailservice.BusDetailWithschedules(BusId);
     }
   
}

