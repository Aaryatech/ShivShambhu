package com.shivshambhuwebapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shivshambhuwebapi.master.model.GetOrder;
import com.shivshambhuwebapi.master.model.GetOrderDetail;
import com.shivshambhuwebapi.master.model.OrderDetail;
import com.shivshambhuwebapi.master.model.OrderHeader;
import com.shivshambhuwebapi.master.repo.GetOrderDetailRepo;
import com.shivshambhuwebapi.master.repo.GetOrderRepo;
import com.shivshambhuwebapi.master.repo.OrderDetailRepo;
import com.shivshambhuwebapi.master.repo.OrderHeaderRepo;
import com.shivshambhuwebapi.model.GetPoDetail;
import com.shivshambhuwebapi.model.GetPoHeader;

@RestController
public class OrderApiController {

	@Autowired
	OrderHeaderRepo orderHeaderRepo;

	@Autowired
	GetOrderRepo getOrderRepo;

	@Autowired
	OrderDetailRepo orderDetailRepo;
	
	@Autowired
	GetOrderDetailRepo getOrderDetailRepo;

	@RequestMapping(value = { "/saveOrder" }, method = RequestMethod.POST)
	public @ResponseBody OrderHeader saveOrder(@RequestBody OrderHeader orderHeader) {

		System.err.println("header body " + orderHeader.toString());

		OrderHeader orderRes = null;

		try {

			orderRes = orderHeaderRepo.save(orderHeader);

			for (int i = 0; i < orderHeader.getOrderDetailList().size(); i++) {

				orderHeader.getOrderDetailList().get(i).setOrderId(orderRes.getOrderId());

			}

			List<OrderDetail> ordDetList = orderDetailRepo.saveAll(orderHeader.getOrderDetailList());

			orderRes.setOrderDetailList(ordDetList);

		} catch (Exception e) {

			System.err.println("exce in saving order head and detail " + e.getMessage());

			e.printStackTrace();

		}
		System.err.println("orderRes body " + orderRes.toString());

		return orderRes;

	}

	@RequestMapping(value = { "/getOrderListBetDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetOrder> getOrderListBetDate(@RequestParam("plantId") int plantId,
			@RequestParam("custId") int custId, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate,@RequestParam("status") int status) {

		List<GetOrder> getOrderList = new ArrayList<>();

		try {
			getOrderList = getOrderRepo.getOrderBetweenDate(plantId, custId, fromDate, toDate,status);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return getOrderList;

	}
	
	@RequestMapping(value = { "/getOrderHeaderById" }, method = RequestMethod.POST)
	public @ResponseBody GetOrder getOrderHeaderById(@RequestParam("orderId") int orderId) {

		GetOrder getOrder =new GetOrder();
		try {
			getOrder = getOrderRepo.getOrderHeaderById(orderId);
		} catch (Exception e) {
			
			System.err.println("exc in getting  getOrderHeaderById " +e.getMessage());

			e.printStackTrace();
		}
		return getOrder;

	}
	
	
	@RequestMapping(value = { "/getOrderDetailList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetOrderDetail> getOrderDetailList(@RequestParam("orderHeaderId") int orderHeaderId) {

		List<GetOrderDetail> getOrderDetailList = new ArrayList<>();

		try {
			getOrderDetailList = getOrderDetailRepo.getOrderDtailList(orderHeaderId);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return getOrderDetailList;

	}
	
	@RequestMapping(value = { "/getOrdHeaderByOrdId" }, method = RequestMethod.POST)
	public @ResponseBody OrderHeader getOrdHeaderByOrdId (@RequestParam("orderHeaderId") int orderHeaderId) {

		OrderHeader orderRes = null;

		try {

			orderRes = orderHeaderRepo.findByOrderId(orderHeaderId);
		}catch (Exception e) {
			System.err.println("exce in getting getOrdHeaderByOrdId " +e.getMessage());
			e.printStackTrace();
		}
		return orderRes;

	}
}
