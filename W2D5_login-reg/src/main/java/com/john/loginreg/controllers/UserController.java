package com.john.loginreg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.john.loginreg.models.LoginUser;
import com.john.loginreg.models.User;
import com.john.loginreg.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
    
     @Autowired
     private UserService userServ;
    
    @GetMapping("/")
    public String index(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "logreg.jsp";
    }
    
    @GetMapping("/dashboard") //trips
    public String renderDashboard(HttpSession session) {
//    	check if userId exists
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/logout";
    	}
    	return "dashboard.jsp";
    }
    
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        
    	User registeredUser = userServ.register(newUser, result);
        
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "logreg.jsp";
        } else {
        	session.setAttribute("userId", registeredUser.getId());
        	session.setAttribute("userName", registeredUser.getUserName());
        	return "redirect:/dashboard";
        }
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
         User user = userServ.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "logreg.jsp";
        } else {
//        	put the user id in session
        	session.setAttribute("userId", user.getId());
        	session.setAttribute("userName", user.getUserName());
        	return "redirect:/dashboard";
        }
    }
    
    @GetMapping("/logout")
    public String clearSession(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }

}
