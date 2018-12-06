package com.shivshambhuwebapi.repository.prodrm;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivshambhuwebapi.model.prodrm.ProdPlanDetail;

public interface ProdPlanDetailRepo extends JpaRepository<ProdPlanDetail, Integer> {
	
	
	ProdPlanDetail save(ProdPlanDetail planDetail);

}
