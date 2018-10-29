package com.shivshambhuwebapi.master.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cust_type_mst")
public class CustType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cust_type_id")
	private int custTypeId;

	@Column(name = "cust_type_name")
	private String custTypeName;

	@Column(name = "del_status")
	private int delStatus;

	public int getCustTypeId() {
		return custTypeId;
	}

	public void setCustTypeId(int custTypeId) {
		this.custTypeId = custTypeId;
	}

	public String getCustTypeName() {
		return custTypeName;
	}

	public void setCustTypeName(String custTypeName) {
		this.custTypeName = custTypeName;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "CustType [custTypeId=" + custTypeId + ", custTypeName=" + custTypeName + ", delStatus=" + delStatus
				+ "]";
	}

}
