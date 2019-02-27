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
import com.shivshambhuwebapi.model.rec.GetPayRecoveryHeadCustWise;
import com.shivshambhuwebapi.model.rec.GetPayRecoveryHeadData;
import com.shivshambhuwebapi.model.rec.PayRecoveryDetail;
import com.shivshambhuwebapi.model.rec.PayRecoveryHead;
import com.shivshambhuwebapi.repo.rec.GetPayRecoveryHeadCustwiseRepo;
import com.shivshambhuwebapi.repo.rec.GetPayRecoveryHeadDataRepo;
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

	@Autowired
	GetPayRecoveryHeadCustwiseRepo payRecoveryHeadCustRepo;

	@Autowired
	GetPayRecoveryHeadDataRepo payRecoveryHeadDataRepo;

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
			@RequestParam("toDate") String toDate, @RequestParam("plantId") int plantId) {

		List<GetPayRecoveryHead> wList = new ArrayList<GetPayRecoveryHead>();

		try {

			// all
			if (plantId == 0) {
				wList = getPayRecoveryHeadRepo.getPayRecBetDate(fromDate, toDate);

			} else {
				// specific plant
				wList = getPayRecoveryHeadRepo.getPayRecBetDatePlantId(fromDate, toDate, plantId);
			}

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

	@RequestMapping(value = { "/getPayRecoveryByStatus" }, method = RequestMethod.GET)
	public @ResponseBody List<GetPayRecoveryHead> getPayRecoveryByStatus() {

		List<GetPayRecoveryHead> wList = new ArrayList<GetPayRecoveryHead>();

		try {

			wList = getPayRecoveryHeadRepo.getPayRecByStatus();
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

	@RequestMapping(value = { "/getPayRecoveryByStatus1" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPayRecoveryHead> getPayRecoveryByStatus1(@RequestParam("plantId") int plantId) {

		List<GetPayRecoveryHead> wList = new ArrayList<GetPayRecoveryHead>();

		try {

			if (plantId != 0) {
				wList = getPayRecoveryHeadRepo.getPayRecByStatusPlantId(plantId);
			} else {
				wList = getPayRecoveryHeadRepo.getPayRecByStatusNoPlantId();
			}

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

	@RequestMapping(value = { "/updatePayRecStatus" }, method = RequestMethod.POST)
	public @ResponseBody Info updatePayRecStatus(@RequestParam("payHeadId") int payHeadId) {

		Info info = new Info();

		try {
			int delete = payRecoveryHeadRepo.updateStatus(payHeadId);

			if (delete >= 1) {
				info.setError(false);
				info.setMessage("successfully Updated");
			} else {
				info.setError(true);
				info.setMessage(" not update");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" Not Update");

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

	// ********************Recovery Done************************//

	@RequestMapping(value = { "/getPayRecoveryDoneBetDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPayRecoveryHead> getPayRecoveryDoneBetDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("plantId") int plantId,
			@RequestParam("custId") int custId) {

		List<GetPayRecoveryHead> wList = new ArrayList<GetPayRecoveryHead>();

		try {

			// all
			if (custId == 0) {
				wList = getPayRecoveryHeadRepo.getPayRecDoneBetDatePlantId(fromDate, toDate, plantId);

			} else {
				// specific plant
				wList = getPayRecoveryHeadRepo.getPayRecDoneBetDatePlantIdCustId(fromDate, toDate, plantId, custId);
			}

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

	// ********************Recovery Done Customerwise************************//

	@RequestMapping(value = { "/getPayRecoveryDoneBetDateCustWise" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPayRecoveryHeadCustWise> getPayRecoveryDoneBetDateCustWise(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("plantId") int plantId, @RequestParam("custId") int custId) {

		List<GetPayRecoveryHeadCustWise> wList = new ArrayList<GetPayRecoveryHeadCustWise>();

		try {

			// all
			if (custId != 0 && plantId == 0) {
				wList = payRecoveryHeadCustRepo.getPayRecDoneBetDateCustId(fromDate, toDate, custId);

			}

			else if (custId == 0 && plantId != 0) {
				// specific plant
				wList = payRecoveryHeadCustRepo.getPayRecDoneBetDatePlantId(fromDate, toDate, plantId);
			} else if (custId != 0 && plantId != 0) {
				// specific plant
				wList = payRecoveryHeadCustRepo.getPayRecDoneBetDatePlantIdCustId(fromDate, toDate, plantId, custId);
			}

			else {

				wList = payRecoveryHeadCustRepo.getPayRecDoneBetDate(fromDate, toDate);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return wList;

	}

	@RequestMapping(value = { "/getPayRecoveryBetDateSpecCust" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPayRecoveryHead> getPayRecoveryBetDateSpecCust(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("custId") int custId) {

		List<GetPayRecoveryHead> wList = new ArrayList<GetPayRecoveryHead>();

		try {

			// all
			if (custId != 0) {
				wList = getPayRecoveryHeadRepo.getPayRecBetDateSpecCust(fromDate, toDate, custId);

			}
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

	@RequestMapping(value = { "/getPayRecoveryBetDateSpecCustAndStatus" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPayRecoveryHead> getPayRecoveryBetDateSpecCustAndStatus(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("custId") int custId, @RequestParam("status") int status) {

		List<GetPayRecoveryHead> wList = new ArrayList<GetPayRecoveryHead>();

		try {

			// all
			if (custId != 0) {
				wList = getPayRecoveryHeadRepo.getPayRecBetDateSpecCustAndStatus(fromDate, toDate, custId, status);

			}

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

	// ------------Payment Recovery--------------------------

	@RequestMapping(value = { "/getPayRecoveryData" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPayRecoveryHeadData> getPayRecoveryData(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("plantId") int plantId,
			@RequestParam("custId") int custId, @RequestParam("custCatId") int custCatId) {

		List<GetPayRecoveryHeadData> wList = new ArrayList<GetPayRecoveryHeadData>();

		try {

			// all
			if (custId == 0 && plantId == 0 && custCatId == 0) {

				wList = payRecoveryHeadDataRepo.getPayRecBetDate(fromDate, toDate);
			}

			else if (custId != 0 && plantId == 0 && custCatId == 0) {
				// specific Customer
				wList = payRecoveryHeadDataRepo.getPayRecBetDateAndCust(fromDate, toDate, custId);
			} else if (custId == 0 && plantId != 0 && custCatId == 0) {
				// specific plant
				wList = payRecoveryHeadDataRepo.getPayRecBetDateAndPlant(fromDate, toDate, plantId);
			}

			else if (custId == 0 && plantId == 0 && custCatId != 0) {
				// specific cust category
				wList = payRecoveryHeadDataRepo.getPayRecBetDateAndCustCat(fromDate, toDate, custCatId);
			}

			else if (custId != 0 && plantId != 0 && custCatId == 0) {

				wList = payRecoveryHeadDataRepo.getPayRecBetDateCustPlant(fromDate, toDate, plantId, custId);
			}

			else if (custId == 0 && plantId != 0 && custCatId != 0) {

				wList = payRecoveryHeadDataRepo.getPayRecBetDatePlantAndCustCat(fromDate, toDate, plantId, custCatId);
			}

			else if (custId != 0 && plantId == 0 && custCatId != 0) {

				wList = payRecoveryHeadDataRepo.getPayRecBetDateCustAndCustCat(fromDate, toDate, custId, custCatId);
			}

			else if (custId != 0 && plantId != 0 && custCatId != 0) {

				wList = payRecoveryHeadDataRepo.getPayRecBetDateCustPlantCustCat(fromDate, toDate, plantId, custId,
						custCatId);
			}

			for (int i = 0; i < wList.size(); i++) {
				wList.get(i).setBillDate(DateConvertor.convertToDMY(wList.get(i).getBillDate()));
				wList.get(i).setCreditDate1(DateConvertor.convertToDMY(wList.get(i).getCreditDate1()));
				wList.get(i).setCreditDate2(DateConvertor.convertToDMY(wList.get(i).getCreditDate2()));
				wList.get(i).setCreditDate3(DateConvertor.convertToDMY(wList.get(i).getCreditDate3()));
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return wList;

	}

}