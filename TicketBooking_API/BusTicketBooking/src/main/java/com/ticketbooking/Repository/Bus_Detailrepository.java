package com.ticketbooking.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.ticketbooking.Entity.Bus_Detail;
import com.ticketbooking.Entity.Login;


public interface Bus_Detailrepository extends JpaRepository<Bus_Detail, String> {

	@Query("select detail.coverage from Bus_Detail detail")
	List <String> listofcoverage();
	@Query("select busname from Bus_Detail busname where busname.busName=:BusName ")
	Bus_Detail findbus_name(@PathVariable("busname") String BusName);
	
	
}
