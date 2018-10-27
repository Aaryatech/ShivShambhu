package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.master.model.QuotTracking;

public interface QuotTrackingRepo extends JpaRepository<QuotTracking, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE QuotTracking SET del_status=0  WHERE quot_track_id=:quotTrackId")
	int deleteQuotTracking(@Param("quotTrackId") int quotTrackId);

	QuotTracking findByQuotTrackIdAndDelStatus(int quotTrackId, int i);

	List<QuotTracking> findByDelStatusOrderByQuotTrackIdDesc(int i);

}
