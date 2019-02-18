package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.master.model.OrderDetail;

public interface OrderDetailRepo extends JpaRepository<OrderDetail, Integer> {

	List<OrderDetail> findByOrOrderIdAndDelStatus(int orderId, int delStatus);

	@Transactional
	@Modifying
	@Query("UPDATE OrderDetail  SET status=2  WHERE orderId=:orderId")
	int updateOrderDetail(@Param("orderId") int orderId);

}
