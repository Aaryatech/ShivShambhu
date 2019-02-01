package com.shivshambhuwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.bill.GetBillHeaderPdf;
import com.shivshambhuwebapi.tx.model.GetTotalChalanQuantity;

public interface GetTotalChalanQuanRepo extends JpaRepository<GetTotalChalanQuantity, Integer> {

	@Query(value = "SELECT\r\n" + "        t_order_detail.item_id as item_id,\r\n"
			+ "        sum(t_chalan_detail.item_qty)as result,\r\n"
			+ "        sum(t_order_detail.order_qty) as total_ord_quan,\r\n"
			+ "        sum(t_order_detail.rem_ord_qty) as total_rem_ord_quan\r\n" + "    from\r\n"
			+ "        t_order_header,\r\n" + "        t_order_detail,t_chalan_detail\r\n" + "    where\r\n"
			+ "        t_order_header.order_id=:orderId\r\n"
			+ "        AND t_order_header.order_id=t_order_detail.order_id  AND t_chalan_detail.order_detail_id=t_order_detail.order_det_id AND t_chalan_detail.chalan_id<=:chalanId\r\n"
			+ "    GROUP BY\r\n" + "        t_chalan_detail.item_id", nativeQuery = true)
	List<GetTotalChalanQuantity> getChalanPrintItem(@Param("orderId") int orderId, @Param("chalanId") int chalanId);

}
