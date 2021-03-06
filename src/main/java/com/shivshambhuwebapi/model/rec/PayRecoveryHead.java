package com.shivshambhuwebapi.model.rec;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_pay_recovery_header")
public class PayRecoveryHead {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pay_head_id")
	private int payHeadId;

	@Column(name = "bill_no")
	private String billNo;

	@Column(name = "bill_head_id")
	private int billHeadId;

	@Column(name = "bill_date")
	private String billDate;

	@Column(name = "cust_id")
	private int custId;

	@Column(name = "credit_date1")
	private String creditDate1;

	@Column(name = "credit_date2")
	private String creditDate2;

	@Column(name = "credit_date3")
	private String creditDate3;

	@Column(name = "bill_total")
	private float billTotal;

	@Column(name = "paid_amt")
	private float paidAmt;

	@Column(name = "pending_amt")
	private float pendingAmt;

	@Column(name = "status")
	private int status;

	@Column(name = "remark")
	private String remark;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "del_status")
	private int delStatus;

	@Column(name = "ex_int1")
	private int exInt1;

	@Column(name = "ex_int2")
	private int exInt2;

	@Column(name = "ex_int3")
	private int exInt3;

	@Column(name = "ex_varchar1")
	private String exVarchar1;

	@Column(name = "ex_varchar2")
	private String exVarchar2;

	@Column(name = "ex_date1")
	private String exDate1;

	@Column(name = "ex_bool1")
	private int exBool1;

	@Column(name = "ex_bool2")
	private int exBool2;

	@Transient
	List<PayRecoveryDetail> payRecoveryDetailList;

	public int getPayHeadId() {
		return payHeadId;
	}

	public void setPayHeadId(int payHeadId) {
		this.payHeadId = payHeadId;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public int getBillHeadId() {
		return billHeadId;
	}

	public void setBillHeadId(int billHeadId) {
		this.billHeadId = billHeadId;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCreditDate1() {
		return creditDate1;
	}

	public void setCreditDate1(String creditDate1) {
		this.creditDate1 = creditDate1;
	}

	public String getCreditDate2() {
		return creditDate2;
	}

	public void setCreditDate2(String creditDate2) {
		this.creditDate2 = creditDate2;
	}

	public String getCreditDate3() {
		return creditDate3;
	}

	public void setCreditDate3(String creditDate3) {
		this.creditDate3 = creditDate3;
	}

	public float getBillTotal() {
		return billTotal;
	}

	public void setBillTotal(float billTotal) {
		this.billTotal = billTotal;
	}

	public float getPaidAmt() {
		return paidAmt;
	}

	public void setPaidAmt(float paidAmt) {
		this.paidAmt = paidAmt;
	}

	public float getPendingAmt() {
		return pendingAmt;
	}

	public void setPendingAmt(float pendingAmt) {
		this.pendingAmt = pendingAmt;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getExVarchar1() {
		return exVarchar1;
	}

	public void setExVarchar1(String exVarchar1) {
		this.exVarchar1 = exVarchar1;
	}

	public String getExVarchar2() {
		return exVarchar2;
	}

	public void setExVarchar2(String exVarchar2) {
		this.exVarchar2 = exVarchar2;
	}

	public String getExDate1() {
		return exDate1;
	}

	public void setExDate1(String exDate1) {
		this.exDate1 = exDate1;
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

	public List<PayRecoveryDetail> getPayRecoveryDetailList() {
		return payRecoveryDetailList;
	}

	public void setPayRecoveryDetailList(List<PayRecoveryDetail> payRecoveryDetailList) {
		this.payRecoveryDetailList = payRecoveryDetailList;
	}

	@Override
	public String toString() {
		return "PayRecoveryHead [payHeadId=" + payHeadId + ", billNo=" + billNo + ", billHeadId=" + billHeadId
				+ ", billDate=" + billDate + ", custId=" + custId + ", creditDate1=" + creditDate1 + ", creditDate2="
				+ creditDate2 + ", creditDate3=" + creditDate3 + ", billTotal=" + billTotal + ", paidAmt=" + paidAmt
				+ ", pendingAmt=" + pendingAmt + ", status=" + status + ", remark=" + remark + ", userId=" + userId
				+ ", delStatus=" + delStatus + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exInt3=" + exInt3
				+ ", exVarchar1=" + exVarchar1 + ", exVarchar2=" + exVarchar2 + ", exDate1=" + exDate1 + ", exBool1="
				+ exBool1 + ", exBool2=" + exBool2 + ", payRecoveryDetailList=" + payRecoveryDetailList + "]";
	}

}
