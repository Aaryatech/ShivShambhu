package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.shivshambhuwebapi.model.bill.MonthWiseBill;

public interface GetMonthwiseReportRepo  extends JpaRepository<MonthWiseBill, String>  {

	
	@Query(value = "SELECT t1.*,\r\n" + 
			" 		t2.*\r\n" + 
			" FROM\r\n" + 
			"(SELECT\r\n" + 
			"        monthname(h.bill_date) as month,\r\n" + 
			"        month(h.bill_date) as month_no,\r\n" + 
			"        year(h.bill_date) as year,\r\n" + 
			"        SUM(d.cgst_amt) as cgst_amt,\r\n" + 
			"        SUM(d.sgst_amt) as sgst_amt,\r\n" + 
			"        SUM(d.igst_amt) as igst_amt,\r\n" + 
			"        SUM(d.tax_amt) as tax_amt,\r\n" + 
			"        SUM(d.taxable_amt) as taxable_amt,\r\n" + 
			"        SUM(d.total_amt) as total_amt,\r\n" + 
			"        SUM(d.cgst_per) as cgst_per,\r\n" + 
			"        SUM(d.sgst_per) as sgst_per,\r\n" + 
			"        SUM(d.igst_per) as igst_per,\r\n" + 
			"        h.bill_no,\r\n" + 
			" 		h.bill_head_id\r\n" + 
			"    FROM\r\n" + 
			"        t_bill_header h,\r\n" + 
			"        t_bill_detail d  \r\n" + 
			"    WHERE\r\n" + 
			"        d.bill_head_id=h.bill_head_id \r\n" + 
			"        and h.bill_date  BETWEEN :fromDate AND :toDate \r\n" + 
			"        AND h.ex_int1 IN (:plantIdList) \r\n" + 
			"        AND h.cust_id IN (:custIdList)  \r\n" + 
			"        and h.del_status=1 \r\n" + 
			"        and d.del_status=1 \r\n" + 
			"    GROUP by\r\n" + 
			"        month(h.bill_date), year(h.bill_date))t1\r\n" + 
			"LEFT JOIN\r\n" + 
			"(SELECT\r\n" + 
			" 	head.bill_head_id,\r\n" + 
			" 	SUM(head.total_amt) AS grand_total,\r\n" + 
			"   SUM(head.ex_float1) AS tcs_amt\r\n" + 
			"	FROM t_bill_header head\r\n" + 
			" 	WHERE head.del_status=1\r\n" + 
			" 	AND head.bill_date  BETWEEN :fromDate AND :toDate \r\n" + 
			" 	AND head.ex_int1 IN (:plantIdList) \r\n" + 
			"   AND head.cust_id IN (:custIdList)  \r\n" + 
			" GROUP by  month(head.bill_date), year(head.bill_date)\r\n" + 
			")t2\r\n" + 
			"ON t1.bill_head_id=t2.bill_head_id", nativeQuery = true)
	List<MonthWiseBill> getBillById(@Param("fromDate") String fromDate,@Param("toDate") String toDate,@Param("plantIdList") List<Integer> plantIdList,@Param("custIdList")  List<Integer> custIdList);
//	SELECT monthname(h.bill_date) as month,month(h.bill_date) as month_no,year(h.bill_date) as year,SUM(d.cgst_amt) as cgst_amt,SUM(d.sgst_amt) "
//			+ "as sgst_amt,SUM(d.igst_amt) as igst_amt,SUM(d.tax_amt) as tax_amt,SUM(d.taxable_amt) "
//			+ "as taxable_amt,SUM(d.total_amt) as total_amt,SUM(d.cgst_per) as cgst_per,SUM(d.sgst_per) as sgst_per,"
//			+ " SUM(d.igst_per) as igst_per,h.bill_no  FROM t_bill_header h,t_bill_detail d "
//			+ " WHERE  d.bill_head_id=h.bill_head_id "
//			+ "and h.bill_date  BETWEEN :fromDate AND :toDate AND h.ex_int1 IN (:plantIdList ) "
//			+ "AND h.cust_id IN (:custIdList )  and h.del_status=1 and d.del_status=1 GROUP by month(h.bill_date) 
	/************************************************************************************************************************************/
	@Query(value = "SELECT\r\n" + 
			"    t1.*,\r\n" + 
			"    t2.*\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        MONTHNAME(h.bill_date) AS MONTH,\r\n" + 
			"        MONTH(h.bill_date) AS month_no,\r\n" + 
			"        YEAR(h.bill_date) AS YEAR,\r\n" + 
			"        SUM(d.cgst_amt) AS cgst_amt,\r\n" + 
			"        SUM(d.sgst_amt) AS sgst_amt,\r\n" + 
			"        SUM(d.igst_amt) AS igst_amt,\r\n" + 
			"        SUM(d.tax_amt) AS tax_amt,\r\n" + 
			"        SUM(d.taxable_amt) AS taxable_amt,\r\n" + 
			"        SUM(d.total_amt) AS total_amt,\r\n" + 
			"        SUM(d.cgst_per) AS cgst_per,\r\n" + 
			"        SUM(d.sgst_per) AS sgst_per,\r\n" + 
			"        SUM(d.igst_per) AS igst_per,\r\n" + 
			"        h.bill_no,\r\n" + 
			"        h.bill_head_id\r\n" + 
			"    FROM\r\n" + 
			"        t_bill_header h,\r\n" + 
			"        t_bill_detail d\r\n" + 
			"    WHERE\r\n" + 
			"        d.bill_head_id = h.bill_head_id AND h.bill_date BETWEEN :fromDate AND :toDate AND h.cust_id IN(:custIdList ) AND h.del_status = 1 AND d.del_status = 1\r\n" + 
			"    GROUP BY\r\n" + 
			"        MONTH(h.bill_date),\r\n" + 
			"        YEAR(h.bill_date)\r\n" + 
			") t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        head.bill_head_id,\r\n" + 
			"        SUM(head.total_amt) AS grand_total,\r\n" + 
			"        SUM(head.ex_float1) AS tcs_amt\r\n" + 
			"    FROM\r\n" + 
			"        t_bill_header head\r\n" + 
			"    WHERE\r\n" + 
			"        head.del_status = 1 AND head.cust_id IN(:custIdList ) AND head.bill_date BETWEEN :fromDate AND :toDate\r\n" + 
			"    GROUP BY\r\n" + 
			"        MONTH(head.bill_date),\r\n" + 
			"        YEAR(head.bill_date)\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.bill_head_id = t2.bill_head_id", nativeQuery = true)
	List<MonthWiseBill> getBillByCustId(@Param("fromDate") String fromDate,@Param("toDate") String toDate,@Param("custIdList")  List<Integer> custIdList);
//	SELECT monthname(h.bill_date) as month,month(h.bill_date) as month_no,year(h.bill_date) as year,SUM(d.cgst_amt) as cgst_amt,SUM(d.sgst_amt) "
//			+ "as sgst_amt,SUM(d.igst_amt) as igst_amt,SUM(d.tax_amt) as tax_amt,SUM(d.taxable_amt) "
//			+ "as taxable_amt,SUM(d.total_amt) as total_amt,SUM(d.cgst_per) as cgst_per,SUM(d.sgst_per) as sgst_per,"
//			+ " SUM(d.igst_per) as igst_per,h.bill_no  FROM t_bill_header h,t_bill_detail d "
//			+ " WHERE  d.bill_head_id=h.bill_head_id "
//			+ "and h.bill_date  BETWEEN :fromDate AND :toDate "
//			+ "AND h.cust_id IN (:custIdList ) and h.del_status=1 and d.del_status=1 GROUP by month(h.bill_date) 
	/**********************************************************************************************************************************/	
	
