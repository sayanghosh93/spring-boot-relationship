package com.sayan.springbootrelationship.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BookEntity implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3689109291995278914L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String author;
//	@ManyToMany(mappedBy = "books")
//	private List<StudentEntity> students = new ArrayList<>();
	
	
	@Override
	public String toString() {
		return "BookEntity [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	
	

}
