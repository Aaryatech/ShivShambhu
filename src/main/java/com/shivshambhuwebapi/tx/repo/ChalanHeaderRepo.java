package com.shivshambhuwebapi.tx.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.tx.model.ChalanHeader;

public interface ChalanHeaderRepo extends JpaRepository<ChalanHeader, Integer> {
	
	ChalanHeader save(ChalanHeader header);

	@Transactional
	@Modifying
	@Query(" UPDATE ChalanHeader SET vehTimeIn=:inTime,inKm=:inKm, chalanRemark=:chalanRemark,"
			+ "costSegment=:costSegment,sitePersonName=:sitePersonName,sitePersonMob=:sitePersonMob,"
			+ "status=:status"
			+ "   WHERE chalanId=:chalanId")
	int closeChalanHeader(@Param("chalanId") int chalanId,@Param("status") int status,
			@Param("inKm") float inKm,@Param("inTime") String inTime,
			@Param("chalanRemark") String chalanRemark,@Param("costSegment") String costSegment,
			
			@Param("sitePersonName") String sitePersonName,@Param("sitePersonMob") String sitePersonMob
			);
	

}
