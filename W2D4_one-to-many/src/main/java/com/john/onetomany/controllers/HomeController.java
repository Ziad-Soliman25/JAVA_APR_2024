package com.john.onetomany.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.john.onetomany.models.User;
import com.john.onetomany.services.TripService;
import com.john.onetomany.services.UserService;

import jakarta.validation.Valid;



@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	@Autowired
	private TripService tripService;
	
//	GET: /trips
	@GetMapping("/trips")
	public String displayTripDashboard() {
		return "tripDashboard.jsp";
	}
	
	
//	----- USER ROUTES ----
//	add a new user
//	GET /users/new
	@GetMapping("/users/new")
	public String renderUserCreateForm(
			@ModelAttribute("newUser") User newUser) {
		return "addUser.jsp";
	}
	
//	POST /users/new
	@PostMapping("/users/new")
	public String processUserForm(
			@Valid @ModelAttribute("newUser") User newUser, BindingResult result) {
        if (result.hasErrors()) {
            return "addUser.jsp";
        } else {
            userService.createUser(newUser);
            return "redirect:/users/new";
        }
	}
	
}













