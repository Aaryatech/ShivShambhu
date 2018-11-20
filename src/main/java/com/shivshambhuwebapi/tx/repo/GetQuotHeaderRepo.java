package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.tx.model.GetQuotHeader;

public interface GetQuotHeaderRepo extends JpaRepository<GetQuotHeader, Integer> {

	@Query(value = " SELECT\n" + 
			"        h.*,\n" + 
			"        c.cust_name ,\n" + 
			"        u.usr_name,\n" + 
			"        o.comp_name,\n" + 
			"        p.proj_name,\n" + 
			"        t.pay_term,\n" + 
			"        pl.plant_name\n" + 
			"    FROM\n" + 
			"        t_quot_header h,\n" + 
			"        m_customer c ,\n" + 
			"        m_user u,\n" + 
			"        m_company o ,\n" + 
			"        m_project p ,\n" + 
			"        m_payment_term t,\n" + 
			"        m_plant pl\n" + 
			"    WHERE\n" + 
			"        h.del_status=1 \n" + 
			"        AND h.cust_id=c.cust_id \n" + 
			"        AND u.user_id=h.user_id \n" + 
			"        AND h.company_id=o.company_id \n" + 
			"        AND p.proj_id=h.proj_id \n" + 
			"        AND t.pay_term_id=h.pay_term_id  \n" + 
			"        AND h.quot_head_id =:quotHeadId\n" + 
			"        and pl.plant_id=h.plant_ids", nativeQuery = true) 
	GetQuotHeader getQuotHeaderByQuotHeadId(@Param("quotHeadId") int quotHeadId);

	@Query(value = "SELECT h.*, c.cust_name ,u.usr_name,o.comp_name,p.proj_name,t.pay_term FROM t_quot_header h,m_customer c ,"
			+ "m_user u,m_company o ,m_project p ,m_payment_term t WHERE h.del_status=1 AND h.cust_id=c.cust_id AND "
			+ "u.user_id=h.user_id AND h.company_id=o.company_id AND p.proj_id=h.proj_id AND t.pay_term_id=h.pay_term_id "
			+ "ORDER BY h.quot_head_id DESC ", nativeQuery = true)

	List<GetQuotHeader> getQuotHeaderList();

}
