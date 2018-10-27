package com.shivshambhuwebapi.master.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_vendor")
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vend_id")
	private int vendId;

	@Column(name = "vend_comp_name")
	private String vendCompName;

	@Column(name = "vend_contact_name")
	private String vendContactName;

	@Column(name = "vend_contact1")
	private String vendContact1;

	@Column(name = "vend_contact2")
	private String vendContact2;

	@Column(name = "vend_email1")
	private String vendEmail1;

	@Column(name = "vend_email2")
	private String vendEmail2;

	@Column(name = "vend_email3")
	private String vendEmail3;

	@Column(name = "vend_gst")
	private String vendGst;

	@Column(name = "vend_pan")
	private String vendPan;

	@Column(name = "vend_city")
	private String vendCity;

	@Column(name = "vend_state")
	private String vendState;

	@Column(name = "vend_type")
	private int vendType;

	@Column(name = "vend_credit_days")
	private int vendCreditDays;

	@Column(name = "plant_id")
	private int plantId;

	@Column(name = "vend_is_used")
	private int vendIsUsed;

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

	public int getVendId() {
		return vendId;
	}

	public void setVendId(int vendId) {
		this.vendId = vendId;
	}

	public String getVendCompName() {
		return vendCompName;
	}

	public void setVendCompName(String vendCompName) {
		this.vendCompName = vendCompName;
	}

	public String getVendContactName() {
		return vendContactName;
	}

	public void setVendContactName(String vendContactName) {
		this.vendContactName = vendContactName;
	}

	public String getVendContact1() {
		return vendContact1;
	}

	public void setVendContact1(String vendContact1) {
		this.vendContact1 = vendContact1;
	}

	public String getVendContact2() {
		return vendContact2;
	}

	public void setVendContact2(String vendContact2) {
		this.vendContact2 = vendContact2;
	}

	public String getVendEmail1() {
		return vendEmail1;
	}

	public void setVendEmail1(String vendEmail1) {
		this.vendEmail1 = vendEmail1;
	}

	public String getVendEmail2() {
		return vendEmail2;
	}

	public void setVendEmail2(String vendEmail2) {
		this.vendEmail2 = vendEmail2;
	}

	public String getVendEmail3() {
		return vendEmail3;
	}

	public void setVendEmail3(String vendEmail3) {
		this.vendEmail3 = vendEmail3;
	}

	public String getVendGst() {
		return vendGst;
	}

	public void setVendGst(String vendGst) {
		this.vendGst = vendGst;
	}

	public String getVendPan() {
		return vendPan;
	}

	public void setVendPan(String vendPan) {
		this.vendPan = vendPan;
	}

	public String getVendCity() {
		return vendCity;
	}

	public void setVendCity(String vendCity) {
		this.vendCity = vendCity;
	}

	public String getVendState() {
		return vendState;
	}

	public void setVendState(String vendState) {
		this.vendState = vendState;
	}

	public int getVendType() {
		return vendType;
	}

	public void setVendType(int vendType) {
		this.vendType = vendType;
	}

	public int getVendCreditDays() {
		return vendCreditDays;
	}

	public void setVendCreditDays(int vendCreditDays) {
		this.vendCreditDays = vendCreditDays;
	}

	public int getPlantId() {
		return plantId;
	}

	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}

	public int getVendIsUsed() {
		return vendIsUsed;
	}

	public void setVendIsUsed(int vendIsUsed) {
		this.vendIsUsed = vendIsUsed;
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

	@Override
	public String toString() {
		return "Vendor [vendId=" + vendId + ", vendCompName=" + vendCompName + ", vendContactName=" + vendContactName
				+ ", vendContact1=" + vendContact1 + ", vendContact2=" + vendContact2 + ", vendEmail1=" + vendEmail1
				+ ", vendEmail2=" + vendEmail2 + ", vendEmail3=" + vendEmail3 + ", vendGst=" + vendGst + ", vendPan="
				+ vendPan + ", vendCity=" + vendCity + ", vendState=" + vendState + ", vendType=" + vendType
				+ ", vendCreditDays=" + vendCreditDays + ", plantId=" + plantId + ", vendIsUsed=" + vendIsUsed
				+ ", delStatus=" + delStatus + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exInt3=" + exInt3
				+ ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", exVar3=" + exVar3 + ", exDate1=" + exDate1
				+ ", exDate2=" + exDate2 + ", exBool1=" + exBool1 + ", exBool2=" + exBool2 + ", exBool3=" + exBool3
				+ "]";
	}

}
