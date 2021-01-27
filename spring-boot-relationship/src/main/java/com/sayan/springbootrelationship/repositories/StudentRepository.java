package com.sayan.springbootrelationship.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sayan.springbootrelationship.entity.BookEntity;
import com.sayan.springbootrelationship.entity.LaptopEntity;
import com.sayan.springbootrelationship.entity.StudentEntity;

@Transactional
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long>{
	
	StudentEntity findByRoll(int roll);
	
	@Modifying
	@Query("update StudentEntity student set student.laptop=?2 where student.roll=?1")
	void addNewLaptop(int roll, LaptopEntity entity);

	@Modifying
	@Query("update StudentEntity student set student.books=?2 where student.roll=?1")
	void addNewBooks(int roll, List<BookEntity> entity);
	
}
