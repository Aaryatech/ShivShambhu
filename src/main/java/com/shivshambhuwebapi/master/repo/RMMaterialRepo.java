package com.shivshambhuwebapi.master.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.master.model.AddItemDetail;

public interface RMMaterialRepo extends JpaRepository<AddItemDetail, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE AddItemDetail SET delStatus=0  WHERE itemDetailId=:itemDetailId")
	int deleteItemDetail(@Param("itemDetailId") int itemDetailId);

}
