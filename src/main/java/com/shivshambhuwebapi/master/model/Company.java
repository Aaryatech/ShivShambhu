package com.shivshambhuwebapi.master.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "company_id")
	private int companyId;

	@Column(name = "comp_name")
	private String compName;

	@Column(name = "comp_loc")
	private String compLoc;

	@Column(name = "comp_office_add")
	private String compOfficeAdd;

	@Column(name = "comp_fact_add")
	private String compFactAdd;

	@Column(name = "comp_other_add")
	private String compOtherAdd;

	@Column(name = "comp_licence")
	private String compLicence;

	@Column(name = "comp_pan_no")
	private String compPanNo;

	@Column(name = "comp_gst_no")
	private String compGstNo;

	@Column(name = "contact_no1")
	private String contactNo1;

	@Column(name = "contact_no2")
	private String contactNo2;

	@Column(name = "fax_no1")
	private String faxNo1;

	@Column(name = "email1")
	private String email1;

	@Column(name = "email2")
	private String email2;

	@Column(name = "email3")
	private String email3;

	@Column(name = "licence2")
	private String licence2;

	@Column(name = "comp_logo")
	private String compLogo;

	@Column(name = "from_date")
	private String fromDate;

	@Column(name = "to_date")
	private String toDate;

	@Column(name = "cin_no")
	private String cinNo;

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

	@Column(name = "del_status")
	private int delStatus;

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getCompLoc() {
		return compLoc;
	}

	public void setCompLoc(String compLoc) {
		this.compLoc = compLoc;
	}

	public String getCompOfficeAdd() {
		return compOfficeAdd;
	}

	public void setCompOfficeAdd(String compOfficeAdd) {
		this.compOfficeAdd = compOfficeAdd;
	}

	public String getCompFactAdd() {
		return compFactAdd;
	}

	public void setCompFactAdd(String compFactAdd) {
		this.compFactAdd = compFactAdd;
	}

	public String getCompOtherAdd() {
		return compOtherAdd;
	}

	public void setCompOtherAdd(String compOtherAdd) {
		this.compOtherAdd = compOtherAdd;
	}

	public String getCompLicence() {
		return compLicence;
	}

	public void setCompLicence(String compLicence) {
		this.compLicence = compLicence;
	}

	public String getCompPanNo() {
		return compPanNo;
	}

	public void setCompPanNo(String compPanNo) {
		this.compPanNo = compPanNo;
	}

	public String getCompGstNo() {
		return compGstNo;
	}

	public void setCompGstNo(String compGstNo) {
		this.compGstNo = compGstNo;
	}

	public String getContactNo1() {
		return contactNo1;
	}

	public void setContactNo1(String contactNo1) {
		this.contactNo1 = contactNo1;
	}

	public String getContactNo2() {
		return contactNo2;
	}

	public void setContactNo2(String contactNo2) {
		this.contactNo2 = contactNo2;
	}

	public String getFaxNo1() {
		return faxNo1;
	}

	public void setFaxNo1(String faxNo1) {
		this.faxNo1 = faxNo1;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getEmail3() {
		return email3;
	}

	public void setEmail3(String email3) {
		this.email3 = email3;
	}

	public String getLicence2() {
		return licence2;
	}

	public void setLicence2(String licence2) {
		this.licence2 = licence2;
	}

	public String getCompLogo() {
		return compLogo;
	}

	public void setCompLogo(String compLogo) {
		this.compLogo = compLogo;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getCinNo() {
		return cinNo;
	}

	public void setCinNo(String cinNo) {
		this.cinNo = cinNo;
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

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", compName=" + compName + ", compLoc=" + compLoc
				+ ", compOfficeAdd=" + compOfficeAdd + ", compFactAdd=" + compFactAdd + ", compOtherAdd=" + compOtherAdd
				+ ", compLicence=" + compLicence + ", compPanNo=" + compPanNo + ", compGstNo=" + compGstNo
				+ ", contactNo1=" + contactNo1 + ", contactNo2=" + contactNo2 + ", faxNo1=" + faxNo1 + ", email1="
				+ email1 + ", email2=" + email2 + ", email3=" + email3 + ", licence2=" + licence2 + ", compLogo="
				+ compLogo + ", fromDate=" + fromDate + ", toDate=" + toDate + ", cinNo=" + cinNo + ", exInt1=" + exInt1
				+ ", exInt2=" + exInt2 + ", exInt3=" + exInt3 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2
				+ ", exVar3=" + exVar3 + ", exDate1=" + exDate1 + ", exDate2=" + exDate2 + ", exBool1=" + exBool1
				+ ", exBool2=" + exBool2 + ", exBool3=" + exBool3 + ", delStatus=" + delStatus + "]";
	}

}
