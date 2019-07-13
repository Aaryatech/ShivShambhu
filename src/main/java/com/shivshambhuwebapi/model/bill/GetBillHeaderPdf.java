package com.shivshambhuwebapi.model.bill;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shivshambhuwebapi.master.model.BankDetail;

@Entity
public class GetBillHeaderPdf implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bill_head_id")
	private int billHeadId;

	@Column(name = "bill_no")
	private String billNo;

	@Column(name = "bill_date")
	private Date billDate;

	@Column(name = "cust_id")
	private int custId;

	@Column(name = "cust_name")
	private String custName;

	private String custVendor;

	private String custGstNo;

	private String custMobNo;

	@Column(name = "plant_name")
	private String plantName;

	@Column(name = "proj_id")
	private int projId;

	@Column(name = "cost_segment")
	private String costSegment;

	@Column(name = "payment_term_id")
	private int paymentTermId;

	@Column(name = "pay_term")
	private String payTerm;

	@Column(name = "company_id")
	private int companyId;

	@Column(name = "comp_name")
	private String compName;

	private String compPanNo;

	private String compGstNo;

	private String contactNo1;

	private String contactNo2;

	private String email1;

	private String compOfficeAdd;

	private String compFactAdd;
	private String custAddress;

	@Column(name = "challan_id")
	private String challanId;

	@Column(name = "delivery_term")
	private String deliveryTerm;

	@Column(name = "po_id")
	private int poId;

	@Column(name = "taxable_amt")
	private float taxableAmt;

	@Column(name = "tax_amt")
	private float taxAmt;

	@Column(name = "total_amt")
	private float totalAmt;

	@Column(name = "acc_id")
	private int accId;

	@Column(name = "order_id")
	private String orderId;

	@Transient
	private String orderNo;

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

	@Column(name = "ex_float1")
	private float exFloat1;

	@Column(name = "ex_float2")
	private float exFloat2;

	@Column(name = "proj_name")
	private String projName;

	@Column(name = "location")
	private String location;

	@Column(name = "chalan_no")
	private String chalanNo;

	private int isSameState;

	@Transient
	List<GetBillDetail> getBillDetails;

	@Transient
	BankDetail bankDetail;

	public String getCustVendor() {
		return custVendor;
	}

	public void setCustVendor(String custVendor) {
		this.custVendor = custVendor;
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

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
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

	public String getCustGstNo() {
		return custGstNo;
	}

	public void setCustGstNo(String custGstNo) {
		this.custGstNo = custGstNo;
	}

	public String getCustMobNo() {
		return custMobNo;
	}

	public void setCustMobNo(String custMobNo) {
		this.custMobNo = custMobNo;
	}

	public String getPayTerm() {
		return payTerm;
	}

	public void setPayTerm(String payTerm) {
		this.payTerm = payTerm;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public BankDetail getBankDetail() {
		return bankDetail;
	}

	public void setBankDetail(BankDetail bankDetail) {
		this.bankDetail = bankDetail;
	}

	public int getBillHeadId() {
		return billHeadId;
	}

	public void setBillHeadId(int billHeadId) {
		this.billHeadId = billHeadId;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

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

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public int getProjId() {
		return projId;
	}

	public void setProjId(int projId) {
		this.projId = projId;
	}

	public String getCostSegment() {
		return costSegment;
	}

	public void setCostSegment(String costSegment) {
		this.costSegment = costSegment;
	}

	public int getPaymentTermId() {
		return paymentTermId;
	}

	public void setPaymentTermId(int paymentTermId) {
		this.paymentTermId = paymentTermId;
	}

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

	public String getChallanId() {
		return challanId;
	}

	public void setChallanId(String challanId) {
		this.challanId = challanId;
	}

	public String getDeliveryTerm() {
		return deliveryTerm;
	}

	public void setDeliveryTerm(String deliveryTerm) {
		this.deliveryTerm = deliveryTerm;
	}

	public int getPoId() {
		return poId;
	}

	public void setPoId(int poId) {
		this.poId = poId;
	}

	public float getTaxableAmt() {
		return taxableAmt;
	}

	public void setTaxableAmt(float taxableAmt) {
		this.taxableAmt = taxableAmt;
	}

	public float getTaxAmt() {
		return taxAmt;
	}

	public void setTaxAmt(float taxAmt) {
		this.taxAmt = taxAmt;
	}

	public float getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(float totalAmt) {
		this.totalAmt = totalAmt;
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
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

	public float getExFloat1() {
		return exFloat1;
	}

	public void setExFloat1(float exFloat1) {
		this.exFloat1 = exFloat1;
	}

	public float getExFloat2() {
		return exFloat2;
	}

	public void setExFloat2(float exFloat2) {
		this.exFloat2 = exFloat2;
	}

	public List<GetBillDetail> getGetBillDetails() {
		return getBillDetails;
	}

	public void setGetBillDetails(List<GetBillDetail> getBillDetails) {
		this.getBillDetails = getBillDetails;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getChalanNo() {
		return chalanNo;
	}

	public void setChalanNo(String chalanNo) {
		this.chalanNo = chalanNo;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public int getIsSameState() {
		return isSameState;
	}

	public void setIsSameState(int isSameState) {
		this.isSameState = isSameState;
	}

	@Override
	public String toString() {
		return "GetBillHeaderPdf [billHeadId=" + billHeadId + ", billNo=" + billNo + ", billDate=" + billDate
				+ ", custId=" + custId + ", custName=" + custName + ", custVendor=" + custVendor + ", custGstNo="
				+ custGstNo + ", custMobNo=" + custMobNo + ", plantName=" + plantName + ", projId=" + projId
				+ ", costSegment=" + costSegment + ", paymentTermId=" + paymentTermId + ", payTerm=" + payTerm
				+ ", companyId=" + companyId + ", compName=" + compName + ", compPanNo=" + compPanNo + ", compGstNo="
				+ compGstNo + ", contactNo1=" + contactNo1 + ", contactNo2=" + contactNo2 + ", email1=" + email1
				+ ", compOfficeAdd=" + compOfficeAdd + ", compFactAdd=" + compFactAdd + ", custAddress=" + custAddress
				+ ", challanId=" + challanId + ", deliveryTerm=" + deliveryTerm + ", poId=" + poId + ", taxableAmt="
				+ taxableAmt + ", taxAmt=" + taxAmt + ", totalAmt=" + totalAmt + ", accId=" + accId + ", orderId="
				+ orderId + ", orderNo=" + orderNo + ", delStatus=" + delStatus + ", exInt1=" + exInt1 + ", exInt2="
				+ exInt2 + ", exInt3=" + exInt3 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", exVar3=" + exVar3
				+ ", exFloat1=" + exFloat1 + ", exFloat2=" + exFloat2 + ", projName=" + projName + ", location="
				+ location + ", chalanNo=" + chalanNo + ", isSameState=" + isSameState + ", getBillDetails="
				+ getBillDetails + ", bankDetail=" + bankDetail + "]";
	}

}
