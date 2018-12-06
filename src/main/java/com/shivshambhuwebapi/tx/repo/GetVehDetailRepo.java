package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.tx.model.GetVehDetail;

public interface GetVehDetailRepo extends JpaRepository<GetVehDetail, Integer> {

	@Query(value = "SELECT d.*,i.item_desc,i.item_code,u.uom_name  FROM t_issue_veh_detail d,m_item i ,m_uom u  WHERE d.del_status=1 "
			+ "AND i.item_id=d.item_id AND d.mat_veh_header_id=:matVehHeaderId AND u.uom_id=d.uom_id", nativeQuery = true)
	List<GetVehDetail> getMatIssueByHeaderId(@Param("matVehHeaderId") int matVehHeaderId);
}
