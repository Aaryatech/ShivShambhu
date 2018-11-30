package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.tx.model.GetQuotDetail;

public interface GetQuotDetailRepo extends JpaRepository<GetQuotDetail, Integer> {

	@Query(value = "SELECT d.*,i.item_name ,u.uom_name  FROM t_quot_detail d,m_item i,m_uom u WHERE d.del_status=1 AND d.item_id=i.item_id  AND d.quot_head_id=:quotHeadId  AND u.uom_id=d.quot_uom_id and d.quot_qty>0 ORDER BY d.quot_detail_id DESC  ", nativeQuery = true)

	List<GetQuotDetail> getQuotDetailByQuotHeadId(@Param("quotHeadId") int quotHeadId);

	@Query(value = "SELECT d.*,i.item_name,u.uom_name FROM t_quot_detail d,m_item i,m_uom u WHERE d.del_status=1 AND d.item_id=i.item_id AND u.uom_id=d.quot_uom_id  ORDER BY d.quot_detail_id DESC  ", nativeQuery = true)

	List<GetQuotDetail> getQuotDetailList();

}
