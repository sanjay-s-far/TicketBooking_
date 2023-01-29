package com.ticketbooking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.ticketbooking.Entity.Login;

public interface LoginRepo extends JpaRepository<Login, String> {
	
	@Query("select usrName from Login usrName where usrName.username = :userName")
	Login FindByUserName(@PathVariable("userName") String userName);
	
	@Query("select usrName from Login usrName where usrName.username = :userName and usrName.password=:password")
	Login FindByUserNameAndPassword(@PathVariable("userName") String userName, @PathVariable("password") String password);
    
	@Query("select count(username) from Login usernme")
	String countUserName();
}
