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
import com.shivshambhuwebapi.model.prodrm.RmcQuotItemDetail;
import com.shivshambhuwebapi.repository.rmc.RmcQuotItemDetailRepo;
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
	
	@Autowired RmcQuotItemDetailRepo getRmcQuotItemDetailRepo;//3 Jan 2018
	
	@RequestMapping(value = { "/getRmcQuotItemDetail" }, method = RequestMethod.POST)
	public @ResponseBody List<RmcQuotItemDetail> getRmcQuotItemDetail(@RequestParam("itemId") int itemId) {

		List<RmcQuotItemDetail> rmcItemDetail = new ArrayList<RmcQuotItemDetail>();

		try {

			rmcItemDetail = getRmcQuotItemDetailRepo.getRmcQuotItemDetail(itemId);
		} catch (Exception e) {

			System.err.println("Exce in getting  getRmcQuotItemDetail" + rmcItemDetail.toString());

			e.printStackTrace();

		}
		return rmcItemDetail;

	}

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
	public @ResponseBody Info deleteQuotDetail(@RequestParam("quotHeadId") int quotHeadId,
			@RequestParam("itemId") int itemId) {

		Info info = new Info();

		try {
			int delete = quotDetailRepo.deleteQuotDetail(quotHeadId, itemId);

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

			if (custId == 0 && plantId != 0) {

				quotHeaderList = getQuotHeaderRepo.getQuotHeaderByPlantId(plantId, fromDate, toDate);

			} else {
				quotHeaderList = getQuotHeaderRepo.getQuotHeaderByPlantIdAndCustId(plantId, custId, fromDate, toDate);

			}
			for (int i = 0; i < quotHeaderList.size(); i++) {
				List<GetQuotDetail> quotDetailList = getQuotDetailRepo
						.getQuotDetailByQuotHeadId(quotHeaderList.get(i).getQuotHeadId());

				quotHeaderList.get(i).setGetQuotDetailList(quotDetailList);
			}
		} catch (Exception e) {

			e.printStackTrace();

		}
		return quotHeaderList;

	}

	// status=0
	@RequestMapping(value = { "/getQuotListDashById" }, method = RequestMethod.POST)
	public @ResponseBody List<GetQuotHeader> getQuotListDashById(@RequestParam("plantId") int plantId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<GetQuotHeader> quotHeaderList = new ArrayList<GetQuotHeader>();

		try {
			if (plantId == 0) {
				quotHeaderList = getQuotHeaderRepo.getQuotHeader(fromDate, toDate);
			} else {
				quotHeaderList = getQuotHeaderRepo.getQuotHeaderByPlantIdAndStatus0(fromDate, toDate, plantId);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return quotHeaderList;

	}

	// status=1
	@RequestMapping(value = { "/getQuotListDashByStatus1" }, method = RequestMethod.POST)
	public @ResponseBody List<GetQuotHeader> getQuotListDashByStatus1(@RequestParam("plantId") int plantId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<GetQuotHeader> quotHeaderList = new ArrayList<GetQuotHeader>();

		try {
			if (plantId == 0) {
				quotHeaderList = getQuotHeaderRepo.getQuotHeaderByStatus1(fromDate, toDate);
			} else {
				quotHeaderList = getQuotHeaderRepo.getQuotHeaderByPlantIdByStatus1(plantId, fromDate, toDate);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return quotHeaderList;

	}

	@RequestMapping(value = { "/getQuotListByPlantIdAndCustIdStatus" }, method = RequestMethod.POST)
	public @ResponseBody List<GetQuotHeader> getQuotListByPlantIdAndCustIdStatus(@RequestParam("plantId") int plantId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("custId") int custId, @RequestParam("status") int status) {

		List<GetQuotHeader> quotHeaderList = new ArrayList<GetQuotHeader>();

		try {

			if (custId == 0 && status == -1) {

				quotHeaderList = getQuotHeaderRepo.getQuotHeaderByPlantId(plantId, fromDate, toDate);
				for (int i = 0; i < quotHeaderList.size(); i++) {
					List<GetQuotDetail> quotDetailList = getQuotDetailRepo
							.getQuotDetailByQuotHeadId(quotHeaderList.get(i).getQuotHeadId());
					quotHeaderList.get(i).setGetQuotDetailList(quotDetailList);
				}
			} else if (custId == 0 && status != -1) {
				quotHeaderList = getQuotHeaderRepo.getQuotHeaderByPlantIdAndCustId(plantId, fromDate, toDate, status);
				for (int i = 0; i < quotHeaderList.size(); i++) {
					List<GetQuotDetail> quotDetailList = getQuotDetailRepo
							.getQuotDetailByQuotHeadId(quotHeaderList.get(i).getQuotHeadId());

					quotHeaderList.get(i).setGetQuotDetailList(quotDetailList);
				}

			} else if (status == -1 && custId != 0) {

				quotHeaderList = getQuotHeaderRepo.getQuotHeaderByPlantIdAndCustId(plantId, custId, fromDate, toDate);
				for (int i = 0; i < quotHeaderList.size(); i++) {
					List<GetQuotDetail> quotDetailList = getQuotDetailRepo
							.getQuotDetailByQuotHeadId(quotHeaderList.get(i).getQuotHeadId());
					quotHeaderList.get(i).setGetQuotDetailList(quotDetailList);
				}

			} else if (status != -1 && custId != 0) {

				quotHeaderList = getQuotHeaderRepo.getQuotHeaderByPlantId(plantId, custId, fromDate, toDate, status);
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

	@RequestMapping(value = { "/updateQuotation" }, method = RequestMethod.POST)
	public @ResponseBody Info updateQuotation(@RequestParam("quotHeadId") int quotHeadId,
			@RequestParam("payTermId") int payTermId, @RequestParam("quotDate") String quotDate,
			@RequestParam("otherRemark1") String otherRemark1, @RequestParam("projId") int projId,
			@RequestParam("quotTermId") int quotTermId) {

		Info info = new Info();

		try {
			int delete = quotHeaderRepo.updateQuotation(quotHeadId, payTermId, quotDate, otherRemark1, projId,
					quotTermId);

			if (delete == 1) {
				info.setError(false);
				info.setMessage("successfully Updated");
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

	@RequestMapping(value = { "/deleteMultiQuot" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiQuot(@RequestParam("quotIds") List<Integer> quotIds) {

		Info info = new Info();

		try {
			int delete = quotHeaderRepo.deleteMultiQuotDetail(quotIds);

			if (delete >= 1) {
				info.setError(false);
				info.setMessage("successfully Multiple Deleted");
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

	// Android_26-12-2018
	@RequestMapping(value = { "/getQuotListByPlantIdAndCustIdAndStatusList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetQuotHeader> getQuotListByPlantIdAndCustIdAndStatus(
			@RequestParam("plantId") int plantId, @RequestParam("custId") int custId,
			@RequestParam("statusList") List<String> statusList) {

		List<GetQuotHeader> quotHeaderList = new ArrayList<GetQuotHeader>();

		try {

			if (custId == 0) {

				quotHeaderList = getQuotHeaderRepo.getQuotHeaderByPlantIdAndStatusAndAllCust(plantId, statusList);
				for (int i = 0; i < quotHeaderList.size(); i++) {
					List<GetQuotDetail> quotDetailList = getQuotDetailRepo
							.getQuotDetailByQuotHeadId(quotHeaderList.get(i).getQuotHeadId());
					quotHeaderList.get(i).setGetQuotDetailList(quotDetailList);
				}
			} else {
				quotHeaderList = getQuotHeaderRepo.getQuotHeaderByPlantIdAndStatusAndCust(plantId, statusList, custId);
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

	/*
	 * @RequestMapping(value = { "/getAllQuotHeaderListDesc" }, method =
	 * RequestMethod.GET) public @ResponseBody
	 * List<GetQuotHeader>getAllQuotHeaderListDesc() {
	 * 
	 * List<GetQuotHeader> getQuotHeaderList = new ArrayList<GetQuotHeader>();
	 * 
	 * try {
	 * 
	 * getQuotHeaderList = getQuotHeaderRepo.getQuotHeaderList(); for (int i = 0; i
	 * < getQuotHeaderList.size(); i++) {
	 * 
	 * List<GetQuotDetail> quotDetailList = getQuotDetailRepo
	 * .getQuotDetailOrderByQuotHeadIdDesc(getQuotHeaderList.get(i).getQuotHeadId())
	 * ;
	 * 
	 * getQuotHeaderList.get(i).setGetQuotDetailList(quotDetailList); }
	 * 
	 * System.err.println("head " + getQuotHeaderList.toString()); } catch
	 * (Exception e) {
	 * 
	 * System.err.println("Exce in getting  getQuotHeaderList" +
	 * getQuotHeaderList.toString());
	 * 
	 * e.printStackTrace();
	 * 
	 * } return getQuotHeaderList;
	 * 
	 * }
	 * 
	 */

	@RequestMapping(value = { "/getQuotListByPlantIdAndCustIdAndStatus" }, method = RequestMethod.POST)
	public @ResponseBody List<GetQuotHeader> getQuotListByPlantIdAndCustIdAndStatus(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("plantId") int plantId, @RequestParam("custId") int custId,
			@RequestParam("statusList") List<Integer> statusList) {

		List<GetQuotHeader> quotHeaderList = new ArrayList<GetQuotHeader>();

		if (statusList.contains(-1)) {
			statusList.clear();
			statusList.add(0);
			statusList.add(1);
			statusList.add(2);
		}

		try {

			if (custId == 0 && plantId != 0) {

				quotHeaderList = getQuotHeaderRepo.getQuotHeaderByPlantIdAndStatus(fromDate, toDate, plantId,
						statusList);

			} else if (custId != 0 && plantId == 0) {

				quotHeaderList = getQuotHeaderRepo.getQuotHeaderByCustIdAndStatus(fromDate, toDate, custId, statusList);

			} else if (custId != 0 && plantId != 0) {

				System.out.println("--------------------------------------------- custId : " + custId
						+ "        plantID : " + plantId);

				quotHeaderList = getQuotHeaderRepo.getQuotHeaderByCustIdAndCustIdStatus(fromDate, toDate, custId,
						plantId, statusList);

			} else if (custId == 0 && plantId == 0) {
				quotHeaderList = getQuotHeaderRepo.getQuotHeaderByDateAndStatus(fromDate, toDate, statusList);

			}

			/*
			 * if (custId == 0 && plantId != 0 && !statusList.contains(0)) {
			 * 
			 * quotHeaderList = getQuotHeaderRepo.getQuotHeaderByPlantIdAndStatus(fromDate,
			 * toDate, plantId, statusList);
			 * 
			 * } else if (custId != 0 && plantId == 0 && !statusList.contains(0)) {
			 * 
			 * quotHeaderList = getQuotHeaderRepo.getQuotHeaderByCustIdAndStatus(fromDate,
			 * toDate, custId, statusList);
			 * 
			 * } else if (custId != 0 && plantId != 0 && !statusList.contains(0)) {
			 * 
			 * quotHeaderList =
			 * getQuotHeaderRepo.getQuotHeaderByCustIdAndCustIdStatus(fromDate, toDate,
			 * plantId, custId, statusList);
			 * 
			 * } else { quotHeaderList = getQuotHeaderRepo.getQuotHeaderByStatus(fromDate,
			 * toDate);
			 * 
			 * }
			 */

		} catch (Exception e) {

			e.printStackTrace();

		}
		return quotHeaderList;

	}

}
