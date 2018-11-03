package com.shivshambhuwebapi.master.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
@Entity
@Table(name="m_tax")


public class Tax 
{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="tax_id")
private int taxId;

@Column(name="tax_name")
private String taxName;

@Column(name="del_status")
private int delStatus;

@Column(name="hsn_code")
private String hsnCode;

@Column(name="total_tax_per")
private float totalTaxPer;

@Column(name="cgst")
private float cgst;

@Column(name="igst")
private float igst;

@Column(name="sgst")
private float sgst;

@Column(name="cess")
private float cess;

@Column(name="sort_no")
private int sortNo;

@Column(name="ex_int1")
private int exInt1;

@Column(name="ex_int2")
private int exInt2;

@Column(name="ex_int3")
private int exInt3;

@Column(name="ex_var1")
private String exVar1;

@Column(name="ex_var2")
private String exVar2;

@Column(name="ex_var3")
private String exVar3;

@Column(name="ex_date1")
private String exDate1;

@Column(name="ex_date2")
private String exDate2;



@Column(name="ex_bool1")
private int exBool1;

@Column(name="ex_bool2")
private int exBool2;

@Column(name="ex_bool3")
private int exBool3;

public int getTaxId() {
	return taxId;
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

public void setTaxId(int taxId) {
	this.taxId = taxId;
}

public String getTaxName() {
	return taxName;
}

public void setTaxName(String taxName) {
	this.taxName = taxName;
}

public int getDelStatus() {
	return delStatus;
}

public void setDelStatus(int delStatus) {
	this.delStatus = delStatus;
}

public String getHsnCode() {
	return hsnCode;
}

public void setHsnCode(String hsnCode) {
	this.hsnCode = hsnCode;
}

public float getTotalTaxPer() {
	return totalTaxPer;
}

public void setTotalTaxPer(float totalTaxPer) {
	this.totalTaxPer = totalTaxPer;
}

public float getCgst() {
	return cgst;
}

public void setCgst(float cgst) {
	this.cgst = cgst;
}

public float getIgst() {
	return igst;
}

public void setIgst(float igst) {
	this.igst = igst;
}

public float getSgst() {
	return sgst;
}

public void setSgst(float sgst) {
	this.sgst = sgst;
}

public float getCess() {
	return cess;
}

public void setCess(float cess) {
	this.cess = cess;
}

public int getSortNo() {
	return sortNo;
}

public void setSortNo(int sortNo) {
	this.sortNo = sortNo;
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

@Override
public String toString() {
	return "Tax [taxId=" + taxId + ", taxName=" + taxName + ", delStatus=" + delStatus + ", hsnCode=" + hsnCode
			+ ", totalTaxPer=" + totalTaxPer + ", cgst=" + cgst + ", igst=" + igst + ", sgst=" + sgst + ", cess=" + cess
			+ ", sortNo=" + sortNo + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exInt3=" + exInt3 + ", exVar1="
			+ exVar1 + ", exVar2=" + exVar2 + ", exVar3=" + exVar3 + ", exDate1=" + exDate1 + ", exDate2=" + exDate2
			+ ", exBool1=" + exBool1 + ", exBool2=" + exBool2 + ", exBool3=" + exBool3 + "]";
}

	
}