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
	/*
	 
	 SELECT t_order_header.*,
m_plant.plant_name,m_company.comp_name,m_customer.cust_name,m_project.proj_name,m_project.address
FROM t_order_header,m_plant,m_company,m_customer,m_project
WHERE t_order_header.plant_id=m_plant.plant_id AND m_plant.company_id=m_company.company_id AND t_order_header.cust_id=m_customer.cust_id AND m_project.proj_id=t_order_header.proj_id
AND t_order_header.plant_id=:plantId AND t_order_header.cust_id=:custId
t_order_header.order_date BETWEEN :fromDate AND :toDate  ORDER BY t_order_header.order_date DESC 
	 */

}
