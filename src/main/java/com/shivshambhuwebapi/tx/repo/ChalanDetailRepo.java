package com.shivshambhuwebapi.tx.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivshambhuwebapi.tx.model.ChalanDetail;

public interface ChalanDetailRepo extends JpaRepository<ChalanDetail, Integer> {
	
	
	ChalanDetail save(ChalanDetail detail);
	
	
	

}
