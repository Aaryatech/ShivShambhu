package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.master.model.Company;

public interface CompanyRepo extends JpaRepository<Company, Integer> {

	Company findByCompanyIdAndIsUsed(int companyId, int i);

	List<Company> findByIsUsedOrderByCompanyIdDesc(int i);

	@Transactional
	@Modifying
	@Query("UPDATE Company SET isUsed=0  WHERE company_id=:companyId")
	int deleteCompany(@Param("companyId") int companyId);

}
