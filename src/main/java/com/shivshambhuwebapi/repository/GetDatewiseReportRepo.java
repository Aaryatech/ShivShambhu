package com.shivshambhuwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.bill.GetDatewiseReport;

public interface GetDatewiseReportRepo extends JpaRepository<GetDatewiseReport, Integer> {

	@Query(value = "  SELECT t1.*,\n" + 
			" 		t2.*\n" + 
			" FROM\n" + 
			"(select\n" + 
			"        h.bill_head_id,\n" + 
			"        h.bill_no,\n" + 
			"        h.bill_date,\n" + 
			"        h.cust_id,\n" + 
			"        c.cust_name,\n" + 
			"        SUM(d.qty) as qty,\n" + 
			"        SUM(d.sgst_per) as sgst_per,\n" + 
			"        SUM(d.cgst_per) as cgst_per,\n" + 
			"        SUM(d.igst_per) as igst_per,\n" + 
			"        SUM(d.sgst_amt) as sgst_amt,\n" + 
			"        SUM(d.cgst_amt) as cgst_amt,\n" + 
			"        SUM(d.igst_amt) as igst_amt,\n" + 
			"        SUM(d.tax_amt) as tax_amt,\n" + 
			"        SUM(d.disc_per) as disc_per,\n" + 
			"        SUM(d.disc_amt) as disc_amt,\n" + 
			"        SUM(d.taxable_amt) as taxable_amt,\n" + 
			"        SUM(d.total_amt) as total_amt  \n" + 
			"    from\n" + 
			"        t_bill_header h,\n" + 
			"        t_bill_detail d,\n" + 
			"        m_customer c \n" + 
			"    where\n" + 
			"        h.bill_head_id=d.bill_head_id \n" + 
			"        and c.cust_id=h.cust_id  \n" + 
			"        AND h.bill_date BETWEEN :fromDate AND :toDate \n" + 
			"        AND h.cust_id=:custId\n" + 
			"        AND h.ex_int1=:plantId \n" + 
			"        and h.del_status=1 \n" + 
			"        and d.del_status=1 \n" + 
			"    group by\n" + 
			"        h.bill_date)t1\n" + 
			"        LEFT JOIN\n" + 
			"        (SELECT\n" + 
			" 	head.bill_head_id,\n" + 
			" 	SUM(head.total_amt) AS grand_total,\n" + 
			"   SUM(head.ex_float1) AS tcs_amt\n" + 
			"	FROM t_bill_header head\n" + 
			" 	WHERE head.del_status=1\n" + 
			" 	AND head.bill_date  BETWEEN :fromDate AND :toDate \n" + 
			"     AND head.cust_id=:custId\n" + 
			"     AND head.ex_int1=:plantId\n" + 
			" GROUP by head.bill_date\n" + 
			")t2\n" + 
			"ON t1.bill_head_id=t2.bill_head_id", nativeQuery = true)
	List<GetDatewiseReport> getBillById(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("plantId") int plantId, @Param("custId") int custId);
//	select h.bill_head_id,h.bill_no,h.bill_date,h.cust_id,c.cust_name,SUM(d.qty) as qty,SUM(d.sgst_per) as sgst_per,"
//			+ "SUM(d.cgst_per) as cgst_per,SUM(d.igst_per) as igst_per,SUM(d.sgst_amt) as sgst_amt,SUM(d.cgst_amt) as cgst_amt,"
//			+ "SUM(d.igst_amt) as igst_amt,SUM(d.tax_amt) as tax_amt,SUM(d.disc_per) as disc_per,SUM(d.disc_amt) as disc_amt,"
//			+ "SUM(d.taxable_amt) as taxable_amt,SUM(d.total_amt) as total_amt  from t_bill_header h,t_bill_detail d,m_customer "
//			+ "c where h.bill_head_id=d.bill_head_id and c.cust_id=h.cust_id  AND h.bill_date BETWEEN :fromDate AND :toDate"
//			+ "  AND h.cust_id=:custId AND h.ex_int1=:plantId and h.del_status=1 and d.del_status=1 group by  h.bill_date
	/**************************************************************************************************************************/

