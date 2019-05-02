package com.shivshambhuwebapi.tx.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.tx.model.QuotDetail;

public interface QuotDetailRepo extends JpaRepository<QuotDetail, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE QuotDetail SET delStatus=0  WHERE quotHeadId=:quotHeadId AND itemId=:itemId")
	int deleteQuotDetail(@Param("quotHeadId") int quotHeadId,@Param("itemId")int itemId);

	List<QuotDetail> findByQuotHeadId(int quotHeadId);

}
