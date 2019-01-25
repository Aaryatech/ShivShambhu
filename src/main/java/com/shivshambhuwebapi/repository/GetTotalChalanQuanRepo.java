package com.shivshambhuwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.bill.GetBillHeaderPdf;
import com.shivshambhuwebapi.tx.model.GetTotalChalanQuantity;

public interface GetTotalChalanQuanRepo  extends JpaRepository<GetTotalChalanQuantity, Integer> {

	@Query(value="SELECT t_order_detail.item_id as item_id,\r\n" + 
			"(sum(t_order_detail.order_qty)-sum(t_order_detail.rem_ord_qty)) as result,"
			+ "sum(t_order_detail.order_qty) as total_ord_quan,sum(t_order_detail.rem_ord_qty) "
			+ "as total_rem_ord_quan"
			+ " from t_order_header,t_order_detail where t_order_header.order_id=:orderId AND "
			+ "t_order_header.order_id=t_order_detail.order_id  GROUP BY t_order_detail.item_id",
			nativeQuery = true)
	List<GetTotalChalanQuantity> getChalanPrintItem(@Param("orderId") int orderId);
	
	
	
	
	
	

}
