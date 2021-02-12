package com.example.designpatterns.state;

public class Swordman2 implements State{

	private int agi = 7;
	private int atk = 13;
	private int def = 5;
	
	@Override
	public void increaseDefense(int increment) {
		def+=increment;
	}

	@Override
	public void speedUp(int increment) {
		atk+= 2 * increment;
		agi+= increment;
	}

	@Override
	public void increaseAttack(int increment) {
		atk+=increment;
		def-= (int)0.3*increment;
	}

	@Override
	public void printStates() {
		System.out.println("Agi-Atk-Def : " + this.agi + "-"+ this.atk +"-" + this.def);
	}

}
