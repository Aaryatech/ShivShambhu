package com.shivshambhuwebapi.model.rec;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetPayRecoveryHeadCustWise {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cust_id")
	private int custId;
	
	
	/*@Column(name = "pay_head_id")
	private int payHeadId;
*/
	/*@Column(name = "bill_no")
	private String billNo;*/

	/*@Column(name = "bill_head_id")
	private int billHeadId;
*/
	@Column(name = "bill_date")
	private String billDate;

	
	@Column(name = "bill_total")
	private float billTotal;

	@Column(name = "paid_amt")
	private float paidAmt;

	@Column(name = "pending_amt")
	private float pendingAmt;
	
	@Column(name = "cust_name")
	private String custName;
	
	@Column(name = "cust_mob_no")
	private String custMobNo;
/*
	public int getPayHeadId() {
		return payHeadId;
	}

	public void setPayHeadId(int payHeadId) {
		this.payHeadId = payHeadId;
	}*/

	/*public String getBillNo() {
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
	}*/

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

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustMobNo() {
		return custMobNo;
	}

	public void setCustMobNo(String custMobNo) {
		this.custMobNo = custMobNo;
	}

	/*@Override
	public String toString() {
		return "GetPayRecoveryHeadCustWise [payHeadId=" + payHeadId + ", billNo=" + billNo + ", billHeadId="
				+ billHeadId + ", billDate=" + billDate + ", custId=" + custId + ", billTotal=" + billTotal
				+ ", paidAmt=" + paidAmt + ", pendingAmt=" + pendingAmt + ", custName=" + custName + ", custMobNo="
				+ custMobNo + "]";
	}

	
	*/
	
	

}