	@Query(value = "  SELECT t1.*,\n" + 
			" 		t2.*\n" + 
			" FROM\n" + 
			"(select\n" + 
			"        h.bill_head_id,\n" + 
			"        h.bill_no,\n" + 
			"        h.bill_date,\n" + 
			"        h.cust_id,\n" + 
			"        c.cust_name,\n" + 
			"        SUM(d.qty) as qty,\n" + 
			"        SUM(d.sgst_per) as sgst_per,\n" + 
			"        SUM(d.cgst_per) as cgst_per,\n" + 
			"        SUM(d.igst_per) as igst_per,\n" + 
			"        SUM(d.sgst_amt) as sgst_amt,\n" + 
			"        SUM(d.cgst_amt) as cgst_amt,\n" + 
			"        SUM(d.igst_amt) as igst_amt,\n" + 
			"        SUM(d.tax_amt) as tax_amt,\n" + 
			"        SUM(d.disc_per) as disc_per,\n" + 
			"        SUM(d.disc_amt) as disc_amt,\n" + 
			"        SUM(d.taxable_amt) as taxable_amt,\n" + 
			"        SUM(d.total_amt) as total_amt  \n" + 
			"    from\n" + 
			"        t_bill_header h,\n" + 
			"        t_bill_detail d,\n" + 
			"        m_customer c \n" + 
			"    where\n" + 
			"        h.bill_head_id=d.bill_head_id \n" + 
			"        and c.cust_id=h.cust_id  \n" + 
			"        AND h.bill_date BETWEEN :fromDate AND :toDate \n" + 
			"        AND h.ex_int1=:plantId \n" + 
			"        and h.del_status=1 \n" + 
			"        and d.del_status=1 \n" + 
			"    group by\n" + 
			"        h.bill_date)t1\n" + 
			"        LEFT JOIN\n" + 
			"        (SELECT\n" + 
			" 	head.bill_head_id,\n" + 
			" 	SUM(head.total_amt) AS grand_total,\n" + 
			"   SUM(head.ex_float1) AS tcs_amt\n" + 
			"	FROM t_bill_header head\n" + 
			" 	WHERE head.del_status=1\n" + 
			" 	AND head.bill_date  BETWEEN :fromDate AND :toDate \n" + 
			"    AND head.ex_int1=:plantId \n" + 
			" GROUP by head.bill_date\n" + 
			")t2\n" + 
			"ON t1.bill_head_id=t2.bill_head_id", nativeQuery = true)
	List<GetDatewiseReport> getBillBetDateAndPlantId(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("plantId") int plantId);
//	select h.bill_head_id,h.bill_no,h.bill_date,h.cust_id,c.cust_name,SUM(d.qty) as qty,SUM(d.sgst_per) as sgst_per,"
//			+ "SUM(d.cgst_per) as cgst_per,SUM(d.igst_per) as igst_per,SUM(d.sgst_amt) as sgst_amt,SUM(d.cgst_amt) as cgst_amt,"
//			+ "SUM(d.igst_amt) as igst_amt,SUM(d.tax_amt) as tax_amt,SUM(d.disc_per) as disc_per,SUM(d.disc_amt) as disc_amt,"
//			+ "SUM(d.taxable_amt) as taxable_amt,SUM(d.total_amt) as total_amt  from t_bill_header h,t_bill_detail d,m_customer "
//			+ "c where h.bill_head_id=d.bill_head_id and c.cust_id=h.cust_id  AND h.bill_date BETWEEN :fromDate AND :toDate"
//			+ "  AND  h.ex_int1=:plantId and h.del_status=1 and d.del_status=1 group by  h.bill_date
	/*********************************************************************************************************************/

