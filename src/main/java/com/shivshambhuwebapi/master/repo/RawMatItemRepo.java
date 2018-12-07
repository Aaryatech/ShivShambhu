package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivshambhuwebapi.master.model.RawMatItem;

public interface RawMatItemRepo extends JpaRepository<RawMatItem, Integer> {

	List<RawMatItem> findByCatIdAndIsUsed(int catId, int i);

	RawMatItem findByItemIdAndIsUsed(int itemId, int i);

}