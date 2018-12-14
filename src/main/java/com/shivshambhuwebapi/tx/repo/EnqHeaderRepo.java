package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.tx.model.EnqHeader;

public interface EnqHeaderRepo extends JpaRepository<EnqHeader, Integer> {

	EnqHeader findByEnqHeadId(int enqHeadId);

	@Transactional
	@Modifying
	@Query("UPDATE EnqHeader SET enqHRemark=:enqHRemark, enqDate=:enqDate ,enqGenId=:enqGenId, enqPriority=:enqPriority WHERE enqHeadId=:enqHeadId")
	int updateEnquiry(@Param("enqHeadId") int enqHeadId, @Param("enqHRemark") String enqHRemark,
			@Param("enqDate") String enqDate, @Param("enqGenId") int enqGenId, @Param("enqPriority") int enqPriority);

	
	
	
	@Transactional
	@Modifying
	@Query("UPDATE EnqHeader  SET exInt1=0  WHERE enq_head_id IN(:enqIds)")
	int deleteMultiEnqDetail(@Param("enqIds") List<Integer> enqIds);

}




