package com.shivshambhuwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.bill.TaxSummery;

public interface TaxSummeryRepo extends JpaRepository<TaxSummery, Integer> {

	@Query(value = "SELECT\n" + 
			"    t.bill_detail_id,\n" + 
			"    t.bill_head_id, 'NA' AS cust_gst_no, 'NA' AS cust_name,\n" + 
			"    SUM(t.gst_per) AS gst_per,\n" + 
			"    SUM(t.cgst_amt) AS cgst_amt,\n" + 
			"    SUM(t.sgst_amt) AS sgst_amt,\n" + 
			"    SUM(t.igst_amt) AS igst_amt,\n" + 
			"    SUM(t.total_amt) AS total_amt,\n" + 
			"    SUM(t.tax_amt) AS tax_amt,\n" + 
			"    SUM(t.taxable_amt) AS taxable_amt,\n" + 
			"    SUM(t.grand) AS grand_total,\n" + 
			"    SUM(t.tcs) AS tcs_amt\n" + 
			"FROM\n" + 
			"    (SELECT\n" + 
			"        d.bill_detail_id,\n" + 
			"   		 h.bill_head_id,\n" + 
			"        'NA' AS cust_gst_no,\n" + 
			"        'NA' AS cust_name,\n" + 
			"        (d.cgst_per+d.sgst_per) as gst_per,\n" + 
			"        sum(d.cgst_amt) as cgst_amt,\n" + 
			"        sum(d.sgst_amt) as sgst_amt,\n" + 
			"        sum(d.igst_amt) as igst_amt,\n" + 
			"        sum(d.total_amt) as total_amt,\n" + 
			"        sum(d.tax_amt)as tax_amt,\n" + 
			"        sum(d.taxable_amt) as taxable_amt,\n" + 
			"      	h.ex_float1 AS tcs,\n" + 
			"        h.total_amt as grand\n" + 
			"    from\n" + 
			"        t_bill_detail d,\n" + 
			"        t_bill_header h\n" + 
			"    WHERE\n" + 
			"        h.bill_head_id=d.bill_head_id \n" + 
			"        AND h.bill_date BETWEEN :fromDate AND :toDate\n" + 
			"        AND h.ex_int1=:plantId\n" + 
			"        AND h.del_status=1 \n" + 
			"    GROUP BY gst_per,\n" + 
			"        h.bill_head_id\n" + 
			"        \n" + 
			") t GROUP by gst_per", nativeQuery = true)
	List<TaxSummery> getTaxSummeryBetDate(@Param("plantId") int plantId, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate);
	
//	SELECT d.bill_detail_id,c.cust_gst_no,c.cust_name,(d.cgst_per+d.sgst_per) "
//			+ "as gst_per,sum(d.cgst_amt) as cgst_amt,sum(d.sgst_amt) as sgst_amt,sum(d.igst_amt) as "
//			+ "igst_amt,sum(d.total_amt) as total_amt,sum(d.tax_amt)as tax_amt,sum(d.taxable_amt) "
//			+ "as taxable_amt from t_bill_detail d,t_bill_header h, m_customer c WHERE "
//			+ "h.bill_head_id=d.bill_head_id AND h.bill_date BETWEEN :fromDate AND :toDate "
//			+ "AND h.ex_int1=:plantId AND h.del_status=1 AND h.cust_id=c.cust_id"
//			+ " GROUP BY gst_per
	/*******************************************************************************************************************/

	@Query(value = "SELECT\n" + 
			"    t.bill_detail_id, 'NA' AS cust_gst_no, 'NA' AS cust_name,\n" + 
			"    t.bill_head_id,\n" + 
			"    SUM(t.gst_per) AS gst_per,\n" + 
			"    SUM(t.cgst_amt) AS cgst_amt,\n" + 
			"    SUM(t.sgst_amt) AS sgst_amt,\n" + 
			"    SUM(t.igst_amt) AS igst_amt,\n" + 
			"    SUM(t.total_amt) AS total_amt,\n" + 
			"    SUM(t.tax_amt) AS tax_amt,\n" + 
			"    SUM(t.taxable_amt) AS taxable_amt,\n" + 
			"    SUM(t.grand) AS grand_total,\n" + 
			"    SUM(t.tcs) AS tcs_amt\n" + 
			"FROM\n" + 
			"    (\n" + 
			"    SELECT\n" + 
			"        d.bill_detail_id,\n" + 
			"        h.bill_head_id,\n" + 
			"        (d.cgst_per + d.sgst_per) AS gst_per,\n" + 
			"        SUM(d.cgst_amt) AS cgst_amt,\n" + 
			"        SUM(d.sgst_amt) AS sgst_amt,\n" + 
			"        SUM(d.igst_amt) AS igst_amt,\n" + 
			"        SUM(d.total_amt) AS total_amt,\n" + 
			"        SUM(d.tax_amt) AS tax_amt,\n" + 
			"        SUM(d.taxable_amt) AS taxable_amt,\n" + 
			"        h.ex_float1 AS tcs,\n" + 
			"        h.total_amt as grand\n" + 
			"    FROM\n" + 
			"        t_bill_detail d,\n" + 
			"        t_bill_header h\n" + 
			"    WHERE\n" + 
			"        h.bill_head_id = d.bill_head_id AND h.bill_date BETWEEN :fromDate AND :toDate AND h.del_status = 1\n" + 
			"    GROUP BY\n" + 
			"        gst_per,\n" + 
			"        h.bill_head_id\n" + 
			"        \n" + 
			") t  GROUP by gst_per", nativeQuery = true)
	List<TaxSummery> getTaxSummeryBetDateOnly(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
//	SELECT d.bill_detail_id,c.cust_gst_no,c.cust_name,(d.cgst_per+d.sgst_per) "
//			+ "as gst_per,sum(d.cgst_amt) as cgst_amt,sum(d.sgst_amt) as sgst_amt,sum(d.igst_amt) as "
//			+ "igst_amt,sum(d.total_amt) as total_amt,sum(d.tax_amt)as tax_amt,sum(d.taxable_amt) "
//			+ "as taxable_amt from t_bill_detail d,t_bill_header h, m_customer c WHERE "
//			+ "h.bill_head_id=d.bill_head_id AND h.bill_date BETWEEN :fromDate AND :toDate "
//			+ "AND h.del_status=1 AND h.cust_id=c.cust_id" + " GROUP BY gst_per

}
