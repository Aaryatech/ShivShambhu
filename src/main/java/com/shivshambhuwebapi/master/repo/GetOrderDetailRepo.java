package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.master.model.GetOrderDetail;

public interface GetOrderDetailRepo extends JpaRepository<GetOrderDetail, Integer> {

	@Query(value = "SELECT t_order_detail.*, t_cust_po_detail.po_rate,t_cust_po_detail.po_qty,t_cust_po_detail.po_consume_qty,"
			+ "t_cust_po_detail.po_remaining_qty,t_cust_po_detail.total as po_total,m_item.item_name,m_item.item_code,"
			+ "t_cust_po_header.po_no,t_cust_po_header.po_date,m_uom.uom_name FROM t_order_header,t_order_detail,t_cust_po_header,"
			+ "t_cust_po_detail,m_item,m_uom WHERE t_order_detail.item_id=m_item.item_id AND t_order_header.order_id=t_order_detail.order_id "
			+ "AND t_order_detail.po_detail_id=t_cust_po_detail.po_detail_id AND t_cust_po_header.po_id=t_cust_po_detail.po_id and"
			+ " t_order_header.po_id=t_cust_po_header.po_id AND t_order_header.order_id=:orderHeaderId AND m_uom.uom_id=m_item.uom_id "
			+ " ", nativeQuery = true)
	List<GetOrderDetail> getOrderDtailList(@Param("orderHeaderId") int orderHeaderId);

}
