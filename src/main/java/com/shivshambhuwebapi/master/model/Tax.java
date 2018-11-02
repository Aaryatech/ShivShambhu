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
private int TaxId;

@Column(name="tax_name")
private String TaxName;

@Column(name="del_status")
private int DelStatus;

@Column(name="hsn_code")
private int HsnCode;

@Column(name="total_tax_per")
private int TotalTaxPer;

@Column(name="cgst")
private int Cgst;

@Column(name="igst")
private int Igst;

@Column(name="sgst")
private int Sgst;

@Column(name="cess")
private int Cess;

@Column(name="sort_no")
private int SortNo;

@Column(name="ex_int1")
private int ExInt1;

@Column(name="ex_int2")
private int ExInt2;

@Column(name="ex_int3")
private int ExInt3;

@Column(name="ex_var1")
private String ExVar1;

@Column(name="ex_var2")
private String ExVar2;

@Column(name="ex_var3")
private String ExVar3;

@Column(name="ex_date1")
private String ExDate1;

@Column(name="ex_date2")
private String ExDate2;


public String getTaxName() {
	return TaxName;
}

public void setTaxName(String taxName) {
	TaxName = taxName;
}

public int getHsnCode() {
	return HsnCode;
}

public void setHsnCode(int hsnCode) {
	HsnCode = hsnCode;
}

public int getTotalTaxPer() {
	return TotalTaxPer;
}

public void setTotalTaxPer(int totalTaxPer) {
	TotalTaxPer = totalTaxPer;
}

public int getCgst() {
	return Cgst;
}

public void setCgst(int cgst) {
	Cgst = cgst;
}

public int getIgst() {
	return Igst;
}

public void setIgst(int igst) {
	Igst = igst;
}

public int getSgst() {
	return Sgst;
}

public void setSgst(int sgst) {
	Sgst = sgst;
}

public int getCess() {
	return Cess;
}

public void setCess(int cess) {
	Cess = cess;
}

public int getSortNo() {
	return SortNo;
}

public void setSortNo(int sortNo) {
	SortNo = sortNo;
}

public int getExInt1() {
	return ExInt1;
}

public void setExInt1(int exInt1) {
	ExInt1 = exInt1;
}

public int getExInt2() {
	return ExInt2;
}

public void setExInt2(int exInt2) {
	ExInt2 = exInt2;
}

public int getExInt3() {
	return ExInt3;
}

public void setExInt3(int exInt3) {
	ExInt3 = exInt3;
}

public String getExVar1() {
	return ExVar1;
}

public void setExVar1(String exVar1) {
	ExVar1 = exVar1;
}

public String getExVar2() {
	return ExVar2;
}

public void setExVar2(String exVar2) {
	ExVar2 = exVar2;
}

public String getExVar3() {
	return ExVar3;
}

public void setExVar3(String exVar3) {
	ExVar3 = exVar3;
}

public String getExDate1() {
	return ExDate1;
}

public void setExDate1(String exDate1) {
	ExDate1 = exDate1;
}

public String getExDate2() {
	return ExDate2;
}

public void setExDate2(String exDate2) {
	ExDate2 = exDate2;
}

public int getExBool1() {
	return ExBool1;
}

public void setExBool1(int exBool1) {
	ExBool1 = exBool1;
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

@Column(name="ex_bool1")
private int ExBool1;

@Column(name="ex_bool2")
private int exBool2;

@Column(name="ex_bool3")
private int exBool3;


public int getTaxId() {
	return TaxId;
}

public void setTaxId(int taxId) {
	TaxId = taxId;
}

public int getDelStatus() {
	return DelStatus;
}

public void setDelStatus(int delStatus) {
	DelStatus = delStatus;
}

@Override
public String toString() {
	return "Tax [TaxId=" + TaxId + ", TaxName=" + TaxName + ", DelStatus=" + DelStatus + ", HsnCode=" + HsnCode
			+ ", TotalTaxPer=" + TotalTaxPer + ", Cgst=" + Cgst + ", Igst=" + Igst + ", Sgst=" + Sgst + ", Cess=" + Cess
			+ ", SortNo=" + SortNo + ", ExInt1=" + ExInt1 + ", ExInt2=" + ExInt2 + ", ExInt3=" + ExInt3 + ", ExVar1="
			+ ExVar1 + ", ExVar2=" + ExVar2 + ", ExVar3=" + ExVar3 + ", ExDate1=" + ExDate1 + ", ExDate2=" + ExDate2
			+ ", ExBool1=" + ExBool1 + ", exBool2=" + exBool2 + ", exBool3=" + exBool3 + "]";
}




	
}
