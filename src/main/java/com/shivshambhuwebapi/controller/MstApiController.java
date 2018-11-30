package com.shivshambhuwebapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shivshambhuwebapi.master.model.GetItemTax;
import com.shivshambhuwebapi.master.repo.GetItemTaxRepo;

@RestController
public class MstApiController {

	@Autowired
	GetItemTaxRepo getItemTaxRepo;

	@RequestMapping(value = { "/getAllItemTaxList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetItemTax> getAllItemTaxList(@RequestParam("plantId") int plantId) {

		List<GetItemTax> itemList = new ArrayList<GetItemTax>();

		try {

			itemList = getItemTaxRepo.getItemListByPlantId(plantId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return itemList;

	}

}
