package com.shivshambhuwebapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shivshambhuwebapi.common.DateConvertor;
import com.shivshambhuwebapi.master.model.GetItenwiseBillReport;
import com.shivshambhuwebapi.master.repo.GetDatewiseDetailReportRepo;
import com.shivshambhuwebapi.master.repo.GetMonthwiseReportRepo;
import com.shivshambhuwebapi.master.repo.ItemWiseBill;
import com.shivshambhuwebapi.master.repo.TaxWiseBillRepo;
import com.shivshambhuwebapi.model.bill.GetBillHeader;
import com.shivshambhuwebapi.model.bill.GetBillReport;
import com.shivshambhuwebapi.model.bill.GetDateWiseDetailBill;
import com.shivshambhuwebapi.model.bill.GetDatewiseReport;
import com.shivshambhuwebapi.model.bill.MonthWiseBill;
import com.shivshambhuwebapi.repository.GetBillReportRepo;
import com.shivshambhuwebapi.repository.GetDatewiseReportRepo;
import com.shivshambhuwebapi.tx.model.GetMatIssueDetail;
import com.shivshambhuwebapi.tx.model.GetMatIssueHeader;
import com.shivshambhuwebapi.tx.model.GetMatIssueReport;
import com.shivshambhuwebapi.tx.model.GetVehDetail;
import com.shivshambhuwebapi.tx.model.GetVehHeader;
import com.shivshambhuwebapi.tx.model.GetVehReport;
import com.shivshambhuwebapi.tx.model.PoklenReport;
import com.shivshambhuwebapi.tx.model.TaxWiseBill;
import com.shivshambhuwebapi.tx.repo.GetMatIssueDetailRepo;
import com.shivshambhuwebapi.tx.repo.GetMatIssueHeaderRepo;
import com.shivshambhuwebapi.tx.repo.GetMatIssueReportRepo;
import com.shivshambhuwebapi.tx.repo.GetVehDetailRepo;
import com.shivshambhuwebapi.tx.repo.GetVehHeaderRepo;
import com.shivshambhuwebapi.tx.repo.GetVehReportRepo;
import com.shivshambhuwebapi.tx.repo.PoklenReportRepo;

@RestController
public class ReportApiController {

	@Autowired
	GetMatIssueReportRepo getMatIssueReportrepo;

	@Autowired
	GetMatIssueDetailRepo getMatIssueDetailRepo;

	@Autowired
	GetVehReportRepo getVehReportRepo;

	@Autowired
	GetVehDetailRepo getVehDetailRepo;

	@Autowired
	PoklenReportRepo poklenReportRepo;

	@Autowired
	GetBillReportRepo getBillReportRepo;

	@Autowired
	ItemWiseBill itemwiseRepo;

	@Autowired
	TaxWiseBillRepo taxwiseRepo;

	@Autowired
	GetDatewiseReportRepo getDatewiseReportRepo;

	@Autowired
	GetMonthwiseReportRepo getMonthwiseReportRepo;
	
	@Autowired
	GetDatewiseDetailReportRepo getDatewiseDetailReportRepo;

