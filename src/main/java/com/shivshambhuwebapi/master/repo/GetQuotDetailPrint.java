package com.shivshambhuwebapi.master.repo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetQuotDetailPrint {
	
	
	@Id
	@Column(name = "quot_detail_id")
	private int quotDetailId;

	@Column(name = "quot_head_id")
	private int quotHeadId;

	@Column(name = "item_id")
	private int itemId;

	@Column(name = "quot_qty")
	private float quotQty;

	@Column(name = "rate")
	private float rate;

	
	private float total;
	
	private String uomName;
	
	private String itemName;
	
	private String itemCode;
	
	private int quotUomId;
	
	private String quotNo;
	
	private Date quotDate;
	
	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getQuotDate() {
		return quotDate;
	}

	public void setQuotDate(Date quotDate) {
		this.quotDate = quotDate;
	}

	public int getQuotDetailId() {
		return quotDetailId;
	}

	public void setQuotDetailId(int quotDetailId) {
		this.quotDetailId = quotDetailId;
	}

	public int getQuotHeadId() {
		return quotHeadId;
	}

	public void setQuotHeadId(int quotHeadId) {
		this.quotHeadId = quotHeadId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public float getQuotQty() {
		return quotQty;
	}

	public void setQuotQty(float quotQty) {
		this.quotQty = quotQty;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getUomName() {
		return uomName;
	}

	public void setUomName(String uomName) {
		this.uomName = uomName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public int getQuotUomId() {
		return quotUomId;
	}

	public void setQuotUomId(int quotUomId) {
		this.quotUomId = quotUomId;
	}

	public String getQuotNo() {
		return quotNo;
	}

	public void setQuotNo(String quotNo) {
		this.quotNo = quotNo;
	}


	
	@Override
	public String toString() {
		return "GetQuotDetailPrint [quotDetailId=" + quotDetailId + ", quotHeadId=" + quotHeadId + ", itemId=" + itemId
				+ ", quotQty=" + quotQty + ", rate=" + rate + ", total=" + total + ", uomName=" + uomName
				+ ", itemName=" + itemName + ", itemCode=" + itemCode + ", quotUomId=" + quotUomId + ", quotNo="
				+ quotNo + "]";
	}
	
	
}
