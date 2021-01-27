package com.sayan.springbootrelationship.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sayan.springbootrelationship.entity.BookEntity;
import com.sayan.springbootrelationship.entity.StudentEntity;
import com.sayan.springbootrelationship.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public void addBooks(List<BookEntity> entities) {
		bookRepository.saveAll(entities);
	}
	
	public List<BookEntity> fetchAllBooks() {
		return bookRepository.findAll();
	}
	
	public List<BookEntity> fetchBooksByAuthor(String author) {
		return bookRepository.findByAuthor(author);
	}
	
	public void updateBooksByName(String bookName, String author) {
		bookRepository.updateBooksByName(bookName, author);
	}
	
	public void deleteBooksByName(String bookName) {
		bookRepository.deleteBooksByName(bookName);
	}
	
	public void deleteBooksByAuthor(String author) {
		bookRepository.deleteBooksByAuthor(author);
	}
	
	public List<StudentEntity> findAssignedStudents(String bookName, String author) {
		return bookRepository.findAssignedStudents(bookName, author);
	}
}
