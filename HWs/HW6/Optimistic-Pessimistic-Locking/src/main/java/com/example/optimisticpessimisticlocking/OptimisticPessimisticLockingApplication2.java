package com.example.optimisticpessimisticlocking;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.optimisticpessimisticlocking.service.ProductService;

@SpringBootApplication
public class OptimisticPessimisticLockingApplication2 {

	public static void main(String[] args) throws IOException, InterruptedException {
		ConfigurableApplicationContext applicationContext = 
				SpringApplication.run(OptimisticPessimisticLockingApplication2.class, args);
		ProductService ps = applicationContext.getBean(ProductService.class);
		
		ps.createMockProduct();
		ps.writeLockTransaction();
		ps.readLockTransaction();
   
	}
}
