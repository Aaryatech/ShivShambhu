package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivshambhuwebapi.master.model.OrderHeader;

public interface OrderHeaderRepo extends JpaRepository<OrderHeader, Integer> {
	
	OrderHeader findByOrderId(int orderId);
	
	List<OrderHeader> findByCustIdAndStatusIn(int custId,List<Integer> statusList);
	
	List<OrderHeader> findByProjIdAndStatusIn(int projId,List<Integer> statusList);
	
}
