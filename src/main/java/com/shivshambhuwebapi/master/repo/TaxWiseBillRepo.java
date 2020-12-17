package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.tx.model.TaxWiseBill;

public interface TaxWiseBillRepo extends JpaRepository<TaxWiseBill , Integer>{
	
	
	//0 0
	@Query(value = " select h.bill_head_id,h.bill_no,h.cust_id,c.cust_name,c.cust_gst_no,h.proj_id,SUM(d.qty) as qty, "
			+ " SUM(d.sgst_per) as sgst_per,SUM(d.cgst_per) as cgst_per,SUM(d.igst_per) as igst_per, "
			+ " SUM(d.sgst_amt) as sgst_amt,SUM(d.cgst_amt) as cgst_amt,SUM(d.igst_amt) as igst_amt, "
			+ " SUM(d.tax_amt) as tax_amt,SUM(d.disc_per) as disc_per,SUM(d.disc_amt) as disc_amt,"
			+ " SUM(d.taxable_amt) as taxable_amt,SUM(d.total_amt) as total_amt, h.total_amt as grand_total, h.ex_float1  from t_bill_header h, "
			+ " t_bill_detail d,m_customer c where h.bill_head_id=d.bill_head_id and c.cust_id=h.cust_id AND "
			+ " h.bill_date  BETWEEN :fromDate AND :toDate "
			+ " group by  h.bill_head_id ", nativeQuery = true)
	List<TaxWiseBill> getBillDetail(@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	
	
	//0 1
		@Query(value = " select h.bill_head_id, h.bill_no,h.cust_id,c.cust_name,c.cust_gst_no,h.proj_id,SUM(d.qty) as qty, "
				+ " SUM(d.sgst_per) as sgst_per,SUM(d.cgst_per) as cgst_per,SUM(d.igst_per) as igst_per, "
				+ " SUM(d.sgst_amt) as sgst_amt,SUM(d.cgst_amt) as cgst_amt,SUM(d.igst_amt) as igst_amt, "
				+ " SUM(d.tax_amt) as tax_amt,SUM(d.disc_per) as disc_per,SUM(d.disc_amt) as disc_amt,"
				+ " SUM(d.taxable_amt) as taxable_amt,SUM(d.total_amt) as total_amt, h.total_amt as grand_total, h.ex_float1  from t_bill_header h, "
				+ " t_bill_detail d,m_customer c where h.bill_head_id=d.bill_head_id and c.cust_id=h.cust_id AND "
				+ " h.bill_date  BETWEEN :fromDate AND :toDate AND h.cust_id IN (:custIdList ) "
				+ " group by  h.bill_head_id ", nativeQuery = true)
		List<TaxWiseBill> getBillCustDetail(@Param("custIdList") List<Integer> custIdList,@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	
	//1 0
		
		@Query(value = " select h.bill_head_id,h.bill_no,h.cust_id,c.cust_name,c.cust_gst_no,h.proj_id,SUM(d.qty) as qty, "
				+ " SUM(d.sgst_per) as sgst_per,SUM(d.cgst_per) as cgst_per,SUM(d.igst_per) as igst_per, "
				+ " SUM(d.sgst_amt) as sgst_amt,SUM(d.cgst_amt) as cgst_amt,SUM(d.igst_amt) as igst_amt, "
				+ " SUM(d.tax_amt) as tax_amt,SUM(d.disc_per) as disc_per,SUM(d.disc_amt) as disc_amt,"
				+ " SUM(d.taxable_amt) as taxable_amt,SUM(d.total_amt) as total_amt, h.total_amt as grand_total, h.ex_float1  from t_bill_header h, "
				+ " t_bill_detail d,m_customer c where h.bill_head_id=d.bill_head_id and c.cust_id=h.cust_id AND "
				+ " h.bill_date  BETWEEN :fromDate AND :toDate AND h.ex_int1=:plantId "
				+ " group by  h.bill_head_id ", nativeQuery = true)
		List<TaxWiseBill> getBillTaxBetDateAndPlantIdList(@Param("plantId") int plantId,@Param("fromDate") String fromDate,@Param("toDate") String toDate);
		
		
	//1 1
		
		@Query(value = " select h.bill_head_id,h.bill_no,h.cust_id,c.cust_name,c.cust_gst_no,h.proj_id,SUM(d.qty) as qty, "
				+ " SUM(d.sgst_per) as sgst_per,SUM(d.cgst_per) as cgst_per,SUM(d.igst_per) as igst_per, "
				+ " SUM(d.sgst_amt) as sgst_amt,SUM(d.cgst_amt) as cgst_amt,SUM(d.igst_amt) as igst_amt, "
				+ " SUM(d.tax_amt) as tax_amt,SUM(d.disc_per) as disc_per,SUM(d.disc_amt) as disc_amt,"
				+ " SUM(d.taxable_amt) as taxable_amt,SUM(d.total_amt) as total_amt, h.total_amt as grand_total, h.ex_float1 from t_bill_header h, "
				+ " t_bill_detail d,m_customer c where h.bill_head_id=d.bill_head_id and c.cust_id=h.cust_id AND "
				+ " h.bill_date  BETWEEN :fromDate AND :toDate AND h.ex_int1=:plantId  AND h.cust_id IN (:custIdList ) "
				+ " group by  h.bill_head_id ", nativeQuery = true)
		List<TaxWiseBill> getBillHeadersBetDateANdCustIdList (@Param("plantId") int plantId,@Param("custIdList") List<Integer> custIdList,@Param("fromDate") String fromDate,@Param("toDate") String toDate);
		
		
		
}
