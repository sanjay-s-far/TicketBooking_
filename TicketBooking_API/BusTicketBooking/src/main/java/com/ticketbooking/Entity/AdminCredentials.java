package com.ticketbooking.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AdminCredentials {
	
	@Id()
	private String adminId;
	
	private String adminName;
	
	private String contactMail;
	
	private String password;
	
	private String role;
	
	

}
