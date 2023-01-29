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
@NoArgsConstructor
@AllArgsConstructor
public class Admincrediential {
@Id
private String adminid;
private String adminname;
private String adminpassword;
private String rollbase;
}
