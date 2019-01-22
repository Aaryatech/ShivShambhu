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
import com.shivshambhuwebapi.model.GetPoHeader;
import com.shivshambhuwebapi.model.prodrm.RmcQuotTemp;
import com.shivshambhuwebapi.stock.GetStockDetail;
import com.shivshambhuwebapi.stock.GetStockDetailRepo;
import com.shivshambhuwebapi.stock.GetStockHeader;
import com.shivshambhuwebapi.stock.GetStockHeaderRepo;
import com.shivshambhuwebapi.stock.StockDetail;
import com.shivshambhuwebapi.stock.StockDetailRepo;
import com.shivshambhuwebapi.stock.StockHeader;
import com.shivshambhuwebapi.stock.StockHeaderRepo;
import com.shivshambhuwebapi.tx.model.EnqDetail;

@RestController
public class StockApiController {
	@Autowired
	StockHeaderRepo stockHeaderRepo;

	@Autowired
	StockDetailRepo stockDetailRepo;

	@Autowired
	GetStockDetailRepo getStockDetailRepo;

	@Autowired
	GetStockHeaderRepo getStockHeaderRepo;

	@RequestMapping(value = { "/saveStockDetailList" }, method = RequestMethod.POST)
	public @ResponseBody List<StockDetail> saveStockDetailList(@RequestBody List<StockDetail> detailList) {
		System.out.println("inside");

		List<StockDetail> itemDList = new ArrayList<>();

		try {
			itemDList = stockDetailRepo.saveAll(detailList);

		} catch (Exception e) {
			System.err.println("Exc in ad Item Detail " + e.getMessage());
		}
		return itemDList;
	}

	@RequestMapping(value = { "/saveStockHeaderDetail" }, method = RequestMethod.POST)
	public @ResponseBody StockHeader saveStockHeaderDetail(@RequestBody StockHeader stockHeader) {

		StockHeader save = new StockHeader();

		try {

			save = stockHeaderRepo.save(stockHeader);

			for (int i = 0; i < stockHeader.getStockDetailList().size(); i++) {

				stockHeader.getStockDetailList().get(i).setStockId(save.getStockId());

			}

			List<StockDetail> saveList = stockDetailRepo.saveAll(stockHeader.getStockDetailList());

			save.setStockDetailList(saveList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return save;

	}

	@RequestMapping(value = { "/getStockDetailListByDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetStockHeader> getStockDetailListByDate(@RequestParam("currDate") String currDate,
			@RequestParam("statusList") List<Integer> statusList) {

		List<GetStockHeader> getStockList = new ArrayList<GetStockHeader>();

		try {
			getStockList = getStockHeaderRepo.getStockheader(currDate, statusList);
			for (int i = 0; i < getStockList.size(); i++) {

				List<GetStockDetail> stockDetailList = getStockDetailRepo
						.getStockDetail(getStockList.get(i).getStockId());
				getStockList.get(i).setStockDetailList(stockDetailList);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return getStockList;

	}

	@RequestMapping(value = { "/getStockHeaderByPlantId" }, method = RequestMethod.POST)
	public @ResponseBody StockHeader getStockHeaderByPlantId(@RequestParam("plantId") int plantId) {

		StockHeader stockHeader = new StockHeader();

		try {

			stockHeader = stockHeaderRepo.findByPlantIdAndStatusAndDelStatus(plantId, 0, 1);
			stockHeader.setStartDate(DateConvertor.convertToDMY(stockHeader.getStartDate()));

		} catch (Exception e) {

			e.printStackTrace();
		}
		return stockHeader;

	}

	@RequestMapping(value = { "/getStockHeaderByStockId" }, method = RequestMethod.POST)
	public @ResponseBody StockHeader getStockHeaderByStockId(@RequestParam("stockId") int stockId) {

		StockHeader stockHeader = new StockHeader();

		try {

			stockHeader = stockHeaderRepo.findByStockIdAndDelStatus(stockId, 1);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return stockHeader;

	}

	@RequestMapping(value = { "/getStockDetailByPlantId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetStockDetail> getStockDetailByPlantId(@RequestParam("plantId") int plantId) {

		List<GetStockDetail> getStockDetailList = new ArrayList<GetStockDetail>();

		try {

			getStockDetailList = getStockDetailRepo.getStockDetailByPlantId(plantId);
			System.out.println(getStockDetailList.toString());

		} catch (Exception e) {

			e.printStackTrace();
		}
		return getStockDetailList;

	}

	@RequestMapping(value = { "/getStockDetailByPlantIdAndCurDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetStockDetail> getStockDetailByPlantIdAndCurDate(@RequestParam("plantId") int plantId) {

		List<GetStockDetail> getStockDetailList = new ArrayList<GetStockDetail>();

		try {

			getStockDetailList = getStockDetailRepo.getStockDetailByPlantAndCurDate(plantId);
			System.out.println(getStockDetailList.toString());

		} catch (Exception e) {

			e.printStackTrace();
		}
		return getStockDetailList;

	}

	@RequestMapping(value = { "/getStockDetailByPlantIdAndBetDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetStockDetail> getStockDetailByPlantIdAndBetDate(@RequestParam("plantId") int plantId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<GetStockDetail> getStockDetailList = new ArrayList<GetStockDetail>();

		try {

			getStockDetailList = getStockDetailRepo.getStockDetailByPlantAndBetDate(plantId, fromDate, toDate);
			System.out.println(getStockDetailList.toString());

		} catch (Exception e) {

			e.printStackTrace();
		}
		return getStockDetailList;

	}

}
