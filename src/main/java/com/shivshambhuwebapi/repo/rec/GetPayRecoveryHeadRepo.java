package com.shivshambhuwebapi.repo.rec;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.rec.GetPayRecoveryHead;

public interface GetPayRecoveryHeadRepo extends JpaRepository<GetPayRecoveryHead, Integer> {


	@Query(value = "SELECT h.*,c.cust_name,c.cust_mob_no FROM t_pay_recovery_header h ,m_customer c,t_pay_recovery_detail d,t_bill_header b WHERE h.del_status=1 AND h.status=0"
			+ " AND h.credit_date2 Between :fromDate AND :toDate AND c.cust_id=h.cust_id AND  h.bill_head_id=b.bill_head_id AND h.pay_head_id=d.pay_head_id ", nativeQuery = true)
	List<GetPayRecoveryHead> getPayRecBetDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	
	
	@Query(value = "SELECT h.*,c.cust_name,c.cust_mob_no FROM t_pay_recovery_header h ,m_customer c,t_pay_recovery_detail d,t_bill_header b WHERE h.del_status=1 AND h.status=0"
			+ " AND h.credit_date2 Between :fromDate AND :toDate AND c.cust_id=h.cust_id AND  h.bill_head_id=b.bill_head_id AND h.pay_head_id=d.pay_head_id AND  b.ex_int1=:plantId ", nativeQuery = true)
	List<GetPayRecoveryHead> getPayRecBetDatePlantId(@Param("fromDate") String fromDate, @Param("toDate") String toDate,@Param("plantId") int plantId);
	
	
	
	@Query(value = "SELECT h.*,c.cust_name,c.cust_mob_no FROM t_pay_recovery_header h ,m_customer c WHERE h.del_status=1 AND h.status=0"
			+ " AND h.pay_head_id=:payHeadId AND c.cust_id=h.cust_id", nativeQuery = true)
	GetPayRecoveryHead getPayRecByHeadId(@Param("payHeadId") int payHeadId);

	
	
	@Query(value = "SELECT h.*,c.cust_name,c.cust_mob_no FROM t_pay_recovery_header h ,m_customer c WHERE h.del_status=1 AND h.status=0"
			+ "  AND c.cust_id=h.cust_id", nativeQuery = true)
	List<GetPayRecoveryHead> getPayRecByStatus();
	
	


	@Query(value = "SELECT h.*,c.cust_name,c.cust_mob_no FROM t_pay_recovery_header h ,m_customer c,t_pay_recovery_detail d,t_bill_header b WHERE h.del_status=1 AND h.status=0"
			+ "  AND c.cust_id=h.cust_id  AND  h.bill_head_id=b.bill_head_id AND h.pay_head_id=d.pay_head_id AND  b.ex_int1=:plantId ", nativeQuery = true)
	List<GetPayRecoveryHead> getPayRecByStatusPlantId(@Param("plantId") int plantId);
	
	
	@Query(value = "SELECT h.*,c.cust_name,c.cust_mob_no FROM t_pay_recovery_header h ,m_customer c WHERE h.del_status=1 AND h.status=0"
			+ "  AND c.cust_id=h.cust_id", nativeQuery = true)
	List<GetPayRecoveryHead> getPayRecByStatusNoPlantId();
	
}
