package com.shivshambhuwebapi.master.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.master.model.RawMatItem;

public interface RawMatItemRepo extends JpaRepository<RawMatItem, Integer> {

	List<RawMatItem> findByCatIdAndIsUsed(int catId, int i);

	RawMatItem findByItemIdAndIsUsed(int itemId, int i);

	@Transactional
	@Modifying
	@Query("update RawMatItem set del_status=0  WHERE itemId=:itemId")
	int deleteRawMatItem(@Param("itemId") int itemId);

	@Transactional
	@Modifying
	@Query("UPDATE RawMatItem  SET delStatus=0  WHERE item_id IN(:itemIds)")
	int deleteMultiRawMatItem(@Param("itemIds") List<Integer> itemIds);

}
