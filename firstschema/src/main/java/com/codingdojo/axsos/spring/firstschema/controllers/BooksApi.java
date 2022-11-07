package com.codingdojo.axsos.spring.firstschema.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.axsos.spring.firstschema.models.Book;
import com.codingdojo.axsos.spring.firstschema.services.BookService;
@RestController
public class BooksApi {
 private final BookService bookService;
 public BooksApi(BookService bookService){
     this.bookService = bookService;
 }
 @RequestMapping("/api/books")
 public List<Book> index() {
     return bookService.allBooks();
 }
 
 @RequestMapping(value="/api/books", method=RequestMethod.POST)
 public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
     Book book = new Book(title, desc, lang, numOfPages);
     return bookService.createBook(book);
 }


  @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
  public Book update(@PathVariable("id") Long id, @RequestParam(value="title") String title,
		  			@RequestParam(value="description") String desc,
		  			@RequestParam(value="language") String lang, 
		  			@RequestParam(value="pages") Integer numOfPages) {
      Book book = bookService.findBook(id);
      book.setTitle(title);
      book.setDescription(desc);
      book.setLanguage(lang);
      book.setNumberOfPages(numOfPages);
      return bookService.updateBook(id);
      
  }
  
  @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
  public void destroy(@PathVariable("id") Long id) {
      bookService.deleteBook(id);
  }
}