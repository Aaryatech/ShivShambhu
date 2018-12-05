package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.tx.model.MatIssueHeader;

public interface MatIssueHeaderRepo extends JpaRepository<MatIssueHeader, Integer>{

	List<MatIssueHeader> findByDelStatus(int i);
	
	@Transactional
	@Modifying
	@Query("UPDATE MatIssueHeader SET delStatus=0  WHERE mat_header_id=:matHeaderId")
	int deleteMatIssueHeader(@Param("matHeaderId") int matHeaderId);
	
	
	@Transactional
	@Modifying
	@Query("UPDATE MatIssueHeader SET delStatus=0  WHERE matHeaderId IN(:matHeaderIds)")
	int deleteMultiMatIssueHeader(@Param("matHeaderIds") List<Integer> matHeaderIds);

	MatIssueHeader findByMatHeaderIdAndDelStatus(int matHeaderId, int i);

}
