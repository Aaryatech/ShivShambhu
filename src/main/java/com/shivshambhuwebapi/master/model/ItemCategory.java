package com.shivshambhuwebapi.master.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_category")
public class ItemCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cat_id")
	private int catId;

	@Column(name = "cat_desc")
	private String catDesc;

	@Column(name = "cat_seq")
	private int catSeq;

	@Column(name = "cat_prefix")
	private String catPrefix;

	@Column(name = "is_used")
	private int isUsed;

	@Column(name = "created_in")
	private int createdIn;

	@Column(name = "deleted_in")
	private int deletedIn;

	@Column(name = "monthly_limit")
	private int monthlyLimit;

	@Column(name = "yearly_limit")
	private int yearlyLimit;

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatDesc() {
		return catDesc;
	}

	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}

	public int getCatSeq() {
		return catSeq;
	}

	public void setCatSeq(int catSeq) {
		this.catSeq = catSeq;
	}

	public String getCatPrefix() {
		return catPrefix;
	}

	public void setCatPrefix(String catPrefix) {
		this.catPrefix = catPrefix;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	public int getCreatedIn() {
		return createdIn;
	}

	public void setCreatedIn(int createdIn) {
		this.createdIn = createdIn;
	}

	public int getDeletedIn() {
		return deletedIn;
	}

	public void setDeletedIn(int deletedIn) {
		this.deletedIn = deletedIn;
	}

	public int getMonthlyLimit() {
		return monthlyLimit;
	}

	public void setMonthlyLimit(int monthlyLimit) {
		this.monthlyLimit = monthlyLimit;
	}

	public int getYearlyLimit() {
		return yearlyLimit;
	}

	public void setYearlyLimit(int yearlyLimit) {
		this.yearlyLimit = yearlyLimit;
	}

	@Override
	public String toString() {
		return "ItemCategory [catId=" + catId + ", catDesc=" + catDesc + ", catSeq=" + catSeq + ", catPrefix="
				+ catPrefix + ", isUsed=" + isUsed + ", createdIn=" + createdIn + ", deletedIn=" + deletedIn
				+ ", monthlyLimit=" + monthlyLimit + ", yearlyLimit=" + yearlyLimit + "]";
	}

}
