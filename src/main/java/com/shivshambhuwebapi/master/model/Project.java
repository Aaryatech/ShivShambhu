package com.shivshambhuwebapi.master.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_project")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "proj_id")
	private int projId;

	@Column(name = "proj_name")
	private String projName;

	@Column(name = "cust_id")
	private int custId;

	@Column(name = "location")
	private String location;

	@Column(name = "start_date")
	private String startDate;

	@Column(name = "end_date")
	private String endDate;

	@Column(name = "is_used")
	private int isUsed;

	@Column(name = "del_status")
	private int delStatus;

	@Column(name = "contact_per_mob")
	private String contactPerMob;

	@Column(name = "contact_per_name")
	private String contactPerName;

	private String pincode;
	private float km;
	private String address;

	public int getProjId() {
		return projId;
	}

	public void setProjId(int projId) {
		this.projId = projId;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
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

	public String getContactPerMob() {
		return contactPerMob;
	}

	public void setContactPerMob(String contactPerMob) {
		this.contactPerMob = contactPerMob;
	}

	public String getContactPerName() {
		return contactPerName;
	}

	public void setContactPerName(String contactPerName) {
		this.contactPerName = contactPerName;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public float getKm() {
		return km;
	}

	public void setKm(float km) {
		this.km = km;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Project [projId=" + projId + ", projName=" + projName + ", custId=" + custId + ", location=" + location
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", isUsed=" + isUsed + ", delStatus="
				+ delStatus + ", contactPerMob=" + contactPerMob + ", contactPerName=" + contactPerName + ", pincode="
				+ pincode + ", km=" + km + ", address=" + address + "]";
	}

}
