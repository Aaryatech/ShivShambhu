package com.shivshambhuwebapi.repo.rec;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.model.rec.PayRecoveryDetail;
import com.shivshambhuwebapi.model.rec.PayRecoveryHead;

public interface PayRecoveryHeadRepo extends JpaRepository<PayRecoveryHead, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE PayRecoveryHead SET delStatus=0  WHERE payHeadId IN(:payHeadIds)")
	int deleteMultiPayRecoveryHead(@Param("payHeadIds") List<Integer> payHeadIds);

}





