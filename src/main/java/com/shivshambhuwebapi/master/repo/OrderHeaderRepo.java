package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.master.model.OrderHeader;

public interface OrderHeaderRepo extends JpaRepository<OrderHeader, Integer> {

	OrderHeader findByOrderId(int orderId);

	List<OrderHeader> findByCustIdAndStatusIn(int custId, List<Integer> statusList);

	List<OrderHeader> findByProjIdAndStatusIn(int projId, List<Integer> statusList);

	@Transactional
	@Modifying
	@Query("UPDATE OrderHeader  SET delStatus=0  WHERE order_id IN(:orderIds)")
	int deleteMultiOrderDetail(@Param("orderIds") List<Integer> orderIds);

	@Transactional
	@Modifying
	@Query("UPDATE OrderHeader  SET status=2  WHERE orderId=:orderId")
	int UpdateOrderHeader(@Param("orderId") int orderId);

	List<OrderHeader> findByCustIdAndStatusInAndDelStatus(int custId, List<Integer> statusList, int i);

	List<OrderHeader> findByProjIdAndStatusInAndDelStatus(int projId, List<Integer> statusList, int i);
	
	
	//Anmol-->2-12-2019---->update status
	@Transactional
	@Modifying
	@Query("UPDATE OrderHeader  SET status=:status  WHERE delivery_date<:currDate")
	int updateStatusDateLessThanCurrent(@Param("status") int status, @Param("currDate") String currDate);

}
