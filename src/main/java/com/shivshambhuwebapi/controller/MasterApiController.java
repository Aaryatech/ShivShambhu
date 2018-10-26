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

import com.shivshambhuwebapi.common.DateConvertor;
import com.shivshambhuwebapi.master.model.Company;
import com.shivshambhuwebapi.master.model.Cust;
import com.shivshambhuwebapi.master.model.Dept;
import com.shivshambhuwebapi.master.model.Item;
import com.shivshambhuwebapi.master.model.MarketingUser;
import com.shivshambhuwebapi.master.model.Plant;
import com.shivshambhuwebapi.master.model.Project;
import com.shivshambhuwebapi.master.repo.CompanyRepo;
import com.shivshambhuwebapi.master.repo.CustRepo;
import com.shivshambhuwebapi.master.repo.DeptRepo;
import com.shivshambhuwebapi.master.repo.ItemRepo;
import com.shivshambhuwebapi.master.repo.MarketingUserRepo;
import com.shivshambhuwebapi.master.repo.PlantRepo;
import com.shivshambhuwebapi.master.repo.ProjectRepo;

@RestController
public class MasterApiController {

	@Autowired
	CompanyRepo companyRepo;

	@Autowired
	CustRepo custRepo;

	@Autowired
	DeptRepo deptRepo;

	@Autowired
	PlantRepo plantRepo;

	@Autowired
	ProjectRepo projectRepo;

	@Autowired
	ItemRepo itemRepo;

	@Autowired
	MarketingUserRepo marketingUserRepo;

	// ----------------------------------------Customer----------------------------------------------------

