package com.shivshambhuwebapi.master.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_customer")
public class Cust {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cust_id")
	private int custId;

	@Column(name = "cust_name")
	private String custName;

	@Column(name = "resp_person")
	private String respPerson;

	@Column(name = "cust_mob_no")
	private String custMobNo;

	@Column(name = "cust_email")
	private String custEmail;

	@Column(name = "cust_address")
	private String custAddress;

	@Column(name = "cust_pan_no")
	private String custPanNo;

	@Column(name = "cust_gst_no")
	private String custGstNo;

	@Column(name = "cust_type")
	private int custType;

	@Column(name = "cust_rate_type")
	private int custRateType;

	@Column(name = "del_status")
	private int delStatus;

	@Column(name = "token")
	private String token;

	@Column(name = "cust_dob")
	private String custDob;

	@Column(name = "plant_id")
	private int plantId;

	@Column(name = "cust_cat")
	private int custCat;

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

	@Column(name = "date_of_reg")
	private String dateOfReg;

	@Column(name = "cheque_remark")
	private String chequeRemark;

	@Column(name = "is_cheque_rcvd")
	private int isChequeRcvd;

	@Column(name = "contact_per_name")
	private String contactPerName;

	@Column(name = "contact_per_mob")
	private String contactPerMob;

	@Column(name = "cust_landline")
	private String custLandline;

	@Column(name = "is_same_state")
	private int isSameState;

	@Column(name = "cust_code")
	private String custCode;

	@Column(name = "cust_vendor")
	private int custVendor;

	@Column(name = "owner_name")
	private String ownerName;

	@Column(name = "acc_person")
	private String accPerson;

	@Column(name = "acc_per_mob")
	private String accPerMob;
	
	
	

	@Column(name = "pincode")
	private String pincode;

	

	@Column(name = "km")
	private float km;

	

	@Column(name = "creadit_limit")
	private float creaditLimit;
	
	@Column(name = "creadit_days")
	private float creaditDays;


	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getRespPerson() {
		return respPerson;
	}

	public void setRespPerson(String respPerson) {
		this.respPerson = respPerson;
	}

	public String getCustMobNo() {
		return custMobNo;
	}

	public void setCustMobNo(String custMobNo) {
		this.custMobNo = custMobNo;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustPanNo() {
		return custPanNo;
	}

	public void setCustPanNo(String custPanNo) {
		this.custPanNo = custPanNo;
	}

	public String getCustGstNo() {
		return custGstNo;
	}

	public void setCustGstNo(String custGstNo) {
		this.custGstNo = custGstNo;
	}

	public int getCustType() {
		return custType;
	}

	public void setCustType(int custType) {
		this.custType = custType;
	}

	public int getCustRateType() {
		return custRateType;
	}

	public void setCustRateType(int custRateType) {
		this.custRateType = custRateType;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCustDob() {
		return custDob;
	}

	public void setCustDob(String custDob) {
		this.custDob = custDob;
	}

	public int getPlantId() {
		return plantId;
	}

	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}

	public int getCustCat() {
		return custCat;
	}

	public void setCustCat(int custCat) {
		this.custCat = custCat;
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

	public String getDateOfReg() {
		return dateOfReg;
	}

	public void setDateOfReg(String dateOfReg) {
		this.dateOfReg = dateOfReg;
	}

	public String getChequeRemark() {
		return chequeRemark;
	}

	public void setChequeRemark(String chequeRemark) {
		this.chequeRemark = chequeRemark;
	}

	public int getIsChequeRcvd() {
		return isChequeRcvd;
	}

	public void setIsChequeRcvd(int isChequeRcvd) {
		this.isChequeRcvd = isChequeRcvd;
	}

	public String getContactPerName() {
		return contactPerName;
	}

	public void setContactPerName(String contactPerName) {
		this.contactPerName = contactPerName;
	}

	public String getContactPerMob() {
		return contactPerMob;
	}

	public void setContactPerMob(String contactPerMob) {
		this.contactPerMob = contactPerMob;
	}

	public String getCustLandline() {
		return custLandline;
	}

	public void setCustLandline(String custLandline) {
		this.custLandline = custLandline;
	}

	public int getIsSameState() {
		return isSameState;
	}

	public void setIsSameState(int isSameState) {
		this.isSameState = isSameState;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public int getCustVendor() {
		return custVendor;
	}

	public void setCustVendor(int custVendor) {
		this.custVendor = custVendor;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getAccPerson() {
		return accPerson;
	}

	public void setAccPerson(String accPerson) {
		this.accPerson = accPerson;
	}

	public String getAccPerMob() {
		return accPerMob;
	}

	public void setAccPerMob(String accPerMob) {
		this.accPerMob = accPerMob;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public float getKm() {
		return km;
	}

	public void setKm(float km) {
		this.km = km;
	}

	public float getCreaditLimit() {
		return creaditLimit;
	}

	public void setCreaditLimit(float creaditLimit) {
		this.creaditLimit = creaditLimit;
	}

	public float getCreaditDays() {
		return creaditDays;
	}

	public void setCreaditDays(float creaditDays) {
		this.creaditDays = creaditDays;
	}

	@Override
	public String toString() {
		return "Cust [custId=" + custId + ", custName=" + custName + ", respPerson=" + respPerson + ", custMobNo="
				+ custMobNo + ", custEmail=" + custEmail + ", custAddress=" + custAddress + ", custPanNo=" + custPanNo
				+ ", custGstNo=" + custGstNo + ", custType=" + custType + ", custRateType=" + custRateType
				+ ", delStatus=" + delStatus + ", token=" + token + ", custDob=" + custDob + ", plantId=" + plantId
				+ ", custCat=" + custCat + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exInt3=" + exInt3
				+ ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", exVar3=" + exVar3 + ", exDate1=" + exDate1
				+ ", exDate2=" + exDate2 + ", exBool1=" + exBool1 + ", exBool2=" + exBool2 + ", exBool3=" + exBool3
				+ ", dateOfReg=" + dateOfReg + ", chequeRemark=" + chequeRemark + ", isChequeRcvd=" + isChequeRcvd
				+ ", contactPerName=" + contactPerName + ", contactPerMob=" + contactPerMob + ", custLandline="
				+ custLandline + ", isSameState=" + isSameState + ", custCode=" + custCode + ", custVendor="
				+ custVendor + ", ownerName=" + ownerName + ", accPerson=" + accPerson + ", accPerMob=" + accPerMob
				+ ", pincode=" + pincode + ", km=" + km + ", creaditLimit=" + creaditLimit + ", creaditDays="
				+ creaditDays + "]";
	}

}
