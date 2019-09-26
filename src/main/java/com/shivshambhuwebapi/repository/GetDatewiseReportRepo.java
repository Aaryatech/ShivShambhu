package com.shivshambhuwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.bill.GetDatewiseReport;

public interface GetDatewiseReportRepo extends JpaRepository<GetDatewiseReport, Integer> {

	@Query(value = " select h.bill_head_id,h.bill_no,h.bill_date,h.cust_id,c.cust_name,SUM(d.qty) as qty,SUM(d.sgst_per) as sgst_per,"
			+ "SUM(d.cgst_per) as cgst_per,SUM(d.igst_per) as igst_per,SUM(d.sgst_amt) as sgst_amt,SUM(d.cgst_amt) as cgst_amt,"
			+ "SUM(d.igst_amt) as igst_amt,SUM(d.tax_amt) as tax_amt,SUM(d.disc_per) as disc_per,SUM(d.disc_amt) as disc_amt,"
			+ "SUM(d.taxable_amt) as taxable_amt,SUM(d.total_amt) as total_amt  from t_bill_header h,t_bill_detail d,m_customer "
			+ "c where h.bill_head_id=d.bill_head_id and c.cust_id=h.cust_id  AND h.bill_date BETWEEN :fromDate AND :toDate"
			+ "  AND h.cust_id=:custId AND h.ex_int1=:plantId and h.del_status=1 and d.del_status=1 group by  h.bill_date", nativeQuery = true)
	List<GetDatewiseReport> getBillById(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("plantId") int plantId, @Param("custId") int custId);

	@Query(value = " select h.bill_head_id,h.bill_no,h.bill_date,h.cust_id,c.cust_name,SUM(d.qty) as qty,SUM(d.sgst_per) as sgst_per,"
			+ "SUM(d.cgst_per) as cgst_per,SUM(d.igst_per) as igst_per,SUM(d.sgst_amt) as sgst_amt,SUM(d.cgst_amt) as cgst_amt,"
			+ "SUM(d.igst_amt) as igst_amt,SUM(d.tax_amt) as tax_amt,SUM(d.disc_per) as disc_per,SUM(d.disc_amt) as disc_amt,"
			+ "SUM(d.taxable_amt) as taxable_amt,SUM(d.total_amt) as total_amt  from t_bill_header h,t_bill_detail d,m_customer "
			+ "c where h.bill_head_id=d.bill_head_id and c.cust_id=h.cust_id  AND h.bill_date BETWEEN :fromDate AND :toDate"
			+ "  AND  h.ex_int1=:plantId and h.del_status=1 and d.del_status=1 group by  h.bill_date", nativeQuery = true)
	List<GetDatewiseReport> getBillBetDateAndPlantId(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("plantId") int plantId);

	@Query(value = " select h.bill_head_id,h.bill_no,h.bill_date,h.cust_id,c.cust_name,SUM(d.qty) as qty,SUM(d.sgst_per) as sgst_per,"
			+ "SUM(d.cgst_per) as cgst_per,SUM(d.igst_per) as igst_per,SUM(d.sgst_amt) as sgst_amt,SUM(d.cgst_amt) as cgst_amt,"
			+ "SUM(d.igst_amt) as igst_amt,SUM(d.tax_amt) as tax_amt,SUM(d.disc_per) as disc_per,SUM(d.disc_amt) as disc_amt,"
			+ "SUM(d.taxable_amt) as taxable_amt,SUM(d.total_amt) as total_amt  from t_bill_header h,t_bill_detail d,m_customer "
			+ "c where h.bill_head_id=d.bill_head_id and c.cust_id=h.cust_id  AND h.bill_date BETWEEN :fromDate AND :toDate"
			+ "  AND h.cust_id=:custId  and h.del_status=1 and d.del_status=1 group by  h.bill_date", nativeQuery = true)
	List<GetDatewiseReport> getBillByCustId(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("custId") int custId);

	@Query(value = " select h.bill_head_id,h.bill_no,h.bill_date,h.cust_id,c.cust_name,SUM(d.qty) as qty,SUM(d.sgst_per) as sgst_per,"
			+ "SUM(d.cgst_per) as cgst_per,SUM(d.igst_per) as igst_per,SUM(d.sgst_amt) as sgst_amt,SUM(d.cgst_amt) as cgst_amt,"
			+ "SUM(d.igst_amt) as igst_amt,SUM(d.tax_amt) as tax_amt,SUM(d.disc_per) as disc_per,SUM(d.disc_amt) as disc_amt,"
			+ "SUM(d.taxable_amt) as taxable_amt,SUM(d.total_amt) as total_amt  from t_bill_header h,t_bill_detail d,m_customer "
			+ "c where h.bill_head_id=d.bill_head_id and c.cust_id=h.cust_id  AND h.bill_date BETWEEN :fromDate AND :toDate"
			+ "   and h.del_status=1 and d.del_status=1 group by  h.bill_date", nativeQuery = true)
	List<GetDatewiseReport> getBillBetdate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	///

	/*@Query(value = " select h.bill_head_id,h.bill_no,h.bill_date,h.cust_id,c.cust_name,c.cust_gst_no,d.qty,d.sgst_per,d.cgst_per,"
			+ " d.igst_per,d.sgst_amt,d.cgst_amt,d.igst_amt,d.tax_amt,d.disc_per,d.disc_amt,d.taxable_amt,d.total_amt  from"
			+ " t_bill_header h,t_bill_detail d,m_customer c where h.bill_head_id=d.bill_head_id and c.cust_id=h.cust_id AND "
			+ "h.bill_date=:billDate", nativeQuery = true)
	List<GetDatewiseReport> getBillByBillHeadId(@Param("billDate") String billDate);*/

}
