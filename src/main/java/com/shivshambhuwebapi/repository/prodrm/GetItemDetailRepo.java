package com.shivshambhuwebapi.repository.prodrm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.prodrm.GetItemDetail;

public interface GetItemDetailRepo extends JpaRepository<GetItemDetail, Integer> {
	
	@Query(value = " SELECT m_item_detail.rm_name,m_item_detail.rm_qty,m_item_detail.no_pieces_per_item,"
			+ " m_item_detail.item_detail_id,"
			+ " m_item_detail.item_id,m_item_detail.rm_weight," + 
			" COALESCE((SELECT m_uom.uom_name FROM m_uom WHERE m_uom.uom_id=m_item_detail.rm_uom_id "
			+ " AND m_uom.del_status=1),'NA') AS rm_uom_name," + 
			" (t_production_plan_detail.plan_qty *m_item_detail.rm_qty) AS rm_quantity "
			+ "FROM t_production_plan_detail,m_item_detail " + 
			" WHERE m_item_detail.item_id=t_production_plan_detail.item_id "
			+ "AND t_production_plan_detail.production_header_id=:prodHeaderId "
			+ " AND m_item_detail.del_status=1 AND t_production_plan_detail.del_status=1 ", nativeQuery = true)
	
	List<GetItemDetail> getGetItemDetail(@Param("prodHeaderId") int prodHeaderId);

}
