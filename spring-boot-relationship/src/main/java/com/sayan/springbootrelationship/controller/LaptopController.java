package com.sayan.springbootrelationship.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sayan.springbootrelationship.entity.LaptopEntity;
import com.sayan.springbootrelationship.service.LaptopService;

@RestController
@RequestMapping("/laptop")
public class LaptopController {
	
	@Autowired
	private LaptopService laptopService;
	
	@PostMapping("/add")
	public void addLaptop(@RequestBody List<LaptopEntity> entities) {
		laptopService.addLaptops(entities);
	}
	
	@GetMapping("/getAll")
	public List<LaptopEntity> fetchLaptop() {
		return laptopService.getAllLaptops();
	}
	
	@RequestMapping(value = "/getByManufacturer{manufacturer}", method=RequestMethod.GET)
	public List<LaptopEntity> getLaptopByManufacturer(@RequestParam("manufacturer") String manufacturer) {
		return laptopService.getLaptopByManufacturer(manufacturer);
	}
	
	@RequestMapping(value = "/getByModel{model}", method = RequestMethod.GET)
	public List<LaptopEntity> getLaptopsByModel(@RequestParam("model") String model) {
		return laptopService.getLaptopsByModel(model);
	}
	
	@PutMapping("/update{id}{model}")
	public void updateLaptopModel(@RequestParam("id") int id, @RequestParam("model") String model) {
		laptopService.updateLaptopById(id, model);
	}
	
	@DeleteMapping("/delete{manufacturer}{model}")
	public void deleteLaptopByManufacturerAndModel(String manufacturer, String model) {
		laptopService.deleteLaptopByManufacturerAndModel(manufacturer, model);
	}

}
