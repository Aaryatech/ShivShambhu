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

	private int plantId;
	
	private String plantName;
	
	private float total;
	
	private float taxPer;//new
	private float taxableValue;//new 
	private float taxValue;//new
	private float isTaxInc;//new
	
	
	
	public float getTaxPer() {
		return taxPer;
	}

	public void setTaxPer(float taxPer) {
		this.taxPer = taxPer;
	}

	public float getTaxableValue() {
		return taxableValue;
	}

	public void setTaxableValue(float taxableValue) {
		this.taxableValue = taxableValue;
	}

	public float getTaxValue() {
		return taxValue;
	}

	public void setTaxValue(float taxValue) {
		this.taxValue = taxValue;
	}

	public float getIsTaxInc() {
		return isTaxInc;
	}

	public void setIsTaxInc(float isTaxInc) {
		this.isTaxInc = isTaxInc;
	}



	private String uomName;
	
	private String itemName;
	
	private String itemCode;
	
	private int quotUomId;
	
	private String quotNo;
	
	private Date quotDate;

	@JsonFormat(locale = "hi",  pattern = "dd-MM-yyyy", timezone = "Asia/Kolkata")
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

	
	
	public int getPlantId() {
		return plantId;
	}

	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	@Override
	public String toString() {
		return "GetQuotDetailPrint [quotDetailId=" + quotDetailId + ", quotHeadId=" + quotHeadId + ", itemId=" + itemId
				+ ", quotQty=" + quotQty + ", rate=" + rate + ", plantId=" + plantId + ", plantName=" + plantName
				+ ", total=" + total + ", taxPer=" + taxPer + ", taxableValue=" + taxableValue + ", taxValue="
				+ taxValue + ", isTaxInc=" + isTaxInc + ", uomName=" + uomName + ", itemName=" + itemName
				+ ", itemCode=" + itemCode + ", quotUomId=" + quotUomId + ", quotNo=" + quotNo + ", quotDate="
				+ quotDate + "]";
	}

	
	
	
}
