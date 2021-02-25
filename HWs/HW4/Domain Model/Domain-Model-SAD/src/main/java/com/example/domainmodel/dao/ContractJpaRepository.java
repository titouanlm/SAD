package com.example.domainmodel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domainmodel.model.Contract;

public interface ContractJpaRepository extends JpaRepository<Contract, Integer>{

}
