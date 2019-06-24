package com.shivshambhuwebapi.repo.rec;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.model.rec.PayRecoveryHead;

public interface PayRecoveryHeadRepo extends JpaRepository<PayRecoveryHead, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE PayRecoveryHead SET delStatus=0  WHERE payHeadId IN(:payHeadIds)")
	int deleteMultiPayRecoveryHead(@Param("payHeadIds") List<Integer> payHeadIds);

	@Transactional
	@Modifying
	@Query("UPDATE PayRecoveryHead SET status=1  WHERE payHeadId=:payHeadId")
	int updateStatus(@Param("payHeadId") int payHeadId);

	@Transactional
	@Modifying
	@Query("UPDATE PayRecoveryHead SET bill_date=:billDate,credit_date1=:creditDate1 ,credit_date2=:creditDate2,credit_date3=:creditDate3 WHERE billHeadId=:billHeadId")
	int updateDate(@Param("billDate") String billDate, @Param("creditDate1") String creditDate1,
			@Param("creditDate2") String creditDate2, @Param("creditDate3") String creditDate3,
			@Param("billHeadId") int billHeadId);

	PayRecoveryHead findByBillHeadIdAndDelStatus(int billHeadId, int i);

}
