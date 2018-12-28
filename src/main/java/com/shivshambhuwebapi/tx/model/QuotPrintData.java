package com.shivshambhuwebapi.tx.model;

import java.util.List;

import com.shivshambhuwebapi.master.model.BankDetail;
import com.shivshambhuwebapi.master.model.Company;
import com.shivshambhuwebapi.master.model.Cust;
import com.shivshambhuwebapi.master.model.DocTermDetail;
import com.shivshambhuwebapi.master.model.PaymentTerm;
import com.shivshambhuwebapi.master.model.Project;
import com.shivshambhuwebapi.master.repo.GetQuotDetailPrint;

public class QuotPrintData {
	
	Company comp;
	
	Cust cust;
	
	List<GetQuotDetailPrint> quotDetPrint;
	
	List<DocTermDetail> docTermList;
	
	PaymentTerm payTerm;
	
	Project proj;
	
	BankDetail bank;
	
	

	public Company getComp() {
		return comp;
	}

	public void setComp(Company comp) {
		this.comp = comp;
	}

	public Cust getCust() {
		return cust;
	}

	public void setCust(Cust cust) {
		this.cust = cust;
	}

	public List<GetQuotDetailPrint> getQuotDetPrint() {
		return quotDetPrint;
	}

	public void setQuotDetPrint(List<GetQuotDetailPrint> quotDetPrint) {
		this.quotDetPrint = quotDetPrint;
	}

	public List<DocTermDetail> getDocTermList() {
		return docTermList;
	}

	public void setDocTermList(List<DocTermDetail> docTermList) {
		this.docTermList = docTermList;
	}

	public PaymentTerm getPayTerm() {
		return payTerm;
	}

	public void setPayTerm(PaymentTerm payTerm) {
		this.payTerm = payTerm;
	}

	public Project getProj() {
		return proj;
	}

	public void setProj(Project proj) {
		this.proj = proj;
	}

	public BankDetail getBank() {
		return bank;
	}

	public void setBank(BankDetail bank) {
		this.bank = bank;
	}

	@Override
	public String toString() {
		return "QuotPrintData [comp=" + comp + ", cust=" + cust + ", quotDetPrint=" + quotDetPrint + ", docTermList="
				+ docTermList + ", payTerm=" + payTerm + ", proj=" + proj + ", bank=" + bank + "]";
	}

}
