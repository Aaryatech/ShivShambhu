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
			@RequestParam("toDate") String toDate) {

		List<GetOrder> getOrderList = new ArrayList<>();

		try {

			if (custId == 0) {
				getOrderList = getOrderRepo.getOrderBetweenDateCust(plantId, fromDate, toDate);
			} else {
				getOrderList = getOrderRepo.getOrderBetweenDate(plantId, custId, fromDate, toDate);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return getOrderList;

	}

	// 27-12-2018
	@RequestMapping(value = { "/getOrderListBetDateAndStatus" }, method = RequestMethod.POST)
	public @ResponseBody List<GetOrder> getOrderListBetDateAndStatus(@RequestParam("plantId") int plantId,
			@RequestParam("custId") int custId, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("statusList") List<Integer> statusList) {

		List<GetOrder> getOrderList = new ArrayList<>();

		if (statusList.contains(-1)) {
			statusList.clear();
			statusList.add(0);
			statusList.add(1);
			statusList.add(2);
		}

		try {

			if (custId == 0 && plantId == 0) {
				getOrderList = getOrderRepo.getOrderBetweenDateAll(fromDate, toDate, statusList);
			} else if (custId != 0 && plantId == 0) {
				getOrderList = getOrderRepo.getOrderBetweenDateAndCust(fromDate, toDate, custId, statusList);
			} else if (custId == 0 && plantId != 0) {
				getOrderList = getOrderRepo.getOrderBetweenDateAndPlant(fromDate, toDate, plantId, statusList);
			} else if (custId != 0 && plantId != 0) {
				getOrderList = getOrderRepo.getOrderBetweenDateAndPlantAndCust(fromDate, toDate, plantId, custId,
						statusList);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return getOrderList;

	}

	@RequestMapping(value = { "/getPendingOrderListBetDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetOrder> getPendingOrderListBetDate(@RequestParam("plantId") int plantId,
			@RequestParam("custId") int custId, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<GetOrder> getOrderList = new ArrayList<>();

		try {

			if (custId == 0) {
				getOrderList = getOrderRepo.getPendingOrderBetweenDate(plantId, fromDate, toDate);
			} else {
				getOrderList = getOrderRepo.getPendingOrderBetweenDateCust(plantId, custId, fromDate, toDate);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return getOrderList;

	}

	@RequestMapping(value = { "/getOrderHeaderById" }, method = RequestMethod.POST)
	public @ResponseBody GetOrder getOrderHeaderById(@RequestParam("orderId") int orderId) {

		GetOrder getOrder = new GetOrder();
		try {
			getOrder = getOrderRepo.getOrderHeaderById(orderId);
		} catch (Exception e) {

			System.err.println("exc in getting  getOrderHeaderById " + e.getMessage());

			e.printStackTrace();
		}
		return getOrder;

	}

	@RequestMapping(value = { "/getOrderDetailList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetOrderDetail> getOrderDetailList(@RequestParam("orderHeaderId") int orderHeaderId) {

		List<GetOrderDetail> getOrderDetailList = new ArrayList<>();
		System.err.println("orderHeaderId for getOrderDetailList  " + orderHeaderId);

		try {
			getOrderDetailList = getOrderDetailRepo.getOrderDtailList(orderHeaderId);

		} catch (Exception e) {
			System.err.println("Exce in  getOrderDetailList by  orderHeaderId " + e.getMessage());

			e.printStackTrace();
		}
		return getOrderDetailList;

	}

	@RequestMapping(value = { "/getOrdHeaderByOrdId" }, method = RequestMethod.POST)
	public @ResponseBody OrderHeader getOrdHeaderByOrdId(@RequestParam("orderHeaderId") int orderHeaderId) {

		OrderHeader orderRes = null;

		try {

			orderRes = orderHeaderRepo.findByOrderId(orderHeaderId);
		} catch (Exception e) {
			System.err.println("exce in getting getOrdHeaderByOrdId " + e.getMessage());
			e.printStackTrace();
		}
		return orderRes;

	}

	@RequestMapping(value = { "/getOrdHeaderForChalan" }, method = RequestMethod.POST)
	public @ResponseBody List<OrderHeader> getOrdHeaderForChalan(@RequestParam("custId") int custId,
			@RequestParam("projId") int projId, @RequestParam("statusList") List<Integer> statusList) {

		List<OrderHeader> orderResList = new ArrayList<>();

		try {

			if (projId == -1) {

				orderResList = orderHeaderRepo.findByCustIdAndStatusInAndDelStatus(custId, statusList, 1);

			} else {

				orderResList = orderHeaderRepo.findByProjIdAndStatusInAndDelStatus(projId, statusList, 1);
			}
		} catch (Exception e) {

			System.err.println("exce in getting getOrdHeaderForChalan " + e.getMessage());
			e.printStackTrace();
		}

		return orderResList;

	}

	@RequestMapping(value = { "/deleteMultiOrder" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiQuot(@RequestParam("orderIds") List<Integer> orderIds) {

		Info info = new Info();

		try {
			int delete = orderHeaderRepo.deleteMultiOrderDetail(orderIds);

			if (delete >= 1) {
				info.setError(false);
				info.setMessage("successfully Multiple Deleted");
			} else {
				info.setError(true);
				info.setMessage(" failed to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" Deleted to Delete");

		}
		return info;

	}

	@RequestMapping(value = { "/UpdateOrderHeader" }, method = RequestMethod.POST)
	public @ResponseBody Info UpdateOrderHeader(@RequestParam("orderId") int orderId) {

		Info info = new Info();

		try {
			int delete = orderHeaderRepo.UpdateOrderHeader(orderId);

			if (delete >= 1) {
				info.setError(false);
				info.setMessage("successfully Multiple Updated");
			} else {
				info.setError(true);
				info.setMessage(" failed to ");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" Exception");

		}
		return info;

	}

	@RequestMapping(value = { "/UpdateOrderDetail" }, method = RequestMethod.POST)
	public @ResponseBody Info UpdateOrderDetail(@RequestParam("orderId") int orderId) {

		Info info = new Info();

		try {
			int delete = orderDetailRepo.updateOrderDetail(orderId);

			if (delete >= 1) {
				info.setError(false);
				info.setMessage("successfully Multiple Updated");
			} else {
				info.setError(true);
				info.setMessage(" failed to ");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" Exception");

		}
		return info;

	}
}
