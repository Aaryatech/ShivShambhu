package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.tx.model.MatIssueVehHeader;

public interface MatIssueVehHeaderRepo extends JpaRepository<MatIssueVehHeader, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE MatIssueVehHeader SET delStatus=0  WHERE mat_veh_header_id=:matVehHeaderId")
	int deleteMatVehHeader(@Param("matVehHeaderId") int matVehHeaderId);

	@Transactional
	@Modifying
	@Query("UPDATE MatIssueVehHeader SET delStatus=0  WHERE matVehHeaderId IN(:matVehHeaderIds)")
	int deleteMultiMatVehHeader(@Param("matVehHeaderIds") List<Integer> matVehHeaderIds);

}
