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
import com.ticketbooking.Entity.Bus_Detail;
import com.ticketbooking.Service.Bus_Detailservice;
import com.ticketbooking.model.BusModel;
import com.ticketbooking.model.busDetailScheduleMode;
import com.ticketbooking.model.countDataModel;

@CrossOrigin("http://localhost:4500")
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
     //////////////////////owner based login
     
     @GetMapping("/ownerlogin")
     public ResponseEntity<?> ownerlogin(@PathParam("BusName")String BusName,@PathParam("busNo")String busNo)
     {
    	 if(bus_detailservice.busdetail(BusName, busNo)!=null)
    	 {
    		 return new ResponseEntity<>( bus_detailservice.busdetail(BusName, busNo),HttpStatus.OK);
         }else {
         	return new ResponseEntity<>("USER DOES NOT EXIST, TRY REGISTERING",HttpStatus.INTERNAL_SERVER_ERROR);
         }
         
    	 }
     
     //////////////////////////////////
     
     @GetMapping("/details/{busId}")
     public busDetailScheduleMode findUsingBusName(@PathVariable("busId") String busId){
        return bus_detailservice.bdetailSchedule(busId);
     }
     
     @GetMapping("/buscount")
     public countDataModel buscountcntr()
     {
    	 return bus_detailservice.buscounts();
     }
    ////////////////////////////////////////////
}

