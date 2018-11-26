package com.shivshambhuwebapi.tx.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivshambhuwebapi.tx.model.ChalanHeader;

public interface ChalanHeaderRepo extends JpaRepository<ChalanHeader, Integer> {
	
	ChalanHeader save(ChalanHeader header);

}
