package com.shivshambhuwebapi.master.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivshambhuwebapi.master.model.OrderHeader;

public interface OrderHeaderRepo extends JpaRepository<OrderHeader, Integer> {

}
