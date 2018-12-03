package com.shivshambhuwebapi.master.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_subplant")
public class Subplant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "subplant_id")
	private int subplantId;

	@Column(name = "subplant_name")
	private String subplantName;

	@Column(name = "location")
	private String location;

	@Column(name = "plant_id")
	private int plantId;

	@Column(name = "del_status")
	private int delStatus;

	@Column(name = "ex_int1")
	private int exInt1;

	@Column(name = "ex_int2")
	private int exInt2;

	@Column(name = "ex_var1")
	private String exVar1;

	@Column(name = "ex_var2")
	private String exVar2;

	@Column(name = "ex_date1")
	private String exDate1;

	@Column(name = "ex_bool1")
	private int exBool1;

	public int getSubplantId() {
		return subplantId;
	}

	public void setSubplantId(int subplantId) {
		this.subplantId = subplantId;
	}

	public String getSubplantName() {
		return subplantName;
	}

	public void setSubplantName(String subplantName) {
		this.subplantName = subplantName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getPlantId() {
		return plantId;
	}

	public void setPlantId(int plantId) {
		this.plantId = plantId;
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

	@Override
	public String toString() {
		return "Subplant [subplantId=" + subplantId + ", subplantName=" + subplantName + ", location=" + location
				+ ", plantId=" + plantId + ", delStatus=" + delStatus + ", exInt1=" + exInt1 + ", exInt2=" + exInt2
				+ ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", exDate1=" + exDate1 + ", exBool1=" + exBool1 + "]";
	}

}
