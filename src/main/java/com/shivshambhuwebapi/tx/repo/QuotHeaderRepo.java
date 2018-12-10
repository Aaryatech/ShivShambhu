package com.shivshambhuwebapi.tx.repo;

import java.util.List;

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

	@Transactional
	@Modifying
	@Query("UPDATE QuotHeader SET status=2  WHERE quot_head_id=:quotHeadId")
	int updateQuatationStatus(@Param("quotHeadId") int quotHeadId);

	@Transactional
	@Modifying
	@Query("UPDATE QuotHeader SET payTermId=:payTermId, quotDate=:quotDate, otherRemark1=:otherRemark1,projId=:projId,quotTermId=:quotTermId"
			+ " WHERE quot_head_id=:quotHeadId")
	int updateQuotation(@Param("quotHeadId") int quotHeadId, @Param("payTermId") int payTermId,
			@Param("quotDate") String quotDate, @Param("otherRemark1") String otherRemark1, @Param("projId") int projId,
			@Param("quotTermId") int quotTermId);
	
	@Transactional
	@Modifying
	@Query("UPDATE QuotHeader  SET delStatus=0  WHERE quot_head_id IN(:quotIds)")
	int deleteMultiQuotDetail(@Param("quotIds") List<Integer> quotIds);

}
