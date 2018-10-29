package com.shivshambhuwebapi.master.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "enq_gen_fact")
public class EnqGenFact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "enq_gen_id")
	private int enqGenId;

	@Column(name = "enq_gen_by")
	private String enqGenBy;

	@Column(name = "date")
	private String date;

	@Column(name = "del_status")
	private int delStatus;

	public int getEnqGenId() {
		return enqGenId;
	}

	public void setEnqGenId(int enqGenId) {
		this.enqGenId = enqGenId;
	}

	public String getEnqGenBy() {
		return enqGenBy;
	}

	public void setEnqGenBy(String enqGenBy) {
		this.enqGenBy = enqGenBy;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "EnqGenFact [enqGenId=" + enqGenId + ", enqGenBy=" + enqGenBy + ", date=" + date + ", delStatus="
				+ delStatus + "]";
	}

}
