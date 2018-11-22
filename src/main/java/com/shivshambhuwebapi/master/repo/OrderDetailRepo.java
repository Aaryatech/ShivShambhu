package com.shivshambhuwebapi.master.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivshambhuwebapi.master.model.OrderDetail;

public interface OrderDetailRepo extends JpaRepository<OrderDetail, Integer> {

}
