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

import com.shivshambhuwebapi.model.prodrm.GetItemDetail;
import com.shivshambhuwebapi.model.prodrm.GetProdPlanDetail;
import com.shivshambhuwebapi.model.prodrm.GetProdPlanHeader;
import com.shivshambhuwebapi.model.prodrm.ProdPlanDetail;
import com.shivshambhuwebapi.model.prodrm.ProdPlanHeader;
import com.shivshambhuwebapi.model.prodrm.ProdReportDetail;
import com.shivshambhuwebapi.model.prodrm.ProdReportHeader;
import com.shivshambhuwebapi.repository.prodrm.GetItemDetailRepo;
import com.shivshambhuwebapi.repository.prodrm.GetProdPlanDetailRepo;
import com.shivshambhuwebapi.repository.prodrm.GetProdPlanHeaderRepo;
import com.shivshambhuwebapi.repository.prodrm.ProdPlanDetailRepo;
import com.shivshambhuwebapi.repository.prodrm.ProdPlanHeaderRepo;
import com.shivshambhuwebapi.repository.prodrm.ProdReportDetailRepo;
import com.shivshambhuwebapi.repository.prodrm.ProdReportHeaderRepo;

@RestController
public class ProdApiController {

	@Autowired
	ProdPlanHeaderRepo prodPlanHeaderRepo;

	@Autowired
	ProdPlanDetailRepo prodPlanDetailRepo;

	@Autowired
	GetProdPlanHeaderRepo getProdPlanHeaderRepo;

	@Autowired
	GetProdPlanDetailRepo getProdPlanDetailRepo;

	@Autowired
	GetItemDetailRepo getItemDetailRepo;// for auto bill of material

	@Autowired
	ProdReportHeaderRepo getProdReportHeaderRepo;

	@Autowired
	ProdReportDetailRepo getProdReportDetailRepo;

	@RequestMapping(value = { "/saveProdPlanHeaderDetail" }, method = RequestMethod.POST)
	public @ResponseBody ProdPlanHeader saveProdPlanHeaderDetail(@RequestBody ProdPlanHeader planHeader) {

		System.err.println("header body " + planHeader.toString());

		ProdPlanHeader planHeadRes = new ProdPlanHeader();

		try {

			planHeadRes = prodPlanHeaderRepo.save(planHeader);

			for (int i = 0; i < planHeader.getProdPlanDetailList().size(); i++) {

				planHeader.getProdPlanDetailList().get(i).setProductionHeaderId((planHeadRes.getProductionHeaderId()));
				planHeader.getProdPlanDetailList().get(i).setProductionBatch("" + planHeadRes.getProductionHeaderId()
						+ "-" + planHeader.getProdPlanDetailList().get(i).getItemId());

			}

			List<ProdPlanDetail> prodPlanDetails = prodPlanDetailRepo.saveAll(planHeader.getProdPlanDetailList());

			planHeadRes.setProdPlanDetailList(prodPlanDetails);
			System.err.println("saveProdPlanHeaderDetail body " + planHeadRes.toString());
			planHeadRes.setProductionBatch(
					"" + planHeadRes.getProductionHeaderId() + "-" + planHeadRes.getProductionDate());
			planHeadRes = prodPlanHeaderRepo.save(planHeadRes);

		} catch (Exception e) {
			System.err.println("exce in saving saveProdPlanHeaderDetail " + e.getMessage());

			e.printStackTrace();

		}

		return planHeadRes;

	}

