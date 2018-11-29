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

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.shivshambhuwebapi.master.model.CustType;
import com.shivshambhuwebapi.tx.model.GetEnqDetail;
import com.shivshambhuwebapi.tx.model.GetEnqHeader;
import com.shivshambhuwebapi.tx.model.GetItemWithEnq;
import com.shivshambhuwebapi.tx.model.GetQuotDetail;
import com.shivshambhuwebapi.tx.model.GetQuotHeader;
import com.shivshambhuwebapi.tx.model.GetQuotHeads;
import com.shivshambhuwebapi.tx.model.QuotDetail;
import com.shivshambhuwebapi.tx.model.QuotHeader;
import com.shivshambhuwebapi.tx.repo.GetItemWithEnqRepo;
import com.shivshambhuwebapi.tx.repo.GetQuotDetailRepo;
import com.shivshambhuwebapi.tx.repo.GetQuotHeaderRepo;
import com.shivshambhuwebapi.tx.repo.GetQuotHeadsRepo;
import com.shivshambhuwebapi.tx.repo.QuotDetailRepo;
import com.shivshambhuwebapi.tx.repo.QuotHeaderRepo;

@RestController
public class QuotController {

	@Autowired
	QuotHeaderRepo quotHeaderRepo;

	@Autowired
	QuotDetailRepo quotDetailRepo;

	@Autowired
	GetQuotDetailRepo getQuotDetailRepo;

	@Autowired
	GetQuotHeaderRepo getQuotHeaderRepo;

