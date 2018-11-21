package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.master.model.Tax;

public interface TaxRepo extends JpaRepository<Tax, Integer> {

	List<Tax> findByDelStatusOrderByTaxIdDesc(int i);

	Tax findByTaxIdAndDelStatus(int taxId, int i);

	@Transactional
	@Modifying
	@Query("UPDATE Tax SET delStatus=0  WHERE tax_id=:taxId")
	int deleteTax(@Param("taxId") int taxId);

}
