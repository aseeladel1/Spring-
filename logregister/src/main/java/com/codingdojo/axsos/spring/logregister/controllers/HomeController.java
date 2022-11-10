package com.codingdojo.axsos.spring.logregister.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.axsos.spring.logregister.models.LoginUser;
import com.codingdojo.axsos.spring.logregister.models.User;
import com.codingdojo.axsos.spring.logregister.services.UserService;


@Controller
public class HomeController {
	
	@Autowired
    private UserService userService;
   
   @GetMapping("/")
   public String index(Model model, HttpSession session) {
   	
   	if (session.getAttribute("userId")!= null){
   		return "redirect:/success";
   	}
   	
       model.addAttribute("newUser", new User());
       model.addAttribute("newLogin", new LoginUser());
       return "index.jsp";
   }
   
   @PostMapping("/register")
   public String register(@Valid @ModelAttribute("newUser") User newUser, 
           BindingResult result, Model model, HttpSession session) {
       
   	User registeredUser = userService.register(newUser, result);
       
       if(result.hasErrors()) {
           
           model.addAttribute("newLogin", new LoginUser());
           return "index.jsp";
       }
       session.setAttribute("userId", registeredUser.getId());
       return "redirect:/success";
     
   }
   
   @PostMapping("/login")
   public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
           BindingResult result, Model model, HttpSession session) {
       
   	
        User user = userService.login(newLogin, result);
   
       if(result.hasErrors()) {
           model.addAttribute("newUser", new User());
           return "index.jsp";
       }
       
       session.setAttribute("userId", user.getId());
       return "redirect:/success";
   }
   
   @GetMapping ("/success")
   public String home(Model model, HttpSession session){
   	if (session.getAttribute("userId")!= null){
   		Long userId = (Long) session.getAttribute("userId");
   		User currentUser = userService.findUserById(userId);
   		model.addAttribute("currentUser", currentUser);	
   		return "success.jsp";
   	}
   	return "redirect:/";
   	  		
   }
   
   @GetMapping ("/logout")
   public String logout(HttpSession session){
   	session.invalidate();
   	return "redirect:/";		
   }
   
}