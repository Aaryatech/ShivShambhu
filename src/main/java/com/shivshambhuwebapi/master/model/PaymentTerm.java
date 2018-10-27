package com.shivshambhuwebapi.master.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_payment_term")
public class PaymentTerm {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pay_term_id")
	private int payTermId;

	@Column(name = "pay_term")
	private String payTerm;

	@Column(name = "date")
	private String date;

	@Column(name = "is_used")
	private int isUsed;

	@Column(name = "del_status")
	private int delStatus;

	public int getPayTermId() {
		return payTermId;
	}

	public void setPayTermId(int payTermId) {
		this.payTermId = payTermId;
	}

	public String getPayTerm() {
		return payTerm;
	}

	public void setPayTerm(String payTerm) {
		this.payTerm = payTerm;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "PaymentTerm [payTermId=" + payTermId + ", payTerm=" + payTerm + ", date=" + date + ", isUsed=" + isUsed
				+ ", delStatus=" + delStatus + "]";
	}

}
