package com.shivshambhuwebapi.repo.rec;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.rec.PayRecoveryDetail;

public interface PayRecoveryDetailRepo extends JpaRepository<PayRecoveryDetail, Integer> {

	List<PayRecoveryDetail> findByPayHeadIdAndDelStatus(int payHeadId, int i);
	
	@Transactional
	@Modifying
	@Query("update PayRecoveryDetail set del_status=0  WHERE payDetailId=:payDetailId")
	int deletePayRecoveryDetail(@Param("payDetailId")int payDetailId);

}
