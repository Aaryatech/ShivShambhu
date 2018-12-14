package com.shivshambhuwebapi.master.repo;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.master.model.Contractor;

public interface ContractorRepo extends JpaRepository<Contractor, Integer> {

	List<Contractor> findByDelStatusOrderByContrIdDesc(int i);

	Contractor findByContrIdAndDelStatus(int contrId, int i);

	
	@Transactional
	@Modifying
	@Query("update Contractor set del_status=0  WHERE contr_id=:contrId")
	int deleteContractor(@Param("contrId")int contrId);

	@Transactional
	@Modifying
	@Query("UPDATE Contractor  SET delStatus=0  WHERE contr_id IN(:contrIds)")
	int deleteMultiContDetail(@Param("contrIds") List<Integer> contrIds);
	
	

}
