package com.shivshambhuwebapi.tx.model;

import java.util.List;

import com.shivshambhuwebapi.master.model.Company;

public class ChalanPrintData {
	
	List<ChalanPrintItem> chalanItemList;
	
	Company comp;

	public List<ChalanPrintItem> getChalanItemList() {
		return chalanItemList;
	}

	public void setChalanItemList(List<ChalanPrintItem> chalanItemList) {
		this.chalanItemList = chalanItemList;
	}

	public Company getComp() {
		return comp;
	}

	public void setComp(Company comp) {
		this.comp = comp;
	}

	@Override
	public String toString() {
		return "ChalanPrintData [chalanItemList=" + chalanItemList + ", comp=" + comp + "]";
	}
	
}
