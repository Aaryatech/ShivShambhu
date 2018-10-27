package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.tx.model.MarketingTravel;

public interface MarketingTravelRepo extends JpaRepository<MarketingTravel, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE MarketingTravel SET del_status=0  WHERE travel_id=:travelId")
	int deleteMarketingTravel(@Param("travelId") int travelId);

	MarketingTravel findByTravelIdAndDelStatus(int travelId, int i);

	List<MarketingTravel> findByDelStatusOrderByTravelIdDesc(int i);

}
