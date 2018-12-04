package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.tx.model.GetMatIssueHeader;

public interface GetMatIssueHeaderRepo extends JpaRepository<GetMatIssueHeader, Integer> {

	@Query(value = "SELECT c.*,n.contr_name ,n.contr_mob  FROM t_mat_issue_contra_header c,m_contractor n WHERE c.del_status=1 AND c.contr_id=n.contr_id", nativeQuery = true)
	List<GetMatIssueHeader> getMatIssueHeadeList();

	@Query(value = "SELECT c.*,n.contr_name ,n.contr_mob  FROM t_mat_issue_contra_header c,m_contractor n WHERE c.del_status=1 AND c.contr_id=n.contr_id AND c.mat_header_id=:matHeaderId", nativeQuery = true)
	GetMatIssueHeader getMatIssueHeaderByHeaderId(@Param("matHeaderId") int matHeaderId);

}
