package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivshambhuwebapi.master.model.ItemType;

public interface ItemTypeRepo extends JpaRepository<ItemType, Integer> {

	List<ItemType> findByDelStatusOrderByItemTypeIdDesc(int i);

	ItemType findByItemTypeIdAndDelStatus(int itemTypeId, int i);

}
