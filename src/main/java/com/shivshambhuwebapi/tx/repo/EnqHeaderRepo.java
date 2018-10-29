package com.shivshambhuwebapi.tx.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivshambhuwebapi.tx.model.EnqHeader;

public interface EnqHeaderRepo extends JpaRepository<EnqHeader, Integer> {

	EnqHeader findByEnqHeadId(int enqHeadId);
	

}
