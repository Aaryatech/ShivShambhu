package com.shivshambhuwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.bill.TaxSummery;

public interface TaxSummeryRepo extends JpaRepository<TaxSummery, Integer> {

	@Query(value = "SELECT d.bill_detail_id,c.cust_gst_no,c.cust_name,(sum(d.cgst_per)+sum(d.sgst_per)) "
			+ "as gst_per,sum(d.cgst_amt) as cgst_amt,sum(d.sgst_amt) as sgst_amt,sum(d.igst_amt) as "
			+ "igst_amt,sum(d.total_amt) as total_amt,sum(d.tax_amt)as tax_amt,sum(d.taxable_amt) "
			+ "as taxable_amt from t_bill_detail d,t_bill_header h, m_customer c WHERE "
			+ "h.bill_head_id=d.bill_head_id AND h.bill_date BETWEEN :fromDate AND :toDate "
			+ "AND h.ex_int1=:plantId AND h.del_status=1 AND h.cust_id=c.cust_id"
			+ " GROUP BY (d.cgst_per+d.sgst_per)", nativeQuery = true)

	List<TaxSummery> getTaxSummeryBetDate(@Param("plantId") int plantId, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

	@Query(value = "SELECT d.bill_detail_id,c.cust_gst_no,c.cust_name,(sum(d.cgst_per)+sum(d.sgst_per)) "
			+ "as gst_per,sum(d.cgst_amt) as cgst_amt,sum(d.sgst_amt) as sgst_amt,sum(d.igst_amt) as "
			+ "igst_amt,sum(d.total_amt) as total_amt,sum(d.tax_amt)as tax_amt,sum(d.taxable_amt) "
			+ "as taxable_amt from t_bill_detail d,t_bill_header h, m_customer c WHERE "
			+ "h.bill_head_id=d.bill_head_id AND h.bill_date BETWEEN :fromDate AND :toDate "
			+ "AND h.del_status=1 AND h.cust_id=c.cust_id" + " GROUP BY (d.cgst_per+d.sgst_per)", nativeQuery = true)

	List<TaxSummery> getTaxSummeryBetDateOnly(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
