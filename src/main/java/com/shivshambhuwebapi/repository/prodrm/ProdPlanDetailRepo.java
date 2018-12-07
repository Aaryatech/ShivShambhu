package com.shivshambhuwebapi.repository.prodrm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.model.prodrm.ProdPlanDetail;

public interface ProdPlanDetailRepo extends JpaRepository<ProdPlanDetail, Integer> {
	
	@Transactional
	@Modifying
	@Query("UPDATE ProdPlanDetail SET status=:prodStatus, productionQty=:productionQty,"
			+ "rejectedQty=:rejectedQty WHERE productionDetailId=:productionDetailId")
	int completProdDetail(@Param("productionDetailId") int productionDetailId,
			@Param("prodStatus") int prodStatus,
			@Param("productionQty") float productionQty,
			@Param("rejectedQty") float rejectedQty
			);
	ProdPlanDetail save(ProdPlanDetail planDetail);
	

}
