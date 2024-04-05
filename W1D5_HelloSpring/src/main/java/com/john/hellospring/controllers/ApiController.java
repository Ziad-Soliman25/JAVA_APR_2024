package com.john.hellospring.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api")
public class ApiController {

	@RequestMapping("/")
	public String home() {
		return "hello ninjas"; 
	}
	
	@RequestMapping("/cool")
	public String coolRoute() {
		System.out.println("<h1>we are entering the cool route</h1>");
		return "<h1>we are entering the cool route</h1>";
	}
	
//	=== QUERY PARAMATERS ===
//	localhost:8080/search?q=you_text_here
	@RequestMapping("/search")
	public String searchSomething(@RequestParam(value="q", required=false) String someSearchVar) {
		System.out.println("what is someSearchVar? => " + someSearchVar);
		return "you searched for: " + someSearchVar;
	}
	
//	=== PATH VARIABLES ===
//	http://localhost:8080/find/{var1}
	@RequestMapping("/find/{age}/{name}")
	public String findPage(@PathVariable("name") String name, @PathVariable("age") int age) {
		if (age >= 21) {
			return "congrats " + name + " you are now over 21";
		} else {
			return "sorry " + name + " you shall not pass";
		}
		
	}
	
}
