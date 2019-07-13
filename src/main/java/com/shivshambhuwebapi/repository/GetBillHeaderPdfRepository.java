package com.shivshambhuwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shivshambhuwebapi.model.bill.GetBillHeader;
import com.shivshambhuwebapi.model.bill.GetBillHeaderPdf;

@Repository
public interface GetBillHeaderPdfRepository extends JpaRepository<GetBillHeaderPdf, Integer> {

//	@Query(value="select t.*,m.comp_name,m.comp_office_add,m.comp_fact_add,m.comp_pan_no,m.comp_gst_no,"
//			+ "m.email1,m.contact_no1,m.contact_no2,c.cust_name,c.cust_gst_no,c.cust_vendor,c.cust_mob_no,"
//			+ "p.plant_name,term.pay_term from t_bill_header t,m_company m,m_customer c,m_plant p,"
//			+ "m_payment_term term where term.pay_term_id=t.payment_term_id and p.plant_id=t.ex_int1"
//			+ " and c.cust_id=t.cust_id and  m.company_id=t.company_id and t.del_status=1 and"
//			+ " t.bill_head_id IN(:billHeadIdList)",nativeQuery=true)
	@Query(value = "  select\n" + "        t.*,\n" + "        m.comp_name,\n" + "        m.comp_office_add,\n"
			+ "        m.comp_fact_add,\n" + "        m.comp_pan_no,\n" + "        m.comp_gst_no,\n"
			+ "        m.email1,\n" + "        m.contact_no1,\n" + "        m.contact_no2,\n"
			+ "        c.cust_name,  c.is_same_state ,\n" + "        c.cust_address,\n" + "        c.cust_gst_no,\n"
			+ "        c.cust_vendor,\n" + "        c.cust_mob_no,\n" + "        p.plant_name,\n"
			+ "        term.pay_term,\n" + "        CASE WHEN t.proj_id=-1\n"
			+ "        THEN '-' ELSE (SELECT pr.proj_name FROM m_project pr WHERE  t.proj_id=pr.proj_id) END AS proj_name,\n"
			+ "         CASE WHEN t.proj_id=-1\n"
			+ "        THEN '-' ELSE (SELECT pr.location FROM m_project pr WHERE  t.proj_id=pr.proj_id) END AS location,\n"
			+ "      \n" + "        group_concat(ch.chalan_no) as chalan_no      \n" + "    from\n"
			+ "        t_bill_header t,\n" + "        m_company m,\n" + "        m_customer c,\n"
			+ "        m_plant p,\n" + "        m_payment_term term,\n" + "       \n"
			+ "        t_chalan_header ch      \n" + "    where\n"
			+ "        term.pay_term_id=t.payment_term_id          \n" + "        and p.plant_id=t.ex_int1           \n"
			+ "        and c.cust_id=t.cust_id          \n" + "        and  m.company_id=t.company_id          \n"
			+ "        and t.del_status=1          \n" + "                     \n" + "        AND t.bill_head_id IN(\n"
			+ "        :billHeadIdList \n" + "       \n" + "        ) \n"
			+ "        AND Find_In_Set(ch.chalan_id,t.challan_id )          \n" + "    GROUP BY\n"
			+ "        t.bill_head_id              \n" + "        \n" + "    ", nativeQuery = true)
	List<GetBillHeaderPdf> findBillsByHeaderId(@Param("billHeadIdList") List<Integer> billHeadIdList);

}
