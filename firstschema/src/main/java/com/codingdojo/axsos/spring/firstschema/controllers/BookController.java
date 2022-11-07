package com.codingdojo.axsos.spring.firstschema.controllers;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codingdojo.axsos.spring.firstschema.models.Book;
import com.codingdojo.axsos.spring.firstschema.services.BookService;
@Controller
public class BookController {
	@Autowired
	BookService bookService;
	
	@GetMapping("/books/{id}")
	public String index(Model model,@PathVariable("id")Long id) {
		Book book = bookService.findBook(id);
		
		model.addAttribute("book",book);
		return "index.jsp";
	}

}
