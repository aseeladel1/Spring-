package com.codingdojo.axsos.spring.logregister.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.axsos.spring.logregister.models.LoginUser;
import com.codingdojo.axsos.spring.logregister.models.User;
import com.codingdojo.axsos.spring.logregister.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
	 public User findUserByEmail(String email) {
	     Optional<User> optionalDojo = userRepository.findByEmail(email);
	     if(optionalDojo.isPresent()) {
	         return optionalDojo.get();
	     } else {
	         return null;
	     }
	 }
	 public User findUserById(long id) {
	     Optional<User> optionalDojo = userRepository.findById(id);
	     if(optionalDojo.isPresent()) {
	         return optionalDojo.get();
	     } else {
	         return null;
	     }
	 }
	 public List<User> allUsers() {
	     return userRepository.findAll();
	 }
	 
	 public User register(User newUser, BindingResult result) {
	        
	    	Optional<User> potentialUser = userRepository.findByEmail(newUser.getEmail());
	    	if (potentialUser.isPresent()) {
	    		result.rejectValue("email", "Matches", "Email already exists");
	    	}
	    	
	    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
	    	    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
	    	}
	    	
	    	String toCheckPattern = newUser.getUserName();
	    	if (!toCheckPattern.matches("[a-zA-Z]+")) {
	    		 result.rejectValue("userName", "Matches", "Must contain letters only");
			}
	    	
	    	if (result.hasErrors()) {
	    		return null;
	    	}
	    	else {
	        	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
	        	newUser.setPassword(hashed);
	        	userRepository.save(newUser);
	            return newUser;
	    	} 
	    }
	    public User login(LoginUser newLogin, BindingResult result) {
	    	
	    	if (result.hasErrors()) {
	    		return null;
	    	}
	    	
	    	Optional<User> potentialUser = userRepository.findByEmail(newLogin.getEmail());
	    	if (!potentialUser.isPresent()) {
	    		result.rejectValue("email", "Matches", "Unknown email");
	    		return null;
	    	}
	    	
	    	User user = potentialUser.get();
	    	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
	    	    result.rejectValue("password", "Matches", "Invalid Password!");
	    	}
	    	
	    	if (result.hasErrors()) {
	    		return null;
	    	}else {
				return user;
			}
	    }
	    
	    
	}
    