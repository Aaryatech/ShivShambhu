package com.shivshambhuwebapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shivshambhuwebapi.master.model.AddItemDetail;
import com.shivshambhuwebapi.master.model.Contractor;
import com.shivshambhuwebapi.master.repo.GetOrderDetailRepo;
import com.shivshambhuwebapi.master.repo.RMMaterialRepo;
import com.shivshambhuwebapi.tx.repo.ChalanHeaderRepo;

public class RMMaterialApiController {
	
	
	@Autowired
	RMMaterialRepo rmmaterialRepo;
	
	@RequestMapping(value = { "/saveItemDetail" }, method = RequestMethod.POST)
	public @ResponseBody List<AddItemDetail> saveItemDetail(@RequestBody List<AddItemDetail> detailList ) {
		return rmmaterialRepo.saveAll( detailList);
	}
	
	
	
	
	
	

}
