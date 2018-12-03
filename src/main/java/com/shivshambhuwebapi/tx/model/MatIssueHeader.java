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
@Table(name = "t_mat_issue_contra_header")
public class MatIssueHeader {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mat_header_id")
	private int matHeaderId;

	@Column(name = "issue_no")
	private String issueNo;

	@Column(name = "contr_id")
	private int contrId;

	@Column(name = "date")
	private String date;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "total")
	private float total;

	@Column(name = "qty_total")
	private float qtyTotal;

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

	@Transient
	List<MatIssueDetail> matIssueDetailList;

	public int getMatHeaderId() {
		return matHeaderId;
	}

	public void setMatHeaderId(int matHeaderId) {
		this.matHeaderId = matHeaderId;
	}

	public String getIssueNo() {
		return issueNo;
	}

	public void setIssueNo(String issueNo) {
		this.issueNo = issueNo;
	}

	public int getContrId() {
		return contrId;
	}

	public void setContrId(int contrId) {
		this.contrId = contrId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getQtyTotal() {
		return qtyTotal;
	}

	public void setQtyTotal(float qtyTotal) {
		this.qtyTotal = qtyTotal;
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

	public List<MatIssueDetail> getMatIssueDetailList() {
		return matIssueDetailList;
	}

	public void setMatIssueDetailList(List<MatIssueDetail> matIssueDetailList) {
		this.matIssueDetailList = matIssueDetailList;
	}

	@Override
	public String toString() {
		return "MatIssueHeader [matHeaderId=" + matHeaderId + ", issueNo=" + issueNo + ", contrId=" + contrId
				+ ", date=" + date + ", userId=" + userId + ", total=" + total + ", qtyTotal=" + qtyTotal
				+ ", delStatus=" + delStatus + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exInt3=" + exInt3
				+ ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", exVar3=" + exVar3 + ", exDate1=" + exDate1
				+ ", exDate2=" + exDate2 + ", exBool1=" + exBool1 + ", exBool2=" + exBool2 + ", matIssueDetailList="
				+ matIssueDetailList + "]";
	}

}
