package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.bill.GetDateWiseDetailBill;


public interface GetDatewiseDetailReportRepo  extends JpaRepository<GetDateWiseDetailBill , Integer>{
	
	
	@Query(value = " select h.bill_date,h.bill_no,h.cust_id,c.cust_name,c.cust_gst_no,d.sgst_per,d.cgst_per,"
			+ " d.igst_per,d.sgst_amt,d.cgst_amt,d.bill_detail_id,d.igst_amt,d.tax_amt,d.disc_per,d.disc_amt,d.taxable_amt,d.total_amt  from"
			+ " t_bill_header h,t_bill_detail d,m_customer c where h.bill_head_id=d.bill_head_id and c.cust_id=h.cust_id AND "
			+ "h.bill_date=:billDate", nativeQuery = true)
	List<GetDateWiseDetailBill> getBillByBillHeadId(@Param("billDate") String billDate);

}
