package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.master.model.Uom;

public interface UomRepo extends JpaRepository<Uom, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Uom SET del_status=0  WHERE uom_id=:uomId")
	int deleteUom(@Param("uomId") int uomId);

	Uom findByUomIdAndDelStatus(int uomId, int i);

	List<Uom> findByDelStatusOrderByUomIdDesc(int i);

}
