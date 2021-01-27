package com.sayan.springbootrelationship.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sayan.springbootrelationship.entity.LaptopEntity;
import com.sayan.springbootrelationship.entity.StudentEntity;

@Transactional
@Repository
public interface LaptopRepository extends JpaRepository<LaptopEntity, Long>{
	

	List<LaptopEntity> findByModel(String model);

	List<LaptopEntity> findByManufaturer(String manufacturer);
	
	@Modifying
	@Query("update LaptopEntity laptop set laptop.model=?2 where laptop.id=?1")
	void updateLaptopById(int id, String model);
	
	@Modifying
	@Query("delete LaptopEntity laptop where laptop.manufaturer=?1 and laptop.model=?2")
	void deleteLaptopByManufacturerAndModel(String manufacturer, String model);
	
//	@Query("SELECT student from StudentEntity student, LaptopEntity laptop WHERE student.laptop = laptop.id")
//	StudentEntity findAssignedLaptop(String manufacturer, String model);
}
