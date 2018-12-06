package com.shivshambhuwebapi.repository.prodrm;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivshambhuwebapi.model.prodrm.ProdPlanHeader;

public interface ProdPlanHeaderRepo  extends JpaRepository<ProdPlanHeader, Integer>{
	
	
	
	ProdPlanHeader save(ProdPlanHeader planHeader);

}
