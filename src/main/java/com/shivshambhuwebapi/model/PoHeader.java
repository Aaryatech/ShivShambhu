package com.shivshambhuwebapi.model;

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
@Table(name = "t_cust_po_header")
public class PoHeader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "po_id")
	private int poId;

	@Column(name = "po_no")
	private String poNo;

	@Column(name = "po_date")
	private String poDate;

	@Column(name = "cust_id")
	private int custId;

	@Column(name = "remark")
	private String remark;

	@Column(name = "cust_project_id")
	private int custProjectId;

	@Column(name = "po_document")
	private String poDocument;

	@Column(name = "po_document1")
	private String poDocument1;

	@Column(name = "quatation_id")
	private int quatationId;

	@Column(name = "quatation_no")
	private String quatationNo;

	@Column(name = "po_validity_date")
	private String poValidityDate;

	@Column(name = "po_term_id")
	private int poTermId;

	@Column(name = "del_status")
	private int delStatus;

	@Column(name = "plant_id")
	private int plantId;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "extra1")
	private int extra1;
	
	@Column(name = "extra2")
	private int extra2;
	
	@Column(name = "bool1")
	private int bool1;
	
	@Column(name = "bool2")
	private int bool2;
	
	@Column(name = "varchar1")
	private String varchar1;
	
	@Column(name = "varchar2")
	private String varchar2;
	
	@Column(name = "extra_date1")
	private String extraDate1;
	
	@Column(name = "extra_date2")
	private String extraDate2;
	
	@Column(name = "qut_date")
	private String qutDate;
	
	@Transient
	List<PoDetail> poDetailList;

	public int getPoId() {
		return poId;
	}

	public void setPoId(int poId) {
		this.poId = poId;
	}

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public String getPoDate() {
		return poDate;
	}

	public void setPoDate(String poDate) {
		this.poDate = poDate;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getCustProjectId() {
		return custProjectId;
	}

	public void setCustProjectId(int custProjectId) {
		this.custProjectId = custProjectId;
	}

	public String getPoDocument() {
		return poDocument;
	}

	public void setPoDocument(String poDocument) {
		this.poDocument = poDocument;
	}

	public String getPoDocument1() {
		return poDocument1;
	}

	public void setPoDocument1(String poDocument1) {
		this.poDocument1 = poDocument1;
	}

	public int getQuatationId() {
		return quatationId;
	}

	public void setQuatationId(int quatationId) {
		this.quatationId = quatationId;
	}

	public String getQuatationNo() {
		return quatationNo;
	}

	public void setQuatationNo(String quatationNo) {
		this.quatationNo = quatationNo;
	}

	public String getPoValidityDate() {
		return poValidityDate;
	}

	public void setPoValidityDate(String poValidityDate) {
		this.poValidityDate = poValidityDate;
	}

	public int getPoTermId() {
		return poTermId;
	}

	public void setPoTermId(int poTermId) {
		this.poTermId = poTermId;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getPlantId() {
		return plantId;
	}

	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getExtra1() {
		return extra1;
	}

	public void setExtra1(int extra1) {
		this.extra1 = extra1;
	}

	public int getExtra2() {
		return extra2;
	}

	public void setExtra2(int extra2) {
		this.extra2 = extra2;
	}

	public int getBool1() {
		return bool1;
	}

	public void setBool1(int bool1) {
		this.bool1 = bool1;
	}

	public int getBool2() {
		return bool2;
	}

	public void setBool2(int bool2) {
		this.bool2 = bool2;
	}

	public String getVarchar1() {
		return varchar1;
	}

	public void setVarchar1(String varchar1) {
		this.varchar1 = varchar1;
	}

	public String getVarchar2() {
		return varchar2;
	}

	public void setVarchar2(String varchar2) {
		this.varchar2 = varchar2;
	}

	public String getExtraDate1() {
		return extraDate1;
	}

	public void setExtraDate1(String extraDate1) {
		this.extraDate1 = extraDate1;
	}

	public String getExtraDate2() {
		return extraDate2;
	}

	public void setExtraDate2(String extraDate2) {
		this.extraDate2 = extraDate2;
	}

	public List<PoDetail> getPoDetailList() {
		return poDetailList;
	}

	public void setPoDetailList(List<PoDetail> poDetailList) {
		this.poDetailList = poDetailList;
	}

	public String getQutDate() {
		return qutDate;
	}

	public void setQutDate(String qutDate) {
		this.qutDate = qutDate;
	}

	@Override
	public String toString() {
		return "PoHeader [poId=" + poId + ", poNo=" + poNo + ", poDate=" + poDate + ", custId=" + custId + ", remark="
				+ remark + ", custProjectId=" + custProjectId + ", poDocument=" + poDocument + ", poDocument1="
				+ poDocument1 + ", quatationId=" + quatationId + ", quatationNo=" + quatationNo + ", poValidityDate="
				+ poValidityDate + ", poTermId=" + poTermId + ", delStatus=" + delStatus + ", plantId=" + plantId
				+ ", status=" + status + ", extra1=" + extra1 + ", extra2=" + extra2 + ", bool1=" + bool1 + ", bool2="
				+ bool2 + ", varchar1=" + varchar1 + ", varchar2=" + varchar2 + ", extraDate1=" + extraDate1
				+ ", extraDate2=" + extraDate2 + ", qutDate=" + qutDate + ", poDetailList=" + poDetailList + "]";
	}
	
	

}