	@Query(value = "SELECT\n" + 
			"        t1.*,\n" + 
			"        t2.*  \n" + 
			"    FROM\n" + 
			"        (select\n" + 
			"        h.bill_head_id,\n" + 
			"        h.bill_no,\n" + 
			"        h.bill_date,\n" + 
			"        h.cust_id,\n" + 
			"        c.cust_name,\n" + 
			"        SUM(d.qty) as qty,\n" + 
			"        SUM(d.sgst_per) as sgst_per,\n" + 
			"        SUM(d.cgst_per) as cgst_per,\n" + 
			"        SUM(d.igst_per) as igst_per,\n" + 
			"        SUM(d.sgst_amt) as sgst_amt,\n" + 
			"        SUM(d.cgst_amt) as cgst_amt,\n" + 
			"        SUM(d.igst_amt) as igst_amt,\n" + 
			"        SUM(d.tax_amt) as tax_amt,\n" + 
			"        SUM(d.disc_per) as disc_per,\n" + 
			"        SUM(d.disc_amt) as disc_amt,\n" + 
			"        SUM(d.taxable_amt) as taxable_amt,\n" + 
			"        SUM(d.total_amt) as total_amt  \n" + 
			"    from\n" + 
			"        t_bill_header h,\n" + 
			"        t_bill_detail d,\n" + 
			"        m_customer c \n" + 
			"    where\n" + 
			"        h.bill_head_id=d.bill_head_id \n" + 
			"        and c.cust_id=h.cust_id  \n" + 
			"        AND h.bill_date BETWEEN :fromDate AND :toDate   \n" + 
			"        AND h.cust_id=:custId\n" + 
			"        and h.del_status=1 \n" + 
			"        and d.del_status=1 \n" + 
			"    group by\n" + 
			"        h.bill_date)t1         \n" + 
			"    LEFT JOIN\n" + 
			"        (\n" + 
			"            SELECT\n" + 
			"                head.bill_head_id,\n" + 
			"                SUM(head.total_amt) AS grand_total,\n" + 
			"                SUM(head.ex_float1) AS tcs_amt  \n" + 
			"            FROM\n" + 
			"                t_bill_header head   \n" + 
			"            WHERE\n" + 
			"                head.del_status=1   \n" + 
			"                AND head.bill_date  BETWEEN :fromDate AND :toDate      \n" + 
			"                AND head.cust_id=:custId  \n" + 
			"            GROUP by\n" + 
			"                head.bill_date \n" + 
			"        )t2 \n" + 
			"            ON t1.bill_head_id=t2.bill_head_id", nativeQuery = true)
	List<GetDatewiseReport> getBillByCustId(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("custId") int custId);
	
//	select h.bill_head_id,h.bill_no,h.bill_date,h.cust_id,c.cust_name,SUM(d.qty) as qty,SUM(d.sgst_per) as sgst_per,"
//			+ "SUM(d.cgst_per) as cgst_per,SUM(d.igst_per) as igst_per,SUM(d.sgst_amt) as sgst_amt,SUM(d.cgst_amt) as cgst_amt,"
//			+ "SUM(d.igst_amt) as igst_amt,SUM(d.tax_amt) as tax_amt,SUM(d.disc_per) as disc_per,SUM(d.disc_amt) as disc_amt,"
//			+ "SUM(d.taxable_amt) as taxable_amt,SUM(d.total_amt) as total_amt  from t_bill_header h,t_bill_detail d,m_customer "
//			+ "c where h.bill_head_id=d.bill_head_id and c.cust_id=h.cust_id  AND h.bill_date BETWEEN :fromDate AND :toDate"
//			+ "  AND h.cust_id=:custId  and h.del_status=1 and d.del_status=1 group by  h.bill_date
	/*************************************************************************************************************************/

