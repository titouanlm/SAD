package com.example.midterm.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.midterm.model.User;

@RepositoryRestResource(collectionResourceRel = "admins" , path="admins")
public interface AdminJPADao extends JpaRepository<User, Integer> {

}
