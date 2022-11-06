package com.codingdojo.axsos.spring.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/your_server")
public class Counter {
	int count=0;
	@RequestMapping("")
	public String index(HttpSession session) {
		
			session.setAttribute("countt",count++);
		
		
		return "demo.jsp";
	}
	
	@RequestMapping("/counter")
	public String show(HttpSession session, Model model) {
		Integer currentCount=(Integer) session.getAttribute("countt");
		model.addAttribute("countToShow",currentCount);
		return "showcount.jsp";
	}

}
