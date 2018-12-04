package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivshambhuwebapi.master.model.ItemCategory;

public interface ItemCategoryRepo extends JpaRepository<ItemCategory, Integer> {

	List<ItemCategory> findByIsUsedOrderByCatIdDesc(int i);

}
