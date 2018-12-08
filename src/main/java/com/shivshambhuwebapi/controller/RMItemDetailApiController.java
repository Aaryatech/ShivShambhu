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
import com.shivshambhuwebapi.model.prodrm.ItemDetail;
import com.shivshambhuwebapi.model.prodrm.ReqBomDetail;
import com.shivshambhuwebapi.model.prodrm.ReqBomHeader;
import com.shivshambhuwebapi.repository.prodrm.ItemDetailRepo;
import com.shivshambhuwebapi.repository.prodrm.ReqBomDetailRepo;
import com.shivshambhuwebapi.repository.prodrm.ReqBomHeaderRepo;

@RestController
public class RMItemDetailApiController {
	
	@Autowired ItemDetailRepo itemDetailRepo;
	
	@Autowired ReqBomDetailRepo reqBomDetailRepo;
	@Autowired ReqBomHeaderRepo reqBomHeaderRepo;
	
	@RequestMapping(value = { "/getItemDetailByItemIds" }, method = RequestMethod.POST)
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
	


}