	@RequestMapping(value = { "/getProdPlanHeadersBetDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetProdPlanHeader> getProdPlanHeadersBetDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("plantId") int plantId) {

		List<GetProdPlanHeader> prodHeadList = new ArrayList<>();

		try {

			prodHeadList = getProdPlanHeaderRepo.getGetProdPlanHeaderByProdDateBet(fromDate, toDate, plantId);
			System.err.println("prodHeadList  /getProdPlanHeadersBetDate " + prodHeadList.toString());

		} catch (Exception e) {
			System.err.println("exce in getProdPlanHeadersBetDate " + e.getMessage());
			prodHeadList = null;
			e.printStackTrace();

		}

		return prodHeadList;

	}

	@RequestMapping(value = { "/getProdPlanDetail" }, method = RequestMethod.POST)
	public @ResponseBody GetProdPlanHeader getProdPlanDetail(@RequestParam("prodHeaderId") int prodHeaderId) {

		List<GetProdPlanDetail> prodDetailList = new ArrayList<GetProdPlanDetail>();
		GetProdPlanHeader planHeader = new GetProdPlanHeader();

		try {

			planHeader = getProdPlanHeaderRepo.getGetProdPlanHeaderByProdId(prodHeaderId);

			prodDetailList = getProdPlanDetailRepo.getGetProdPlanDetailNByProdHeadId(prodHeaderId);
			System.err.println("prodDetailList  /getProdPlanDetail " + prodDetailList.toString());
			planHeader.setGetProdPlanDetList(prodDetailList);
		} catch (Exception e) {
			System.err.println("exce in getProdPlanDetail " + e.getMessage());

			e.printStackTrace();

		}

		return planHeader;

	}

	// complete Prod

	@RequestMapping(value = { "/completeProd" }, method = RequestMethod.POST)
	public @ResponseBody Info completeProd(@RequestBody ProdPlanHeader planHeader) {

		Info info = new Info();

		try {

			int prodHeadUpdate = prodPlanHeaderRepo.completProd(planHeader.getProductionHeaderId(),
					planHeader.getProductionStatus(), planHeader.getProductionEndDate());

			if (prodHeadUpdate > 0) {

				info.setError(false);

				List<ProdPlanDetail> prodDetList = new ArrayList<>();

				prodDetList = planHeader.getProdPlanDetailList();
				int response = 0;
				for (int i = 0; i < prodDetList.size(); i++) {
					response = 0;
					ProdPlanDetail det = prodDetList.get(i);

					response = prodPlanDetailRepo.completProdDetail(det.getProductionDetailId(), det.getStatus(),
							det.getProductionQty(), det.getRejectedQty());

					if (response > 0) {

						info.setError(false);
					} else {

						info.setError(true);
					}
				} // end of for
			}

		} catch (Exception e) {
			System.err.println("exce in /completeProd  " + e.getMessage());
			e.printStackTrace();
		}
		return info;
	}

	@RequestMapping(value = { "/getItemDetailForBOM" }, method = RequestMethod.POST)
	public @ResponseBody List<GetItemDetail> getItemDetailForBOM(@RequestParam("prodHeaderId") int prodHeaderId) {

		List<GetItemDetail> itemDetList = new ArrayList<>();

		try {
			itemDetList = getItemDetailRepo.getGetItemDetail(prodHeaderId);

		} catch (Exception e) {
			System.err.println("exce in getItemDetailForBOM " + e.getMessage());
			itemDetList = null;
			e.printStackTrace();

		}

		return itemDetList;

	}

//Report Prod Header

	// getProdReportHeaderRepo

	@RequestMapping(value = { "/getProdReportHeader" }, method = RequestMethod.POST)
	public @ResponseBody List<ProdReportHeader> getProdReportHeader(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("plantId") int plantId) {

		List<ProdReportHeader> prodReportHeader = new ArrayList<>();

		try {

			prodReportHeader = getProdReportHeaderRepo.getProdReportHeader(plantId, fromDate, toDate);
			System.err.println("prodHeadList  /getProdReportHeader " + prodReportHeader.toString());

		} catch (Exception e) {
			System.err.println("exce in getProdReportHeader " + e.getMessage());
			prodReportHeader = null;
			e.printStackTrace();

		}

		return prodReportHeader;

	}

	// ProdReportDetailRepo

	@RequestMapping(value = { "/getProdReportDetail" }, method = RequestMethod.POST)
	public @ResponseBody List<ProdReportDetail> getProdReportDetail(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("plantId") int plantId,
			@RequestParam("itemId") int itemId) {

		List<ProdReportDetail> prodDetailReport = new ArrayList<>();

		try {

			prodDetailReport = getProdReportDetailRepo.getProdReportDetail(plantId, fromDate, toDate, itemId);
			System.err.println("getProdReportDetail  /getProdReportDetail " + prodDetailReport.toString());

		} catch (Exception e) {
			System.err.println("exce in getProdReportDetail " + e.getMessage());
			prodDetailReport = null;
			e.printStackTrace();

		}

		return prodDetailReport;

	}

	@RequestMapping(value = { "/deleteMultiProdPlan" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiProdPlan(@RequestParam("prodHeaderIds") List<Integer> prodHeaderIds) {

		Info info = new Info();

		try {
			int delete = prodPlanHeaderRepo.deleteMultiProdPlanHeader(prodHeaderIds);

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

}
