package com.example.designpatterns;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.designpatterns.adapter.CsvAdapterImpl;
import com.example.designpatterns.adapter.CsvFormattable;
import com.example.designpatterns.adapter.CsvFormatter;
import com.example.designpatterns.adapter.LineFormattable;
import com.example.designpatterns.adapter.NewLineFormatter;
import com.example.designpatterns.decorator.Armor;
import com.example.designpatterns.decorator.Character;
import com.example.designpatterns.decorator.Swordman;
import com.example.designpatterns.decorator.Weapon;
import com.example.designpatterns.state.Swordman2;

@SpringBootApplication
public class DesignPatternsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignPatternsApplication.class, args);
		
		/*
		 * Test adapter

		String testString = "Formatting line 1. Formatting line 2. Formatting line 3.";
		LineFormattable newLineFormatter = new NewLineFormatter();
		String newString = newLineFormatter.formatText(testString);
		System.out.println(newString);
		
		CsvFormattable csvFormatter = new CsvFormatter();
		LineFormattable csvAdapter = new CsvAdapterImpl(csvFormatter);
		String newString2 = csvAdapter.formatText(testString);
		System.out.println(newString2);
		*/
		
		/*
		 * Test decorator

		Character swordman = new Swordman();
		System.out.println(swordman.getLore() + " has attack of " + swordman.attack());
		
		
		Character decoratedSwordman = new Swordman();
		decoratedSwordman = new Weapon(decoratedSwordman);
		decoratedSwordman = new Armor(decoratedSwordman);

		System.out.println(decoratedSwordman.getLore() + "has attack of " + decoratedSwordman.attack());
		*/
		
		Swordman2 sm = new Swordman2();
		sm.increaseAttack(4);
		sm.speedUp(3);
		sm.increaseDefense(1);
		sm.speedUp(2);
		
		System.out.println("Character present state : ");
		sm.printStates();
	}

}
