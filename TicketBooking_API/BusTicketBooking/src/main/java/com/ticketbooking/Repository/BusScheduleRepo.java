package com.ticketbooking.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ticketbooking.Entity.BusSchedule;

public interface BusScheduleRepo extends JpaRepository<BusSchedule, String> {
// @Query("select schedule from BusSchedule schedule where schedule.from=:from and schedule.to=:to and schedule.date=:date")
// BusSchedule fetchBus( @Param("from") String from,@Param("to") String to,@Param("date") String date);
	@Query("select schedule from BusSchedule schedule WHERE cast(schedule.startingTime as date) = cast(:date as date) and schedule.from=:from and schedule.to=:to")
	List<BusSchedule> fetchBus( @Param("from") String from,@Param("to") String to,@Param("date") String date);
	
	@Query("select schedule from BusSchedule schedule where schedule.busId=:busId")
	List<BusSchedule> FetchByBusId(@Param("busId") String busId);
}
