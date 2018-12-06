package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.tx.model.GetQuotHeads;

public interface GetQuotHeadsRepo extends JpaRepository<GetQuotHeads, Integer> {
	
	@Query(value = " SELECT t_quot_header.quot_head_id,t_quot_header.enq_head_id,t_quot_header.quot_no,t_quot_header.quot_date,t_quot_header.status, " + 
			"t_quot_header.plant_ids AS plant_id,t_quot_header.cust_id, m_customer.cust_name,m_company.comp_name,m_plant.plant_name,t_enq_header.enq_no, m_user.usr_name " + 
			" FROM t_quot_header,m_customer,m_user,m_company,m_plant,t_enq_header " + 
			" WHERE t_quot_header.enq_head_id=t_enq_header.enq_head_id and m_customer.cust_id=t_enq_header.cust_id AND " + 
			" t_enq_header.plant_id=m_plant.plant_id AND m_company.company_id=m_plant.company_id AND t_quot_header.user_id=m_user.user_id AND " + 
			"  t_quot_header.status IN (:statusList)   ORDER BY t_quot_header.quot_head_id DESC ", nativeQuery = true)
	
	List<GetQuotHeads> getQuotHeads(@Param("statusList") List<String> statusList);

}
