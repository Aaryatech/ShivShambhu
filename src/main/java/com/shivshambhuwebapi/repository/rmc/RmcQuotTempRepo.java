package com.shivshambhuwebapi.repository.rmc;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.model.prodrm.RmcQuotTemp;
import com.shivshambhuwebapi.model.rec.GetPayRecoveryHeadCustWise;

public interface RmcQuotTempRepo extends JpaRepository<RmcQuotTemp, Integer> {

	List<RmcQuotTemp> findByQuotDetailIdAndDelStatus(int quotDetailId, int i);

	@Transactional
	@Modifying
	@Query("UPDATE RmcQuotTemp SET quot_no=:quotNo, po_no=:poNo  WHERE quot_detail_id=:quotDetailId")
	int updateRmcQuotTemp(@Param("quotDetailId") int quotDetailId, @Param("quotNo") String quotNo,
			@Param("poNo") String poNo);

	@Transactional
	@Modifying
	@Query("UPDATE RmcQuotTemp SET chalan_no=:chalanNo  WHERE order_no=:orderId")
	int updateChalanNo(@Param("orderId") int orderId, @Param("chalanNo") String chalanNo);

	@Transactional
	@Modifying
	@Query("UPDATE RmcQuotTemp SET order_no=:orderNo  WHERE po_no=:poId")
	int updateOrderNo(@Param("poId") int poId, @Param("orderNo") String orderNo);

	List<RmcQuotTemp> findByOrderNoAndDelStatus(int orderId, int i);

	List<RmcQuotTemp> findByPoNoAndDelStatus(int poId, int i);

	List<RmcQuotTemp> findByChalanNoAndDelStatus(int chalanId, int i);

	@Transactional
	@Modifying
	@Query("UPDATE RmcQuotTemp SET bill_no=:billNo  WHERE chalan_no IN(:chalanNoList)")
	int updateBillNo(@Param("chalanNoList") List<Integer> chalanNoList, @Param("billNo") String billNo);

	@Query(value = "SELECT * FROM temp_item_detail WHERE del_status=1 AND chalan_no IN(:chalanIdList)", nativeQuery = true)
	List<RmcQuotTemp> getRmcByChalanIdList(@Param("chalanIdList") List<Integer> chalanIdList);

}
