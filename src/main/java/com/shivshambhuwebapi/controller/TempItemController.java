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

import com.shivshambhuwebapi.model.prodrm.RmcQuotItemDetail;
import com.shivshambhuwebapi.model.prodrm.RmcQuotTemp;
import com.shivshambhuwebapi.repository.rmc.RmcQuotItemDetailRepo;
import com.shivshambhuwebapi.repository.rmc.RmcQuotTempRepo;

@RestController
public class TempItemController {

	@Autowired
	RmcQuotTempRepo rmcQuotTempRepo;

	@RequestMapping(value = { "/saveTempItemDetail" }, method = RequestMethod.POST)
	public @ResponseBody List<RmcQuotTemp> saveTempItemDetail(@RequestBody List<RmcQuotTemp> detailList) {
		System.out.println("inside");

		List<RmcQuotTemp> itemDList = new ArrayList<>();

		try {
			itemDList = rmcQuotTempRepo.saveAll(detailList);

		} catch (Exception e) {
			System.err.println("Exc in ad Item Detail " + e.getMessage());
		}
		return itemDList;
	}

	@RequestMapping(value = { "/getTempItemDetailByQuotDetailId" }, method = RequestMethod.POST)
	public @ResponseBody List<RmcQuotTemp> getTempItemDetailByQuotDetailId(
			@RequestParam("quotDetailId") int quotDetailId) {

		List<RmcQuotTemp> billHeaderRes = new ArrayList<>();

		try {

			billHeaderRes = rmcQuotTempRepo.findByQuotDetailIdAndDelStatus(quotDetailId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return billHeaderRes;

	}

	@RequestMapping(value = { "/getTempItemDetailByOrderId" }, method = RequestMethod.POST)
	public @ResponseBody List<RmcQuotTemp> getTempItemDetailByOrderId(@RequestParam("orderId") int orderId) {

		List<RmcQuotTemp> billHeaderRes = new ArrayList<>();

		try {

			billHeaderRes = rmcQuotTempRepo.findByOrderNoAndDelStatus(orderId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return billHeaderRes;

	}

	@RequestMapping(value = { "/getTempItemDetailByPOId" }, method = RequestMethod.POST)
	public @ResponseBody List<RmcQuotTemp> getTempItemDetailByPOId(@RequestParam("poId") int poId) {

		List<RmcQuotTemp> billHeaderRes = new ArrayList<>();

		try {

			billHeaderRes = rmcQuotTempRepo.findByPoNoAndDelStatus(poId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return billHeaderRes;

	}

	@RequestMapping(value = { "/getTempItemDetailByChalanId" }, method = RequestMethod.POST)
	public @ResponseBody List<RmcQuotTemp> getTempItemDetailByChalanId(
			@RequestParam("chalanIdList") List<Integer> chalanIdList) {

		List<RmcQuotTemp> billHeaderRes = new ArrayList<>();

		try {

			billHeaderRes = rmcQuotTempRepo.getRmcByChalanIdList(chalanIdList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return billHeaderRes;

	}

	@RequestMapping(value = { "/updateQuotNoAndPoNo" }, method = RequestMethod.POST)
	public @ResponseBody Info updateQuotNoAndPoNo(@RequestParam("quotDetailId") int quotDetailId,
			@RequestParam("quotNo") String quotNo, @RequestParam("poNo") String poNo) {

		Info info = new Info();

		try {
			int delete = rmcQuotTempRepo.updateRmcQuotTemp(quotDetailId, quotNo, poNo);

			if (delete == 1) {
				info.setError(false);
				info.setMessage("successfully Updated");
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

	@RequestMapping(value = { "/updateChalanNo" }, method = RequestMethod.POST)
	public @ResponseBody Info updateChalanNo(@RequestParam("orderId") int orderId,
			@RequestParam("chalanNo") String chalanNo) {

		Info info = new Info();

		try {
			int delete = rmcQuotTempRepo.updateChalanNo(orderId, chalanNo);

			if (delete == 1) {
				info.setError(false);
				info.setMessage("successfully Updated");
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

	@RequestMapping(value = { "/updateOrderNo" }, method = RequestMethod.POST)
	public @ResponseBody Info updateOrderNo(@RequestParam("poId") int poId, @RequestParam("orderNo") String orderNo) {

		Info info = new Info();

		try {
			int delete = rmcQuotTempRepo.updateOrderNo(poId, orderNo);

			if (delete == 1) {
				info.setError(false);
				info.setMessage("successfully Updated");
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

	@RequestMapping(value = { "/updateBillNo" }, method = RequestMethod.POST)
	public @ResponseBody Info updateBillNo(@RequestParam("chalanNoList") List<Integer> chalanNoList,
			@RequestParam("billNo") String billNo) {

		Info info = new Info();

		try {
			int delete = rmcQuotTempRepo.updateBillNo(chalanNoList, billNo);

			if (delete == 1) {
				info.setError(false);
				info.setMessage("successfully Updated");
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
