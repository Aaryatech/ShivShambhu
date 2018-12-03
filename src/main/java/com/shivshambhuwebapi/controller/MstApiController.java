package com.shivshambhuwebapi.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shivshambhuwebapi.master.model.Contractor;
import com.shivshambhuwebapi.master.model.GetItemTax;
import com.shivshambhuwebapi.master.model.ItemCategory;
import com.shivshambhuwebapi.master.model.RawMatItem;
import com.shivshambhuwebapi.master.model.Subplant;
import com.shivshambhuwebapi.master.model.VehicleType;
import com.shivshambhuwebapi.master.repo.ContractorRepo;
import com.shivshambhuwebapi.master.repo.GetItemTaxRepo;
import com.shivshambhuwebapi.master.repo.ItemCategoryRepo;
import com.shivshambhuwebapi.master.repo.RawMatItemRepo;
import com.shivshambhuwebapi.master.repo.SubplantRepo;
import com.shivshambhuwebapi.master.repo.VehicleTypeRepo;

@RestController
public class MstApiController {

	@Autowired
	GetItemTaxRepo getItemTaxRepo;

	@Autowired
	VehicleTypeRepo vehicleTypeRepo;

	@Autowired
	ContractorRepo contractorRepo;

	@Autowired
	SubplantRepo subplantRepo;

	@Autowired
	ItemCategoryRepo itemCategoryRepo;

	@Autowired
	RawMatItemRepo rawMatItemRepo;

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

	// ----------------Vehicle Type Master-------------------------------

	@RequestMapping(value = { "/getAllVehicleTypeList" }, method = RequestMethod.GET)
	public @ResponseBody List<VehicleType> getAllVehicleTypeList() {

		List<VehicleType> vehList = new ArrayList<VehicleType>();

		try {

			vehList = vehicleTypeRepo.findByDelStatusOrderByVehTypeIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return vehList;

	}

	// ----------------Contractor Master-------------------------------

	@RequestMapping(value = { "/getAllContractorList" }, method = RequestMethod.GET)
	public @ResponseBody List<Contractor> getAllContractorList() {

		List<Contractor> conList = new ArrayList<Contractor>();

		try {

			conList = contractorRepo.findByDelStatusOrderByContrIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return conList;

	}

	// ----------------Subplant Master-------------------------------

	@RequestMapping(value = { "/getAllSubPlantList" }, method = RequestMethod.GET)
	public @ResponseBody List<Subplant> getAllSubPlantList() {

		List<Subplant> subplantList = new ArrayList<Subplant>();

		try {

			subplantList = subplantRepo.findByDelStatusOrderBySubplantIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return subplantList;

	}

	// ----------------Itemcategory Master-------------------------------

	@RequestMapping(value = { "/getAllItemCategoryList" }, method = RequestMethod.GET)
	public @ResponseBody List<ItemCategory> getAllItemCategoryList() {

		List<ItemCategory> itemCatList = new ArrayList<ItemCategory>();

		try {

			itemCatList = itemCategoryRepo.findByDelStatusOrderByItemCatIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return itemCatList;

	}

	@RequestMapping(value = { "/getRawItemListByCatId" }, method = RequestMethod.POST)
	public @ResponseBody List<RawMatItem> getRawItemListByCatId(@RequestParam("catId") int catId) {

		List<RawMatItem> itemList = new ArrayList<RawMatItem>();

		try {

			itemList = rawMatItemRepo.findByCatIdAndDelStatus(catId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return itemList;

	}

	@RequestMapping(value = { "/getRawItemLByItemId" }, method = RequestMethod.POST)
	public @ResponseBody RawMatItem getRawItemLByItemId(@RequestParam("rmId") int rmId) {

		RawMatItem item = new RawMatItem();

		try {

			item = rawMatItemRepo.findByRmIdAndDelStatus(rmId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return item;

	}

}
