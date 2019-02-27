package com.shivshambhuwebapi.tx.repo;

import java.util.List;

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
			+ "status=:status,exFloat1=1" + "   WHERE chalanId=:chalanId")
	int closeChalanHeader(@Param("chalanId") int chalanId, @Param("status") int status, @Param("inKm") float inKm,
			@Param("inTime") String inTime, @Param("chalanRemark") String chalanRemark,
			@Param("costSegment") String costSegment,

			@Param("sitePersonName") String sitePersonName, @Param("sitePersonMob") String sitePersonMob);

	@Transactional
	@Modifying
	@Query("UPDATE ChalanHeader  SET exInt1=0  WHERE chalan_id IN(:chalanIds)")
	int deleteMultiChalanDetail(@Param("chalanIds") List<Integer> chalanIds);

	@Transactional
	@Modifying
	@Query(" UPDATE ChalanHeader SET status=2  WHERE chalanId=:chalanId")
	void updateChalanHeaderStatus(@Param("chalanId") Integer integer);

	@Transactional
	@Modifying
	@Query("UPDATE ChalanHeader SET  exInt1=0 WHERE chalanId=:chalanId")
	int deleteChalan(@Param("chalanId") int chalanId);

	List<ChalanHeader> findByChalanId(int chalanId);

}
