package com.shivshambhuwebapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shivshambhuwebapi.master.model.OrderDetail;
import com.shivshambhuwebapi.master.model.OrderHeader;
import com.shivshambhuwebapi.master.repo.OrderDetailRepo;
import com.shivshambhuwebapi.master.repo.OrderHeaderRepo;


@RestController
public class OrderApiController {

	@Autowired
	OrderHeaderRepo orderHeaderRepo;

	@Autowired
	OrderDetailRepo orderDetailRepo;
	
	

	@RequestMapping(value = { "/saveOrder" }, method = RequestMethod.POST)
	public @ResponseBody OrderHeader saveOrder(@RequestBody OrderHeader orderHeader) {

		
		System.err.println("header body " +orderHeader.toString());
		
		
		OrderHeader orderRes = null;

		try {

			orderRes = orderHeaderRepo.save(orderHeader);
			
			for(int i=0 ; i<orderHeader.getOrderDetailList().size() ; i++) {
				
				orderHeader.getOrderDetailList().get(i).setOrderId(orderRes.getOrderId());
				
			}
			
			List<OrderDetail> ordDetList = orderDetailRepo.saveAll(orderHeader.getOrderDetailList());
			
			orderRes.setOrderDetailList(ordDetList);

		} catch (Exception e) {
			
			System.err.println("exce in saving order head and detail " +e.getMessage());

			e.printStackTrace();

		}
		System.err.println("orderRes body " +orderRes.toString());

		return orderRes;

	}

}