	@Query(value = " SELECT t1.*,\n" + 
			" 		t2.*\n" + 
			" FROM\n" + 
			"(select\n" + 
			"        h.bill_head_id,\n" + 
			"        h.bill_no,\n" + 
			"        h.bill_date,\n" + 
			"        h.cust_id,\n" + 
			"        c.cust_name,\n" + 
			"        SUM(d.qty) as qty,\n" + 
			"        SUM(d.sgst_per) as sgst_per,\n" + 
			"        SUM(d.cgst_per) as cgst_per,\n" + 
			"        SUM(d.igst_per) as igst_per,\n" + 
			"        SUM(d.sgst_amt) as sgst_amt,\n" + 
			"        SUM(d.cgst_amt) as cgst_amt,\n" + 
			"        SUM(d.igst_amt) as igst_amt,\n" + 
			"        SUM(d.tax_amt) as tax_amt,\n" + 
			"        SUM(d.disc_per) as disc_per,\n" + 
			"        SUM(d.disc_amt) as disc_amt,\n" + 
			"        SUM(d.taxable_amt) as taxable_amt,\n" + 
			"        SUM(d.total_amt) as total_amt\n" + 
			"    from\n" + 
			"        t_bill_header h,\n" + 
			"        t_bill_detail d,\n" + 
			"        m_customer c \n" + 
			"    where\n" + 
			"        h.bill_head_id=d.bill_head_id \n" + 
			"        and c.cust_id=h.cust_id  \n" + 
			"        AND h.bill_date BETWEEN :fromDate AND :toDate \n" + 
			"        and h.del_status=1 \n" + 
			"        and d.del_status=1 \n" + 
			"    group by\n" + 
			"        h.bill_date)t1\n" + 
			"        LEFT JOIN\n" + 
			"        (SELECT\n" + 
			" 	head.bill_head_id,\n" + 
			" 	SUM(head.total_amt) AS grand_total,\n" + 
			"   SUM(head.ex_float1) AS tcs_amt\n" + 
			"	FROM t_bill_header head\n" + 
			" 	WHERE head.del_status=1\n" + 
			" 	AND head.bill_date  BETWEEN :fromDate AND :toDate \n" + 
			" GROUP by head.bill_date\n" + 
			")t2\n" + 
			"ON t1.bill_head_id=t2.bill_head_id", nativeQuery = true)
	List<GetDatewiseReport> getBillBetdate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

//	select h.bill_head_id,h.bill_no,h.bill_date,h.cust_id,c.cust_name,SUM(d.qty) as qty,SUM(d.sgst_per) as sgst_per,"
//			+ "SUM(d.cgst_per) as cgst_per,SUM(d.igst_per) as igst_per,SUM(d.sgst_amt) as sgst_amt,SUM(d.cgst_amt) as cgst_amt,"
//			+ "SUM(d.igst_amt) as igst_amt,SUM(d.tax_amt) as tax_amt,SUM(d.disc_per) as disc_per,SUM(d.disc_amt) as disc_amt,"
//			+ "SUM(d.taxable_amt) as taxable_amt,SUM(d.total_amt) as total_amt  from t_bill_header h,t_bill_detail d,m_customer "
//			+ "c where h.bill_head_id=d.bill_head_id and c.cust_id=h.cust_id  AND h.bill_date BETWEEN :fromDate AND :toDate"
//			+ "   and h.del_status=1 and d.del_status=1 group by  h.bill_date
	/************************************************************************************************************************/
	
	
	///

	/*@Query(value = " select h.bill_head_id,h.bill_no,h.bill_date,h.cust_id,c.cust_name,c.cust_gst_no,d.qty,d.sgst_per,d.cgst_per,"
			+ " d.igst_per,d.sgst_amt,d.cgst_amt,d.igst_amt,d.tax_amt,d.disc_per,d.disc_amt,d.taxable_amt,d.total_amt  from"
			+ " t_bill_header h,t_bill_detail d,m_customer c where h.bill_head_id=d.bill_head_id and c.cust_id=h.cust_id AND "
			+ "h.bill_date=:billDate", nativeQuery = true)
	List<GetDatewiseReport> getBillByBillHeadId(@Param("billDate") String billDate);*/

}
