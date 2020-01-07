package com.shivshambhuwebapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class PoChallanDetails {
@Id
	private String id;
	private int itemQty;
	private Date chalanDate;
	private String chalanNo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getItemQty() {
		return itemQty;
	}
	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getChalanDate() {
		return chalanDate;
	}
	public void setChalanDate(Date chalanDate) {
		this.chalanDate = chalanDate;
	}
	public String getChalanNo() {
		return chalanNo;
	}
	public void setChalanNo(String chalanNo) {
		this.chalanNo = chalanNo;
	}
	@Override
	public String toString() {
		return "PoChallanDetails [id=" + id + ", itemQty=" + itemQty + ", chalanDate=" + chalanDate + ", chalanNo="
				+ chalanNo + "]";
	}
	
	
}
