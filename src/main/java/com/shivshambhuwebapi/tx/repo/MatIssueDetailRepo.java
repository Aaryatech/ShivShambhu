package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.tx.model.MatIssueDetail;

public interface MatIssueDetailRepo extends JpaRepository<MatIssueDetail, Integer> {

	List<MatIssueDetail> findByMatHeaderIdAndDelStatus(int matHeaderId, int i);

	@Transactional
	@Modifying
	@Query("UPDATE MatIssueDetail SET delStatus=0  WHERE mat_detail_id=:matDetailId")
	int deleteMatIssueDetail(@Param("matDetailId") int matDetailId);

}
