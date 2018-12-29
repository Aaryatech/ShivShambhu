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

import com.shivshambhuwebapi.master.model.BankDetail;
import com.shivshambhuwebapi.master.model.DashPlant;
import com.shivshambhuwebapi.master.model.DashSaleCount;
import com.shivshambhuwebapi.master.model.Document;
import com.shivshambhuwebapi.master.model.OtherExpenses;
import com.shivshambhuwebapi.master.repo.DashPlantRepo;
import com.shivshambhuwebapi.master.repo.DashSaleCountRepo;
import com.shivshambhuwebapi.master.repo.GetOtherExpRepo;
import com.shivshambhuwebapi.master.repo.OtherExpensesRepo;

@RestController
public class DashApiController {

	@Autowired
	DashSaleCountRepo dashSaleCountRepo;

	@Autowired
	DashPlantRepo dashPlantRepo;

	@Autowired
	OtherExpensesRepo otherExpensesRepo;

	@Autowired
	GetOtherExpRepo getOtherExpRepo;

	// --------------------------------------Other Expenses-------------------------

	@RequestMapping(value = { "/saveOtherExpenses" }, method = RequestMethod.POST)
	public @ResponseBody OtherExpenses saveOtherExpenses(@RequestBody OtherExpenses otherExpenses) {

		OtherExpenses res = new OtherExpenses();

		try {

			res = otherExpensesRepo.saveAndFlush(otherExpenses);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getAllOtherExpList" }, method = RequestMethod.GET)
	public @ResponseBody List<OtherExpenses> getAllOtherExpList() {

		List<OtherExpenses> expList = new ArrayList<OtherExpenses>();

		try {

			expList = otherExpensesRepo.findByDelStatusOrderByOtherExpIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return expList;

	}

	@RequestMapping(value = { "/getOtherExpByExpId" }, method = RequestMethod.POST)
	public @ResponseBody OtherExpenses getOtherExpByExpId(@RequestParam("otherExpId") int otherExpId) {

		OtherExpenses otherExp = new OtherExpenses();

		try {
			otherExp = otherExpensesRepo.findByOtherExpIdAndDelStatus(otherExpId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return otherExp;

	}

	@RequestMapping(value = { "/deleteOtherExp" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteOtherExp(@RequestParam("otherExpId") int otherExpId) {

		Info info = new Info();

		try {
			int delete = otherExpensesRepo.deleteOtherExpenses(otherExpId);

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

	@RequestMapping(value = { "/deleteMultiOtherExp" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiOtherExp(@RequestParam("otherExpIds") List<Integer> otherExpIds) {

		Info info = new Info();

		try {
			int delete = otherExpensesRepo.deleteMultiOtherExpenses(otherExpIds);

			if (delete >= 1) {
				info.setError(false);
				info.setMessage("successfully Multiple Deleted");
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

	// getDashboardCount

	@RequestMapping(value = { "/getDashboardCountBetDate" }, method = RequestMethod.POST)
	public @ResponseBody DashSaleCount getDashboardCountBetDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("plantId") int plantId) {

		DashSaleCount dashSaleCount = new DashSaleCount();

		try {
			if (plantId != 0) {

				dashSaleCount = dashSaleCountRepo.getDashboardCountByPlantId(fromDate, toDate, plantId);
			} else {
				dashSaleCount = dashSaleCountRepo.getDashboardCount(fromDate, toDate);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return dashSaleCount;

	}

	// getDashboardCount

	@RequestMapping(value = { "/getPlantDashCountBetDate" }, method = RequestMethod.POST)
	public @ResponseBody DashPlant getPlantDashCountBetDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		DashPlant dashSaleCount = new DashPlant();

		try {

			dashSaleCount = dashPlantRepo.getDashPlantCount(fromDate, toDate);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return dashSaleCount;

	}

}
