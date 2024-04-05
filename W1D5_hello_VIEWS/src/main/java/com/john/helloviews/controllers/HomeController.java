package com.john.helloviews.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {
	
	@GetMapping("/")
	public String indexPage(Model model) {
		model.addAttribute("name", "<h2>bob</h2><script>alert('you have been hacked')</script>");
		return "index.jsp";
	}
	
	@GetMapping("/cool")
	public String coolPage(Model model) {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Victoria");
		names.add("Austin");
		names.add("Ziad");
		names.add("Jesse");
//		System.out.println(names);
		
		model.addAttribute("names", names);
		return "cool.jsp";
	}
	

}
