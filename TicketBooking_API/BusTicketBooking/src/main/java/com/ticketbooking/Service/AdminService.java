package com.ticketbooking.Service;

import java.util.List;
import java.util.UUID;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.ticketbooking.Entity.AdminCredentials;
import com.ticketbooking.Repository.AdminRepo;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepo adminRepo;

	public AdminCredentials OnLoginOwner(String AdminName, String Adminpswd)
	{
		
		AdminCredentials admincredentials =adminRepo.FetchAdminCredentials(AdminName);
		if(admincredentials.getPassword() == null) {
			return null;
		}else {
			if(BCrypt.checkpw(Adminpswd, admincredentials.getPassword())) {
				return admincredentials;
			}
		}
		return null;

	}
	
	public List<AdminCredentials> ListOfAdmins(String role1,String role2 ){
		return adminRepo.FetchByRole(role1, role2);
	}
	
	public void DeleteAdmin(String adminId) {
		adminRepo.deleteById(adminId);
	}
	
	
	public AdminCredentials addingAdmin(AdminCredentials admincred) {
		AdminCredentials admincredentials = new AdminCredentials();
		admincredentials.setAdminId(UUID.randomUUID().toString());
		admincredentials.setAdminName(admincred.getAdminName());
		String hashMapedpassword = BCrypt.hashpw(admincred.getPassword().replace(" ", ""), BCrypt.gensalt());
		admincredentials.setPassword(hashMapedpassword);
		admincredentials.setRole(admincred.getRole());
		admincredentials.setContactMail(admincred.getContactMail());
		return adminRepo.save(admincredentials);
	}
	
	public AdminCredentials EditingAdminPrivilages(String Id, AdminCredentials Privilages) {
		AdminCredentials admincredentials = adminRepo.findById(Id).get();
		admincredentials.setAdminName(Privilages.getAdminName());
		admincredentials.setContactMail(Privilages.getContactMail());
		admincredentials.setRole(Privilages.getRole());
		return adminRepo.save(admincredentials);
	}
	

	public boolean checkAdminPrivilages(String id) {
		if(adminRepo.findById(id) != null) {
			return true;
		}
		return false;
	}
}
