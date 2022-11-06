package com.codingdojo.axsos.spring.omikuji;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Omikuji {
	
	@RequestMapping("/")
	public String index() {
		return "demo.jsp";
	}
	

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(
	@RequestParam(value="number") int mynumber,
	   @RequestParam(value="city") String mycity, 
	   @RequestParam(value="person") String persson, 
       @RequestParam(value="hobby") String myhobby, 
       @RequestParam(value="living") String liviing, 
       @RequestParam(value="textarea") String textarea, HttpSession session) {
		session.setAttribute("number",mynumber);
		session.setAttribute("city",mycity);	
		session.setAttribute("person",persson);
		session.setAttribute("hobby",myhobby);
		session.setAttribute("living",liviing);
		session.setAttribute("textarea",textarea);
		
       
    return "redirect:/show";

}
	
	@RequestMapping("/show")
	public String show() {
		return "show.jsp";
	}
}
