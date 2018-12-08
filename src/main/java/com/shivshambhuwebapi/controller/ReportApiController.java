package com.shivshambhuwebapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shivshambhuwebapi.common.DateConvertor;
import com.shivshambhuwebapi.tx.model.GetMatIssueDetail;
import com.shivshambhuwebapi.tx.model.GetMatIssueHeader;
import com.shivshambhuwebapi.tx.model.GetVehDetail;
import com.shivshambhuwebapi.tx.model.GetVehHeader;
import com.shivshambhuwebapi.tx.repo.GetMatIssueDetailRepo;
import com.shivshambhuwebapi.tx.repo.GetMatIssueHeaderRepo;
import com.shivshambhuwebapi.tx.repo.GetVehDetailRepo;
import com.shivshambhuwebapi.tx.repo.GetVehHeaderRepo;

@RestController
public class ReportApiController {

	@Autowired
	GetMatIssueHeaderRepo getMatIssueHeaderRepo;

	@Autowired
	GetMatIssueDetailRepo getMatIssueDetailRepo;

	@Autowired
	GetVehHeaderRepo getVehHeaderRepo;

	@Autowired
	GetVehDetailRepo getVehDetailRepo;

	@RequestMapping(value = { "/getContractorBetweenDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetMatIssueHeader> getContractorBetweenDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<GetMatIssueHeader> headerList = new ArrayList<GetMatIssueHeader>();

		try {

			headerList = getMatIssueHeaderRepo.getContractorBetweenDate(fromDate, toDate);

			for (int i = 0; i < headerList.size(); i++) {
				headerList.get(i).setDate(DateConvertor.convertToDMY(headerList.get(i).getDate()));

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return headerList;

	}

	@RequestMapping(value = { "/getVehicleBetweenDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetVehHeader> getVehicleBetweenDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<GetVehHeader> headerList = new ArrayList<GetVehHeader>();

		try {

			headerList = getVehHeaderRepo.getVehicleBetweenDate(fromDate, toDate);

			for (int i = 0; i < headerList.size(); i++) {
				headerList.get(i).setDate(DateConvertor.convertToDMY(headerList.get(i).getDate()));
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return headerList;

	}

}
