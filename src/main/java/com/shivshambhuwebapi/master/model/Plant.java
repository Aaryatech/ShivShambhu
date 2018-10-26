package com.shivshambhuwebapi.master.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_plant")
public class Plant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "plant_id")
	private int plantId;

	@Column(name = "plant_name")
	private String plantName;

	@Column(name = "company_id")
	private int companyId;

	@Column(name = "plant_address1")
	private String plantAddress1;

	@Column(name = "plant_address2")
	private String plantAddress2;

	@Column(name = "plant_contact_no1")
	private String plantContactNo1;

	@Column(name = "plant_contact_no2")
	private String plantContactNo2;

	@Column(name = "plant_fax1")
	private String plantFax1;

	@Column(name = "plant_fax2")
	private String plantFax2;

	@Column(name = "plant_head")
	private int plantHead;

	@Column(name = "plant_email1")
	private String plantEmail1;

	@Column(name = "plant_email2")
	private String plantEmail2;

	@Column(name = "is_used")
	private int isUsed;

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

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getPlantAddress1() {
		return plantAddress1;
	}

	public void setPlantAddress1(String plantAddress1) {
		this.plantAddress1 = plantAddress1;
	}

	public String getPlantAddress2() {
		return plantAddress2;
	}

	public void setPlantAddress2(String plantAddress2) {
		this.plantAddress2 = plantAddress2;
	}

	public String getPlantContactNo1() {
		return plantContactNo1;
	}

	public void setPlantContactNo1(String plantContactNo1) {
		this.plantContactNo1 = plantContactNo1;
	}

	public String getPlantContactNo2() {
		return plantContactNo2;
	}

	public void setPlantContactNo2(String plantContactNo2) {
		this.plantContactNo2 = plantContactNo2;
	}

	public String getPlantFax1() {
		return plantFax1;
	}

	public void setPlantFax1(String plantFax1) {
		this.plantFax1 = plantFax1;
	}

	public String getPlantFax2() {
		return plantFax2;
	}

	public void setPlantFax2(String plantFax2) {
		this.plantFax2 = plantFax2;
	}

	public int getPlantHead() {
		return plantHead;
	}

	public void setPlantHead(int plantHead) {
		this.plantHead = plantHead;
	}

	public String getPlantEmail1() {
		return plantEmail1;
	}

	public void setPlantEmail1(String plantEmail1) {
		this.plantEmail1 = plantEmail1;
	}

	public String getPlantEmail2() {
		return plantEmail2;
	}

	public void setPlantEmail2(String plantEmail2) {
		this.plantEmail2 = plantEmail2;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
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
		return "Plant [plantId=" + plantId + ", plantName=" + plantName + ", companyId=" + companyId
				+ ", plantAddress1=" + plantAddress1 + ", plantAddress2=" + plantAddress2 + ", plantContactNo1="
				+ plantContactNo1 + ", plantContactNo2=" + plantContactNo2 + ", plantFax1=" + plantFax1 + ", plantFax2="
				+ plantFax2 + ", plantHead=" + plantHead + ", plantEmail1=" + plantEmail1 + ", plantEmail2="
				+ plantEmail2 + ", isUsed=" + isUsed + ", delStatus=" + delStatus + ", exInt1=" + exInt1 + ", exInt2="
				+ exInt2 + ", exInt3=" + exInt3 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", exVar3=" + exVar3
				+ ", exDate1=" + exDate1 + ", exDate2=" + exDate2 + ", exBool1=" + exBool1 + ", exBool2=" + exBool2
				+ ", exBool3=" + exBool3 + "]";
	}

}
