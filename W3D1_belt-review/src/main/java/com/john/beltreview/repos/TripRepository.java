package com.john.beltreview.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.john.beltreview.models.Trip;

@Repository
public interface TripRepository extends CrudRepository<Trip, Long> {

	List<Trip> findAll();
	List<Trip> findByLocationContaining(String x);
}
