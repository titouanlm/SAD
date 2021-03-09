package com.example.midterm.model;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Transient
	private String passwordConfirm;
	
	private String email;
	
	private boolean active;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JsonBackReference 
	private Role role;
	
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Employee emp;
	
	
	public User(String username, String password, Role role, boolean active, Employee emp) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.active = active;
		this.emp = emp;
	}
}
