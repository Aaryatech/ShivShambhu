package com.shivshambhuwebapi.master.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_contractor")
public class Contractor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "contr_id")
	private int contrId;

	@Column(name = "contr_name")
	private String contrName;

	@Column(name = "contr_mob")
	private String contrMob;

	@Column(name = "contr_rate")
	private float contrRate;

	@Column(name = "contr_type")
	private int contrType;

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

	public int getContrId() {
		return contrId;
	}

	public void setContrId(int contrId) {
		this.contrId = contrId;
	}

	public String getContrName() {
		return contrName;
	}

	public void setContrName(String contrName) {
		this.contrName = contrName;
	}

	public String getContrMob() {
		return contrMob;
	}

	public void setContrMob(String contrMob) {
		this.contrMob = contrMob;
	}

	public float getContrRate() {
		return contrRate;
	}

	public void setContrRate(float contrRate) {
		this.contrRate = contrRate;
	}

	public int getContrType() {
		return contrType;
	}

	public void setContrType(int contrType) {
		this.contrType = contrType;
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
		return "Contractor [contrId=" + contrId + ", contrName=" + contrName + ", contrMob=" + contrMob + ", contrRate="
				+ contrRate + ", contrType=" + contrType + ", delStatus=" + delStatus + ", exInt1=" + exInt1
				+ ", exInt2=" + exInt2 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", exDate1=" + exDate1
				+ ", exBool1=" + exBool1 + "]";
	}

}
