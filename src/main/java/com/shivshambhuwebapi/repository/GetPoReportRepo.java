package com.shivshambhuwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.GetPoReport;

public interface GetPoReportRepo extends JpaRepository<GetPoReport, Integer> {

	@Query(value = "SELECT DISTINCT d.po_detail_id, d.item_id, h.po_id ,h.po_date ,h.po_no ,d.po_remaining_qty,c.cust_name,c.cust_mob_no,i.item_name FROM t_cust_po_detail d,t_cust_po_header h,t_order_header o,m_customer c,m_item_fg i WHERE  h.po_id=d.po_id AND h.po_id=o.po_id AND c.cust_id=h.cust_id AND d.item_id=i.item_id AND d.status=1 AND h.del_status=1  AND o.del_status=1 AND o.order_date BETWEEN :fromDate AND :toDate", nativeQuery = true)
	List<GetPoReport> getPoBetweenDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = "SELECT DISTINCT d.po_detail_id, d.item_id, h.po_id ,h.po_date ,h.po_no ,d.po_remaining_qty,c.cust_name,c.cust_mob_no,i.item_name FROM t_cust_po_detail d,t_cust_po_header h,t_order_header o,m_customer c,m_item_fg i WHERE  h.po_id=d.po_id AND h.po_id=o.po_id AND c.cust_id=h.cust_id AND d.item_id=i.item_id AND d.status=1 AND h.del_status=1  AND h.plant_id=:plantId AND o.del_status=1 AND o.order_date BETWEEN :fromDate AND :toDate", nativeQuery = true)
	List<GetPoReport> getPoBetweenDateAndPlantId(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("plantId") int plantId);

	@Query(value = "SELECT d.po_detail_id, d.item_id,h.po_id ,h.po_date ,h.po_no ,d.po_remaining_qty,c.cust_name,c.cust_mob_no,i.item_name FROM t_cust_po_detail d,t_cust_po_header h,m_customer c,m_item_fg i WHERE  h.po_id=d.po_id AND d.status=0 AND h.del_status=1 AND c.cust_id=h.cust_id AND d.item_id=i.item_id", nativeQuery = true)
	List<GetPoReport> getPoReport();

	@Query(value = "SELECT d.po_detail_id, d.item_id,h.po_id ,h.po_date ,h.po_no ,d.po_remaining_qty,c.cust_name,c.cust_mob_no,i.item_name FROM t_cust_po_detail d,t_cust_po_header h,m_customer c,m_item_fg i WHERE  h.po_id=d.po_id AND d.status=0 AND h.del_status=1  AND h.plant_id=:plantId AND c.cust_id=h.cust_id AND d.item_id=i.item_id", nativeQuery = true)
	List<GetPoReport> getPoByPlantId(@Param("plantId") int plantId);

}
