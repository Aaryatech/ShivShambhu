package com.shivshambhuwebapi.master.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.master.model.Subplant;

public interface SubplantRepo extends JpaRepository<Subplant, Integer> {

	List<Subplant> findByDelStatusOrderBySubplantIdDesc(int i);
	
	

	@Transactional
	@Modifying
	@Query("update Subplant  set del_status=0  WHERE subplant_id=:spId")
	int deleteSubPlant(@Param("spId") int spId);

	@Transactional
	@Modifying
	@Query("UPDATE Subplant  SET delStatus=0  WHERE subplant_id IN(:spIds)")
	int deleteMultiSubPlantDetail(@Param("spIds") List<Integer> spIds);



	Subplant findBysubplantIdAndDelStatus(int spId, int i);



	
	

}
