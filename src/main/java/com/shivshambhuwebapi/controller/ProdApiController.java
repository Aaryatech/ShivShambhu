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

import com.shivshambhuwebapi.model.prodrm.GetProdPlanDetail;
import com.shivshambhuwebapi.model.prodrm.GetProdPlanHeader;
import com.shivshambhuwebapi.model.prodrm.ProdPlanDetail;
import com.shivshambhuwebapi.model.prodrm.ProdPlanHeader;
import com.shivshambhuwebapi.repository.prodrm.GetProdPlanDetailRepo;
import com.shivshambhuwebapi.repository.prodrm.GetProdPlanHeaderRepo;
import com.shivshambhuwebapi.repository.prodrm.ProdPlanDetailRepo;
import com.shivshambhuwebapi.repository.prodrm.ProdPlanHeaderRepo;
import com.shivshambhuwebapi.tx.model.ChalanDetail;
import com.shivshambhuwebapi.tx.model.ChalanHeader;

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

	@RequestMapping(value = { "/saveProdPlanHeaderDetail" }, method = RequestMethod.POST)
	public @ResponseBody ProdPlanHeader saveProdPlanHeaderDetail(@RequestBody ProdPlanHeader planHeader) {

		System.err.println("header body " + planHeader.toString());

		ProdPlanHeader planHeadRes = new ProdPlanHeader();

		try {

			planHeadRes = prodPlanHeaderRepo.save(planHeader);

			for (int i = 0; i < planHeader.getProdPlanDetailList().size(); i++) {

				planHeader.getProdPlanDetailList().get(i).setProductionHeaderId((planHeadRes.getProductionHeaderId()));

			}

			List<ProdPlanDetail> prodPlanDetails = prodPlanDetailRepo.saveAll(planHeader.getProdPlanDetailList());

			planHeadRes.setProdPlanDetailList(prodPlanDetails);
			System.err.println("saveProdPlanHeaderDetail body " + planHeadRes.toString());

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

		List<GetProdPlanDetail> prodDetailList = new ArrayList<>();
		GetProdPlanHeader planHeader = new GetProdPlanHeader();

		try {

			planHeader = getProdPlanHeaderRepo.getGetProdPlanHeaderByProdId(prodHeaderId);

			prodDetailList = getProdPlanDetailRepo.getGetProdPlanDetailNByProdHeadId(prodHeaderId);
			System.err.println("prodDetailList  /getProdPlanDetail " + prodDetailList.toString());
			planHeader.setGetProdPlanDetList(prodDetailList);
		} catch (Exception e) {
			System.err.println("exce in getProdPlanDetail " + e.getMessage());
			prodDetailList = null;
			planHeader = null;
			e.printStackTrace();

		}

		return planHeader;

	}

	// complete Prod

	@RequestMapping(value = { "/completeProd" }, method = RequestMethod.POST)
	public @ResponseBody Info completeProd(@RequestBody  ProdPlanHeader planHeader) {

		Info info = new Info();

		try {

			int prodHeadUpdate = prodPlanHeaderRepo.completProd(planHeader.getProductionHeaderId(),
					planHeader.getProductionStatus(),planHeader.getProductionEndDate());

			if (prodHeadUpdate > 0) {

				info.setError(false);

				List<ProdPlanDetail> prodDetList = new ArrayList<>();

				prodDetList = planHeader.getProdPlanDetailList();
				int response = 0;
				for (int i = 0; i < prodDetList.size(); i++) {
					response = 0;
					ProdPlanDetail det = prodDetList.get(i);

					response=prodPlanDetailRepo.completProdDetail(det.getProductionDetailId(), det.getStatus(), det.getProductionQty(), det.getRejectedQty());

					if (response > 0) {

						info.setError(false);
					} else {

						info.setError(true);
					}
				} // end of for
			}

		} catch (Exception e) {
			System.err.println("exce in /completeProd  " +e.getMessage());
			e.printStackTrace();
		}
		return info;
	}
	

}
