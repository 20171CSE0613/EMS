package com.cg.ems.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StatusReport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int statusId;
	
	
	  //@Column(nullable = false) 
	  private String comments;
	  
	  //@Column(nullable = false) 
	  private String details;
	  
	  private LocalDate createDate; 
	  private int userId; 
	  private int complianceId;
	  
	  
	  //private Department department;
	 	

}
