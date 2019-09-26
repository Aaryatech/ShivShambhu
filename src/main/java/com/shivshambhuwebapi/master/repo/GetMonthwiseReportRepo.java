package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.shivshambhuwebapi.model.bill.MonthWiseBill;

public interface GetMonthwiseReportRepo  extends JpaRepository<MonthWiseBill, String>  {

	
	@Query(value = "SELECT monthname(h.bill_date) as month,month(h.bill_date) as month_no,year(h.bill_date) as year,SUM(d.cgst_amt) as cgst_amt,SUM(d.sgst_amt) "
			+ "as sgst_amt,SUM(d.igst_amt) as igst_amt,SUM(d.tax_amt) as tax_amt,SUM(d.taxable_amt) "
			+ "as taxable_amt,SUM(d.total_amt) as total_amt,SUM(d.cgst_per) as cgst_per,SUM(d.sgst_per) as sgst_per,"
			+ " SUM(d.igst_per) as igst_per,h.bill_no  FROM t_bill_header h,t_bill_detail d "
			+ " WHERE  d.bill_head_id=h.bill_head_id "
			+ "and h.bill_date  BETWEEN :fromDate AND :toDate AND h.ex_int1 IN (:plantIdList ) "
			+ "AND h.cust_id IN (:custIdList )  and h.del_status=1 and d.del_status=1 GROUP by month(h.bill_date) ", nativeQuery = true)
	List<MonthWiseBill> getBillById(@Param("fromDate") String fromDate,@Param("toDate") String toDate,@Param("plantIdList") List<Integer> plantIdList,@Param("custIdList")  List<Integer> custIdList);
	
	@Query(value = "SELECT monthname(h.bill_date) as month,month(h.bill_date) as month_no,year(h.bill_date) as year,SUM(d.cgst_amt) as cgst_amt,SUM(d.sgst_amt) "
			+ "as sgst_amt,SUM(d.igst_amt) as igst_amt,SUM(d.tax_amt) as tax_amt,SUM(d.taxable_amt) "
			+ "as taxable_amt,SUM(d.total_amt) as total_amt,SUM(d.cgst_per) as cgst_per,SUM(d.sgst_per) as sgst_per,"
			+ " SUM(d.igst_per) as igst_per,h.bill_no  FROM t_bill_header h,t_bill_detail d "
			+ " WHERE  d.bill_head_id=h.bill_head_id "
			+ "and h.bill_date  BETWEEN :fromDate AND :toDate "
			+ "AND h.cust_id IN (:custIdList ) and h.del_status=1 and d.del_status=1 GROUP by month(h.bill_date) ", nativeQuery = true)
	List<MonthWiseBill> getBillByCustId(@Param("fromDate") String fromDate,@Param("toDate") String toDate,@Param("custIdList")  List<Integer> custIdList);
	
	@Query(value = "SELECT monthname(h.bill_date) as month,month(h.bill_date) as month_no,year(h.bill_date) as year,SUM(d.cgst_amt) as cgst_amt,SUM(d.sgst_amt) "
			+ "as sgst_amt,SUM(d.igst_amt) as igst_amt,SUM(d.tax_amt) as tax_amt,SUM(d.taxable_amt) "
			+ "as taxable_amt,SUM(d.total_amt) as total_amt,SUM(d.cgst_per) as cgst_per,SUM(d.sgst_per) as sgst_per,"
			+ " SUM(d.igst_per) as igst_per,h.bill_no  FROM t_bill_header h,t_bill_detail d "
			+ " WHERE  d.bill_head_id=h.bill_head_id "
			+ "and h.bill_date  BETWEEN :fromDate AND :toDate AND h.ex_int1 IN (:plantIdList ) and h.del_status=1 and d.del_status=1 GROUP by month(h.bill_date)", nativeQuery = true)
	List<MonthWiseBill> getBillByPlantId(@Param("fromDate") String fromDate,@Param("toDate") String toDate,@Param("plantIdList") List<Integer> plantIdList);
	
	@Query(value = "SELECT monthname(h.bill_date) as month,month(h.bill_date) as month_no,year(h.bill_date) as year,SUM(d.cgst_amt) as cgst_amt,SUM(d.sgst_amt) "
			+ "as sgst_amt,SUM(d.igst_amt) as igst_amt,SUM(d.tax_amt) as tax_amt,SUM(d.taxable_amt) "
			+ "as taxable_amt,SUM(d.total_amt) as total_amt,SUM(d.cgst_per) as cgst_per,SUM(d.sgst_per) as sgst_per,"
			+ " SUM(d.igst_per) as igst_per,h.bill_no  FROM t_bill_header h,t_bill_detail d "
			+ " WHERE  d.bill_head_id=h.bill_head_id "
			+ "and h.bill_date  BETWEEN :fromDate AND :toDate and h.del_status=1 and d.del_status=1 GROUP by month(h.bill_date) ", nativeQuery = true)
	List<MonthWiseBill> getBillBetdate(@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	
	
}
