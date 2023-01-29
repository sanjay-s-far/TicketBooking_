package com.ticketbooking.Repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;

import com.ticketbooking.Entity.BusSchedule;
import com.ticketbooking.Entity.Bus_Detail;

public interface BusScheduleRepo extends JpaRepository<BusSchedule, String> {

	@Query("select schedule from BusSchedule schedule WHERE cast(schedule.startingTime as date) = cast(:date as date) and schedule.from=:from and schedule.to=:to")
	List<BusSchedule> fetchBus( @Param("from") String from,@Param("to") String to,@Param("date") String date);

	


	@Query("select busname from BusSchedule busname where busname.busId=:busId ")
	List<BusSchedule> findByBusid(@Param("busId") String busId);
	
	
	 @Query("select count(scheduleid) from BusSchedule bsdetail")
	 String countBusNames();
	 
	 
//////	excel export
	 @Query("select timing from BusSchedule timing where cast(timing.startingTime as date) = cast(:StartDate as date) and cast(timing.reachTime as date) = cast(:ReachDate as date)")
	 List<BusSchedule> getcsvreport(@Param("StartDate") String Start,@Param("ReachDate") String Reach);
	
	 


}

