package com.john.hellomvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.john.hellomvc.models.Trip;

@Repository // Generate queries (mongoose) - FOR ANY DATABASE
public interface TripRepository extends CrudRepository<Trip, Long> {
	
	List<Trip> findAll();
	
}
