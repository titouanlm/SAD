package com.example.designpatterns.builderwithoutlombok;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User2 {
	@Id
	private int uid;
	private String name;
	private String nationality;
	private String email;
	
	public User2(int uid, String name, String nationality, String email) {
		super();
		this.uid = uid;
		this.name = name;
		this.nationality = nationality;
		this.email = email;
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", nationality=" + nationality + ", email=" + email + "]";
	}
	
	
}
