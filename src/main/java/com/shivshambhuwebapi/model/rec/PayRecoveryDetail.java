package com.shivshambhuwebapi.model.rec;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_pay_recovery_detail")
public class PayRecoveryDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pay_detail_id")
	private int payDetailId;

	@Column(name = "pay_head_id")
	private int payHeadId;

	@Column(name = "payment_date")
	private String paymentDate;

	@Column(name = "paid_amt")
	private float paidAmt;

	@Column(name = "type_tx")
	private int typeTx;

	@Column(name = "tx_no")
	private String txNo;

	@Column(name = "remark")
	private String remark;

	@Column(name = "ex_int1")
	private int exInt1;

	@Column(name = "ex_int2")
	private int exInt2;

	@Column(name = "ex_varchar1")
	private String exVarchar1;

	@Column(name = "ex_varchar2")
	private String exVarchar2;

	@Column(name = "ex_date1")
	private String exDate1;

	@Column(name = "ex_bool1")
	private int exBool1;

	@Column(name = "del_status")
	private int delStatus;

	public int getPayDetailId() {
		return payDetailId;
	}

	public void setPayDetailId(int payDetailId) {
		this.payDetailId = payDetailId;
	}

	public int getPayHeadId() {
		return payHeadId;
	}

	public void setPayHeadId(int payHeadId) {
		this.payHeadId = payHeadId;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public float getPaidAmt() {
		return paidAmt;
	}

	public void setPaidAmt(float paidAmt) {
		this.paidAmt = paidAmt;
	}

	public int getTypeTx() {
		return typeTx;
	}

	public void setTypeTx(int typeTx) {
		this.typeTx = typeTx;
	}

	public String getTxNo() {
		return txNo;
	}

	public void setTxNo(String txNo) {
		this.txNo = txNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "PayRecoveryDetail [payDetailId=" + payDetailId + ", payHeadId=" + payHeadId + ", paymentDate="
				+ paymentDate + ", paidAmt=" + paidAmt + ", typeTx=" + typeTx + ", txNo=" + txNo + ", remark=" + remark
				+ ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exVarchar1=" + exVarchar1 + ", exVarchar2="
				+ exVarchar2 + ", exDate1=" + exDate1 + ", exBool1=" + exBool1 + ", delStatus=" + delStatus + "]";
	}
	
	

}
