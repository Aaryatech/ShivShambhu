package com.shivshambhuwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivshambhuwebapi.model.PoDetail;

public interface PoDetailRepository extends JpaRepository<PoDetail, Integer>{
	
	List<PoDetail> findByPoId(int poId);

}