	@RequestMapping(value = { "/getContractorBetweenDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetMatIssueReport> getContractorBetweenDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<GetMatIssueReport> headerList = new ArrayList<GetMatIssueReport>();

		try {

			headerList = getMatIssueReportrepo.getContrBetweenDate(fromDate, toDate);

			for (int i = 0; i < headerList.size(); i++) {
				headerList.get(i).setDate(DateConvertor.convertToDMY(headerList.get(i).getDate()));

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return headerList;

	}

	@RequestMapping(value = { "/getVehicleBetweenDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetVehReport> getVehicleBetweenDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<GetVehReport> headerList = new ArrayList<GetVehReport>();

		try {

			headerList = getVehReportRepo.getVehicleBetweenDate(fromDate, toDate);

			for (int i = 0; i < headerList.size(); i++) {
				headerList.get(i).setDate(DateConvertor.convertToDMY(headerList.get(i).getDate()));
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return headerList;

	}

	@RequestMapping(value = { "/getPoklenReportBetweenDate" }, method = RequestMethod.POST)
	public @ResponseBody List<PoklenReport> getPoklenReportBetweenDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<PoklenReport> headerList = new ArrayList<PoklenReport>();

		try {

			headerList = poklenReportRepo.getPoklenReportBetweenDate(fromDate, toDate);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return headerList;

	}

	@RequestMapping(value = { "/getBillwiseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GetBillReport> getBillwiseReport(@RequestParam("plantIdList") List<Integer> plantIdList,
			@RequestParam("companyIdList") List<Integer> companyIdList, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {
		System.err.println("plantIdList " + plantIdList + "companyIdList " + companyIdList + "fromDate" + fromDate
				+ "toDate" + toDate);
		List<GetBillReport> billHeaderRes = new ArrayList<>();

		try {

			if (plantIdList.contains(0) && companyIdList.contains(0)) {

				billHeaderRes = getBillReportRepo.getBillHeadersBetDate(fromDate, toDate);

				System.err.println("billHeaderRes" + billHeaderRes.toString());
				System.out.println("billHeaderRes" + billHeaderRes.toString());

			} else if (!plantIdList.contains(0) && companyIdList.contains(0)) {
				billHeaderRes = getBillReportRepo.getBillHeadersBetDateANdPlantIdList(plantIdList, fromDate, toDate);

				System.out.println("billHeaderRes" + billHeaderRes.toString());
			} else if (plantIdList.contains(0) && !companyIdList.contains(0)) {
				billHeaderRes = getBillReportRepo.getBillHeadersBetDateANdCompIdList(companyIdList, fromDate, toDate);
				System.out.println("billHeaderRes" + billHeaderRes.toString());
			} else {

				billHeaderRes = getBillReportRepo.getBillHeadersBetDateANdIdList(plantIdList, companyIdList, fromDate,
						toDate);
				System.out.println("billHeaderRes" + billHeaderRes.toString());
			}

			for (int i = 0; i < billHeaderRes.size(); i++) {
				billHeaderRes.get(i).setBillDate(DateConvertor.convertToDMY(billHeaderRes.get(i).getBillDate()));
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return billHeaderRes;

	}

	@RequestMapping(value = { "/getCustomerwiseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GetBillReport> getCustomerwiseReport(
			@RequestParam("plantIdList") List<Integer> plantIdList,
			@RequestParam("custIdList") List<Integer> custIdList, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {
		System.err.println(
				"plantIdList " + plantIdList + "custIdList " + custIdList + "fromDate" + fromDate + "toDate" + toDate);
		List<GetBillReport> billHeaderRes = new ArrayList<>();

		try {

			if (plantIdList.contains(0) && custIdList.contains(0)) {

				billHeaderRes = getBillReportRepo.getBillCustBetDate(fromDate, toDate);

			} else if (!plantIdList.contains(0) && custIdList.contains(0)) {
				billHeaderRes = getBillReportRepo.getBillCustBetDateAndPlantIdList(plantIdList, fromDate, toDate);

			} else if (plantIdList.contains(0) && !custIdList.contains(0)) {
				billHeaderRes = getBillReportRepo.getBillCustBetDateANdCustIdList(custIdList, fromDate, toDate);

			} else {

				billHeaderRes = getBillReportRepo.getBillHeadersBetDateANdCustIdList(plantIdList, custIdList, fromDate,
						toDate);

			}

			for (int i = 0; i < billHeaderRes.size(); i++) {
				billHeaderRes.get(i).setBillDate(DateConvertor.convertToDMY(billHeaderRes.get(i).getBillDate()));
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return billHeaderRes;

	}

	@RequestMapping(value = { "/getBillDetailByCustId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetBillReport> getBillDetailByCustId(@RequestParam("custId") int custId) {

		List<GetBillReport> billHeaderRes = new ArrayList<>();

		try {

			billHeaderRes = getBillReportRepo.getBillHeaderByCustId(custId);

			for (int i = 0; i < billHeaderRes.size(); i++) {
				billHeaderRes.get(i).setBillDate(DateConvertor.convertToDMY(billHeaderRes.get(i).getBillDate()));
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return billHeaderRes;

	}

	// ******************************************Itemwise****************************************

	@RequestMapping(value = { "/getItemwiseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GetItenwiseBillReport> getItemwiseReport(
			@RequestParam("plantIdList") List<Integer> plantIdList, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {
		System.err.println("plantIdList " + plantIdList + "fromDate" + fromDate + "toDate" + toDate);
		List<GetItenwiseBillReport> billHeaderRes = new ArrayList<>();

		try {

			if (plantIdList.contains(0)) {

				billHeaderRes = itemwiseRepo.getBillDetail(fromDate, toDate);

				System.err.println("billHeaderRes" + billHeaderRes.toString());
				System.out.println("billHeaderRes" + billHeaderRes.toString());

			} else if (!plantIdList.contains(0)) {
				billHeaderRes = itemwiseRepo.getBillDetailByPlantId(plantIdList, fromDate, toDate);

				System.out.println("billHeaderRes" + billHeaderRes.toString());
			} else {

				billHeaderRes = itemwiseRepo.getBillDetailByPlantId(plantIdList, fromDate, toDate);
				System.out.println("billHeaderRes" + billHeaderRes.toString());
			}

			/*
			 * for (int i = 0; i < billHeaderRes.size(); i++) {
			 * billHeaderRes.get(i).setBillDate(DateConvertor.convertToDMY(billHeaderRes.get
			 * (i).getBillDate())); }
			 */
		} catch (Exception e) {

			e.printStackTrace();

		}

		return billHeaderRes;

	}

	@RequestMapping(value = { "/getTaxwiseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<TaxWiseBill> getTaxwiseReport(@RequestParam("plantIdList") List<Integer> plantIdList,
			@RequestParam("custIdList") List<Integer> custIdList, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		System.err.println(
				"plantIdList " + plantIdList + "custIdList " + custIdList + "fromDate" + fromDate + "toDate" + toDate);
		List<TaxWiseBill> billHeaderRes = new ArrayList<>();

		try {

			if (plantIdList.contains(0) && custIdList.contains(0)) {

				billHeaderRes = taxwiseRepo.getBillDetail(fromDate, toDate);

			} else if (!plantIdList.contains(0) && custIdList.contains(0)) {
				billHeaderRes = taxwiseRepo.getBillTaxBetDateAndPlantIdList(plantIdList, fromDate, toDate);

			} else if (plantIdList.contains(0) && !custIdList.contains(0)) {
				billHeaderRes = taxwiseRepo.getBillCustDetail(custIdList, fromDate, toDate);

			} else {

				billHeaderRes = taxwiseRepo.getBillHeadersBetDateANdCustIdList(plantIdList, custIdList, fromDate,
						toDate);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return billHeaderRes;

	}

	@RequestMapping(value = { "/getDatewiseBillReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GetDatewiseReport> getDatewiseBillReport(@RequestParam("plantId") int plantId,
			@RequestParam("custId") int custId, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<GetDatewiseReport> billHeaderRes = new ArrayList<>();

		try {

			if (plantId != 0 && custId != 0) {

				billHeaderRes = getDatewiseReportRepo.getBillById(fromDate, toDate, plantId, custId);

			} else if (plantId != 0 && custId == 0) {
				billHeaderRes = getDatewiseReportRepo.getBillBetDateAndPlantId(fromDate, toDate, plantId);

			} else if (plantId == 0 && custId != 0) {
				billHeaderRes = getDatewiseReportRepo.getBillByCustId(fromDate, toDate, custId);

			} else {

				billHeaderRes = getDatewiseReportRepo.getBillBetdate(fromDate, toDate);

			}
			for (int i = 0; i < billHeaderRes.size(); i++) {
				billHeaderRes.get(i).setBillDate(DateConvertor.convertToDMY(billHeaderRes.get(i).getBillDate()));
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return billHeaderRes;

	}

	@RequestMapping(value = { "/getDatewiseDetailBillReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GetDateWiseDetailBill> getDatewiseDetailBillReport(
			@RequestParam("billDate") String billDate) {

		List<GetDateWiseDetailBill> billHeaderRes = new ArrayList<>();

		try {
			billHeaderRes = getDatewiseDetailReportRepo.getBillByBillHeadId(billDate);
			for (int i = 0; i < billHeaderRes.size(); i++) {
				billHeaderRes.get(i).setBillDate(DateConvertor.convertToDMY(billHeaderRes.get(i).getBillDate()));
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return billHeaderRes;

	}

	@RequestMapping(value = { "/getMonthwiseBillReport" }, method = RequestMethod.POST)
	public @ResponseBody List<MonthWiseBill> getMonthwiseBillReport(
			@RequestParam("plantIdList") List<Integer> plantIdList,
			@RequestParam("custIdList") List<Integer> custIdList, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<MonthWiseBill> billHeaderRes = new ArrayList<>();

		try {

			if (!plantIdList.contains(0) && !custIdList.contains(0)) {

				billHeaderRes = getMonthwiseReportRepo.getBillById(fromDate, toDate, plantIdList, custIdList);

			} else if (!plantIdList.contains(0) && custIdList.contains(0)) {
				billHeaderRes = getMonthwiseReportRepo.getBillByPlantId(fromDate, toDate, plantIdList);

			} else if (plantIdList.contains(0) && !custIdList.contains(0)) {
				billHeaderRes = getMonthwiseReportRepo.getBillByCustId(fromDate, toDate, custIdList);

			} else {

				billHeaderRes = getMonthwiseReportRepo.getBillBetdate(fromDate, toDate);

			}
			/*
			 * for (int i = 0; i < billHeaderRes.size(); i++) {
			 * billHeaderRes.get(i).setBillDate(DateConvertor.convertToDMY(billHeaderRes.get
			 * (i).getBillDate())); }
			 */

		} catch (Exception e) {

			e.printStackTrace();

		}

		return billHeaderRes;

	}

}
/*
 * SELECT monthname(h.bill_date) as month_name,SUM(d.cgst_amt) as
 * cgst_amt,SUM(d.sgst_amt) as sgst_amt,SUM(d.igst_amt) as
 * igst_amt,SUM(d.tax_amt) as tax_amt,SUM(d.taxable_amt) as
 * taxable_amt,SUM(d.total_amt) as total_amt FROM t_bill_header h, t_bill_detail
 * d WHERE h.cust_id=47 and h.ex_int1=51 and d.bill_head_id=h.bill_head_id and
 * bill_date BETWEEN '2018-12-1' AND '2019-01-30' GROUP by month(h.bill_date)
 */