package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.master.model.GetItenwiseBillReport;


public interface ItemWiseBill extends JpaRepository<GetItenwiseBillReport , Integer>  {
	
	
	@Query(value = "SELECT i.item_id,i.item_code, i.item_name, sum(b.tax_amt) as tax_amt, "
			+ "sum(b.taxable_amt) as taxable_amt, sum(b.total_amt) as total_amt, sum(b.cgst_amt) as cgst_amt, "
			+ "sum(b.sgst_amt) as sgst_amt, sum(b.igst_amt) as igst_amt, sum(b.qty) as qty, sum(b.rate) as rate, "
			+ "sum(b.cgst_per) as cgst_per, sum(b.sgst_per) as sgst_per, sum(b.igst_per) as igst_per, sum(b.disc_per)"
			+ " as disc_per, sum(b.disc_amt) as disc_amt, b.del_status FROM m_item_fg i, t_bill_detail b, t_bill_header"
			+ " h where i.item_id=b.item_id"
			+ " AND h.bill_date "
			+ " BETWEEN :fromDate AND :toDate GROUP by b.item_id", nativeQuery = true)
	List<GetItenwiseBillReport> getBillDetail(@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	
	
	
	@Query(value = "SELECT i.item_id,i.item_code, i.item_name, sum(b.tax_amt) as tax_amt, "
			+ "sum(b.taxable_amt) as taxable_amt, sum(b.total_amt) as total_amt, sum(b.cgst_amt) as cgst_amt, "
			+ "sum(b.sgst_amt) as sgst_amt, sum(b.igst_amt) as igst_amt, sum(b.qty) as qty, sum(b.rate) as rate, "
			+ "sum(b.cgst_per) as cgst_per, sum(b.sgst_per) as sgst_per, sum(b.igst_per) as igst_per, sum(b.disc_per)"
			+ " as disc_per, sum(b.disc_amt) as disc_amt, b.del_status FROM m_item_fg i, t_bill_detail b, t_bill_header"
			+ " h where h.ex_int1 IN (:plantIdList ) AND h.bill_head_id=b.bill_head_id AND i.item_id=b.item_id"
			+ " AND h.bill_date "
			+ " BETWEEN :fromDate AND :toDate GROUP by b.item_id", nativeQuery = true)
	List<GetItenwiseBillReport> getBillDetailByPlantId(@Param("plantIdList") List<Integer> plantIdList,@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	
	

}
