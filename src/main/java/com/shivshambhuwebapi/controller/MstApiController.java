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

import com.shivshambhuwebapi.master.model.Contractor;
import com.shivshambhuwebapi.master.model.GetItemTax;
import com.shivshambhuwebapi.master.model.GetRawMatItem;
import com.shivshambhuwebapi.master.model.GetsubplantData;
import com.shivshambhuwebapi.master.model.ItemCategory;
import com.shivshambhuwebapi.master.model.ItemType;
import com.shivshambhuwebapi.master.model.OrderDetail;
import com.shivshambhuwebapi.master.model.OrderHeader;
import com.shivshambhuwebapi.master.model.RawMatItem;
import com.shivshambhuwebapi.master.model.Subplant;
import com.shivshambhuwebapi.master.model.Vehicle;
import com.shivshambhuwebapi.master.model.VehicleType;
import com.shivshambhuwebapi.master.repo.ContractorRepo;
import com.shivshambhuwebapi.master.repo.GetItemTaxRepo;
import com.shivshambhuwebapi.master.repo.GetOrderDetailRepo;
import com.shivshambhuwebapi.master.repo.GetRawMatItemRepo;
import com.shivshambhuwebapi.master.repo.ItemCategoryRepo;
import com.shivshambhuwebapi.master.repo.ItemTypeRepo;
import com.shivshambhuwebapi.master.repo.RawMatItemRepo;
import com.shivshambhuwebapi.master.repo.SubplantRepo;
import com.shivshambhuwebapi.master.repo.VehicleRepo;
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

	@Autowired
	VehicleRepo vehicleRepo;

	@Autowired
	ItemTypeRepo itemTypeRepo;

	@Autowired
	GetRawMatItemRepo getRawMatItemRepo;

	// ----------------Contractor Master-------------------------------

	@Autowired
	GetOrderDetailRepo getOrderDetailRepo;

	@RequestMapping(value = { "/saveContractor" }, method = RequestMethod.POST)
	public @ResponseBody Contractor saveContractor(@RequestBody Contractor con) {
		return contractorRepo.save(con);
	}

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

	@RequestMapping(value = { "/getContractorById" }, method = RequestMethod.POST)
	public @ResponseBody Contractor getContractorById(@RequestParam("contrId") int contrId) {

		Contractor res = new Contractor();

		try {

			res = contractorRepo.findByContrIdAndDelStatus(contrId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/deleteContractor" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteContractor(@RequestParam("contrId") int contrId) {

		int isDeleted = contractorRepo.deleteContractor(contrId);
		Info infoRes = new Info();
		if (isDeleted >= 1) {
			infoRes.setError(false);
			infoRes.setMessage("Contractor Deleted Successfully");
		} else {
			infoRes.setError(true);
			infoRes.setMessage("Contractor Deletion Failed");
		}
		return infoRes;
	}

	@RequestMapping(value = { "/deleteMultiContractor" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiQuot(@RequestParam("contrIds") List<Integer> contrIds) {

		Info info = new Info();

		try {
			int delete = contractorRepo.deleteMultiContDetail(contrIds);

			if (delete >= 1) {
				info.setError(false);
				info.setMessage("successfully Multiple Deleted");
			} else {
				info.setError(true);
				info.setMessage(" Failed to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" Failed to Delete");

		}
		return info;

	}

	// ----------------Vehicle Master-------------------------------

	@RequestMapping(value = { "/saveVehicle" }, method = RequestMethod.POST)
	public @ResponseBody Vehicle saveVehicle(@RequestBody Vehicle veh) {
		return vehicleRepo.save(veh);
	}

	@RequestMapping(value = { "/getAllVehicleList" }, method = RequestMethod.GET)
	public @ResponseBody List<Vehicle> getAllVehicleList() {

		List<Vehicle> vehList = new ArrayList<Vehicle>();

		try {

			vehList = vehicleRepo.findByDelStatusOrderByVehicleIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return vehList;

	}

	@RequestMapping(value = { "/getVehicleById" }, method = RequestMethod.POST)
	public @ResponseBody Vehicle getVehicleById(@RequestParam("vehId") int vehId) {

		Vehicle res = new Vehicle();

		try {

			res = vehicleRepo.findByVehicleIdAndDelStatus(vehId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getVehListByVehicleType" }, method = RequestMethod.POST)
	public @ResponseBody List<Vehicle> getVehListByVehicleType(@RequestParam("vehicleType") int vehicleType) {

		List<Vehicle> vehicleList = new ArrayList<Vehicle>();

		try {
			vehicleList = vehicleRepo.findByVehicleTypeAndDelStatus(vehicleType, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return vehicleList;

	}

	@RequestMapping(value = { "/deleteVehicle" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteVehicle(@RequestParam("vehId") int vehId) {

		int isDeleted = vehicleRepo.deleteVehicle(vehId);
		Info infoRes = new Info();
		if (isDeleted >= 1) {
			infoRes.setError(false);
			infoRes.setMessage("Vehicle Deleted Successfully");
		} else {
			infoRes.setError(true);
			infoRes.setMessage("Vehicle Deletion Failed");
		}
		return infoRes;
	}

	@RequestMapping(value = { "/deleteMultiVehicle" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiVehicle(@RequestParam("vehIds") List<Integer> vehIds) {

		Info info = new Info();

		try {
			int delete = vehicleRepo.deleteMultiVehicleDetail(vehIds);

			if (delete >= 1) {
				info.setError(false);
				info.setMessage("successfully Multiple Deleted");
			} else {
				info.setError(true);
				info.setMessage(" Failed to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" Failed to Delete");

		}
		return info;

	}

	// ----------------Subplant Master-------------------------------

	@RequestMapping(value = { "/saveSubPlant" }, method = RequestMethod.POST)
	public @ResponseBody Subplant saveSubPlant(@RequestBody Subplant sp) {
		return subplantRepo.save(sp);
	}

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

	/*
	 * @RequestMapping(value = { "/getAllSubPlant" }, method = RequestMethod.GET)
	 * public @ResponseBody List<GetsubplantData> getAllSubPlant() {
	 * 
	 * List<GetsubplantData> subplantList = new ArrayList<GetsubplantData>();
	 * 
	 * try {
	 * 
	 * subplantList = subplantRepo.findByDelStatusOrderBySubplantIdDesc(1);
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace();
	 * 
	 * } return subplantList;
	 * 
	 * }
	 * 
	 */

	@RequestMapping(value = { "/getSubPlantById" }, method = RequestMethod.POST)
	public @ResponseBody Subplant getSubPlantById(@RequestParam("spId") int spId) {

		Subplant res = new Subplant();

		try {

			res = subplantRepo.findBysubplantIdAndDelStatus(spId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/deleteSubPlant" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSubPlant(@RequestParam("spId") int spId) {

		int isDeleted = subplantRepo.deleteSubPlant(spId);
		Info infoRes = new Info();
		if (isDeleted >= 1) {
			infoRes.setError(false);
			infoRes.setMessage("subplant Deleted Successfully");
		} else {
			infoRes.setError(true);
			infoRes.setMessage("subplant Deletion Failed");
		}
		return infoRes;
	}

	@RequestMapping(value = { "/deleteMultiSubPlant" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiSubPlant(@RequestParam("spIds") List<Integer> spIds) {

		Info info = new Info();

		try {
			int delete = subplantRepo.deleteMultiSubPlantDetail(spIds);

			if (delete >= 1) {
				info.setError(false);
				info.setMessage("successfully Multiple Deleted");
			} else {
				info.setError(true);
				info.setMessage(" Failed to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" Failed to Delete");

		}
		return info;

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

	// ----------------Category Master-------------------------------

	@RequestMapping(value = { "/getAllItemCategoryList" }, method = RequestMethod.GET)
	public @ResponseBody List<ItemCategory> getAllItemCategoryList() {

		List<ItemCategory> itemCatList = new ArrayList<ItemCategory>();

		try {

			itemCatList = itemCategoryRepo.findByIsUsedOrderByCatIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return itemCatList;

	}

	@RequestMapping(value = { "/getRawItemListByCatId" }, method = RequestMethod.POST)
	public @ResponseBody List<RawMatItem> getRawItemListByCatId(@RequestParam("catId") int catId) {

		List<RawMatItem> itemList = new ArrayList<RawMatItem>();

		try {

			itemList = rawMatItemRepo.findByCatIdAndIsUsed(catId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return itemList;

	}

	@RequestMapping(value = { "/getAllItems" }, method = RequestMethod.GET)
	public @ResponseBody List<GetRawMatItem> getAllItems() {

		List<GetRawMatItem> itemList = new ArrayList<GetRawMatItem>();

		try {

			itemList = getRawMatItemRepo.getAllItems();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return itemList;

	}

	@RequestMapping(value = { "/saveRawItem" }, method = RequestMethod.POST)
	public @ResponseBody RawMatItem saveItem(@RequestBody RawMatItem item) {

		RawMatItem res = new RawMatItem();

		try {

			res = rawMatItemRepo.saveAndFlush(item);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getRawItemLByItemId" }, method = RequestMethod.POST)
	public @ResponseBody RawMatItem getRawItemLByItemId(@RequestParam("itemId") int itemId) {

		RawMatItem item = new RawMatItem();

		try {

			item = rawMatItemRepo.findByItemIdAndIsUsed(itemId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return item;

	}

	@RequestMapping(value = { "/deleteRawMatItem" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteRawMatItem(@RequestParam("itemId") int itemId) {

		int isDeleted = rawMatItemRepo.deleteRawMatItem(itemId);
		Info infoRes = new Info();
		if (isDeleted >= 1) {
			infoRes.setError(false);
			infoRes.setMessage(" Deleted Successfully");
		} else {
			infoRes.setError(true);
			infoRes.setMessage(" Deletion Failed");
		}
		return infoRes;
	}

	@RequestMapping(value = { "/deleteMultiRawMatItem" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiRawMatItem(@RequestParam("itemIds") List<Integer> itemIds) {

		Info info = new Info();

		try {
			int delete = rawMatItemRepo.deleteMultiRawMatItem(itemIds);

			if (delete >= 1) {
				info.setError(false);
				info.setMessage("successfully Multiple Deleted");
			} else {
				info.setError(true);
				info.setMessage(" Failed to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" Failed to Delete");

		}
		return info;

	}

	// ----------------Item Type-------------------------------

	@RequestMapping(value = { "/getAllItemTypeList" }, method = RequestMethod.GET)
	public @ResponseBody List<ItemType> getAllItemTypeList() {

		List<ItemType> itemTypeList = new ArrayList<ItemType>();

		try {

			itemTypeList = itemTypeRepo.findByDelStatusOrderByItemTypeIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return itemTypeList;

	}

	@RequestMapping(value = { "/getItemTypeByItemTypeId" }, method = RequestMethod.POST)
	public @ResponseBody ItemType getItemTypeByItemTypeId(@RequestParam("itemTypeId") int itemTypeId) {

		ItemType itemType = new ItemType();

		try {
			itemType = itemTypeRepo.findByItemTypeIdAndDelStatus(itemTypeId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return itemType;

	}

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
