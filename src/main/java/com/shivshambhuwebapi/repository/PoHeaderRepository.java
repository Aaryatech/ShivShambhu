package com.shivshambhuwebapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.model.PoHeader;

public interface PoHeaderRepository extends JpaRepository<PoHeader, Integer>{

	@Transactional
	@Modifying
	@Query("UPDATE PoHeader SET del_status=0  WHERE po_id=:poId")
	int deletePurchaseOrder(@Param("poId")int poId);

}
