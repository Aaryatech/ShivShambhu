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
import com.shivshambhuwebapi.master.repo.SettingRepo;
import com.shivshambhuwebapi.tx.model.MarketingTravel;
import com.shivshambhuwebapi.tx.model.Weighing;
import com.shivshambhuwebapi.tx.repo.MarketingTravelRepo;
import com.shivshambhuwebapi.tx.repo.PoklenReadingRepo;
import com.shivshambhuwebapi.tx.repo.WeighingRepo;

@RestController
public class TxApiController {

	@Autowired
	MarketingTravelRepo marketingTravelRepo;

	@Autowired
	WeighingRepo weighingRepo;

	@Autowired
	SettingRepo settingRepo;

	@Autowired
	PoklenReadingRepo poklenReadingRepo;

	// ------------------------------------Weighing----------------------------------------------------

	@RequestMapping(value = { "/saveWeighing" }, method = RequestMethod.POST)
	public @ResponseBody Weighing saveWeighing(@RequestBody Weighing weighing) {

		Weighing res = new Weighing();

		try {

			res = weighingRepo.saveAndFlush(weighing);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getWeighingById" }, method = RequestMethod.POST)
	public @ResponseBody Weighing getWeighingById(@RequestParam("weighId") int weighId) {

		Weighing weighing = new Weighing();

		try {
			weighing = weighingRepo.findByWeighIdAndDelStatus(weighId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return weighing;

	}

	@RequestMapping(value = { "/getAllWeighingList" }, method = RequestMethod.GET)
	public @ResponseBody List<Weighing> getAllWeighingList() {

		List<Weighing> wList = new ArrayList<Weighing>();

		try {

			wList = weighingRepo.findByDelStatusOrderByWeighIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return wList;

	}

	@RequestMapping(value = { "/deleteWeighing" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteWeighing(@RequestParam("weighId") int weighId) {

		Info info = new Info();

		try {
			int delete = weighingRepo.deleteWeighing(weighId);

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

	@RequestMapping(value = { "/deleteMultiWeighing" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiWeighing(@RequestParam("weighIds") List<Integer> weighIds) {

		Info info = new Info();

		try {
			int delete = weighingRepo.deleteMultiWeighing(weighIds);

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
