package com.shivshambhuwebapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shivshambhuwebapi.tx.model.ChalanDetail;
import com.shivshambhuwebapi.tx.model.ChalanHeader;
import com.shivshambhuwebapi.tx.repo.ChalanDetailRepo;
import com.shivshambhuwebapi.tx.repo.ChalanHeaderRepo;

@RestController
public class ChalanApiController {
	
	@Autowired ChalanHeaderRepo chalanHeaderRepo;
	@Autowired ChalanDetailRepo chalanDetailRepo;
	
	@RequestMapping(value = { "/saveChalanHeaderDetail" }, method = RequestMethod.POST)
	public @ResponseBody ChalanHeader saveChalanHeaderDetail (@RequestBody ChalanHeader chHead) {

		ChalanHeader chHeaderRes = new ChalanHeader();
		
		try {

			chHeaderRes = chalanHeaderRepo.save(chHead);

			for (int i = 0; i < chHead.getChalanDetailList().size(); i++) {

				chHead.getChalanDetailList().get(i).setChalanId(chHeaderRes.getChalanId());

			}

			List<ChalanDetail> chalanDetList = chalanDetailRepo.saveAll(chHead.getChalanDetailList());
			chHeaderRes.setChalanDetailList(chalanDetList);


		} catch (Exception e) {

			System.err.println("Exce in saving chalan " +e.getMessage());
			e.printStackTrace();
		}
		
		return chHeaderRes;

	}

}
