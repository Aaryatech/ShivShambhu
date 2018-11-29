package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivshambhuwebapi.master.model.OrderDetail;

public interface OrderDetailRepo extends JpaRepository<OrderDetail, Integer> {
	
	List<OrderDetail> findByOrOrderIdAndDelStatus(int orderId,int delStatus);

}
