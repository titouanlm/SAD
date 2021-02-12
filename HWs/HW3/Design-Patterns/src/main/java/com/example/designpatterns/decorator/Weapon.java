package com.example.designpatterns.decorator;

public class Weapon extends CharacterDecorator{
	
	private Character character;
	
	public Weapon(Character character) {
		this.character = character;
	}
	
	@Override
	public String getLore() {
		return character.getLore() + ", with weapon ";
	}

	@Override
	public double attack() {
		return 10 + character.attack();
	}
}
