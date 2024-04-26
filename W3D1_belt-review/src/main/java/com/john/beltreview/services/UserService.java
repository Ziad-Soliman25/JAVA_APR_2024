package com.john.beltreview.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.john.beltreview.models.LoginUser;
import com.john.beltreview.models.User;
import com.john.beltreview.repos.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
    public User register(User newUser, BindingResult result) {
//     1. find user in the DB by email
    	Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());
//        2. if email is present - reject
    	if(optionalUser.isPresent()) {
//    		add an error
    		result.rejectValue("email", "unique", "email is taken");
    	}
    	
//    	check if passwords don't match
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    	    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    	}
    	
//    	at the end check if result has any erros, return
    	if (result.hasErrors()) {
    		return null;
    	}

//    	else hash and SET the pw, save the user to the DB.
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	User registeredUser = userRepo.save(newUser);
    	
    	return registeredUser;
    }
    
    
    public User login(LoginUser newLoginObject, BindingResult result) {
//        1. find user by email in the DB
    	Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
//        2. if email is not present - reject
    	if (!potentialUser.isPresent()) {
    		result.rejectValue("email", "unique", "email not registered");
    		return null;
    	}
//    	3. grab the user from potential user
    	User loggedUser = potentialUser.get();
//    	4. if BCrypt password match fails - reject
    	if(!BCrypt.checkpw(newLoginObject.getPassword(), loggedUser.getPassword())) {
    	    result.rejectValue("password", "Matches", "Invalid Password!");
    	}
    	
//    	5. if result has errors, return
    	if (result.hasErrors()) {
    		return null;
    	}
    	
//    	otherwise return the user object
    	return loggedUser;
    }
    
//    FIND ONE
	public User findUser(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}

}

