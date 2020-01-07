package com.shivshambhuwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.GetPoChallan;

public interface PoChallanReportRepo extends JpaRepository<GetPoChallan, Integer> {

	
	@Query(value="SELECT\n" + 
			"        UUID() AS id,\n" + 
			"        t_chalan_detail.order_detail_id,\n" + 
			"        m_item.item_desc,\n" + 
			"        t_cust_po_header.po_no,\n" + 
			"        t_cust_po_header.po_date,\n" + 
			"        t_cust_po_detail.po_qty,\n" + 
			"        SUM(t_chalan_detail.item_qty) AS po_challan_qty \n" + 
			"    FROM\n" + 
			"        t_cust_po_header,\n" + 
			"        t_cust_po_detail,\n" + 
			"        t_chalan_header,\n" + 
			"        t_chalan_detail,\n" + 
			"        t_order_header,\n" + 
			"        t_order_detail,\n" + 
			"        m_item,\n" + 
			"        m_customer,\n" + 
			"        m_plant \n" + 
			"    WHERE\n" + 
			"        t_cust_po_header.cust_id IN(:custIds) \n" + 
			"        AND m_customer.cust_id = t_cust_po_header.cust_id \n" + 
			"        AND t_cust_po_header.plant_id = :plantId\n" + 
			"        AND m_plant.plant_id = t_cust_po_header.plant_id \n" + 
			"        AND t_cust_po_header.del_status = 1 \n" + 
			"        AND t_cust_po_header.po_id = t_cust_po_detail.po_id \n" + 
			"        AND t_cust_po_detail.po_detail_id = t_order_detail.po_detail_id \n" + 
			"        AND t_order_header.order_id = t_order_detail.order_id \n" + 
			"        AND t_order_detail.order_det_id = t_chalan_detail.order_detail_id \n" + 
			"        AND t_chalan_detail.chalan_id = t_chalan_header.chalan_id \n" + 
			"        AND t_cust_po_detail.item_id = m_item.item_id \n" + 
			"        AND t_order_detail.item_id = m_item.item_id \n" + 
			"    GROUP BY       \n" + 
			"        t_chalan_detail.order_detail_id \n" + 
			"    ORDER BY\n" + 
			"        t_cust_po_header.po_id DESC",nativeQuery=true)
	public List<GetPoChallan> getPoChallanDetails(@Param("plantId") int plantId, @Param("custIds") List<Integer> custIds);
	
	/*@Query(value="SELECT\n" + 
			"    UUID() AS id, t_chalan_detail.order_detail_id, m_item.item_desc, t_cust_po_header.po_no, t_cust_po_header.po_date, SUM(t_cust_po_detail.po_qty) AS po_qty,\n" + 
			"    SUM(t_chalan_detail.item_qty) AS po_challan_qty\n" + 
			"FROM\n" + 
			"    t_cust_po_header,\n" + 
			"    t_cust_po_detail,\n" + 
			"    t_chalan_header,\n" + 
			"    t_chalan_detail,\n" + 
			"    t_order_header,\n" + 
			"    t_order_detail,\n" + 
			"    m_item,\n" + 
			"    m_customer,\n" + 
			"    m_plant\n" + 
			"WHERE\n" + 
			"    t_cust_po_header.cust_id IN(:custIds) AND m_customer.cust_id = t_cust_po_header.cust_id AND t_cust_po_header.plant_id = :plantId AND m_plant.plant_id = t_cust_po_header.plant_id AND t_cust_po_header.del_status = 1 AND t_cust_po_header.po_id = t_cust_po_detail.po_id AND t_cust_po_detail.po_id = t_order_detail.po_id AND t_order_header.order_id = t_order_detail.order_id AND t_order_detail.order_det_id = t_chalan_detail.order_detail_id AND t_chalan_detail.chalan_id = t_chalan_header.chalan_id AND t_cust_po_detail.item_id = m_item.item_id AND t_order_detail.item_id = m_item.item_id\n" + 
			"GROUP BY\n" + 
			"    t_cust_po_detail.po_id,\n" + 
			"    t_chalan_detail.order_detail_id\n" + 
			"ORDER BY\n" + 
			"    t_cust_po_header.po_id\n" + 
			"DESC\n" + 
			"    ",nativeQuery=true)
	public List<GetPoChallan> getPoChallanDetails(@Param("plantId") int plantId, @Param("custIds") List<Integer> custIds);*/
}
