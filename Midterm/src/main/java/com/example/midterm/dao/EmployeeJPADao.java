package com.example.midterm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.midterm.model.Employee;

public interface EmployeeJPADao extends JpaRepository<Employee, Integer> {

}
