package com.example.designpatterns.factory.model;

public interface Role {
	void setName(String name);
	String getName();
	String getRole();
	void checkAccess();
}
