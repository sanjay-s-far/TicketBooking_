package com.ticketbooking.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.ticketbooking.Entity.AdminCredentials;

public interface AdminRepo extends JpaRepository<AdminCredentials, String> {

	@Query("select AdminCred from AdminCredentials AdminCred where AdminCred.adminName =:adminname")
	AdminCredentials FetchAdminCredentials(@PathVariable("adminname") String adminname);
	
	@Query("select AdminCred from AdminCredentials AdminCred where AdminCred.role=:role1 or AdminCred.role=:role2")
	List<AdminCredentials> FetchByRole(@PathVariable("role1") String role1,@PathVariable("role2") String role2);
}
