package com.shivshambhuwebapi.tx.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_enq_header")
public class EnqHeader {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "enq_head_id")
	private int enqHeadId;

	@Column(name = "enq_no")
	private String enqNo;

	@Column(name = "enq_usr_id")
	private int enqUsrId;

	@Column(name = "enq_date")
	private String enqDate;

	@Column(name = "cust_id")
	private int custId;

	@Column(name = "enq_date_time")
	private String enqDateTime;

	@Column(name = "enq_priority")
	private int enqPriority;

	@Column(name = "enq_status")
	private int enqStatus;

	@Column(name = "plant_id")
	private int plantId;

	@Column(name = "enq_usr_id2")
	private int enqUsrId2;

	@Column(name = "quot_id")
	private int quotId;

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

	@Column(name = "enq_gen_id")
	private int enqGenId;

	@Column(name = "enq_h_remark")
	private String enqHRemark;

	@Transient
	List<EnqDetail> enqDetailList;

	public int getEnqHeadId() {
		return enqHeadId;
	}

	public void setEnqHeadId(int enqHeadId) {
		this.enqHeadId = enqHeadId;
	}

	public String getEnqNo() {
		return enqNo;
	}

	public void setEnqNo(String enqNo) {
		this.enqNo = enqNo;
	}

	public int getEnqUsrId() {
		return enqUsrId;
	}

	public void setEnqUsrId(int enqUsrId) {
		this.enqUsrId = enqUsrId;
	}

	public String getEnqDate() {
		return enqDate;
	}

	public void setEnqDate(String enqDate) {
		this.enqDate = enqDate;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getEnqDateTime() {
		return enqDateTime;
	}

	public void setEnqDateTime(String enqDateTime) {
		this.enqDateTime = enqDateTime;
	}

	public int getEnqPriority() {
		return enqPriority;
	}

	public void setEnqPriority(int enqPriority) {
		this.enqPriority = enqPriority;
	}

	public int getEnqStatus() {
		return enqStatus;
	}

	public void setEnqStatus(int enqStatus) {
		this.enqStatus = enqStatus;
	}

	public int getPlantId() {
		return plantId;
	}

	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}

	public int getEnqUsrId2() {
		return enqUsrId2;
	}

	public void setEnqUsrId2(int enqUsrId2) {
		this.enqUsrId2 = enqUsrId2;
	}

	public int getQuotId() {
		return quotId;
	}

	public void setQuotId(int quotId) {
		this.quotId = quotId;
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

	public List<EnqDetail> getEnqDetailList() {
		return enqDetailList;
	}

	public void setEnqDetailList(List<EnqDetail> enqDetailList) {
		this.enqDetailList = enqDetailList;
	}

	public int getEnqGenId() {
		return enqGenId;
	}

	public void setEnqGenId(int enqGenId) {
		this.enqGenId = enqGenId;
	}

	public String getEnqHRemark() {
		return enqHRemark;
	}

	public void setEnqHRemark(String enqHRemark) {
		this.enqHRemark = enqHRemark;
	}

	@Override
	public String toString() {
		return "EnqHeader [enqHeadId=" + enqHeadId + ", enqNo=" + enqNo + ", enqUsrId=" + enqUsrId + ", enqDate="
				+ enqDate + ", custId=" + custId + ", enqDateTime=" + enqDateTime + ", enqPriority=" + enqPriority
				+ ", enqStatus=" + enqStatus + ", plantId=" + plantId + ", enqUsrId2=" + enqUsrId2 + ", quotId="
				+ quotId + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exInt3=" + exInt3 + ", exVar1=" + exVar1
				+ ", exVar2=" + exVar2 + ", exVar3=" + exVar3 + ", exDate1=" + exDate1 + ", exDate2=" + exDate2
				+ ", exBool1=" + exBool1 + ", exBool2=" + exBool2 + ", exBool3=" + exBool3 + ", enqGenId=" + enqGenId
				+ ", enqHRemark=" + enqHRemark + ", enqDetailList=" + enqDetailList + "]";
	}

}