	@RequestMapping(value = { "/saveCust" }, method = RequestMethod.POST)
	public @ResponseBody Cust saveCust(@RequestBody Cust cust) {

		Cust res = new Cust();

		try {

			res = custRepo.saveAndFlush(cust);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getCustByCustId" }, method = RequestMethod.POST)
	public @ResponseBody Cust getCustByCustId(@RequestParam("custId") int custId) {

		Cust cust = new Cust();

		try {
			cust = custRepo.findByCustIdAndDelStatus(custId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return cust;

	}

	@RequestMapping(value = { "/getAllCustList" }, method = RequestMethod.GET)
	public @ResponseBody List<Cust> getAllCustList() {

		List<Cust> custList = new ArrayList<Cust>();

		try {

			custList = custRepo.findByDelStatusOrderByCustIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return custList;

	}

	@RequestMapping(value = { "/deleteCust" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteCust(@RequestParam("custId") int custId) {

		Info info = new Info();

		try {
			int delete = custRepo.deleteCust(custId);

			if (delete == 1) {
				info.setError(false);
				info.setMessage("successfully Deleted");
			} else {
				info.setError(true);
				info.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" Deleted to Delete");

		}
		return info;

	}

	// ----------------------------------------Company----------------------------------------------------

	@RequestMapping(value = { "/saveCompany" }, method = RequestMethod.POST)
	public @ResponseBody Company saveCompany(@RequestBody Company company) {

		Company res = new Company();

		try {

			res = companyRepo.saveAndFlush(company);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getCompByCompanyId" }, method = RequestMethod.POST)
	public @ResponseBody Company getCompByCompanyId(@RequestParam("companyId") int companyId) {

		Company comp = new Company();

		try {
			comp = companyRepo.findByCompanyIdAndDelStatus(companyId, 1);
			comp.setFromDate(DateConvertor.convertToDMY(comp.getFromDate()));
			comp.setToDate(DateConvertor.convertToDMY(comp.getToDate()));

		} catch (Exception e) {

			e.printStackTrace();

		}
		return comp;

	}

	@RequestMapping(value = { "/getAllCompList" }, method = RequestMethod.GET)
	public @ResponseBody List<Company> getAllCompList() {

		List<Company> compList = new ArrayList<Company>();

		try {

			compList = companyRepo.findByDelStatusOrderByCompanyIdDesc(1);
			for (int i = 0; i < compList.size(); i++) {
				compList.get(i).setFromDate(DateConvertor.convertToDMY(compList.get(i).getFromDate()));
				compList.get(i).setToDate(DateConvertor.convertToDMY(compList.get(i).getToDate()));

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return compList;

	}

	@RequestMapping(value = { "/deleteCompany" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteCompany(@RequestParam("companyId") int companyId) {

		Info info = new Info();

		try {
			int delete = companyRepo.deleteCompany(companyId);

			if (delete == 1) {
				info.setError(false);
				info.setMessage("successfully Deleted");
			} else {
				info.setError(true);
				info.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" Deleted to Delete");

		}
		return info;

	}

	// ----------------------------------------Dept----------------------------------------------------

	@RequestMapping(value = { "/saveDept" }, method = RequestMethod.POST)
	public @ResponseBody Dept saveDept(@RequestBody Dept dept) {

		Dept res = new Dept();

		try {

			res = deptRepo.saveAndFlush(dept);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getDeptByDeptId" }, method = RequestMethod.POST)
	public @ResponseBody Dept getDeptByDeptId(@RequestParam("deptId") int deptId) {

		Dept dept = new Dept();

		try {
			dept = deptRepo.findByDeptIdAndDelStatus(deptId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return dept;

	}

	@RequestMapping(value = { "/getAllDeptList" }, method = RequestMethod.GET)
	public @ResponseBody List<Dept> getAllDeptList() {

		List<Dept> deptList = new ArrayList<Dept>();

		try {

			deptList = deptRepo.findByDelStatusOrderByDeptIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return deptList;

	}

	@RequestMapping(value = { "/deleteDept" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteDept(@RequestParam("deptId") int deptId) {

		Info info = new Info();

		try {
			int delete = deptRepo.deleteDept(deptId);

			if (delete == 1) {
				info.setError(false);
				info.setMessage("successfully Deleted");
			} else {
				info.setError(true);
				info.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" Deleted to Delete");

		}
		return info;

	}

	// ----------------------------------------Plant----------------------------------------------------

	@RequestMapping(value = { "/savePlant" }, method = RequestMethod.POST)
	public @ResponseBody Plant savePlant(@RequestBody Plant plant) {

		Plant res = new Plant();

		try {

			res = plantRepo.saveAndFlush(plant);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getAllPlantList" }, method = RequestMethod.GET)
	public @ResponseBody List<Plant> getAllPlantList() {

		List<Plant> plantList = new ArrayList<Plant>();

		try {

			plantList = plantRepo.findByDelStatusOrderByPlantIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return plantList;

	}

	@RequestMapping(value = { "/getPlantByPlantId" }, method = RequestMethod.POST)
	public @ResponseBody Plant getPlantByPlantId(@RequestParam("plantId") int plantId) {

		Plant plant = new Plant();

		try {
			plant = plantRepo.findByPlantIdAndDelStatus(plantId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return plant;

	}

	@RequestMapping(value = { "/deletePlant" }, method = RequestMethod.POST)
	public @ResponseBody Info deletePlant(@RequestParam("plantId") int plantId) {

		Info info = new Info();

		try {
			int delete = plantRepo.deletePlant(plantId);

			if (delete == 1) {
				info.setError(false);
				info.setMessage("successfully Deleted");
			} else {
				info.setError(true);
				info.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" Deleted to Delete");

		}
		return info;

	}

	// ----------------------------------------Project----------------------------------------------------

	@RequestMapping(value = { "/saveProject" }, method = RequestMethod.POST)
	public @ResponseBody Project saveProject(@RequestBody Project project) {

		Project res = new Project();

		try {

			res = projectRepo.saveAndFlush(project);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getAllProjectList" }, method = RequestMethod.GET)
	public @ResponseBody List<Project> getAllProjectList() {

		List<Project> proList = new ArrayList<Project>();

		try {

			proList = projectRepo.findByDelStatusOrderByProjIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return proList;

	}

	@RequestMapping(value = { "/getProjectByProjId" }, method = RequestMethod.POST)
	public @ResponseBody Project getProjectByProjId(@RequestParam("projId") int projId) {

		Project project = new Project();

		try {
			project = projectRepo.findByProjIdAndDelStatus(projId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return project;

	}

	@RequestMapping(value = { "/deleteProject" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteProject(@RequestParam("projId") int projId) {

		Info info = new Info();

		try {
			int delete = projectRepo.deleteProject(projId);

			if (delete == 1) {
				info.setError(false);
				info.setMessage("successfully Deleted");
			} else {
				info.setError(true);
				info.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" Deleted to Delete");

		}
		return info;

	}

	// ----------------------------------------Item----------------------------------------------------

	@RequestMapping(value = { "/saveItem" }, method = RequestMethod.POST)
	public @ResponseBody Item saveItem(@RequestBody Item item) {

		Item res = new Item();

		try {

			res = itemRepo.saveAndFlush(item);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getAllItemList" }, method = RequestMethod.GET)
	public @ResponseBody List<Item> getAllItemList() {

		List<Item> itemList = new ArrayList<Item>();

		try {

			itemList = itemRepo.findByDelStatusOrderByItemIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return itemList;

	}

	@RequestMapping(value = { "/getItemByItemId" }, method = RequestMethod.POST)
	public @ResponseBody Item getItemByItemId(@RequestParam("itemId") int itemId) {

		Item item = new Item();

		try {
			item = itemRepo.findByItemIdAndDelStatus(itemId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return item;

	}

	@RequestMapping(value = { "/deleteItem" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteItem(@RequestParam("itemId") int itemId) {

		Info info = new Info();

		try {
			int delete = itemRepo.deleteItem(itemId);

			if (delete == 1) {
				info.setError(false);
				info.setMessage("successfully Deleted");
			} else {
				info.setError(true);
				info.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" Deleted to Delete");

		}
		return info;

	}

	// -------------------------------------MarketingUser----------------------------

	@RequestMapping(value = { "/saveMarketingUser" }, method = RequestMethod.POST)
	public @ResponseBody MarketingUser saveMarketingUser(@RequestBody MarketingUser marketingUser) {

		MarketingUser res = new MarketingUser();

		try {

			res = marketingUserRepo.saveAndFlush(marketingUser);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getMarketingUserByMUserId" }, method = RequestMethod.POST)
	public @ResponseBody MarketingUser getMarketingUserByMUserId(@RequestParam("markUsrId") int markUsrId) {

		MarketingUser mu = new MarketingUser();

		try {
			mu = marketingUserRepo.findByMarkUsrIdAndDelStatus(markUsrId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return mu;

	}
	
	@RequestMapping(value = { "/getAllMUList" }, method = RequestMethod.GET)
	public @ResponseBody List<MarketingUser> getAllMUList() {

		List<MarketingUser> muList = new ArrayList<MarketingUser>();

		try {

			muList = marketingUserRepo.findByDelStatusOrderByMarkUsrIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return muList;

	}

	@RequestMapping(value = { "/deleteMarketingUser" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMarketingUser(@RequestParam("markUsrId") int markUsrId) {

		Info info = new Info();

		try {
			int delete = marketingUserRepo.deleteMarketingUser(markUsrId);

			if (delete == 1) {
				info.setError(false);
				info.setMessage("successfully Deleted");
			} else {
				info.setError(true);
				info.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" Deleted to Delete");

		}
		return info;

	}

}
