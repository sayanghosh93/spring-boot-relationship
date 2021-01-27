package com.sayan.springbootrelationship.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class StudentEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -641395284154850767L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@Getter
	@Setter
	private int roll;
	@OneToOne
	private LaptopEntity laptop;
	@ManyToMany
	private List<BookEntity> books = new ArrayList<>();
	
	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + ", roll=" + roll + "]";
	}
}
