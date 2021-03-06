package com.shivshambhuwebapi.tx.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetQuotHeads {

	@Id	
	private int quotHeadId;

	private String quotNo;

	private Date quotDate;

	private int status;

	private String custName;

	private String compName;

	private String plantName;

	private String enqNo;

	private String usrName;

	private int plantId;
	
	private int custId;

	private int enqHeadId;

	
	public int getEnqHeadId() {
		return enqHeadId;
	}

	public void setEnqHeadId(int enqHeadId) {
		this.enqHeadId = enqHeadId;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public int getPlantId() {
		return plantId;
	}

	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}

	public String getUsrName() {
		return usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public int getQuotHeadId() {
		return quotHeadId;
	}

	public void setQuotHeadId(int quotHeadId) {
		this.quotHeadId = quotHeadId;
	}

	public String getQuotNo() {
		return quotNo;
	}

	public void setQuotNo(String quotNo) {
		this.quotNo = quotNo;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getQuotDate() {
		return quotDate;
	}

	public void setQuotDate(Date quotDate) {
		this.quotDate = quotDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public String getEnqNo() {
		return enqNo;
	}

	public void setEnqNo(String enqNo) {
		this.enqNo = enqNo;
	}

	@Override
	public String toString() {
		return "GetQuotHeads [quotHeadId=" + quotHeadId + ", quotNo=" + quotNo + ", quotDate=" + quotDate + ", status="
				+ status + ", custName=" + custName + ", compName=" + compName + ", plantName=" + plantName + ", enqNo="
				+ enqNo + ", usrName=" + usrName + ", plantId=" + plantId + ", custId=" + custId + ", enqHeadId="
				+ enqHeadId + "]";
	}

}
