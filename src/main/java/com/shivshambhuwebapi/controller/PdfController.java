package com.shivshambhuwebapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shivshambhuwebapi.master.model.BankDetail;
import com.shivshambhuwebapi.master.model.Company;
import com.shivshambhuwebapi.master.model.Cust;
import com.shivshambhuwebapi.master.model.DocTermDetail;
import com.shivshambhuwebapi.master.model.PaymentTerm;
import com.shivshambhuwebapi.master.model.Project;
import com.shivshambhuwebapi.master.repo.BankDetailRepo;
import com.shivshambhuwebapi.master.repo.CompanyRepo;
import com.shivshambhuwebapi.master.repo.CustRepo;
import com.shivshambhuwebapi.master.repo.DocTermDetailRepo;
import com.shivshambhuwebapi.master.repo.GetQuotDetailPrint;
import com.shivshambhuwebapi.master.repo.PaymentTermRepo;
import com.shivshambhuwebapi.master.repo.ProjectRepo;
import com.shivshambhuwebapi.tx.model.ChalanPrintData;
import com.shivshambhuwebapi.tx.model.ChalanPrintItem;
import com.shivshambhuwebapi.tx.model.QuotPrintData;
import com.shivshambhuwebapi.tx.repo.ChalanPrintItemRepo;
import com.shivshambhuwebapi.tx.repo.GetQuotDetailPrintRepo;

@RestController
public class PdfController {

	@Autowired
	CompanyRepo getCompanyRepo;

	@Autowired
	CustRepo getCustRepo;

	@Autowired
	GetQuotDetailPrintRepo getGetQuotDetailPrintRepo;

	@Autowired
	DocTermDetailRepo getDocTermDetailRepo;

	@Autowired
	PaymentTermRepo getPaymentTermRepo;

	@Autowired
	ProjectRepo getProjectRepo;
	@Autowired
	BankDetailRepo getBankDetailRepo;

	@RequestMapping(value = { "/getQuotPrintData" }, method = RequestMethod.POST)
	public @ResponseBody List<QuotPrintData> getQuotPrintData(@RequestParam("quotIdList") List<Integer> quotIdList) {

		System.err.println("Inside getQuotPrintData" + quotIdList);
		List<QuotPrintData> printDataList = new ArrayList<QuotPrintData>();

		Company comp;
//..
		Cust cust;

		List<GetQuotDetailPrint> quotDetPrint;

		List<DocTermDetail> docTermList;

		PaymentTerm payTerm;

		Project proj;

		BankDetail bank;
		try {

			for (int i = 0; i < quotIdList.size(); i++) {
				QuotPrintData printData = new QuotPrintData();

				comp = getCompanyRepo.getCompaniesByQuotIds(quotIdList.get(i));
				printData.setComp(comp);

				cust = getCustRepo.getCustByQuotIdList(quotIdList.get(i));
				printData.setCust(cust);

				quotDetPrint = getGetQuotDetailPrintRepo.getGetQuotDetailPrint(quotIdList.get(i));
				printData.setQuotDetPrint(quotDetPrint);

				docTermList = getDocTermDetailRepo.getDocTermDetailForQuotPrint(quotIdList.get(i));
				printData.setDocTermList(docTermList);

				payTerm = getPaymentTermRepo.getPayTermDetailForQuotPrint(quotIdList.get(i));
				printData.setPayTerm(payTerm);

				proj = getProjectRepo.getProjectByQuotIdList(quotIdList.get(i));
				printData.setProj(proj);

				bank = getBankDetailRepo.findFirstByCompanyIdAndDelStatus(comp.getCompanyId(), 1);
				printData.setBank(bank);

				printDataList.add(printData);

			}

			System.err.println("Print data quot" + printDataList.toString());
		} catch (Exception e) {

			System.err.println("exce in  /getQuotPrintData @PDf Api Controller " + e.getMessage());
			e.printStackTrace();

		}

		return printDataList;
	}
	
	
	@Autowired ChalanPrintItemRepo getChalanPrintItemRepo;
	
	@RequestMapping(value = { "/getChalanPrintData" }, method = RequestMethod.POST)
	public @ResponseBody ChalanPrintData getChalanPrintData(@RequestParam("chalanId") int chalanId) {

		System.err.println("Inside getChalanPrintData chalanId" + chalanId);
		ChalanPrintData chPrintData=new ChalanPrintData();
		try {
			
			List<ChalanPrintItem> chItemList=getChalanPrintItemRepo.getChalanPrintItem(chalanId);
			
			System.err.println("ch Item list " +chItemList.toString());
			
			
			chPrintData.setChalanItemList(chItemList);
			
			Company comp=getCompanyRepo.getCompanyByPlanId(chItemList.get(0).getPlantId());
			
			chPrintData.setComp(comp);
			if(chPrintData!=null)
			System.err.println("chPrintData" +chPrintData.toString());
			
			
		}catch (Exception e) {
			
			System.err.println("exce in  /getChalanPrintData @PDf Api Controller " + e.getMessage());
			e.printStackTrace();
			
		}
		
		return chPrintData;
	}
}
