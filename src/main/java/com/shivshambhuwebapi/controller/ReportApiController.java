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
import com.shivshambhuwebapi.model.bill.GetBillHeader;
import com.shivshambhuwebapi.model.bill.GetBillReport;
import com.shivshambhuwebapi.repository.GetBillReportRepo;
import com.shivshambhuwebapi.tx.model.GetMatIssueDetail;
import com.shivshambhuwebapi.tx.model.GetMatIssueHeader;
import com.shivshambhuwebapi.tx.model.GetMatIssueReport;
import com.shivshambhuwebapi.tx.model.GetVehDetail;
import com.shivshambhuwebapi.tx.model.GetVehHeader;
import com.shivshambhuwebapi.tx.model.GetVehReport;
import com.shivshambhuwebapi.tx.model.PoklenReport;
import com.shivshambhuwebapi.tx.repo.GetMatIssueDetailRepo;
import com.shivshambhuwebapi.tx.repo.GetMatIssueHeaderRepo;
import com.shivshambhuwebapi.tx.repo.GetMatIssueReportRepo;
import com.shivshambhuwebapi.tx.repo.GetVehDetailRepo;
import com.shivshambhuwebapi.tx.repo.GetVehHeaderRepo;
import com.shivshambhuwebapi.tx.repo.GetVehReportRepo;
import com.shivshambhuwebapi.tx.repo.PoklenReportRepo;

@RestController
public class ReportApiController {

	@Autowired
	GetMatIssueReportRepo getMatIssueReportrepo;

	@Autowired
	GetMatIssueDetailRepo getMatIssueDetailRepo;

	@Autowired
	GetVehReportRepo getVehReportRepo;

	@Autowired
	GetVehDetailRepo getVehDetailRepo;

	@Autowired
	PoklenReportRepo poklenReportRepo;

	@Autowired
	GetBillReportRepo getBillReportRepo;

	@RequestMapping(value = { "/getContractorBetweenDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetMatIssueReport> getContractorBetweenDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<GetMatIssueReport> headerList = new ArrayList<GetMatIssueReport>();

		try {

			headerList = getMatIssueReportrepo.getContrBetweenDate(fromDate, toDate);

			for (int i = 0; i < headerList.size(); i++) {
				headerList.get(i).setDate(DateConvertor.convertToDMY(headerList.get(i).getDate()));

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return headerList;

	}

	@RequestMapping(value = { "/getVehicleBetweenDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetVehReport> getVehicleBetweenDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<GetVehReport> headerList = new ArrayList<GetVehReport>();

		try {

			headerList = getVehReportRepo.getVehicleBetweenDate(fromDate, toDate);

			for (int i = 0; i < headerList.size(); i++) {
				headerList.get(i).setDate(DateConvertor.convertToDMY(headerList.get(i).getDate()));
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return headerList;

	}

	@RequestMapping(value = { "/getPoklenReportBetweenDate" }, method = RequestMethod.POST)
	public @ResponseBody List<PoklenReport> getPoklenReportBetweenDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<PoklenReport> headerList = new ArrayList<PoklenReport>();

		try {

			headerList = poklenReportRepo.getPoklenReportBetweenDate(fromDate, toDate);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return headerList;

	}

	@RequestMapping(value = { "/getBillwiseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GetBillReport> getBillwiseReport(@RequestParam("plantIdList") List<Integer> plantIdList,
			@RequestParam("companyIdList") List<Integer> companyIdList, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {
System.err.println("plantIdList " +plantIdList + "companyIdList " +companyIdList + "fromDate" +fromDate + "toDate" +toDate);
		List<GetBillReport> billHeaderRes = new ArrayList<>();

		try {

			if (plantIdList.contains(0) && companyIdList.contains(0)) {

				billHeaderRes = getBillReportRepo.getBillHeadersBetDate(fromDate, toDate);

				System.err.println("billHeaderRes" +billHeaderRes.toString());
				System.out.println("billHeaderRes" + billHeaderRes.toString());

			} else if (!plantIdList.contains(0) && companyIdList.contains(0)) {
				billHeaderRes = getBillReportRepo.getBillHeadersBetDateANdPlantIdList(plantIdList, fromDate, toDate);

				System.out.println("billHeaderRes" + billHeaderRes.toString());
			} else if (plantIdList.contains(0) && !companyIdList.contains(0)) {
				billHeaderRes = getBillReportRepo.getBillHeadersBetDateANdCompIdList(companyIdList, fromDate, toDate);
				System.out.println("billHeaderRes" + billHeaderRes.toString());
			} else {

				billHeaderRes = getBillReportRepo.getBillHeadersBetDateANdIdList(plantIdList, companyIdList, fromDate,
						toDate);
				System.out.println("billHeaderRes" + billHeaderRes.toString());
			}

			for (int i = 0; i < billHeaderRes.size(); i++) {
				billHeaderRes.get(i).setBillDate(DateConvertor.convertToDMY(billHeaderRes.get(i).getBillDate()));
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return billHeaderRes;

	}

}
