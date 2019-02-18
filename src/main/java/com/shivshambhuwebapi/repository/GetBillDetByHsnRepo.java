package com.shivshambhuwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.bill.GetBillDetByHsn;

public interface GetBillDetByHsnRepo extends JpaRepository<GetBillDetByHsn, Integer> {

	@Query(value = "SELECT d.hsn_code,SUM(d.cgst_per) AS cgst_per,SUM(d.sgst_per) AS sgst_per ,SUM(cgst_amt) "
			+ "as cgst_amt,SUM(sgst_amt) as sgst_amt,SUM(igst_amt) as igst_amt, SUM(igst_per) as igst_per,"
			+ "SUM(d.taxable_amt) AS taxable_amt,SUM(d.tax_amt) AS tax_amt ,SUM(d.total_amt) AS total_amt ,"
			+ "SUM(d.disc_per) AS disc_per ,SUM(d.disc_amt) AS disc_amt FROM t_bill_detail d WHERE "
			+ "d.del_status=1 AND d.bill_head_id IN(:billHeadIds)   GROUP BY d.hsn_code", nativeQuery = true)
	List<GetBillDetByHsn> getBillDetailsById(@Param("billHeadIds") List<Integer> billHeadIds);

}
