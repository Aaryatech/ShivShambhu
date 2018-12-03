package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.tx.model.GetChalanDetail;

public interface GetChalanDetailRepo extends JpaRepository<GetChalanDetail, Integer> {
	@Query(value = " SELECT t_chalan_detail.*, m_item.item_name,m_item.item_code,m_uom.uom_name,"
			+ " t_order_detail.rem_ord_qty,t_order_detail.order_qty, "
			+ " m_uom.uom_short_name " + " FROM t_chalan_detail,m_item,m_uom,t_order_detail "
			+ " WHERE  t_chalan_detail.item_id=m_item.item_id AND m_item.uom_id=m_uom.uom_id "
			+ " AND t_chalan_detail.chalan_id=:chalanId AND t_chalan_detail.order_detail_id=t_order_detail.order_det_id ", nativeQuery = true)

	List<GetChalanDetail> getGetChalanDetail(@Param("chalanId") int chalanId);

}
