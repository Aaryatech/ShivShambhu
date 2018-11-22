package com.shivshambhuwebapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.shivshambhuwebapi.master.repo.OrderDetailRepo;
import com.shivshambhuwebapi.master.repo.OrderHeaderRepo;

@RestController
public class OrderApiController {

	@Autowired
	OrderHeaderRepo orderHeaderRepo;

	@Autowired
	OrderDetailRepo orderDetailRepo;

}
