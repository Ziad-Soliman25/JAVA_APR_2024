package com.john.beltreview.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.john.beltreview.models.Trip;
import com.john.beltreview.models.User;
import com.john.beltreview.services.TripService;
import com.john.beltreview.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class TripController {
	
	@Autowired
	private TripService tripService;
	@Autowired
	private UserService userService;

//	READ ALL trips
//	GET /trips
    @GetMapping({"/dashboard", "/trips"}) //trips
    public String renderDashboard(HttpSession session, Model model) {
//    	check if userId exists
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/logout";
    	}
    	
//    	1. get all the trips
    	List<Trip> tripList = tripService.allTrips();
    	model.addAttribute("tripList", tripList);
    	
    	Long userId = (Long) session.getAttribute("userId");
    	User thisUser = userService.findUser(userId);
    	List<Trip> ownedTrips = thisUser.getOwnedTrips();
    	model.addAttribute("ownedTrips", ownedTrips);
    	
    	return "dashboard.jsp";
    }
    
//    CREATE PAGE
//    GET /trips/new
    @GetMapping("/trips/new")
	public String renderCreatePage(
			@ModelAttribute("newTrip") Trip newTrip) {
    	return "addTrip.jsp";
    }
    
//    CREATE METHOD
//    POST /trips/new
    @PostMapping("/trips/new")
	public String processCreate(
			@Valid @ModelAttribute("newTrip") Trip newTrip,
			BindingResult result){
    	if(result.hasErrors()) {
			return "addTrip.jsp";
		} else {
			tripService.createTrip(newTrip);
			return "redirect:/trips";
		}
    }
    
    
//	EDIT PAGE
//	Get /trips/3/edit
	@GetMapping("/trips/{id}/edit")
	public String renderEditPage(@PathVariable("id") Long id,
			Model model) {
		model.addAttribute("trip", tripService.findTrip(id));
		return "editTrip.jsp";
	}
	
//	EDIT METHOD
//	PUT /trips/3/edit
	@PutMapping("/trips/{id}/edit")
	public String processEditForm(
			@Valid @ModelAttribute("trip") Trip trip,
			BindingResult result) {
		if(result.hasErrors()) {
			return "editTrip.jsp";
		} else {
			tripService.updateTrip(trip);
			return "redirect:/trips";
		}
	}
	
	
//	READ ONE
//	GET /trips/3
	@GetMapping("/trips/{id}")
	public String renderTripDetailsPage(
			@PathVariable("id") Long id, Model model) {
		model.addAttribute("oneTrip", tripService.findTrip(id));
		return "tripDetails.jsp";
	}
	
	
//	DELETE
	 @DeleteMapping("/trips/{id}/delete")
	    public String destroy(@PathVariable("id") Long id) {
	        tripService.deleteTripById(id);
	        return "redirect:/trips";
	    }
    
}











