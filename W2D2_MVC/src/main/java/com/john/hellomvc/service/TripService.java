package com.john.hellomvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.john.hellomvc.models.Trip;
import com.john.hellomvc.repositories.TripRepository;


@Service
public class TripService {
	
//	add the repo as a dependency
	private final TripRepository tripRepo;
	
	public TripService(TripRepository tripRepo) {
		this.tripRepo = tripRepo;
	}
	
//	---------------------------
	
//	READ ALL
	public List<Trip> allTrips() {
		return tripRepo.findAll();
	}

//	CREATE
	public Trip createTrip(Trip newTrip) {
		return tripRepo.save(newTrip);
	}
	
//	READ ONE
	public Trip findBook(Long id) {
        Optional<Trip> optionalTrip = tripRepo.findById(id);
        if(optionalTrip.isPresent()) {
            return optionalTrip.get();
        } else {
            return null;
        }
    }
	
//	UPDATE
//	DELETE
}









