package com.john.hellomvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.john.hellomvc.models.Trip;
import com.john.hellomvc.service.TripService;



@RestController
@RequestMapping("/api")
public class ApiController {
	
//	add the service as a dependency
	private final TripService tripService;
	
	public ApiController(TripService tripService) {
		this.tripService = tripService;
	}
	
//-----------------------	
	
//	READ ALL 
//	GET: /api/trips  ----> all trips
	@GetMapping("/trips")
	public List<Trip> getAllTrips() {
		return tripService.allTrips();
	}
	
	
//	CREATE - Process of create
//	POST: /api/trips ---> create a trip
	@PostMapping("/trips")
	public Trip addTrip(
			@RequestParam("location") String location,
			@RequestParam("tripLength") Integer tripLength,
			@RequestParam("description") String description,
			@RequestParam("owner") String owner
			) {
		
		Trip newTrip = new Trip(location, tripLength, description, owner);
		return tripService.createTrip(newTrip);
		
	}
}














