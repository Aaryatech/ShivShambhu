package com.shivshambhuwebapi.tx.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.tx.model.MatIssueVehDetail;

public interface MatIssueVehDetailRepo extends JpaRepository<MatIssueVehDetail, Integer> {
	@Transactional
	@Modifying
	@Query("UPDATE MatIssueVehDetail SET delStatus=0  WHERE mat_veh_detail_id=:matVehDetailId")
	int deleteMatVehDetail(@Param("matVehDetailId") int matVehDetailId);

}
