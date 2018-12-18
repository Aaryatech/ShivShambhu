package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.tx.model.GetPendingBillReport;

public interface GetPendingBillReportRepo extends JpaRepository<GetPendingBillReport, Integer> {

	@Query(value = "SELECT d.chalan_detail_id, h.order_no ,o.order_date,h.chalan_no,h.chalan_date,c.cust_name,c.cust_mob_no,i.item_name,"
			+ "i.item_code ,d.item_qty   FROM t_chalan_header h ,m_customer c ,t_chalan_detail d ,m_item_fg i,t_order_header o  WHERE "
			+ " c.cust_id=h.cust_id AND h.chalan_id=d.chalan_id AND i.item_id=d.item_id AND o.order_id=h.order_id AND h.chalan_date "
			+ "BETWEEN :fromDate AND :toDate  ", nativeQuery = true)

	List<GetPendingBillReport> getPendingBillList(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = " SELECT d.chalan_detail_id, h.order_no ,o.order_date,h.chalan_no,h.chalan_date,c.cust_name,c.cust_mob_no,i.item_name"
			+ ",i.item_code ,d.item_qty   FROM t_chalan_header h ,m_customer c ,t_chalan_detail d ,m_item_fg i,t_order_header o "
			+ " WHERE  c.cust_id=h.cust_id AND h.chalan_id=d.chalan_id AND i.item_id=d.item_id AND o.order_id=h.order_id AND"
			+ " h.chalan_date BETWEEN :fromDate AND :toDate AND h.cust_id=:custId ", nativeQuery = true)

	List<GetPendingBillReport> getPendingBillListByCustId(@Param("custId") int custId,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
