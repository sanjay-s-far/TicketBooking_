package com.ticketbooking.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.ticketbooking.Entity.Admincrediential;
import com.ticketbooking.Entity.Bus_Detail;

public interface AdmincredientialRepo extends JpaRepository<Admincrediential, String>  {
  @Query("select adminname from Admincrediential adminname where adminname.adminname = :adminname and adminname.adminpassword = :password")
  List <Admincrediential> Loginadmin(@PathVariable("adminname")String adminname,@PathVariable ("password")String password);

  
  @Query("select adminname from Admincrediential adminname where adminname.adminname=:adminname" )
  Admincrediential findadminname(@PathVariable("adminname")String adminname);
}

