package com.example.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import com.example.hibernate.model.Address;
import com.example.hibernate.model.AddressId;
import com.example.hibernate.model.AnnualLeave;
import com.example.hibernate.model.Benefit;
import com.example.hibernate.model.Employee;
import com.example.hibernate.model.LeaveType;
import com.example.hibernate.model.Name;
import com.example.hibernate.model.SickLeave;
import com.example.hibernate.model.User;

@SpringBootTest
class HibernateApplicationTests {

	@PersistenceContext
	private EntityManager em;
	
	@Test
	void contextLoads() {
	}
	
	@Transactional
	@Test
	public void testCache() throws InterruptedException {
		Employee employee = em.find(Employee.class, 1);
		
		assertEquals("Chaklam" ,employee.getName().getFname());
	}
	

	
	@Transactional
	@Test
	public void testFetch() {
		Employee employee = em.find(Employee.class, 2);
		
		assertEquals("John",employee.getName().getFname());
		assertEquals("Bangkok",employee.getAddresses().iterator().next().getId().getCity());
		assertEquals("Benefit Free Water",employee.getBenefits().iterator().next().getTitle());
		assertEquals("john",employee.getUser().getUsername());

	}
	

	@Transactional
	@Test
	public void testCascadePersist() {
		Employee employee = new Employee();
		Name name = new Name("Peter", "Shawn", "");
		employee.setName(name);
		employee.setAge(35);

		// add user
		User u = em.find(User.class, 3);
		employee.setUser(u);

		// add address
		Address add = new Address();
		AddressId addId = new AddressId();
		addId.setCity("Bangkok");
		addId.setHouseNo("33/9");
		addId.setStreetAddress("Fashion Island");
		addId.setZipcode("10304");
		add.setId(addId);
		add.setEmp(employee);
		List<Address> adds = new ArrayList<Address>();
		adds.add(add);
		employee.setAddresses(adds);

		// add benefits
		Set<Employee> employees = new HashSet<Employee>();
		employees.add(employee);
		Benefit benefit = new Benefit("Free Lunch", employees);
		Set<Benefit> benefits = new HashSet<Benefit>();
		benefits.add(benefit);
		employee.setBenefits(benefits);

		em.persist(employee);
		
		Employee employee2 = em.find(Employee.class, 4);
		assertEquals("Peter",employee2.getName().getFname());
		assertEquals("Bangkok",employee2.getAddresses().iterator().next().getId().getCity());
		assertEquals("Free Lunch",employee2.getBenefits().iterator().next().getTitle());
		assertEquals("peter",employee2.getUser().getUsername());
	

	}

	@Transactional
	@Test
	public void testCascadeRemove() {
		Employee employee = em.find(Employee.class, 1);
		assertEquals("Chaklam" ,employee.getName().getFname());
		em.remove(employee);
		Employee employee2 = em.find(Employee.class, 1);
		assertNull(employee2);
	}
	
}
