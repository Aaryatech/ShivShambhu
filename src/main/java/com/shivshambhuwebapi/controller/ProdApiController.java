package com.shivshambhuwebapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shivshambhuwebapi.model.prodrm.ProdPlanDetail;
import com.shivshambhuwebapi.model.prodrm.ProdPlanHeader;
import com.shivshambhuwebapi.repository.prodrm.ProdPlanDetailRepo;
import com.shivshambhuwebapi.repository.prodrm.ProdPlanHeaderRepo;

@RestController
public class ProdApiController {
	
	@Autowired
	ProdPlanHeaderRepo prodPlanHeaderRepo;

	@Autowired
	ProdPlanDetailRepo prodPlanDetailRepo;
	
	@RequestMapping(value = { "/saveProdPlanHeaderDetail" }, method = RequestMethod.POST)
	public @ResponseBody ProdPlanHeader saveProdPlanHeaderDetail(@RequestBody ProdPlanHeader planHeader) {

		System.err.println("header body " + planHeader.toString());

		ProdPlanHeader planHeadRes=new ProdPlanHeader();

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

}
