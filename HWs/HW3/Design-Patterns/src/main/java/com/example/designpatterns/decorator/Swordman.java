package com.example.designpatterns.decorator;

public class Swordman extends Character {

	public Swordman() {
		lore = "Swordman";
	}
	
	@Override
	public double attack() {
		return 15.0;
	}

}
