package com.shivshambhuwebapi.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.websocket.server.Constants;
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
import com.shivshambhuwebapi.model.GetPoReport;
import com.shivshambhuwebapi.model.bill.GetBillHeader;
import com.shivshambhuwebapi.model.bill.GetBillReport;
import com.shivshambhuwebapi.model.bill.GetDailySalesReport;
import com.shivshambhuwebapi.model.bill.GetDateWiseDetailBill;
import com.shivshambhuwebapi.model.bill.GetDatewiseReport;
import com.shivshambhuwebapi.model.bill.MonthWiseBill;
import com.shivshambhuwebapi.model.bill.TaxSummery;
import com.shivshambhuwebapi.repository.GetBillReportRepo;
import com.shivshambhuwebapi.repository.GetDailySalesReportRepo;
import com.shivshambhuwebapi.repository.GetDatewiseReportRepo;
import com.shivshambhuwebapi.repository.GetPoReportRepo;
import com.shivshambhuwebapi.repository.TaxSummeryRepo;
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

import ch.qos.logback.classic.pattern.DateConverter;

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

	@Autowired
	GetPoReportRepo getPoReportRepo;

	@Autowired
	TaxSummeryRepo taxSummeryRepo;

	@RequestMapping(value = { "/getPoReportBetDateAndType" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPoReport> getPoReportBetDateAndType(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("plantId") int plantId,
			@RequestParam("type") int type) {

		List<GetPoReport> poList = new ArrayList<GetPoReport>();

		try {

			if (type == 1) {

				if (plantId != 0) {
					poList = getPoReportRepo.getPoBetweenDateAndPlantId(fromDate, toDate, plantId);
				} else {
					poList = getPoReportRepo.getPoBetweenDate(fromDate, toDate);
				}

			} else {

				if (plantId != 0) {
					poList = getPoReportRepo.getPoByPlantId(plantId);
				} else {
					poList = getPoReportRepo.getPoReport();
				}

			}

			for (int i = 0; i < poList.size(); i++) {
				poList.get(i).setPoDate(DateConvertor.convertToDMY(poList.get(i).getPoDate()));

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return poList;

	}

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

		System.out.println("startgetPoklenReportBetweenDate ");

		System.out.println("start date is" + fromDate);
		System.out.println("end date is" + toDate);

		List<PoklenReport> headerList = new ArrayList<PoklenReport>();

		try {

			if (fromDate.compareTo(toDate) < 0) {

				System.out.println("start is before end");

				String sd = DateConvertor.convertToDMY(fromDate);
				String ed = DateConvertor.convertToDMY(toDate);
				System.out.println("start date new is" + sd);
				System.out.println("end date new  is" + ed);

				// SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
				Date dateBefore = new SimpleDateFormat("dd-MM-yyyy").parse(sd);
				Date dateAfter = new SimpleDateFormat("dd-MM-yyyy").parse(ed);

				// Date dateBefore = myFormat.parse(sd);
				// Date dateAfter = myFormat.parse(ed);
				long difference = dateAfter.getTime() - dateBefore.getTime();
				float diff = (difference / (1000 * 60 * 60 * 24));

				System.out.println("Number of Days between dates: " + diff);

				headerList = poklenReportRepo.getPoklenReportBetweenDate1(fromDate, toDate, diff);
			}

			else if (fromDate.compareTo(toDate) == 0) {

				System.out.println("start is equal to end");
				headerList = poklenReportRepo.getPoklenReportBetweenDate(fromDate, toDate);
			}
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

				System.err.println("billHeaderRes1" + billHeaderRes.toString());
				System.out.println("billHeaderRes1" + billHeaderRes.toString());

			} else if (!plantIdList.contains(0) && companyIdList.contains(0)) {
				billHeaderRes = getBillReportRepo.getBillHeadersBetDateANdPlantIdList(plantIdList, fromDate, toDate);

				System.out.println("billHeaderRes2" + billHeaderRes.toString());
			} else if (plantIdList.contains(0) && !companyIdList.contains(0)) {
				billHeaderRes = getBillReportRepo.getBillHeadersBetDateANdCompIdList(companyIdList, fromDate, toDate);
				System.out.println("billHeaderRes3" + billHeaderRes.toString());
			} else {

				billHeaderRes = getBillReportRepo.getBillHeadersBetDateANdIdList(plantIdList, companyIdList, fromDate,
						toDate);
				System.out.println("billHeaderRes4" + billHeaderRes.toString());
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
	public @ResponseBody List<GetBillReport> getCustomerwiseReport(@RequestParam("plantId") int plantId,
			@RequestParam("custIdList") List<Integer> custIdList, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {
		System.err.println(
				"plantIdList " + plantId + "custIdList " + custIdList + "fromDate" + fromDate + "toDate" + toDate);
		List<GetBillReport> billHeaderRes = new ArrayList<>();

		try {

			if (plantId == 0 && custIdList.contains(0)) {
				System.out.println("BillHeaderRes1:");
				billHeaderRes = getBillReportRepo.getBillCustBetDate(fromDate, toDate);

			} else if (plantId != 0 && custIdList.contains(0)) {
				System.out.println("BillHeaderRes2:");
				billHeaderRes = getBillReportRepo.getBillCustBetDateAndPlantIdList(plantId, fromDate, toDate);
			} else if (plantId == 0 && !custIdList.contains(0)) {
				System.out.println("BillHeaderRes3:");
				billHeaderRes = getBillReportRepo.getBillCustBetDateANdCustIdList(custIdList, fromDate, toDate);

			} else {

				System.out.println("BillHeaderRes4:");
				billHeaderRes = getBillReportRepo.getBillHeadersBetDateANdCustIdList(plantId, custIdList, fromDate,
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

	// 7-1-2019
	@RequestMapping(value = { "/getBillDetailByCustIdAndDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetBillReport> getBillDetailByCustIdAndDate(@RequestParam("custId") int custId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<GetBillReport> billHeaderRes = new ArrayList<>();

		try {

			billHeaderRes = getBillReportRepo.getBillHeaderByCustIdAndDate(custId, fromDate, toDate);

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

				System.err.println("billHeaderRes01" + billHeaderRes.toString());
				System.out.println("billHeaderRes01" + billHeaderRes.toString());

			} else if (!plantIdList.contains(0)) {
				billHeaderRes = itemwiseRepo.getBillDetailByPlantId(plantIdList, fromDate, toDate);

				System.out.println("billHeaderRes1" + billHeaderRes.toString());
			} else {

				billHeaderRes = itemwiseRepo.getBillDetailByPlantId(plantIdList, fromDate, toDate);
				System.out.println("billHeaderRes2" + billHeaderRes.toString());
			}

			/*
			 * for (int i = 0; i < billHeaderRes.size(); i++) {
			 * billHeaderRes.get(i).setBillDate(DateConvertor.convertToDMY(billHeaderRes.get
			 * (i).getBillDate())); }
			 *///

		} catch (Exception e) {

			e.printStackTrace();

		}

		return billHeaderRes;

	}

	@RequestMapping(value = { "/getTaxwiseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<TaxWiseBill> getTaxwiseReport(@RequestParam("plantId") int plantId,
			@RequestParam("custIdList") List<Integer> custIdList, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		System.err.println(
				"plantIdList " + plantId + "custIdList " + custIdList + "fromDate" + fromDate + "toDate" + toDate);
		List<TaxWiseBill> billHeaderRes = new ArrayList<>();

		try {

			if (plantId == 0 && custIdList.contains(0)) {

				billHeaderRes = taxwiseRepo.getBillDetail(fromDate, toDate);

			} else if (plantId != 0 && custIdList.contains(0)) {
				billHeaderRes = taxwiseRepo.getBillTaxBetDateAndPlantIdList(plantId, fromDate, toDate);

			} else if (plantId == 0 && !custIdList.contains(0)) {
				billHeaderRes = taxwiseRepo.getBillCustDetail(custIdList, fromDate, toDate);

			} else {

				billHeaderRes = taxwiseRepo.getBillHeadersBetDateANdCustIdList(plantId, custIdList, fromDate, toDate);

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
			@RequestParam("billDate") String billDate,@RequestParam("plantIdList") List<Integer> plantIdList,
			@RequestParam("custIdList") List<Integer> custIdList) {

		List<GetDateWiseDetailBill> billHeaderRes = new ArrayList<>();

		try {
			
			if (!plantIdList.contains(0) && !custIdList.contains(0)) {
				System.out.println("Q1");
				billHeaderRes = getDatewiseDetailReportRepo.getBillByBillHeadId(billDate,plantIdList,custIdList);
			} else if (!plantIdList.contains(0) && custIdList.contains(0)) {
				System.out.println("Q2");
				billHeaderRes = getDatewiseDetailReportRepo.getBillByBillHeadIdpalnt(billDate,plantIdList);
			} else if (plantIdList.contains(0) && !custIdList.contains(0)) {
				System.out.println("Q3");
				billHeaderRes = getDatewiseDetailReportRepo.getBillByBillHeadId(billDate,custIdList);

			} else {
				System.out.println("Q4");
				billHeaderRes = getDatewiseDetailReportRepo.getBillByBillHeadId(billDate);

			}
			 
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

	@RequestMapping(value = { "/getTaxSummeryBetweenDate" }, method = RequestMethod.POST)
	public @ResponseBody List<TaxSummery> getTaxSummeryBetweenDate(@RequestParam("plantId") int plantId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<TaxSummery> headerList = new ArrayList<TaxSummery>();

		try {
			if(plantId!=0)
			{

			headerList = taxSummeryRepo.getTaxSummeryBetDate(plantId, fromDate, toDate);
			}else
			{
				headerList = taxSummeryRepo.getTaxSummeryBetDateOnly(fromDate, toDate);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return headerList;

	}
	
	/***************************************************************************/
	@Autowired GetDailySalesReportRepo dailySalesRepo;
	@RequestMapping(value = { "/getDailySalesReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GetDailySalesReport> getDailySalesReport(
			@RequestParam("plantId") int plantId,  @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {
		System.err.println(
				"plantIdList " + plantId + "fromDate" + fromDate + "toDate" + toDate);
		List<GetDailySalesReport> billHeaderRes = new ArrayList<GetDailySalesReport>();

		try {

			if (plantId==0) {
				System.out.println("getDailySalesReport1:");	
				billHeaderRes = dailySalesRepo.getDailySalesBetDate(fromDate, toDate);
				
			} else{
				System.out.println("getDailySalesReport2:");
				billHeaderRes = dailySalesRepo.getDailySalesBetDateByPlantId(fromDate, toDate, plantId);
			} 
			System.err.println("Daily Sales Rep-------------"+billHeaderRes);

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