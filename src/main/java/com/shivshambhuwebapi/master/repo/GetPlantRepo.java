package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.master.model.GetPlant;

public interface GetPlantRepo extends JpaRepository<GetPlant, Integer> {

	@Query(value = "SELECT p.*,c.comp_name FROM m_plant p,m_company c  WHERE p.del_status=1 AND p.company_id=c.company_id ORDER BY p.plant_id DESC", nativeQuery = true)
	List<GetPlant> getAllPlantList();

	@Query(value = "SELECT p.*,c.comp_name FROM m_plant p,m_company c  WHERE p.del_status=1 AND p.company_id=c.company_id AND p.plant_id=:plantId", nativeQuery = true)
	GetPlant getPlantByPlantId(@Param("plantId") int plantId);

}
