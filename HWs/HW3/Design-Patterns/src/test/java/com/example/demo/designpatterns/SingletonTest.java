package com.example.demo.designpatterns;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.designpatterns.singleton1.Singleton;
import com.example.designpatterns.singleton2.SpringSingleton;

@SpringBootTest(classes = {Singleton.class, SpringSingleton.class})
public class SingletonTest {

	@Autowired
	SpringSingleton springSing1;
	
	@Autowired
	SpringSingleton springSing2;
	
	@Test
	void contextLoads() {
		Singleton sing1 = Singleton.getInstance();
		Singleton sing2 = Singleton.getInstance();
		
		Assertions.assertSame(sing1, sing2);
	
		Assertions.assertSame(springSing1, springSing2);
	}
}
