package com.example.microservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microservices.model.Notes;

public interface NoteJPARepo extends JpaRepository<Notes, Integer> {
	
}