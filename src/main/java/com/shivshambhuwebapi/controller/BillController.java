package com.shivshambhuwebapi.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.shivshambhuwebapi.common.DateConvertor;
import com.shivshambhuwebapi.master.model.BankDetail;
import com.shivshambhuwebapi.master.model.OrderDetail;
import com.shivshambhuwebapi.master.model.OrderHeader;
import com.shivshambhuwebapi.master.repo.BankDetailRepo;
import com.shivshambhuwebapi.model.bill.BillDetail;
import com.shivshambhuwebapi.model.bill.BillHeader;
import com.shivshambhuwebapi.model.bill.GetBillDetail;
import com.shivshambhuwebapi.model.bill.GetBillHeader;
import com.shivshambhuwebapi.model.bill.GetBillHeaderPdf;
import com.shivshambhuwebapi.model.bill.GetItemsForBill;
import com.shivshambhuwebapi.repository.BillDetailRepository;
import com.shivshambhuwebapi.repository.BillHeaderRepository;
import com.shivshambhuwebapi.repository.GetBillDetailRepository;
import com.shivshambhuwebapi.repository.GetBillHeaderPdfRepository;
import com.shivshambhuwebapi.repository.GetBillHeaderRepository;
import com.shivshambhuwebapi.repository.GetItemsForBillRepository;
import com.shivshambhuwebapi.tx.model.GetChalanHeader;
import com.shivshambhuwebapi.tx.repo.ChalanDetailRepo;
import com.shivshambhuwebapi.tx.repo.ChalanHeaderRepo;
import com.shivshambhuwebapi.tx.repo.GetChalanHeaderRepo;

@RestController
public class BillController {

	@Autowired
	BillHeaderRepository billHeaderRepository;

	@Autowired
	BillDetailRepository billDetailRepository;

	@Autowired
	GetChalanHeaderRepo getGetChalanHeaderRepo;

	@Autowired
	GetItemsForBillRepository getItemsForBillRepository;

	@Autowired
	GetBillHeaderRepository getBillHeaderRepository;

	@Autowired
	GetBillDetailRepository getBillDetailRepository;

	@Autowired
	GetBillHeaderPdfRepository getBillHeaderPdfRepository;

	@Autowired
	BankDetailRepo bankDetailRepository;

	@Autowired
	ChalanHeaderRepo chalanHeaderRepo;

	@Autowired
	ChalanDetailRepo chalanDetailRepo;

	@RequestMapping(value = { "/saveBills" }, method = RequestMethod.POST)
	public @ResponseBody BillHeader saveBills(@RequestBody BillHeader billHeader) {

		System.err.println("header body " + billHeader.toString());

		BillHeader billRes = null;

		try {

			billRes = billHeaderRepository.save(billHeader);

			for (int i = 0; i < billHeader.getBillDetailList().size(); i++) {

				billHeader.getBillDetailList().get(i).setBillHeadId(billRes.getBillHeadId());

			}

			List<BillDetail> billDetailList = billDetailRepository.saveAll(billHeader.getBillDetailList());

			billRes.setBillDetailList(billDetailList);

		} catch (Exception e) {

			System.err.println("exce in saving order head and detail " + e.getMessage());

			e.printStackTrace();

		}
		System.err.println("billRes body " + billRes.toString());

		return billRes;

	}

	@RequestMapping(value = { "/getChalanHeadersByCustAndStatus" }, method = RequestMethod.POST)
	public @ResponseBody List<GetChalanHeader> getChalanHeadersByCustAndStatus(@RequestParam("poId") int poId,
			@RequestParam("chalanStatus") List<Integer> chalanStatus,
			@RequestParam("billStatus") List<Integer> billStatus) {

		List<GetChalanHeader> chList = new ArrayList<>();

		try {

			chList = getGetChalanHeaderRepo.getGetChalanHeaderByCustId(poId, chalanStatus, billStatus);

		} catch (Exception e) {

			System.err.println("exce in  getChalanHeadersByPlantAndStatus " + e.getMessage());
			e.printStackTrace();

		}

		return chList;
	}

