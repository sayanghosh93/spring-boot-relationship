package com.sayan.springbootrelationship.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class LaptopEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4103299897740332027L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter @Setter private int id;
	@Getter @Setter private String manufaturer;
	@Getter @Setter private String model;
//	@OneToOne(mappedBy = "laptop")
//	private StudentEntity student;
	
	@Override
	public String toString() {
		return "LaptopEntity [id=" + id + ", manufaturer=" + manufaturer + ", model=" + model + "]";
	}
	
	
}
