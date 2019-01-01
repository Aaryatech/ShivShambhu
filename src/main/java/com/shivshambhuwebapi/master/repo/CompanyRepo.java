package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.master.model.Company;

public interface CompanyRepo extends JpaRepository<Company, Integer> {

	Company findByCompanyIdAndDelStatus(int companyId, int i);

	List<Company> findByDelStatusOrderByCompanyIdDesc(int i);

	@Transactional
	@Modifying
	@Query("UPDATE Company SET delStatus=0  WHERE company_id=:companyId")
	int deleteCompany(@Param("companyId") int companyId);
	
	@Transactional
	@Modifying
	@Query("UPDATE Company SET delStatus=0  WHERE companyId IN(:companyIds)")
	int deleteMultiCompany(@Param("companyIds") List<Integer> companyIds);

	Company findByCompGstNoAndDelStatus(String compGstNo, int i);
	
	//Sachin 27 Dec 2018
	@Query(value = ""
			+ "SELECT m_company.* FROM m_company,t_quot_header WHERE "
			+ "m_company.company_id=t_quot_header.company_id AND "
			+ "t_quot_header.quot_head_id IN (:quotIdList)   ", nativeQuery = true)
	Company getCompaniesByQuotIds(@Param("quotIdList")int  quotIdList);
	
	
	//SELECT m_company.*  FROM m_company,m_plant WHERE m_plant.plant_id=67 AND m_plant.company_id=m_company.company_id AND m_company.del_status=1
	
	
	//Sachin  1 Jan 2019 web service for chalan print 
	@Query(value = ""
			+ " SELECT m_company.*  FROM m_company,m_plant WHERE m_plant.plant_id=:plantId "
			+ " AND m_plant.company_id=m_company.company_id AND m_company.del_status=1 ", nativeQuery = true)
	Company getCompanyByPlanId(@Param("plantId")int  plantId);
}
