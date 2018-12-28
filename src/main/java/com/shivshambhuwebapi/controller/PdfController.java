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
import com.shivshambhuwebapi.tx.model.QuotPrintData;
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

		
		try {

			for (int i = 0; i < quotIdList.size(); i++) {
				QuotPrintData printData = new QuotPrintData();

				Company comp=new Company();

				Cust cust=new Cust();


				List<DocTermDetail> docTermList=new ArrayList<>();

				PaymentTerm payTerm=new PaymentTerm();

				Project proj=new Project();

				BankDetail bank=new BankDetail();
				
				comp = getCompanyRepo.getCompaniesByQuotIds(quotIdList.get(i));
				printData.setComp(comp);

				cust = getCustRepo.getCustByQuotIdList(quotIdList.get(i));
				printData.setCust(cust);
				List<GetQuotDetailPrint> quotDetPrint=new ArrayList<>();

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

}
