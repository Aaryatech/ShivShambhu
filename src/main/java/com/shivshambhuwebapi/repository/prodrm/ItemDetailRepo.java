package com.shivshambhuwebapi.repository.prodrm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivshambhuwebapi.model.prodrm.ItemDetail;

public interface ItemDetailRepo extends JpaRepository<ItemDetail, Integer>{
	
	List<ItemDetail> findByDelStatusAndItemIdIn(int delStatus,List<Integer> itemIdList);

}
