package com.sayan.springbootrelationship.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sayan.springbootrelationship.entity.LaptopEntity;
import com.sayan.springbootrelationship.entity.StudentEntity;
import com.sayan.springbootrelationship.repositories.LaptopRepository;

@Service
public class LaptopService {
	
	@Autowired
	private LaptopRepository laptopRepository;
	
	public void addLaptops(List<LaptopEntity> entities) {
		laptopRepository.saveAll(entities);
	}
	
	public List<LaptopEntity> getAllLaptops() {
		return laptopRepository.findAll();
	}
	
	public List<LaptopEntity> getLaptopsByModel(String model) {
		return laptopRepository.findByModel(model);
	}

	public List<LaptopEntity> getLaptopByManufacturer(String manufacturer) {
		return laptopRepository.findByManufaturer(manufacturer);
	}
	
	public void updateLaptopById(int id, String model) {
		laptopRepository.updateLaptopById(id, model);
	}
	
	public void deleteLaptopByManufacturerAndModel(String manufacturer, String model) {
		laptopRepository.deleteLaptopByManufacturerAndModel(manufacturer, model);
	}
	
//	public StudentEntity findAssignedStudent(LaptopEntity laptopEntity) {
//		return laptopRepository.findAssignedLaptop(laptopEntity.getManufaturer(), laptopEntity.getModel());
//	}
}
