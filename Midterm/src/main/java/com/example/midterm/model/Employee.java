package com.example.midterm.model;

import java.math.BigDecimal;



import java.time.LocalDate;
import java.util.Set;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.MonetaryAmountFactory;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Employee {

	@Id
	private int id;
	
	private String name;
	
	private String level;
		
	private LocalDate birthday ;
	
	private double baseSalary; // I didn't succeed in using Monetary
	
	@OneToMany( mappedBy = "employee")
	private Set<Address> adresses;
	
	
	
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "user_id", referencedColumnName = "id") 
	@JsonIgnore
	@MapsId
	private User user;
	
	
	public double calculateSalary() {
		double salary = 0.;
		switch(level) {
		  case "C1":
			  salary = Level.C1.positionSalary +baseSalary;
			 break;
		  case "C2":
			  salary = Level.C2.positionSalary +baseSalary;
		     break;
		  default:
			  salary = Level.C3.positionSalary +baseSalary;
		}
		return salary;

	}

}


