package com.sayan.springbootrelationship.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.sayan.springbootrelationship.entity.BookEntity;
import com.sayan.springbootrelationship.service.BookService;

@RestController
@RequestMapping(value = "/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addBooks(@RequestBody List<BookEntity> books) {
		bookService.addBooks(books);
	}
	
	@GetMapping("/getAll")
	public List<BookEntity> fetchAllBooks() {
		return bookService.fetchAllBooks();
	}
	
	@GetMapping("/get{author}")
	public List<BookEntity> fetchBooks(@RequestParam(name = "author") String author) {
		return bookService.fetchBooksByAuthor(author);
	}
	
	@RequestMapping(value = "/update{name}{author}", method = RequestMethod.PUT)
	public void updateBooksByName(@RequestParam(name = "name") String bookName, @RequestParam(name = "author") String author) {
		bookService.updateBooksByName(bookName, author);
	}
	
	@RequestMapping(value = "/deleteByName{name}", method = RequestMethod.DELETE)
	public void deleteBooksByName(@RequestParam(name = "name") String bookName) {
		bookService.deleteBooksByName(bookName);
	}
	
	@RequestMapping(value = "/deleteByAuthor{author}", method = RequestMethod.DELETE)
	public void updateBooksByName(@RequestParam(name = "author") String author) {
		bookService.deleteBooksByAuthor(author);
	}
	
	@RequestMapping(value = "/getAssignedStudents{name}{author}", method = RequestMethod.PUT)
	public void getAssignedStudents(@RequestParam(name = "name") String bookName, @RequestParam(name = "author") String author) {
		bookService.findAssignedStudents(bookName, author);
	}
	
}
