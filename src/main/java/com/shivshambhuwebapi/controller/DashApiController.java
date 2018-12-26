package com.shivshambhuwebapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shivshambhuwebapi.master.model.DashSaleCount;
import com.shivshambhuwebapi.master.repo.DashSaleCountRepo;

@RestController
public class DashApiController {

	@Autowired
	DashSaleCountRepo dashSaleCountRepo;

	// getDashboardCount

	@RequestMapping(value = { "/getDashboardCountBetDate" }, method = RequestMethod.POST)
	public @ResponseBody DashSaleCount getDashboardCountBetDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("plantId") int plantId) {

		DashSaleCount dashSaleCount = new DashSaleCount();

		try {
			if(plantId!=0)
			{

			dashSaleCount = dashSaleCountRepo.getDashboardCountByPlantId(fromDate, toDate, plantId);
			}
			else
			{
				dashSaleCount = dashSaleCountRepo.getDashboardCount(fromDate, toDate);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return dashSaleCount;

	}
	
	
	

}
