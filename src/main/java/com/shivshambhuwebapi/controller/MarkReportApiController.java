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
import com.shivshambhuwebapi.model.bill.GetBillReport;
import com.shivshambhuwebapi.model.bill.GetEnqReport;
import com.shivshambhuwebapi.model.bill.GetQuotReport;
import com.shivshambhuwebapi.repository.GetEnqReportRepo;
import com.shivshambhuwebapi.repository.GetQuotReportRepo;
import com.shivshambhuwebapi.tx.model.GetChalanPendingReport;
import com.shivshambhuwebapi.tx.model.GetPendingBillReport;
import com.shivshambhuwebapi.tx.repo.GetChalanPendingRepo;
import com.shivshambhuwebapi.tx.repo.GetPendingBillReportRepo;

@RestController
public class MarkReportApiController {
	@Autowired
	GetEnqReportRepo getEnqReportRepo;

	@Autowired
	GetQuotReportRepo getQuotReportRepo;

	@Autowired
	GetChalanPendingRepo getChalanPendingRepo;

	@Autowired
	GetPendingBillReportRepo getPendingBillReportRepo;

	@RequestMapping(value = { "/getQutotPendingReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GetEnqReport> getQutotPendingReport(
			@RequestParam("plantIdList") List<Integer> plantIdList, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<GetEnqReport> enqHeaderRes = new ArrayList<>();

		try {

			if (!plantIdList.contains(0)) {
				enqHeaderRes = getEnqReportRepo.getEnqBetDateANdIdList(plantIdList, fromDate, toDate);

			} else {

				enqHeaderRes = getEnqReportRepo.getEnqListBetDate(fromDate, toDate);

			}

			for (int i = 0; i < enqHeaderRes.size(); i++) {
				enqHeaderRes.get(i).setEnqDate(DateConvertor.convertToDMY(enqHeaderRes.get(i).getEnqDate()));
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return enqHeaderRes;

	}

	@RequestMapping(value = { "/getPoPendingReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GetQuotReport> getPoPendingReport(@RequestParam("plantIdList") List<Integer> plantIdList,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<GetQuotReport> enqHeaderRes = new ArrayList<>();

		try {

			if (!plantIdList.contains(0)) {
				enqHeaderRes = getQuotReportRepo.getEnqPendingPoBetDateANdIdList(plantIdList, fromDate, toDate);

			} else {

				enqHeaderRes = getQuotReportRepo.getEnqPendingPoListBetDate(fromDate, toDate);

			}

			for (int i = 0; i < enqHeaderRes.size(); i++) {
				enqHeaderRes.get(i).setQuotDate(DateConvertor.convertToDMY(enqHeaderRes.get(i).getQuotDate()));
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return enqHeaderRes;

	}

	@RequestMapping(value = { "/getChalanPendingReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GetChalanPendingReport> getChalanPendingReport(@RequestParam("custId") int custId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<GetChalanPendingReport> enqHeaderRes = new ArrayList<>();

		try {

			if (custId != 0) {
				enqHeaderRes = getChalanPendingRepo.getPendingChalanListByCustId(custId, fromDate, toDate);

			} else {

				enqHeaderRes = getChalanPendingRepo.getPendingChalanList(fromDate, toDate);

			}

			for (int i = 0; i < enqHeaderRes.size(); i++) {
				enqHeaderRes.get(i).setOrderDate(DateConvertor.convertToDMY(enqHeaderRes.get(i).getOrderDate()));
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return enqHeaderRes;

	}

	@RequestMapping(value = { "/getBillPendingReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPendingBillReport> getBillPendingReport(@RequestParam("custId") int custId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<GetPendingBillReport> enqHeaderRes = new ArrayList<>();

		try {

			if (custId != 0) {
				enqHeaderRes = getPendingBillReportRepo.getPendingBillListByCustId(custId, fromDate, toDate);

			} else {

				enqHeaderRes = getPendingBillReportRepo.getPendingBillList(fromDate, toDate);

			}

			for (int i = 0; i < enqHeaderRes.size(); i++) {
				enqHeaderRes.get(i).setOrderDate(DateConvertor.convertToDMY(enqHeaderRes.get(i).getOrderDate()));
				enqHeaderRes.get(i).setChalanDate(DateConvertor.convertToDMY(enqHeaderRes.get(i).getChalanDate()));
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return enqHeaderRes;

	}

}
