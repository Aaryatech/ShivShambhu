package com.shivshambhuwebapi.repository.prodrm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.model.prodrm.ProdPlanHeader;

public interface ProdPlanHeaderRepo extends JpaRepository<ProdPlanHeader, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE ProdPlanHeader SET production_status=:prodStatus,"
			+ "production_end_date=:productionEndDate WHERE production_header_id=:prodHeaderId")
	int completProd(@Param("prodHeaderId") int prodHeaderId, @Param("prodStatus") int prodStatus,
			@Param("productionEndDate") String productionEndDate);

	ProdPlanHeader findByProductionHeaderId(int prodHeaderId);

	@Transactional
	@Modifying
	@Query("UPDATE ProdPlanHeader SET delStatus=0  WHERE productionHeaderId IN(:prodHeaderIds)")
	int deleteMultiProdPlanHeader(@Param("prodHeaderIds") List<Integer> prodHeaderIds);

}
