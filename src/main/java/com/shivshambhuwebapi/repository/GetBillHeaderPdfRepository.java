package com.shivshambhuwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shivshambhuwebapi.model.bill.GetBillHeader;
import com.shivshambhuwebapi.model.bill.GetBillHeaderPdf;

@Repository
public interface GetBillHeaderPdfRepository extends JpaRepository<GetBillHeaderPdf, Integer>{


//	@Query(value="select t.*,m.comp_name,m.comp_office_add,m.comp_fact_add,m.comp_pan_no,m.comp_gst_no,"
//			+ "m.email1,m.contact_no1,m.contact_no2,c.cust_name,c.cust_gst_no,c.cust_vendor,c.cust_mob_no,"
//			+ "p.plant_name,term.pay_term from t_bill_header t,m_company m,m_customer c,m_plant p,"
//			+ "m_payment_term term where term.pay_term_id=t.payment_term_id and p.plant_id=t.ex_int1"
//			+ " and c.cust_id=t.cust_id and  m.company_id=t.company_id and t.del_status=1 and"
//			+ " t.bill_head_id IN(:billHeadIdList)",nativeQuery=true)
	@Query(value="select t.*,m.comp_name,m.comp_office_add,m.comp_fact_add,m.comp_pan_no,m.comp_gst_no,"
			+ "m.email1,m.contact_no1,m.contact_no2,c.cust_name,c.cust_gst_no,c.cust_vendor,c.cust_mob_no,"
			+ "p.plant_name,term.pay_term,pr.proj_name,pr.location, ch.chalan_no  from t_bill_header t,"
			+ "m_company m,m_customer c,m_plant p,m_payment_term term, m_project pr, t_chalan_header ch "
			+ "where term.pay_term_id=t.payment_term_id and p.plant_id=t.ex_int1  and c.cust_id=t.cust_id "
			+ "and  m.company_id=t.company_id and t.del_status=1 AND t.proj_id=pr.proj_id "
			+ "AND t.challan_id=ch.chalan_id AND t.bill_head_id IN(:billHeadIdList)"
			,nativeQuery=true)
	List<GetBillHeaderPdf> findBillsByHeaderId(@Param("billHeadIdList")List<Integer> billHeadIdList);

	
}
