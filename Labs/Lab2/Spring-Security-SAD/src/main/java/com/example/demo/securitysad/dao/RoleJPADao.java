package com.example.demo.securitysad.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.securitysad.model.Role;

public interface RoleJPADao extends JpaRepository<Role, Integer> {

}
