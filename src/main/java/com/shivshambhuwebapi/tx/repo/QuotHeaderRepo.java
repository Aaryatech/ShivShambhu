package com.shivshambhuwebapi.tx.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.tx.model.QuotHeader;

public interface QuotHeaderRepo extends JpaRepository<QuotHeader, Integer> {
	
	
	@Transactional
	@Modifying
	@Query("UPDATE QuotHeader SET delStatus=0  WHERE quot_head_id=:quotHeadId")
	int deleteQuotHeader(@Param("quotHeadId") int quotHeadId);

	QuotHeader findByQuotHeadId(int quotHeadId);

}
