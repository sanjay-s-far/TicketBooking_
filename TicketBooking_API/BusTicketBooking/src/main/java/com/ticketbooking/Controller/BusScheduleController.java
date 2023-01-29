package com.ticketbooking.Controller;

import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.websocket.server.PathParam;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.ticketbooking.Entity.BusSchedule;
import com.ticketbooking.Entity.Bus_Detail;
import com.ticketbooking.Service.BusScheduleService;
import com.ticketbooking.model.BusCardModel;
import com.ticketbooking.model.randomModel;


@CrossOrigin("http://localhost:4500")
@RestController
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
	
	
	
	///random
	@PostMapping("/randomdata")
	
		public BusSchedule randomdatacnrt(@RequestBody BusSchedule randaomdata)
		{
			return busscheduleservice.randomdata(randaomdata);
		}
		
		
		
	//////csv
//	@GetMapping("/csvexport")
//	public ResponseEntity<BusSchedule> csvExportCntrl(Writer writer,HttpServletResponse response )throws IOException
//	{
//		response.setContentType("text/csv");
//		DateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
//		 
//		String currentTime=dateformat.format(new Date());
//		String headerkey="content-Disposition";
//		String headervalue="attachement; filename=\"schedule.csv\"" + currentTime + ".csv";
//	     response.setHeader(headerkey, headervalue);
//	     List<BusSchedule> listUsers = busscheduleservice.csvExport();
//	     ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
//	        String[] csvHeader = {"busName", "from", "to", "startingTime", "reachTime"};
//	       
//	        String[] nameMapping = {"busName", "from", "to", "startingTime", "reachTime"};
//	        csvWriter.writeHeader(csvHeader);
//	        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
//	        for(BusSchedule csvContent:listUsers)
//	        {
//	        	csvWriter.write(csvContent,nameMapping);
//	        }
//	        csvWriter.close();
//	        
//			return new ResponseEntity(busscheduleservice.csvExport(), HttpStatus.OK);
//	}
//		

@GetMapping("/excelexport/StartDate={StartDate}/ReachDate={ReachDate}")
public List<BusSchedule>excelExportScheduleCntrl(@PathVariable("StartDate") String StartDate,@PathVariable("ReachDate") String ReachDate)
{
	return busscheduleservice.excelExportSchedule(StartDate, ReachDate);
}
}


	

