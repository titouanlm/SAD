package com.example.midterm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.midterm.model.Role;


public interface RoleJPADao extends JpaRepository<Role, Integer> {

}
