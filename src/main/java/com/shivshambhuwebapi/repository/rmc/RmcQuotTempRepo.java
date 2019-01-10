package com.shivshambhuwebapi.repository.rmc;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.prodrm.RmcQuotTemp;

public interface RmcQuotTempRepo extends JpaRepository<RmcQuotTemp, Integer> {

	/*@Query(value = "SELECT m_item_detail.item_detail_id,m_item_detail.rm_id,m_item_detail.rm_qty,"
			+ "m_item.item_op_rate,m_item.item_wt,m_item.item_code,m_item.item_desc,m_uom_store.uom,"
			+ "m_item_detail.item_id,m_item_fg.item_name, "
			+ "COALESCE(round((m_item.item_op_rate/ m_item.item_wt),2),0) as unit_rate, "
			+ "COALESCE(round((m_item.item_op_rate/ m_item.item_wt)*m_item_detail.rm_qty,2),0) as amt "
			+ "FROM m_item_detail,m_item_fg,m_item,m_uom_store "
			+ "WHERE m_item_detail.rm_id=m_item.item_id AND m_item_detail.item_id=m_item_fg.item_id "
			+ "AND m_item.item_uom2=m_uom_store.uom_id AND m_item_detail.item_id=:itemId "
			+ "AND m_item_detail.del_status=1 AND m_item.is_used=1   ", nativeQuery = true)

	List<RmcQuotTemp> getRmcQuotItemDetail(@Param("itemId") int itemId);*/

	List<RmcQuotTemp> findByQuotDetailIdAndDelStatus(int quotDetailId, int i);

}
