package com.shivshambhuwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.model.PoHeader;
import com.shivshambhuwebapi.model.bill.GetQuotReport;

public interface PoHeaderRepository extends JpaRepository<PoHeader, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE PoHeader SET del_status=0  WHERE po_id=:poId")
	int deletePurchaseOrder(@Param("poId") int poId);

	List<PoHeader> findByDelStatusAndCustIdAndStatusIn(int delStatus, int custId, List<Integer> statusList);

	@Transactional
	@Modifying
	@Query("UPDATE PoHeader SET delStatus=0  WHERE poId IN(:poIds)")
	int deleteMultiPO(@Param("poIds") List<Integer> poIds);

	@Query(value = "SELECT ph.* FROM t_cust_po_header ph ,t_cust_po_detail pd,t_order_detail od,t_chalan_detail"
			+ " cd WHERE ph.cust_id=:custId AND cd.order_detail_id=od.order_det_id AND "
			+ "od.po_detail_id=pd.po_detail_id AND  pd.po_id=ph.po_id  AND cd.chalan_id IN (:chalanIdList) GROUP BY ph.po_id", nativeQuery = true)

	List<PoHeader> getPoNoForBill(@Param("custId") int custId, @Param("chalanIdList") List<Integer> chalanIdList);

}
