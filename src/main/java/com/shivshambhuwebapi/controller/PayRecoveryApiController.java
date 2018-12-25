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
import com.shivshambhuwebapi.model.rec.GetPayRecoveryHead;
import com.shivshambhuwebapi.model.rec.PayRecoveryDetail;
import com.shivshambhuwebapi.model.rec.PayRecoveryHead;
import com.shivshambhuwebapi.repo.rec.GetPayRecoveryHeadRepo;
import com.shivshambhuwebapi.repo.rec.PayRecoveryDetailRepo;
import com.shivshambhuwebapi.repo.rec.PayRecoveryHeadRepo;
import com.shivshambhuwebapi.tx.model.GetPoklenReading;
import com.shivshambhuwebapi.tx.model.GetVehDetail;

@RestController
public class PayRecoveryApiController {

	@Autowired
	PayRecoveryDetailRepo payRecoveryDetailRepo;

	@Autowired
	GetPayRecoveryHeadRepo getPayRecoveryHeadRepo;

	@Autowired
	PayRecoveryHeadRepo payRecoveryHeadRepo;

	@RequestMapping(value = { "/savePaymentRecovery" }, method = RequestMethod.POST)
	public @ResponseBody PayRecoveryHead savePaymentRecovery(@RequestBody PayRecoveryHead payRecoveryHead) {

		System.err.println("header body " + payRecoveryHead.toString());

		PayRecoveryHead payRecoveryRes = null;

		try {

			payRecoveryRes = payRecoveryHeadRepo.save(payRecoveryHead);

			for (int i = 0; i < payRecoveryHead.getPayRecoveryDetailList().size(); i++) {

				payRecoveryHead.getPayRecoveryDetailList().get(i).setPayHeadId(payRecoveryRes.getPayHeadId());

			}

			List<PayRecoveryDetail> recDetailList = payRecoveryDetailRepo
					.saveAll(payRecoveryHead.getPayRecoveryDetailList());

			payRecoveryRes.setPayRecoveryDetailList(recDetailList);

		} catch (Exception e) {

			System.err.println("exce in saving order head and detail " + e.getMessage());

			e.printStackTrace();

		}
		System.err.println("Payres body " + payRecoveryRes.toString());

		return payRecoveryRes;

	}

	@RequestMapping(value = { "/savePaymentRecoveryHeader" }, method = RequestMethod.POST)
	public @ResponseBody PayRecoveryHead savePaymentRecoveryHeader(@RequestBody PayRecoveryHead payRecoveryHead) {

		System.err.println("header body " + payRecoveryHead.toString());

		PayRecoveryHead payRecoveryRes = null;

		try {

			payRecoveryRes = payRecoveryHeadRepo.save(payRecoveryHead);

		} catch (Exception e) {

			System.err.println("exce in saving order head and detail " + e.getMessage());

			e.printStackTrace();

		}
		System.err.println("Payres body " + payRecoveryRes.toString());

		return payRecoveryRes;

	}

	@RequestMapping(value = { "/getPayRecoveryBetDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPayRecoveryHead> getPayRecoveryBetDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<GetPayRecoveryHead> wList = new ArrayList<GetPayRecoveryHead>();

		try {

			wList = getPayRecoveryHeadRepo.getPayRecBetDate(fromDate, toDate);
			for (int i = 0; i < wList.size(); i++) {
				wList.get(i).setCreditDate1(DateConvertor.convertToDMY(wList.get(i).getCreditDate1()));
				wList.get(i).setCreditDate2(DateConvertor.convertToDMY(wList.get(i).getCreditDate2()));
				wList.get(i).setCreditDate3(DateConvertor.convertToDMY(wList.get(i).getCreditDate3()));
				wList.get(i).setBillDate(DateConvertor.convertToDMY(wList.get(i).getBillDate()));

			}
		} catch (Exception e) {

			e.printStackTrace();

		}
		return wList;

	}

	@RequestMapping(value = { "/getPayRecoveryByPayHeadId" }, method = RequestMethod.POST)
	public @ResponseBody GetPayRecoveryHead getPayRecoveryByPayHeadId(@RequestParam("payHeadId") int payHeadId) {

		GetPayRecoveryHead wget = new GetPayRecoveryHead();

		try {

			wget = getPayRecoveryHeadRepo.getPayRecByHeadId(payHeadId);
			wget.setBillDate(DateConvertor.convertToDMY(wget.getBillDate()));
			wget.setCreditDate1(DateConvertor.convertToDMY(wget.getCreditDate1()));
			wget.setCreditDate2(DateConvertor.convertToDMY(wget.getCreditDate2()));
			wget.setCreditDate3(DateConvertor.convertToDMY(wget.getCreditDate3()));

			List<PayRecoveryDetail> detailList = payRecoveryDetailRepo.findByPayHeadIdAndDelStatus(wget.getPayHeadId(),
					1);
			wget.setPayRecoveryDetailList(detailList);

			for (int i = 0; i < detailList.size(); i++) {
				detailList.get(i).setPaymentDate(DateConvertor.convertToDMY(detailList.get(i).getPaymentDate()));

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return wget;

	}

	@RequestMapping(value = { "/deleteMultiPayRec" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiPayRec(@RequestParam("payHeadIds") List<Integer> payHeadIds) {

		Info info = new Info();

		try {
			int delete = payRecoveryHeadRepo.deleteMultiPayRecoveryHead(payHeadIds);

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

	@RequestMapping(value = { "/deletePayRecDetail" }, method = RequestMethod.POST)
	public @ResponseBody Info deletePayRecDetail(@RequestParam("payDetailId") int payDetailId) {

		int isDeleted = payRecoveryDetailRepo.deletePayRecoveryDetail(payDetailId);
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

}
