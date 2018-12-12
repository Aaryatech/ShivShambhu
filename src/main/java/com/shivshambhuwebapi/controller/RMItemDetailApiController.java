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

import com.shivshambhuwebapi.master.model.OrderDetail;
import com.shivshambhuwebapi.master.model.OrderHeader;
import com.shivshambhuwebapi.model.prodrm.FgItemWiseRMReport;
import com.shivshambhuwebapi.model.prodrm.ItemDetail;
import com.shivshambhuwebapi.model.prodrm.ProdReportDetail;
import com.shivshambhuwebapi.model.prodrm.ProdReportHeader;
import com.shivshambhuwebapi.model.prodrm.ReqBomDetail;
import com.shivshambhuwebapi.model.prodrm.ReqBomHeader;
import com.shivshambhuwebapi.model.prodrm.RmReportDetail;
import com.shivshambhuwebapi.model.prodrm.RmReportHeader;
import com.shivshambhuwebapi.repository.prodrm.FgItemWiseRMReportRepo;
import com.shivshambhuwebapi.repository.prodrm.ItemDetailRepo;
import com.shivshambhuwebapi.repository.prodrm.ReqBomDetailRepo;
import com.shivshambhuwebapi.repository.prodrm.ReqBomHeaderRepo;
import com.shivshambhuwebapi.repository.prodrm.RmReportDetailRepo;
import com.shivshambhuwebapi.repository.prodrm.RmReportHeaderRepo;

@RestController
public class RMItemDetailApiController {
	
	@Autowired ItemDetailRepo itemDetailRepo;
	
	@Autowired ReqBomDetailRepo reqBomDetailRepo;
	@Autowired ReqBomHeaderRepo reqBomHeaderRepo;
	
	/*@RequestMapping(value = { "/getItemDetailByItemIds" }, method = RequestMethod.POST)
	public @ResponseBody List<ItemDetail> getItemDetailByItemIds(@RequestParam("delStatus") int delStatus,
			@RequestParam("itemIdList") List<Integer> itemIdList) {

		List<ItemDetail> itemDetList = new ArrayList<>();

		try {

			itemDetList = itemDetailRepo.findByDelStatusAndItemIdIn(delStatus, itemIdList);
			System.err.println("/getItemDetailByItemIds  @ RMItemDetailApiController " + itemDetList.toString());

		} catch (Exception e) {
			System.err.println("exce in getProdPlanHeadersBetDate " + e.getMessage());
			itemDetList = null;
			e.printStackTrace();

		}

		return itemDetList;

	}
	*/
	
	
	//insert saveBomHeaderDetail
	
	@RequestMapping(value = { "/saveBomHeaderDetail" }, method = RequestMethod.POST)
	public @ResponseBody ReqBomHeader saveOrder(@RequestBody ReqBomHeader bomHeader) {

		System.err.println("ReqBomHeader body " + bomHeader.toString());

		ReqBomHeader bomRes = null;

		try {

			bomRes = reqBomHeaderRepo.save(bomHeader);

			for (int i = 0; i < bomHeader.getReqBomDetailsList().size(); i++) {

				bomHeader.getReqBomDetailsList().get(i).setBomReqId(bomRes.getBomReqId());

			}

			List<ReqBomDetail> bomDetList = reqBomDetailRepo.saveAll(bomHeader.getReqBomDetailsList());

			bomRes.setReqBomDetailsList(bomDetList);

		} catch (Exception e) {

			System.err.println("exce in saving order head and detail " + e.getMessage());

			e.printStackTrace();

		}
		System.err.println("saveBomHeaderDetail Res{} body " + bomRes.toString());

		return bomRes;

	}
	
	
	@Autowired RmReportHeaderRepo getRmReportHeaderRepo;
	
	@RequestMapping(value = { "/getRmReportHeader" }, method = RequestMethod.POST)
	public @ResponseBody List<RmReportHeader> getRmReportHeader(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("plantId") int plantId) {

		List<RmReportHeader> rmReportHeader = new ArrayList<>();

		try {

			rmReportHeader = getRmReportHeaderRepo.getRmReportHeader(plantId, fromDate, toDate);
			System.err.println("rmReportHeader  /getProdReportHeader " + rmReportHeader.toString());

		} catch (Exception e) {
			System.err.println("exce in getRmReportHeader " + e.getMessage());
			rmReportHeader = null;
			e.printStackTrace();

		}

		return rmReportHeader;

	}
	
	@Autowired	RmReportDetailRepo getRmReportDetailRepo;
	
	@RequestMapping(value = { "/getRmReportDetail" }, method = RequestMethod.POST)
	public @ResponseBody List<RmReportDetail> getRmReportDetail(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("plantId") int plantId,
			@RequestParam("rmId") int rmId) {

		List<RmReportDetail> rmDetailReport = new ArrayList<>();

		try {
			rmDetailReport = getRmReportDetailRepo.getRmReportDetail(plantId, fromDate, toDate, rmId);
			System.err.println(" rmDetailReport List /getRmReportDetail " + rmDetailReport.toString());

		} catch (Exception e) {
			System.err.println("exce in getRmReportDetail " + e.getMessage());
			rmDetailReport = null;
			e.printStackTrace();

		}

		return rmDetailReport;

	}
	
	
	
	@Autowired FgItemWiseRMReportRepo getFgItemWiseRMReportRepo;
	
	@RequestMapping(value = { "/getFgItemWiseRMReport" }, method = RequestMethod.POST)
	public @ResponseBody List< FgItemWiseRMReport> getFgItemWiseRMReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("plantId") int plantId,
			@RequestParam("itemId") int itemId) {

		List< FgItemWiseRMReport> rmReport = new ArrayList<>();

		try {
			rmReport = getFgItemWiseRMReportRepo.getFgItemWiseRMReport(fromDate, toDate, plantId, itemId);
					
			System.err.println(" rmReport List /getRmReportDetail " + rmReport.toString());

		} catch (Exception e) {
			System.err.println("exce in getFgItemWiseRMReport " + e.getMessage());
			rmReport = null;
			e.printStackTrace();

		}

		return rmReport;

	}
	
	
	


}