	@Query(value = "SELECT\r\n" + 
			"    t1.*,\r\n" + 
			"    t2.*\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        MONTHNAME(h.bill_date) AS MONTH,\r\n" + 
			"        MONTH(h.bill_date) AS month_no,\r\n" + 
			"        YEAR(h.bill_date) AS YEAR,\r\n" + 
			"        SUM(d.cgst_amt) AS cgst_amt,\r\n" + 
			"        SUM(d.sgst_amt) AS sgst_amt,\r\n" + 
			"        SUM(d.igst_amt) AS igst_amt,\r\n" + 
			"        SUM(d.tax_amt) AS tax_amt,\r\n" + 
			"        SUM(d.taxable_amt) AS taxable_amt,\r\n" + 
			"        SUM(d.total_amt) AS total_amt,\r\n" + 
			"        SUM(d.cgst_per) AS cgst_per,\r\n" + 
			"        SUM(d.sgst_per) AS sgst_per,\r\n" + 
			"        SUM(d.igst_per) AS igst_per,\r\n" + 
			"        h.bill_no,\r\n" + 
			"        h.bill_head_id\r\n" + 
			"    FROM\r\n" + 
			"        t_bill_header h,\r\n" + 
			"        t_bill_detail d\r\n" + 
			"    WHERE\r\n" + 
			"        d.bill_head_id = h.bill_head_id AND h.bill_date BETWEEN :fromDate AND :toDate AND h.ex_int1 IN(:plantIdList) AND h.del_status = 1 AND d.del_status = 1\r\n" + 
			"    GROUP BY\r\n" + 
			"        MONTH(h.bill_date),\r\n" + 
			"        YEAR(h.bill_date)\r\n" + 
			") t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        head.bill_head_id,\r\n" + 
			"        SUM(head.total_amt) AS grand_total,\r\n" + 
			"        SUM(head.ex_float1) AS tcs_amt\r\n" + 
			"    FROM\r\n" + 
			"        t_bill_header head\r\n" + 
			"    WHERE\r\n" + 
			"        head.del_status = 1 AND head.bill_date BETWEEN :fromDate AND :toDate AND head.ex_int1 IN(:plantIdList)\r\n" + 
			"    GROUP BY\r\n" + 
			"        MONTH(head.bill_date),\r\n" + 
			"        YEAR(head.bill_date)\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.bill_head_id = t2.bill_head_id", nativeQuery = true)
	List<MonthWiseBill> getBillByPlantId(@Param("fromDate") String fromDate,@Param("toDate") String toDate,@Param("plantIdList") List<Integer> plantIdList);
	
//	SELECT monthname(h.bill_date) as month,month(h.bill_date) as month_no,year(h.bill_date) as year,SUM(d.cgst_amt) as cgst_amt,SUM(d.sgst_amt) "
//			+ "as sgst_amt,SUM(d.igst_amt) as igst_amt,SUM(d.tax_amt) as tax_amt,SUM(d.taxable_amt) "
//			+ "as taxable_amt,SUM(d.total_amt) as total_amt,SUM(d.cgst_per) as cgst_per,SUM(d.sgst_per) as sgst_per,"
//			+ " SUM(d.igst_per) as igst_per,h.bill_no  FROM t_bill_header h,t_bill_detail d "
//			+ " WHERE  d.bill_head_id=h.bill_head_id "
//			+ "and h.bill_date  BETWEEN :fromDate AND :toDate AND h.ex_int1 IN (:plantIdList ) and h.del_status=1 and d.del_status=1 GROUP by month(h.bill_date)
	/**********************************************************************************************************************************/	
	
	
	@Query(value = "SELECT\r\n" + 
			"    t1.*,\r\n" + 
			"    t2.*\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        MONTHNAME(h.bill_date) AS MONTH,\r\n" + 
			"        MONTH(h.bill_date) AS month_no,\r\n" + 
			"        YEAR(h.bill_date) AS YEAR,\r\n" + 
			"        h.bill_head_id,\r\n" + 
			"        SUM(d.cgst_amt) AS cgst_amt,\r\n" + 
			"        SUM(d.sgst_amt) AS sgst_amt,\r\n" + 
			"        SUM(d.igst_amt) AS igst_amt,\r\n" + 
			"        SUM(d.tax_amt) AS tax_amt,\r\n" + 
			"        SUM(d.taxable_amt) AS taxable_amt,\r\n" + 
			"        SUM(d.total_amt) AS total_amt,\r\n" + 
			"        SUM(d.cgst_per) AS cgst_per,\r\n" + 
			"        SUM(d.sgst_per) AS sgst_per,\r\n" + 
			"        SUM(d.igst_per) AS igst_per,\r\n" + 
			"        h.bill_no\r\n" + 
			"    FROM\r\n" + 
			"        t_bill_header h,\r\n" + 
			"        t_bill_detail d\r\n" + 
			"    WHERE\r\n" + 
			"        d.bill_head_id = h.bill_head_id AND h.bill_date BETWEEN :fromDate AND :toDate AND h.del_status = 1 AND d.del_status = 1\r\n" + 
			"    GROUP BY\r\n" + 
			"        MONTH(h.bill_date),\r\n" + 
			"        YEAR(h.bill_date)\r\n" + 
			") t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        head.bill_head_id,\r\n" + 
			"        SUM(head.total_amt) AS grand_total,\r\n" + 
			"        SUM(head.ex_float1) AS tcs_amt\r\n" + 
			"    FROM\r\n" + 
			"        t_bill_header head\r\n" + 
			"    WHERE\r\n" + 
			"        head.del_status = 1 AND head.bill_date BETWEEN :fromDate AND :toDate\r\n" + 
			"    GROUP BY\r\n" + 
			"        MONTH(head.bill_date),\r\n" + 
			"        YEAR(head.bill_date)\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.bill_head_id = t2.bill_head_id", nativeQuery = true)
	List<MonthWiseBill> getBillBetdate(@Param("fromDate") String fromDate,@Param("toDate") String toDate);
//	SELECT monthname(h.bill_date) as month,month(h.bill_date) as month_no,year(h.bill_date) as year,SUM(d.cgst_amt) as cgst_amt,SUM(d.sgst_amt) "
//			+ "as sgst_amt,SUM(d.igst_amt) as igst_amt,SUM(d.tax_amt) as tax_amt,SUM(d.taxable_amt) "
//			+ "as taxable_amt,SUM(d.total_amt) as total_amt,SUM(d.cgst_per) as cgst_per,SUM(d.sgst_per) as sgst_per,"
//			+ " SUM(d.igst_per) as igst_per,h.bill_no  FROM t_bill_header h,t_bill_detail d "
//			+ " WHERE  d.bill_head_id=h.bill_head_id "
//			+ "and h.bill_date  BETWEEN :fromDate AND :toDate and h.del_status=1 and d.del_status=1 GROUP by month(h.bill_date) 
//	
	
}