	@RequestMapping(value = { "/saveQuotHeaderAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody QuotHeader saveQuotHeaderAndDetail(@RequestBody QuotHeader quotHeader) {

		Info errorMessage = new Info();
		QuotHeader quotRes = new QuotHeader();

		try {

			quotRes = quotHeaderRepo.save(quotHeader);

			for (int i = 0; i < quotHeader.getQuotDetailList().size(); i++) {

				quotHeader.getQuotDetailList().get(i).setQuotHeadId(quotRes.getQuotHeadId());

			}
			List<QuotDetail> quotDetailsList = quotDetailRepo.saveAll(quotHeader.getQuotDetailList());
			quotRes.setQuotDetailList(quotDetailsList);

			errorMessage.setError(false);
			errorMessage.setMessage("successfully Saved ");

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("failed to Save ");

		}
		return quotRes;

	}

	@RequestMapping(value = { "/deleteQuotHeader" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteQuotHeader(@RequestParam("quotHeadId") int quotHeadId) {

		Info info = new Info();

		try {
			int delete = quotHeaderRepo.deleteQuotHeader(quotHeadId);

			if (delete == 1) {
				info.setError(false);
				info.setMessage("successfully Deleted");
			} else {
				info.setError(true);
				info.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" Deleted to Delete");

		}
		return info;

	}

	@RequestMapping(value = { "/deleteQuotDetail" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteQuotDetail(@RequestParam("quotDetailId") int quotDetailId) {

		Info info = new Info();

		try {
			int delete = quotDetailRepo.deleteQuotDetail(quotDetailId);

			if (delete == 1) {
				info.setError(false);
				info.setMessage("successfully Deleted");
			} else {
				info.setError(true);
				info.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" Deleted to Delete");

		}
		return info;

	}

	@RequestMapping(value = { "/getQuotHeaderByQuotHeadId" }, method = RequestMethod.POST)
	public @ResponseBody QuotHeader getQuotHeaderByQuotHeadId(@RequestParam("quotHeadId") int quotHeadId) {

		QuotHeader quotHeader = new QuotHeader();

		try {

			quotHeader = quotHeaderRepo.findByQuotHeadId(quotHeadId);
			List<QuotDetail> quotDetailList = quotDetailRepo.findByQuotHeadId(quotHeadId);
			quotHeader.setQuotDetailList(quotDetailList);
		} catch (Exception e) {

			e.printStackTrace();

		}
		return quotHeader;

	}

	// GetQuotHeads

	@Autowired
	GetQuotHeadsRepo getQuotHeadsRepo;

	@RequestMapping(value = { "/getQuotHeaders" }, method = RequestMethod.POST)
	public @ResponseBody List<GetQuotHeads> getQuotHeads(@RequestParam("statusList") List<String> statusList) {

		List<GetQuotHeads> quotHeadList = new ArrayList<GetQuotHeads>();

		try {

			quotHeadList = getQuotHeadsRepo.getQuotHeads(statusList);

		} catch (Exception e) {

			System.err.println("Exce in getting  quotHeadList" + quotHeadList.toString());

			e.printStackTrace();

		}
		return quotHeadList;

	}

	// SACHIN 15 NOV
	@Autowired
	GetItemWithEnqRepo getGetItemWithEnqRepo;

	@RequestMapping(value = { "/getItemsAndEnqItemList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetItemWithEnq> getGetItemWithEnq(@RequestParam("plantId") int plantId,
			@RequestParam("enqHeadId") int enqHeadId) {

		List<GetItemWithEnq> itemsAndEnqItemList = new ArrayList<GetItemWithEnq>();

		try {

			System.err.println("getItemsAndEnqItemList enqHeadId   " + enqHeadId + "plant Id  " + plantId);

			itemsAndEnqItemList = getGetItemWithEnqRepo.getGetItemWithEnq(plantId, enqHeadId);

		} catch (Exception e) {

			System.err.println("Exce in getting  itemsAndEnqItemList" + itemsAndEnqItemList.toString());

			e.printStackTrace();

		}
		return itemsAndEnqItemList;

	}

	@RequestMapping(value = { "/getQuotHeaderWithNameByQuotHeadId" }, method = RequestMethod.POST)
	public @ResponseBody GetQuotHeader getQuotHeaderWithNameByQuotHeadId(@RequestParam("quotHeadId") int quotHeadId) {

		GetQuotHeader quotHeader = new GetQuotHeader();

		try {

			quotHeader = getQuotHeaderRepo.getQuotHeaderByQuotHeadId(quotHeadId);
			List<GetQuotDetail> quotDetailList = getQuotDetailRepo.getQuotDetailByQuotHeadId(quotHeadId);
			quotHeader.setGetQuotDetailList(quotDetailList);
		} catch (Exception e) {

			e.printStackTrace();

		}
		return quotHeader;

	}

	@RequestMapping(value = { "/getAllQuotHeaderList" }, method = RequestMethod.GET)
	public @ResponseBody List<GetQuotHeader> getAllQuotHeaderList() {

		List<GetQuotHeader> getQuotHeaderList = new ArrayList<GetQuotHeader>();

		try {

			getQuotHeaderList = getQuotHeaderRepo.getQuotHeaderList();
			for (int i = 0; i < getQuotHeaderList.size(); i++) {

				List<GetQuotDetail> quotDetailList = getQuotDetailRepo
						.getQuotDetailByQuotHeadId(getQuotHeaderList.get(i).getQuotHeadId());

				getQuotHeaderList.get(i).setGetQuotDetailList(quotDetailList);
			}

			System.err.println("head " + getQuotHeaderList.toString());
		} catch (Exception e) {

			System.err.println("Exce in getting  getQuotHeaderList" + getQuotHeaderList.toString());

			e.printStackTrace();

		}
		return getQuotHeaderList;

	}

	@RequestMapping(value = { "/getQuotListByPlantIdAndCustId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetQuotHeader> getQuotListByPlantIdAndCustId(@RequestParam("plantId") int plantId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("custId") int custId) {

		List<GetQuotHeader> quotHeaderList = new ArrayList<GetQuotHeader>();

		try {

			if (custId == 0) {

				quotHeaderList = getQuotHeaderRepo.getQuotHeaderByPlantId(plantId, fromDate, toDate);
				for (int i = 0; i < quotHeaderList.size(); i++) {
					List<GetQuotDetail> quotDetailList = getQuotDetailRepo
							.getQuotDetailByQuotHeadId(quotHeaderList.get(i).getQuotHeadId());
					quotHeaderList.get(i).setGetQuotDetailList(quotDetailList);
				}
			} else {
				quotHeaderList = getQuotHeaderRepo.getQuotHeaderByPlantIdAndCustId(plantId, custId, fromDate, toDate);
				for (int i = 0; i < quotHeaderList.size(); i++) {
					List<GetQuotDetail> quotDetailList = getQuotDetailRepo
							.getQuotDetailByQuotHeadId(quotHeaderList.get(i).getQuotHeadId());

					quotHeaderList.get(i).setGetQuotDetailList(quotDetailList);
				}

			}
		} catch (Exception e) {

			e.printStackTrace();

		}
		return quotHeaderList;

	}

}
