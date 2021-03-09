package com.example.midterm.model;

public enum Level {
	C1(200.), C2(500.), C3(1000.);
	
	public final double positionSalary;
	
	private Level(double positionSalary) {
		this.positionSalary = positionSalary;
	}
}
