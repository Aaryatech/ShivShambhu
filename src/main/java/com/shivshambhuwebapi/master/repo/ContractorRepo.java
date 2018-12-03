package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivshambhuwebapi.master.model.Contractor;

public interface ContractorRepo extends JpaRepository<Contractor, Integer> {

	List<Contractor> findByDelStatusOrderByContrIdDesc(int i);

}
