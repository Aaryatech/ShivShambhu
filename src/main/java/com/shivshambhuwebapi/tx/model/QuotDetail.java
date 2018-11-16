package com.shivshambhuwebapi.tx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_quot_detail")
public class QuotDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	@Column(name = "taxable_value")
	private float taxableValue;

	@Column(name = "tax_value")
	private float taxValue;

	@Column(name = "tax_id")
	private int taxId;

	@Column(name = "total")
	private float total;

	@Column(name = "total_cost")
	private float totalCost;

	@Column(name = "trans_cost")
	private float transCost;

	@Column(name = "other_cost_before_tax")
	private float otherCostBeforeTax;

	@Column(name = "other_tax_after_tax")
	private float otherTaxAfterTax;

	@Column(name = "royalty_tax")
	private float royaltyTax;

	@Column(name = "no_of_km")
	private float noOfKm;

	private float sgstPer;
	private float cgstPer;

	public float getSgstPer() {
		return sgstPer;
	}

	public void setSgstPer(float sgstPer) {
		this.sgstPer = sgstPer;
	}

	public float getCgstPer() {
		return cgstPer;
	}

	public void setCgstPer(float cgstPer) {
		this.cgstPer = cgstPer;
	}

	@Column(name = "enq_detail_id")
	private int enqDetailId;

	@Column(name = "cgst_value")
	private float cgstValue;

	@Column(name = "sgst_value")
	private float sgstValue;

	@Column(name = "other_cost")
	private float otherCost;

	@Column(name = "status")
	private int status;

	@Column(name = "del_status")
	private int delStatus;

	@Column(name = "ex_int1")
	private int exInt1;

	@Column(name = "ex_int2")
	private int exInt2;

	@Column(name = "ex_int3")
	private int exInt3;

	@Column(name = "ex_var1")
	private String exVar1;

	@Column(name = "ex_var2")
	private String exVar2;

	@Column(name = "ex_var3")
	private String exVar3;

	@Column(name = "ex_date1")
	private String exDate1;

	@Column(name = "ex_date2")
	private String exDate2;

	@Column(name = "ex_bool1")
	private int exBool1;

	@Column(name = "ex_bool2")
	private int exBool2;

	@Column(name = "ex_bool3")
	private int exBool3;

	@Column(name = "con_factor")
	private float conFactor;

	@Column(name = "conv_qty")
	private float convQty;

	@Column(name = "quot_uom_id")
	private int quotUomId;

	@Column(name = "igst_per")
	private float igstPer;

	@Column(name = "igst_value")
	private float igstValue;

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

	public float getTransCost() {
		return transCost;
	}

	public void setTransCost(float transCost) {
		this.transCost = transCost;
	}

	public float getOtherCostBeforeTax() {
		return otherCostBeforeTax;
	}

	public void setOtherCostBeforeTax(float otherCostBeforeTax) {
		this.otherCostBeforeTax = otherCostBeforeTax;
	}

	public float getOtherTaxAfterTax() {
		return otherTaxAfterTax;
	}

	public void setOtherTaxAfterTax(float otherTaxAfterTax) {
		this.otherTaxAfterTax = otherTaxAfterTax;
	}

	public float getRoyaltyTax() {
		return royaltyTax;
	}

	public void setRoyaltyTax(float royaltyTax) {
		this.royaltyTax = royaltyTax;
	}

	public float getNoOfKm() {
		return noOfKm;
	}

	public void setNoOfKm(float noOfKm) {
		this.noOfKm = noOfKm;
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

	public int getTaxId() {
		return taxId;
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	public int getEnqDetailId() {
		return enqDetailId;
	}

	public void setEnqDetailId(int enqDetailId) {
		this.enqDetailId = enqDetailId;
	}

	public float getCgstValue() {
		return cgstValue;
	}

	public void setCgstValue(float cgstValue) {
		this.cgstValue = cgstValue;
	}

	public float getSgstValue() {
		return sgstValue;
	}

	public void setSgstValue(float sgstValue) {
		this.sgstValue = sgstValue;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getExInt1() {
		return exInt1;
	}

	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}

	public int getExInt2() {
		return exInt2;
	}

	public void setExInt2(int exInt2) {
		this.exInt2 = exInt2;
	}

	public int getExInt3() {
		return exInt3;
	}

	public void setExInt3(int exInt3) {
		this.exInt3 = exInt3;
	}

	public String getExVar1() {
		return exVar1;
	}

	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}

	public String getExVar2() {
		return exVar2;
	}

	public void setExVar2(String exVar2) {
		this.exVar2 = exVar2;
	}

	public String getExVar3() {
		return exVar3;
	}

	public void setExVar3(String exVar3) {
		this.exVar3 = exVar3;
	}

	public String getExDate1() {
		return exDate1;
	}

	public void setExDate1(String exDate1) {
		this.exDate1 = exDate1;
	}

	public String getExDate2() {
		return exDate2;
	}

	public void setExDate2(String exDate2) {
		this.exDate2 = exDate2;
	}

	public int getExBool1() {
		return exBool1;
	}

	public void setExBool1(int exBool1) {
		this.exBool1 = exBool1;
	}

	public int getExBool2() {
		return exBool2;
	}

	public void setExBool2(int exBool2) {
		this.exBool2 = exBool2;
	}

	public int getExBool3() {
		return exBool3;
	}

	public void setExBool3(int exBool3) {
		this.exBool3 = exBool3;
	}

	public float getOtherCost() {
		return otherCost;
	}

	public void setOtherCost(float otherCost) {
		this.otherCost = otherCost;
	}

	public float getConFactor() {
		return conFactor;
	}

	public void setConFactor(float conFactor) {
		this.conFactor = conFactor;
	}

	public float getConvQty() {
		return convQty;
	}

	public void setConvQty(float convQty) {
		this.convQty = convQty;
	}

	public int getQuotUomId() {
		return quotUomId;
	}

	public void setQuotUomId(int quotUomId) {
		this.quotUomId = quotUomId;
	}

	public float getIgstPer() {
		return igstPer;
	}

	public void setIgstPer(float igstPer) {
		this.igstPer = igstPer;
	}

	public float getIgstValue() {
		return igstValue;
	}

	public void setIgstValue(float igstValue) {
		this.igstValue = igstValue;
	}

	@Override
	public String toString() {
		return "QuotDetail [quotDetailId=" + quotDetailId + ", quotHeadId=" + quotHeadId + ", itemId=" + itemId
				+ ", quotQty=" + quotQty + ", rate=" + rate + ", taxableValue=" + taxableValue + ", taxValue="
				+ taxValue + ", taxId=" + taxId + ", total=" + total + ", totalCost=" + totalCost + ", transCost="
				+ transCost + ", otherCostBeforeTax=" + otherCostBeforeTax + ", otherTaxAfterTax=" + otherTaxAfterTax
				+ ", royaltyTax=" + royaltyTax + ", noOfKm=" + noOfKm + ", sgstPer=" + sgstPer + ", cgstPer=" + cgstPer
				+ ", enqDetailId=" + enqDetailId + ", cgstValue=" + cgstValue + ", sgstValue=" + sgstValue
				+ ", otherCost=" + otherCost + ", status=" + status + ", delStatus=" + delStatus + ", exInt1=" + exInt1
				+ ", exInt2=" + exInt2 + ", exInt3=" + exInt3 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2
				+ ", exVar3=" + exVar3 + ", exDate1=" + exDate1 + ", exDate2=" + exDate2 + ", exBool1=" + exBool1
				+ ", exBool2=" + exBool2 + ", exBool3=" + exBool3 + ", conFactor=" + conFactor + ", convQty=" + convQty
				+ ", quotUomId=" + quotUomId + ", igstPer=" + igstPer + ", igstValue=" + igstValue + "]";
	}

}
