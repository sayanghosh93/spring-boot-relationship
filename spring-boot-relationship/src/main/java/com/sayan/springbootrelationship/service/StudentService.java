package com.sayan.springbootrelationship.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sayan.springbootrelationship.entity.BookEntity;
import com.sayan.springbootrelationship.entity.LaptopEntity;
import com.sayan.springbootrelationship.entity.StudentEntity;
import com.sayan.springbootrelationship.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public void addStudents(List<StudentEntity> entities) {
		studentRepository.saveAll(entities);
	}
	
	public List<StudentEntity> getStudents() {
		return studentRepository.findAll();
	}
	
	public StudentEntity getStudentsByRoll(int roll) {
		return studentRepository.findByRoll(roll);
	}
	
//	public void updateStudent(StudentEntity studentEntity) {
//		StudentEntity entity = studentRepository.findStudentByRoll(studentEntity.getRoll());
//		studentRepository.save(entity);
//	}
//	
	public void deleteStudent(int roll) {
		StudentEntity entity = studentRepository.findByRoll(roll);
		studentRepository.delete(entity);
	}
	
	public void removeAllAssignedBooks(int roll) {
		StudentEntity entity = studentRepository.findByRoll(roll);
		entity.setBooks(new ArrayList<>());
		studentRepository.save(entity);
	}
	
	public void removeAssignedLaptop(int roll) {
		StudentEntity entity = studentRepository.findByRoll(roll);
		entity.setLaptop(new LaptopEntity());
		studentRepository.save(entity);
	}
	
	public void addNewLaptop(int roll, LaptopEntity entity) {
//		StudentEntity studentEntity = studentRepository.findByRoll(roll);
//		studentEntity.setLaptop(entity);
//		studentRepository.save(studentEntity);
		studentRepository.addNewLaptop(roll, entity);
	}
	
	public void addNewBooks(int roll, List<BookEntity> entities) {
//		StudentEntity studentEntity = studentRepository.findByRoll(roll);
//		studentEntity.setLaptop(entity);
//		studentRepository.save(studentEntity);
	}

}
