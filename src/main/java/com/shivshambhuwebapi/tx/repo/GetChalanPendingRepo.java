package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.tx.model.GetChalanPendingReport;

public interface GetChalanPendingRepo extends JpaRepository<GetChalanPendingReport, Integer> {

	@Query(value = " SELECT  d.order_det_id, i.item_id,i.item_name,i.item_code,h.order_date,h.order_no,c.cust_name ,c.cust_mob_no, d.order_qty"
			+ "  FROM t_order_header h,m_customer c ,t_order_detail d,m_item_fg i WHERE h.del_status=1  AND "
			+ "c.cust_id=h.cust_id AND d.del_status=1 AND h.status=0 AND h.order_date BETWEEN :fromDate AND :toDate   "
			+ "AND d.order_id=h.order_id AND i.item_id=d.item_id  ", nativeQuery = true)

	List<GetChalanPendingReport> getPendingChalanList(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

	@Query(value = " SELECT  d.order_det_id,i.item_id,i.item_name,i.item_code,h.order_date,h.order_no,c.cust_name ,c.cust_mob_no,d.order_qty"
			+ " FROM t_order_header h,m_customer c ,t_order_detail d,m_item_fg i WHERE h.del_status=1  AND "
			+ "c.cust_id=h.cust_id AND d.del_status=1 AND h.status=0 AND h.order_date BETWEEN :fromDate AND :toDate  and h.cust_id=:custId "
			+ "AND d.order_id=h.order_id AND i.item_id=d.item_id ", nativeQuery = true)

	List<GetChalanPendingReport> getPendingChalanListByCustId(@Param("custId") int custId,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