	@RequestMapping(value = { "/getChalanHeadersByCustAndStatusAndProj" }, method = RequestMethod.POST)
	public @ResponseBody List<GetChalanHeader> getChalanHeadersByCustAndStatusAndProj(
			@RequestParam("custId") int custId, @RequestParam("projId") int projId,
			@RequestParam("chalanStatus") List<Integer> chalanStatus) {

		List<GetChalanHeader> chList = new ArrayList<>();

		try {

			chList = getGetChalanHeaderRepo.getGetChalanHeaderByCustIdAndProId(projId, chalanStatus, custId);

		} catch (Exception e) {

			System.err.println("exce in  getChalanHeadersByPlantAndStatus " + e.getMessage());
			e.printStackTrace();

		}

		return chList;
	}

	List<GetItemsForBill> chList = new ArrayList<>();

	@RequestMapping(value = { "/getItemsForBill" }, method = RequestMethod.POST)
	public @ResponseBody List<GetItemsForBill> getItemsForBill(@RequestParam("chalanId") List<Integer> chalanId) {

		try {
			System.err.println("exce in  getChalanHeadersByPlantAndStatus " + chalanId.toString());
			chList = getItemsForBillRepository.getItemsForBill(chalanId);
			System.err.println("getItemsForBill " + chList.toString());

		} catch (Exception e) {
			System.err.println("exce in  getItemsForBill " + e.getMessage());
			e.printStackTrace();
		}

		return chList;
	}

	@RequestMapping(value = { "/getItemsForRmcBill" }, method = RequestMethod.POST)
	public @ResponseBody List<GetItemsForBill> getItemsForRmcBill(@RequestParam("chalanId") List<Integer> chalanId) {
		List<GetItemsForBill> chList = new ArrayList<>();
		try {
			System.err.println("exce in  getChalanHeadersByPlantAndStatus " + chalanId.toString());
			chList = getItemsForBillRepository.getItemsForRmcBill(chalanId);
			System.err.println("exce in  getChalanHeadersByPlantAndStatus " + chList.toString());

		} catch (Exception e) {
			System.err.println("exce in  getChalanHeadersByPlantAndStatus " + e.getMessage());
			e.printStackTrace();
		}

		return chList;
	}

