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

import com.shivshambhuwebapi.master.model.Setting;
import com.shivshambhuwebapi.master.model.Tax;
import com.shivshambhuwebapi.master.repo.SettingRepo;
import com.shivshambhuwebapi.master.repo.TaxRepo;
import com.shivshambhuwebapi.tx.model.MarketingTravel;
import com.shivshambhuwebapi.tx.repo.MarketingTravelRepo;

@RestController
public class TxApiController {
	@RequestMapping(value = { "/getTaxList" }, method = RequestMethod.GET)
	public @ResponseBody List<Tax> getTAxList() {

		List<Tax> taxList = new ArrayList<Tax>();

		try {

			taxList = objTaxrepo.findByDelStatusOrderByTaxIdDesc(1);
			
		} catch (Exception e) {

			e.printStackTrace();

		}
		return taxList;

	}
	@Autowired
	TaxRepo objTaxrepo;

	@Autowired
	MarketingTravelRepo marketingTravelRepo;

	// ----------------------------------------MarketingTravel----------------------------------------------------

	@RequestMapping(value = { "/saveMarketingTravel" }, method = RequestMethod.POST)
	public @ResponseBody MarketingTravel saveQuotTracking(@RequestBody MarketingTravel marketingTravel) {

		MarketingTravel res = new MarketingTravel();

		try {

			res = marketingTravelRepo.saveAndFlush(marketingTravel);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getMarketingTravelByTravelId" }, method = RequestMethod.POST)
	public @ResponseBody MarketingTravel getMarketingTravelByTravelId(@RequestParam("travelId") int travelId) {

		MarketingTravel markTravel = new MarketingTravel();

		try {
			markTravel = marketingTravelRepo.findByTravelIdAndDelStatus(travelId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return markTravel;

	}

	@RequestMapping(value = { "/getAllMarketTravelList" }, method = RequestMethod.GET)
	public @ResponseBody List<MarketingTravel> getAllMarketTravelList() {

		List<MarketingTravel> travelList = new ArrayList<MarketingTravel>();

		try {

			travelList = marketingTravelRepo.findByDelStatusOrderByTravelIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return travelList;

	}

	@RequestMapping(value = { "/deleteMarketingTravel" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMarketingTravel(@RequestParam("travelId") int travelId) {

		Info info = new Info();

		try {
			int delete = marketingTravelRepo.deleteMarketingTravel(travelId);

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

	// Sachin 1 Nov 2018

	@Autowired
	SettingRepo settingRepo;

	@RequestMapping(value = { "/getSettingValueByKeyList" }, method = RequestMethod.POST)
	public @ResponseBody List<Setting> getSettingValueByKeyList(@RequestParam("keyList") List<Integer> keyList) {

		List<Setting> settingList = new ArrayList<Setting>();

		try {

			settingList = settingRepo.findBySettingKeyIn(keyList);

		} catch (Exception e) {
			
			System.err.println("Exce in getting  getSettingValueByKeyList  In TxApi" + e.getMessage());
			e.printStackTrace();

		}
		
		return settingList;

	}

}
