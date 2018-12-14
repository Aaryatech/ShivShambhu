package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.master.model.Plant;

public interface PlantRepo extends JpaRepository<Plant, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Plant SET delStatus=0  WHERE plant_id=:plantId")
	int deletePlant(@Param("plantId") int plantId);

	List<Plant> findByDelStatusOrderByPlantIdDesc(int i);

	Plant findByPlantIdAndDelStatus(int plantId, int i);

	List<Plant> findByCompanyIdAndDelStatus(int companyId, int i);

	@Transactional
	@Modifying
	@Query("UPDATE Plant SET delStatus=0  WHERE plant_id IN(:plantIds)")
	int deleteMultiPlant(@Param("plantIds") List<Integer> plantIds);

	Plant findByPlantNameAndDelStatus(String plantName, int i);

	List<Plant> findByDelStatus(int i);

}
