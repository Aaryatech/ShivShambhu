package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.master.model.Item;

public interface ItemRepo extends JpaRepository<Item, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Item SET delStatus=0  WHERE item_id=:itemId")
	int deleteItem(@Param("itemId") int itemId);

	List<Item> findByDelStatusOrderByItemIdDesc(int i);

	Item findByItemIdAndDelStatus(int itemId, int i);
	
	List<Item> findByPlantIdAndDelStatusOrderByItemIdDesc(int plantId,int delStatus);

}
