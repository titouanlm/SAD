package com.example.designpatterns.decorator;

public abstract class Character {

	protected String lore;
	
	public String getLore() {
		return lore;
	}
	
	public abstract double attack();
}
