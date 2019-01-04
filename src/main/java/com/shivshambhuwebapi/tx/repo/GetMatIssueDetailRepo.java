package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.tx.model.GetMatIssueDetail;

public interface GetMatIssueDetailRepo extends JpaRepository<GetMatIssueDetail, Integer> {

	@Query(value = "SELECT  d.*,i.item_desc,i.item_code,u.uom_name FROM  t_mat_issue_contra_detail d ,m_item i ,m_uom u "
			+ "WHERE d.del_status=1 AND d.item_id= i.item_id AND d.uom_id=u.uom_id AND d.mat_header_id=:matHeaderId", nativeQuery = true)
	List<GetMatIssueDetail> getMatIssueHeaderByHeaderId(@Param("matHeaderId") int matHeaderId);

	@Query(value = "SELECT  d.*,i.item_desc,i.item_code,u.uom_name FROM  t_mat_issue_contra_detail d ,m_item i ,m_uom u,t_mat_issue_contra_header h WHERE d.del_status=1 AND d.item_id= i.item_id AND d.uom_id=u.uom_id AND d.mat_header_id=h.mat_header_id AND h.del_status=1 AND h.contr_id=:contrId AND h.date BETWEEN :fromDate AND :toDate", nativeQuery = true)
	List<GetMatIssueDetail> getMatIssueHeaderByDateAndContractor(@Param("contrId") int contrId,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
