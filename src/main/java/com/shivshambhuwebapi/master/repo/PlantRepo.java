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
	
	
	@Transactional
	@Modifying
	@Query("UPDATE Plant SET exInt1=:enqCount  WHERE plantId =:plantId")
	int updateDocSrNo(@Param("plantId") int plantId, @Param("enqCount") int enqCount);
	
	
	@Transactional
	@Modifying
	@Query("UPDATE Plant SET exInt2=:quotCount  WHERE plantId =:plantId")
	int updateQuotCount(@Param("plantId") int plantId, @Param("quotCount") int quotCount);

	
	
	@Transactional
	@Modifying
	@Query("UPDATE Plant SET exInt3=:ordCount  WHERE plantId =:plantId")
	int updateOrdCount(@Param("plantId") int plantId, @Param("ordCount") int ordCount);
	

	@Transactional
	@Modifying
	@Query("UPDATE Plant SET exVar1=:chCount  WHERE plantId =:plantId")
	int updateChalanCount(@Param("plantId") int plantId, @Param("chCount") String chCount);
	
	@Transactional
	@Modifying
	@Query("UPDATE Plant SET exVar2=:billCount  WHERE plantId =:plantId")
	int updateBillGstCount(@Param("plantId") int plantId, @Param("billCount") String billCount);
	
	
	@Transactional
	@Modifying
	@Query("UPDATE Plant SET exVar3=:billCount  WHERE plantId =:plantId")
	int updateBillNonGstCount(@Param("plantId") int plantId, @Param("billCount") String billCount);

	
}
