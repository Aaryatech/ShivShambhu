package com.shivshambhuwebapi.tx.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.tx.model.ChalanDetail;

public interface ChalanDetailRepo extends JpaRepository<ChalanDetail, Integer> {
	
	ChalanDetail save(ChalanDetail detail);
	
	@Transactional
	@Modifying
	@Query(" UPDATE ChalanDetail SET itemQty=:itemQty,itemLengthSite=:itemLengthSite, itemWidthSite=:itemWidthSite,"
			+ " itemHeightSite=:itemHeightSite,itemTotalSite=:itemTotalSite,status=:status "
			+ "   WHERE chalanDetailId=:chalanDetailId ")
	int closeChalanDetail(@Param("chalanDetailId") int chalanDetailId,@Param("status") int status,
			@Param("itemQty") float itemQty,@Param("itemLengthSite") float itemLengthSite,
			@Param("itemWidthSite") float itemWidthSite,@Param("itemHeightSite") float itemHeightSite,
			@Param("itemTotalSite") float itemTotalSite);

}
