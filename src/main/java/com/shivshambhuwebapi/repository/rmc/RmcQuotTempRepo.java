package com.shivshambhuwebapi.repository.rmc;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.model.prodrm.RmcQuotTemp;

public interface RmcQuotTempRepo extends JpaRepository<RmcQuotTemp, Integer> {

	List<RmcQuotTemp> findByQuotDetailIdAndDelStatus(int quotDetailId, int i);

	@Transactional
	@Modifying
	@Query("UPDATE RmcQuotTemp SET quot_no=:quotNo, po_no=:poNo  WHERE quot_detail_id=:quotDetailId")
	int updateRmcQuotTemp(@Param("quotDetailId") int quotDetailId, @Param("quotNo") String quotNo,
			@Param("poNo") String poNo);

	@Transactional
	@Modifying
	@Query("UPDATE RmcQuotTemp SET chalan_no=:chalanNo  WHERE order_id=:orderId")
	int updateChalanNo(@Param("orderId") int orderId, @Param("chalanNo") String chalanNo);

	@Transactional
	@Modifying
	@Query("UPDATE RmcQuotTemp SET order_no=:orderNo  WHERE po_id=:poId")
	int updateOrderNo(@Param("poId") int poId, @Param("orderNo") String orderNo);

	List<RmcQuotTemp> findByOrderNoAndDelStatus(String orderId, int i);

	List<RmcQuotTemp> findByPoNoAndDelStatus(String poId, int i);

}
