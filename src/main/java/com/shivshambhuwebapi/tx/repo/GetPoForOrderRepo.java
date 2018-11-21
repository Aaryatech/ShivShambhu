package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.tx.model.GetPoForOrder;

public interface GetPoForOrderRepo extends JpaRepository<GetPoForOrder, Integer> {
	
	@Query(value = " SELECT t_cust_po_detail.po_detail_id,t_cust_po_detail.item_id,"
			+ " t_cust_po_detail.po_rate,t_cust_po_detail.po_qty,t_cust_po_detail.po_consume_qty,"
			+ " t_cust_po_detail.po_remaining_qty,t_cust_po_detail.status,t_cust_po_detail.remark,"
			+ " t_cust_po_detail.tax_amt,t_cust_po_detail.tax_per,t_cust_po_detail.taxable_amt,"
			+ " t_cust_po_detail.other_charges,t_cust_po_detail.total,t_cust_po_detail.qu_detail_id, "
			+ " t_cust_po_header.po_id,t_cust_po_header.po_no,t_cust_po_header.po_date, m_item.item_code,"
			+ " m_item.item_name,m_item.short_name,m_item.dispatch_limit,m_item.royalty_rate,"
			+ " m_item.freight_rate,m_item.item_rate1, m_uom.uom_name "
			+ " FROM t_cust_po_detail,t_cust_po_header,m_item,m_uom "
			+ " WHERE t_cust_po_detail.po_id=t_cust_po_header.po_id AND"
			+ " t_cust_po_detail.item_id=m_item.item_id AND m_item.uom_id=m_uom.uom_id "
			+ " AND t_cust_po_header.po_id=:poId ", nativeQuery = true)
	
	List<GetPoForOrder> getGetPoForOrderByPoId(@Param("poId") int poId);

}
