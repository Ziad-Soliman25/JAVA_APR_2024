package com.john.flashmessages.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
public class FormController {
	 
	@GetMapping("/")
	public String formPage() {
		return "form.jsp";
	}
	
	@PostMapping("/getFormData")
	public String getFormDataMethod(
			@RequestParam("name") String name,
			@RequestParam("age") Integer age,
			@RequestParam("productID") Integer productId,
			HttpSession sesh,
			RedirectAttributes flash
			) {

//		these keys are GLOBALLY AVAILABLE TO ANY JSP PAGE and method!
		sesh.setAttribute("productId", productId);
		sesh.setAttribute("name", name);
		sesh.setAttribute("age", age);
		
		if (age < 18) {
//			add an error to our RedirectAttributes
			flash.addFlashAttribute("ageError", "you are not old enough");
			return "redirect:/";
		}
		
		System.out.println(name + " : " + age);
		return "redirect:/display";
	}
	
	@GetMapping("/display")
	public String displayPage() {
		return "display.jsp";
	}

}
