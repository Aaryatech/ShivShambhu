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

import com.shivshambhuwebapi.master.model.AddItemDetail;
import com.shivshambhuwebapi.master.model.GetExistingItemDetail;

import com.shivshambhuwebapi.master.repo.GetItemExistingDetailRepo;
import com.shivshambhuwebapi.master.repo.GetOrderDetailRepo;
import com.shivshambhuwebapi.master.repo.RMMaterialRepo;
import com.shivshambhuwebapi.model.bill.GetBillReport;
import com.shivshambhuwebapi.tx.repo.ChalanHeaderRepo;

@RestController
public class RMMaterialApiController {
	
	
	@Autowired
	RMMaterialRepo rmmaterialRepo;
	
	@Autowired
	private GetItemExistingDetailRepo   getExistingItemDetailRepo;
	
	
	@RequestMapping(value = { "/saveItemDetail" }, method = RequestMethod.POST)
	public @ResponseBody List<AddItemDetail> saveItemDetail(@RequestBody List<AddItemDetail> detailList ) {
		System.out.println("inside");
		
		 List<AddItemDetail> itemDList=new ArrayList<>();
		 
		 try {
			 itemDList=rmmaterialRepo.saveAll( detailList);
			 
		 }catch (Exception e) {
			System.err.println("Exc in ad Item Detail "+e.getMessage());
		}
		return itemDList;
	}
	
	
	@RequestMapping(value = { "/getItemDetailByItemDetailId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetExistingItemDetail> getBillDetailByCustId(@RequestParam("itemId") int itemId) {

		List<GetExistingItemDetail> billHeaderRes = new ArrayList<>();

		try {

			billHeaderRes =  getExistingItemDetailRepo.getItemDetailByItemId(itemId);

			
		} catch (Exception e) {

			e.printStackTrace();

		}

		return billHeaderRes;

	}
	
	
	
	

}
