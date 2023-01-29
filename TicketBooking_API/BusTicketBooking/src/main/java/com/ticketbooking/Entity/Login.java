package com.ticketbooking.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Login {
  @Id
  
  private String userid;
  private String username;
  private String name;
  private String email;
  private String password;
  private String mobileno;
  
@Override
public String toString() {
	return "Login [userid=" + userid + ", username=" + username + ", password=" + password + ", mobileno=" + mobileno
			+ "]";
}
  
  
}
