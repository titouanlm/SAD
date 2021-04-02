package com.example.multithread.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.multithread.model.Car;

@Repository
public interface CarJPADao extends JpaRepository<Car, Long> {

}