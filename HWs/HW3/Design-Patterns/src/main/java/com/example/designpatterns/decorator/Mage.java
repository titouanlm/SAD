package com.example.designpatterns.decorator;

public class Mage extends Character {

	public Mage() {
		lore = "Magician";
	}
	
	@Override
	public double attack() {
		return 12.5;
	}

}
