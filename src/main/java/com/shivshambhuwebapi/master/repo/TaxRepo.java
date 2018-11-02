package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivshambhuwebapi.master.model.Tax;

public interface TaxRepo extends JpaRepository<Tax, Integer>
{

	List<Tax> findByDelStatusOrderByTaxIdDesc(int i);

	

	
	

}
