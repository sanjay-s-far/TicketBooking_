package com.ticketbooking.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;


import org.springframework.stereotype.Service;

import com.ticketbooking.Entity.Bus_Detail;
import com.ticketbooking.Entity.Login;
import com.ticketbooking.Repository.Bus_Detailrepository;
import com.ticketbooking.Repository.LoginRepo;

@Service
public class LoginService {

	@Autowired
	private LoginRepo loginrepo;
	private Bus_Detailrepository bus_detail;
	


	public Login saveuserdetail(Login login)
	{
		String hashpw = BCrypt.hashpw(login.getPassword(), BCrypt.gensalt());
		login.setUserid(UUID.randomUUID().toString());
		login.setPassword(hashpw);
		
		return loginrepo.save(login); 
	}

	public List<Login> getuserdetail()
	{
		return loginrepo.findAll();
	}
	
	public Boolean UserExist(String UserName) {
		if(loginrepo.FindByUserName(UserName)!= null) {
			return true;
		}else {
			return false;
		}
	}

	public Login updateuserdetail(Login login, String userid)
	{
		Login ExistingUser = loginrepo.findById(userid).get();
		ExistingUser.setUsername(login.getUsername());
		ExistingUser.setMobileno(login.getMobileno());
		return loginrepo.save(ExistingUser);
	}

	public Login GetUserById(String userid) {
		if(loginrepo.findById(userid).isPresent()) {
			return loginrepo.findById(userid).get();  
		}
		return null;
	}
	
	public Login LoginINUser(String UserName, String password) {
		Login login = loginrepo.FindByUserName(UserName);
		if(BCrypt.checkpw(password, login.getPassword())) {
			return login;
		}else {
			return null;
		}
		
	}
	
	
	public void DeleteById(String userid) {
		loginrepo.deleteById(userid);
	}

}
