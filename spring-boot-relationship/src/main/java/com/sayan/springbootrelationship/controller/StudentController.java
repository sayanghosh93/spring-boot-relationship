package com.sayan.springbootrelationship.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sayan.springbootrelationship.entity.BookEntity;
import com.sayan.springbootrelationship.entity.LaptopEntity;
import com.sayan.springbootrelationship.entity.StudentEntity;
import com.sayan.springbootrelationship.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void add(@RequestBody List<StudentEntity> studentEntities) {
		studentService.addStudents(studentEntities);
	}
	
	@RequestMapping("/getAll")
	public List<StudentEntity> getAll() {
		return studentService.getStudents();
	}
	
	@RequestMapping("/getByRoll{roll}")
	public StudentEntity getByRoll(int roll) {
		return studentService.getStudentsByRoll(roll);
	}
	
	@RequestMapping(value = "/asignLaptop{roll}", method = RequestMethod.PUT)
	public void asignLaptop(@RequestParam("roll") int roll, @RequestBody LaptopEntity entity) {
		studentService.addNewLaptop(roll, entity);
	}
	
	@RequestMapping(value = "/asignBooks{roll}", method = RequestMethod.PUT)
	public void addNewBooks(@RequestParam("roll") int roll, @RequestBody List<BookEntity> entities) {
		studentService.addNewBooks(roll, entities);
	}
	
	@RequestMapping(value = "/deleteAsignedLaptop{roll}", method = RequestMethod.PUT)
	public void deleteAsignedLaptop(@RequestParam("roll") int roll) {
		studentService.removeAssignedLaptop(roll);
	}
	
	@RequestMapping(value = "/deleteAsignedBooks{roll}", method = RequestMethod.PUT)
	public void deleteAsignedBooks(@RequestParam("roll") int roll) {
		studentService.removeAllAssignedBooks(roll);
	}
}
