package com.shivshambhuwebapi.master.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.master.model.DashSaleCount;

public interface DashSaleCountRepo extends JpaRepository<DashSaleCount, Integer> {

	@Query(value = "SELECT \n"
			+ "coalesce (( SELECT COUNT(*)  FROM t_enq_header WHERE enq_status=0 AND ex_int1=1 AND plant_id=:plantId AND enq_date BETWEEN :fromDate AND :toDate),'0') AS total_enq,\n"
			+ "\n"
			+ "coalesce (( SELECT COUNT(*)  FROM t_quot_header WHERE status=0 AND del_status=1 AND plant_ids=:plantId AND quot_date BETWEEN :fromDate AND :toDate),'0') AS total_quot_pending,\n"
			+ "\n"
			+ "coalesce (( SELECT COUNT(*)  FROM t_quot_header WHERE status=1 AND del_status=1 AND plant_ids=:plantId AND quot_date BETWEEN :fromDate AND :toDate),'0') AS total_quot_generated,\n"
			+ "\n"
			+ "coalesce (( SELECT COUNT(*)  FROM t_cust_po_header WHERE status=0 AND del_status=1 AND plant_id=:plantId AND po_date BETWEEN :fromDate AND :toDate),'0') AS total_po_pending,\n"
			+ "\n"
			+ "coalesce (( SELECT SUM(total)  FROM t_order_header WHERE status=1 AND del_status=1 AND plant_id=:plantId AND order_date BETWEEN :fromDate AND :toDate),'0') AS total_order_amount,\n"
			+ "\n"
			+ "coalesce (( SELECT SUM(total_amt)  FROM t_bill_header WHERE  del_status=1 AND ex_int1=:plantId AND bill_date BETWEEN :fromDate AND :toDate),'0') AS total_bill_amount,\n"
			+ "\n"
			+ "coalesce (( SELECT SUM(tax_amt)  FROM t_bill_header WHERE  del_status=1 AND ex_int1=:plantId AND bill_date BETWEEN :fromDate AND :toDate),'0') AS total_tax_bill_amt,\n"
			+ "\n"
			+ "coalesce (( SELECT SUM(taxable_amt)  FROM t_bill_header WHERE  del_status=1 AND ex_int1=:plantId AND bill_date BETWEEN :fromDate AND :toDate),'0') AS total_taxable_bill_amt,\n"
			+ "\n" + "\n"
			+ "coalesce ((SELECT SUM(pd.paid_amt) FROM t_pay_recovery_detail as pd,t_pay_recovery_header as ph,t_bill_header bh WHERE pd.payment_date BETWEEN :fromDate AND :toDate AND pd.del_status = 1 AND pd.pay_head_id=ph.pay_head_id AND ph.bill_head_id=bh.bill_head_id AND bh.ex_int1=:plantId),'0') AS payment_rec_paid,\n"
			+ "\n"
			+ "coalesce (( SELECT SUM(ph.pending_amt) FROM t_pay_recovery_header as ph, t_bill_header as bh WHERE ph.credit_date2 BETWEEN :fromDate AND :toDate AND ph.del_status = 1 AND ph.bill_head_id=bh.bill_head_id AND bh.ex_int1=:plantId),'0') AS payment_rec_outstanding_pending\n"
			+ "", nativeQuery = true)
	DashSaleCount getDashboardCountByPlantId(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("plantId") int plantId);
	
	
	
	
	
	@Query(value = "SELECT \n"
			+ "coalesce (( SELECT COUNT(*)  FROM t_enq_header WHERE enq_status=0 AND ex_int1=1  AND enq_date BETWEEN :fromDate AND :toDate),'0') AS total_enq,\n"
			+ "\n"
			+ "coalesce (( SELECT COUNT(*)  FROM t_quot_header WHERE status=0 AND del_status=1  AND quot_date BETWEEN :fromDate AND :toDate),'0') AS total_quot_pending,\n"
			+ "\n"
			+ "coalesce (( SELECT COUNT(*)  FROM t_quot_header WHERE status=1 AND del_status=1  AND quot_date BETWEEN :fromDate AND :toDate),'0') AS total_quot_generated,\n"
			+ "\n"
			+ "coalesce (( SELECT COUNT(*)  FROM t_cust_po_header WHERE status=0 AND del_status=1  AND po_date BETWEEN :fromDate AND :toDate),'0') AS total_po_pending,\n"
			+ "\n"
			+ "coalesce (( SELECT SUM(total)  FROM t_order_header WHERE status=1 AND del_status=1 AND order_date BETWEEN :fromDate AND :toDate),'0') AS total_order_amount,\n"
			+ "\n"
			+ "coalesce (( SELECT SUM(total_amt)  FROM t_bill_header WHERE  del_status=1 AND bill_date BETWEEN :fromDate AND :toDate),'0') AS total_bill_amount,\n"
			+ "\n"
			+ "coalesce (( SELECT SUM(tax_amt)  FROM t_bill_header WHERE  del_status=1 AND bill_date BETWEEN :fromDate AND :toDate),'0') AS total_tax_bill_amt,\n"
			+ "\n"
			+ "coalesce (( SELECT SUM(taxable_amt)  FROM t_bill_header WHERE  del_status=1  AND bill_date BETWEEN :fromDate AND :toDate),'0') AS total_taxable_bill_amt,\n"
			+ "\n" + "\n"
			+ "coalesce ((SELECT SUM(pd.paid_amt) FROM t_pay_recovery_detail as pd WHERE pd.payment_date BETWEEN :fromDate AND :toDate AND pd.del_status = 1 ),'0') AS payment_rec_paid,\n"
			+ "\n"
			+ "coalesce (( SELECT SUM(ph.pending_amt) FROM t_pay_recovery_header as ph  WHERE ph.credit_date2 BETWEEN :fromDate AND :toDate AND ph.del_status = 1 ),'0') AS payment_rec_outstanding_pending\n"
			+ "", nativeQuery = true)
	DashSaleCount getDashboardCount(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
