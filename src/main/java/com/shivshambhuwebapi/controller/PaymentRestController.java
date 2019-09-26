package com.shivshambhuwebapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shivshambhuwebapi.master.model.OrderDetail;
import com.shivshambhuwebapi.master.model.OrderHeader; 
import com.shivshambhuwebapi.model.rec.GetPayRecoveryHeadData;
import com.shivshambhuwebapi.repo.rec.GetPayRecoveryHeadDataRepo;

@RestController
public class PaymentRestController {

	@Autowired
	GetPayRecoveryHeadDataRepo payRecoveryHeadDataRepo;
	
	@RequestMapping(value = { "/getPayHeaderByHeaderId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPayRecoveryHeadData> getPayHeaderByHeaderId(@RequestParam("payId") List<Integer> payId) {

		List<GetPayRecoveryHeadData> wList = new ArrayList<GetPayRecoveryHeadData>();
		
		try {

			wList = payRecoveryHeadDataRepo.getPayHeaderByHeaderId(payId);
			
		} catch (Exception e) {

			e.printStackTrace();

		}

		return wList;

	}

}
