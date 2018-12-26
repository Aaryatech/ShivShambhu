package com.shivshambhuwebapi.repo.rec;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.rec.GetPayRecoveryHead;

public interface GetPayRecoveryHeadRepo extends JpaRepository<GetPayRecoveryHead, Integer> {

	@Query(value = "SELECT h.*,c.cust_name,c.cust_mob_no FROM t_pay_recovery_header h ,m_customer c WHERE h.del_status=1 AND h.status=0"
			+ " AND h.bill_date Between :fromDate AND :toDate AND c.cust_id=h.cust_id", nativeQuery = true)
	List<GetPayRecoveryHead> getPayRecBetDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = "SELECT h.*,c.cust_name,c.cust_mob_no FROM t_pay_recovery_header h ,m_customer c WHERE h.del_status=1 AND h.status=0"
			+ " AND h.pay_head_id=:payHeadId AND c.cust_id=h.cust_id", nativeQuery = true)
	GetPayRecoveryHead getPayRecByHeadId(@Param("payHeadId") int payHeadId);

	@Query(value = "SELECT h.*,c.cust_name,c.cust_mob_no FROM t_pay_recovery_header h ,m_customer c WHERE h.del_status=1 AND h.status=0"
			+ "  AND c.cust_id=h.cust_id", nativeQuery = true)
	List<GetPayRecoveryHead> getPayRecByStatus();
}
