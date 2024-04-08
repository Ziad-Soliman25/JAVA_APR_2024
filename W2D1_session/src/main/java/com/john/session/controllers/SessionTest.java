package com.john.session.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;



@Controller
public class SessionTest {
	
	@GetMapping("/")
	public String home(Model model, HttpSession session) {
//		model.addAttribute("name", "Waldo");
		
//		add something in session
		session.setAttribute("name", "Waldo");
		return "index.jsp";
	} 
	
	@GetMapping("/other")
	public String otherPage(HttpSession sesh) {
		
		if (sesh.getAttribute("name") == null) {
			return "redirect:/";
		}
		
//		grab something from session
		String somethingInSessionString = (String) sesh.getAttribute("name");
		System.out.println(somethingInSessionString);
		return "other.jsp";
	}
	
//	RENDERS THE FROM PAGE ONLY
	@GetMapping("/form")
	public String formPage() {
		return "form.jsp";
	}
	
//	PROCESS THE FROM DATA - METHOD
	@RequestMapping(value="/processForm", method=RequestMethod.POST)
	public String processFormData(
	    @RequestParam(value="email") String email,
	    @RequestParam(value="password") String password,
	    HttpSession sesh) {
		System.out.println(email + " : " + password);
		sesh.setAttribute("email", email);
		sesh.setAttribute("password", password);
	    // CODE TO PROCESS FORM ie. check email and password

//		ALWAYS REDIRECT FROM A POST
	    return "redirect:/results";
	}
	
	@GetMapping("/results")
	public String resultsPage() {
		return "results.jsp";
	}
	

}
