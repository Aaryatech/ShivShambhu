package com.shivshambhuwebapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.model.bill.BillHeader;
@Repository
public interface BillHeaderRepository extends JpaRepository<BillHeader, Integer>{

	BillHeader findByBillHeadIdAndDelStatus(int billHeadId, int i);
	
	@Transactional
	@Modifying
	@Query("UPDATE BillHeader SET  delStatus=0 WHERE bill_head_id=:billHeadId")
	int deleteBill(@Param("billHeadId") int billHeadId);

}
