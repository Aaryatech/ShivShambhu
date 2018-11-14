package com.shivshambhuwebapi.master.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "doc_term_header")
public class DocTermHeader {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "term_id")
	private int termId;

	private String termTitle;
	private int docId;
	private int delStatus;
	private int sortNo;

	@Column(name = "ex_int1")
	private int exInt1;

	@Column(name = "ex_int2")
	private int exInt2;

	@Column(name = "ex_var1")
	private String exVar1;

	@Column(name = "ex_var2")
	private String exVar2;
	
	@Transient
	List<DocTermDetail> detailList;

	public int getTermId() {
		return termId;
	}

	public void setTermId(int termId) {
		this.termId = termId;
	}

	public String getTermTitle() {
		return termTitle;
	}

	public void setTermTitle(String termTitle) {
		this.termTitle = termTitle;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getSortNo() {
		return sortNo;
	}

	public void setSortNo(int sortNo) {
		this.sortNo = sortNo;
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

	public List<DocTermDetail> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<DocTermDetail> detailList) {
		this.detailList = detailList;
	}

	@Override
	public String toString() {
		return "DocTermHeader [termId=" + termId + ", termTitle=" + termTitle + ", docId=" + docId + ", delStatus="
				+ delStatus + ", sortNo=" + sortNo + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exVar1=" + exVar1
				+ ", exVar2=" + exVar2 + ", detailList=" + detailList + "]";
	}
	
	
	
	
	
	
	

}
