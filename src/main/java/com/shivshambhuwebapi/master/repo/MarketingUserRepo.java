package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.master.model.MarketingUser;

public interface MarketingUserRepo extends JpaRepository<MarketingUser, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE MarketingUser SET delStatus=0  WHERE mark_user_id=:markUsrId")
	int deleteMarketingUser(@Param("markUsrId") int markUsrId);

	MarketingUser findByMarkUsrIdAndDelStatus(int markUsrId, int i);

	List<MarketingUser> findByDelStatusOrderByMarkUsrIdDesc(int i);

	@Transactional
	@Modifying
	@Query("UPDATE MarketingUser SET delStatus=0  WHERE markUsrId IN(:markUsrIds)")
	int deleteMultiMarketingUser(@Param("markUsrIds") List<Integer> markUsrIds);

}
