package com.shivshambhuwebapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shivshambhuwebapi.model.rmc.GetRmcOrders;
import com.shivshambhuwebapi.repository.rmc.GetRmcOrdersRepo;

@RestController
public class RmcApiController {
	
	
	@Autowired GetRmcOrdersRepo getGetRmcOrdersRepo;
	
	@RequestMapping(value = { "/getRmcOrdList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetRmcOrders> getDispatchList(@RequestParam("plantId") int plantId,
			@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate) {

		List<GetRmcOrders> getRmcOrdList = new ArrayList<GetRmcOrders>();

		try {
			System.err.println("plantId"+plantId);
			getRmcOrdList = getGetRmcOrdersRepo.getGetRmcOrders(fromDate, toDate, plantId);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return getRmcOrdList;

	}

}