	@RequestMapping(value = { "/getBillHeadersByDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetBillHeader> getBillHeadersByDate(@RequestParam("plantId") int plantId,
			@RequestParam("custId") int custId, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<GetBillHeader> billHeaderRes = null;

		try {

			billHeaderRes = getBillHeaderRepository.getBillHeadersByDate(plantId, custId, fromDate, toDate);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return billHeaderRes;

	}
	// 2018-12-27

	@RequestMapping(value = { "/getBillHeadersByDateAndCustAndPlant" }, method = RequestMethod.POST)
	public @ResponseBody List<GetBillHeader> getBillHeadersByDateAndCustAndPlant(@RequestParam("plantId") int plantId,
			@RequestParam("custId") int custId, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<GetBillHeader> billHeaderRes = null;

		try {

			if (plantId == 0 && custId == 0) {
				billHeaderRes = getBillHeaderRepository.getBillHeadersByDateByAll(fromDate, toDate);
			} else if (plantId == 0 && custId != 0) {
				billHeaderRes = getBillHeaderRepository.getBillHeadersByDateByCust(custId, fromDate, toDate);
			} else if (plantId != 0 && custId == 0) {
				billHeaderRes = getBillHeaderRepository.getBillHeadersByDateByPlant(plantId, fromDate, toDate);
			} else if (plantId != 0 && custId != 0) {
				billHeaderRes = getBillHeaderRepository.getBillHeadersByDateByCustByPlant(plantId, custId, fromDate,
						toDate);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return billHeaderRes;

	}

	@RequestMapping(value = { "/getBillHeaderById" }, method = RequestMethod.POST)
	public @ResponseBody GetBillHeader getBillHeaderById(@RequestParam("billHeadId") int billHeadId) {

		GetBillHeader billHeaderRes = null;

		try {

			billHeaderRes = getBillHeaderRepository.getBillHeaderById(billHeadId);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return billHeaderRes;

	}

	@RequestMapping(value = { "/findBillsByHeaderId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetBillHeaderPdf> findBillsByHeaderId(
			@RequestParam("billTempIds") List<Integer> billHeadIdList) {

		List<GetBillHeaderPdf> billHeaderRes = null;

		try {

			billHeaderRes = getBillHeaderPdfRepository.findBillsByHeaderId(billHeadIdList);

			for (int i = 0; i < billHeaderRes.size(); i++) {
				
				BankDetail bankDetail = bankDetailRepository
						.findByBankDetIdAndDelStatus(billHeaderRes.get(i).getAccId(), 1);
				
				List<GetBillDetail> billDetailList = getBillDetailRepository
						.getBillDetailsById(billHeaderRes.get(i).getBillHeadId());
				
				
				System.err.println(billDetailList + "billDetailList");
				billHeaderRes.get(i).setBankDetail(bankDetail);
				billHeaderRes.get(i).setGetBillDetails(billDetailList);
			}
			System.err.println(billHeaderRes.toString() + "billHeaderRes");
		} catch (Exception e) {

			e.printStackTrace();

		}

		return billHeaderRes;

	}

	@RequestMapping(value = { "/getBillHeaderByBillHeadId" }, method = RequestMethod.POST)
	public @ResponseBody BillHeader getBillHeaderByBillHeadId(@RequestParam("billHeadId") int billHeadId) {

		BillHeader billHeaderRes = null;

		try {

			billHeaderRes = billHeaderRepository.findByBillHeadIdAndDelStatus(billHeadId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return billHeaderRes;

	}

	@RequestMapping(value = { "/getBillDetailsById" }, method = RequestMethod.POST)
	public @ResponseBody List<GetBillDetail> getBillDetailsById(@RequestParam("billHeadId") int billHeadId) {

		List<GetBillDetail> billDetailList = null;

		try {

			billDetailList = getBillDetailRepository.getBillDetailsById(billHeadId);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return billDetailList;

	}

	@RequestMapping(value = { "/updateChalanStatus" }, method = RequestMethod.POST)
	public @ResponseBody Info updateChalanStatus(@RequestParam("chalanDetailId") List<Integer> chalanDetailId) {

		Info info = null;

		try {

			int isUpdated = chalanDetailRepo.updateChalanStatus(chalanDetailId);
			if (isUpdated >= 1) {
				List<Integer> chalanIds = getBillDetailRepository.getDistinctChalanIds(chalanDetailId);
				System.err.println(chalanIds.toString());
				for (int i = 0; i < chalanIds.size(); i++) {
					int cnt = getBillDetailRepository.getStatusCnt(chalanIds.get(i));
					System.err.println(cnt);
					if (cnt == 0) {
						chalanHeaderRepo.updateChalanHeaderStatus(chalanIds.get(i));
						System.err.println(chalanIds.get(i));
					}
				}
				info = new Info();
				info.setError(false);
				info.setMessage("Chalan Updated Successfully.");
			} else {
				info = new Info();
				info.setError(true);
				info.setMessage("Chalan Not Updated.");
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return info;

	}

	@RequestMapping(value = { "/getChalanHeadersByChalanIdList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetChalanHeader> getChalanHeadersByChalanIdList(
			@RequestParam("chalanIdList") List<Integer> chalanIdList) {

		List<GetChalanHeader> chHeader = new ArrayList<>();

		try {

			chHeader = getGetChalanHeaderRepo.getGetChalanHeaderByChalanIdList(chalanIdList);

		} catch (Exception e) {

			System.err.println("exce in  getChalanHeadersByChalanId " + e.getMessage());
			e.printStackTrace();

		}

		return chHeader;
	}
}
