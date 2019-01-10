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

import com.shivshambhuwebapi.model.prodrm.RmcQuotItemDetail;
import com.shivshambhuwebapi.model.prodrm.RmcQuotTemp;
import com.shivshambhuwebapi.repository.rmc.RmcQuotItemDetailRepo;
import com.shivshambhuwebapi.repository.rmc.RmcQuotTempRepo;

@RestController
public class TempItemController {

	@Autowired
	RmcQuotTempRepo rmcQuotTempRepo;
	

	@RequestMapping(value = { "/saveTempItemDetail" }, method = RequestMethod.POST)
	public @ResponseBody List<RmcQuotTemp> saveTempItemDetail(@RequestBody List<RmcQuotTemp> detailList) {
		System.out.println("inside");

		List<RmcQuotTemp> itemDList = new ArrayList<>();

		try {
			itemDList = rmcQuotTempRepo.saveAll(detailList);

		} catch (Exception e) {
			System.err.println("Exc in ad Item Detail " + e.getMessage());
		}
		return itemDList;
	}

	@RequestMapping(value = { "/getTempItemDetailByQuotDetailId" }, method = RequestMethod.POST)
	public @ResponseBody List<RmcQuotTemp> getTempItemDetailByQuotDetailId(
			@RequestParam("quotDetailId") int quotDetailId) {

		List<RmcQuotTemp> billHeaderRes = new ArrayList<>();

		try {

			billHeaderRes = rmcQuotTempRepo.findByQuotDetailIdAndDelStatus(quotDetailId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return billHeaderRes;

	}

}
