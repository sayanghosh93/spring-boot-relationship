package com.sayan.springbootrelationship.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sayan.springbootrelationship.entity.BookEntity;
import com.sayan.springbootrelationship.entity.StudentEntity;

@Transactional
@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long>{
	
	List<BookEntity> findByAuthor(String author);
	
	List<BookEntity> findByName(String bookName);
	
	@Modifying
	@Query("UPDATE BookEntity book set book.author=?2 WHERE book.name=?1")
	void updateBooksByName(String bookName, String author);
	
	@Modifying
	@Query("DELETE BookEntity book WHERE book.name=?1")
	void deleteBooksByName(String bookName);
	
	@Modifying
	@Query("DELETE BookEntity book WHERE book.author=?1")
	void deleteBooksByAuthor(String author);
	
	@Query("SELECT student FROM StudentEntity student, BookEntity book WHERE student.books in (SELECT books FROM BookEntity books)")
	List<StudentEntity> findAssignedStudents(String bookName, String author);
	
}
