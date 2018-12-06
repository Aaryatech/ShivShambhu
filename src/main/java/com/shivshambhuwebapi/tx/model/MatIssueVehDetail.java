package com.shivshambhuwebapi.tx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_issue_veh_detail")
public class MatIssueVehDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mat_veh_detail_id")
	private int matVehDetailId;

	@Column(name = "mat_veh_header_id")
	private int matVehHeaderId;

	@Column(name = "quantity")
	private float quantity;

	@Column(name = "item_id")
	private int itemId;

	@Column(name = "rate")
	private float rate;

	@Column(name = "value")
	private float value;

	@Column(name = "uom_id")
	private int uomId;

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

	public int getMatVehDetailId() {
		return matVehDetailId;
	}

	public void setMatVehDetailId(int matVehDetailId) {
		this.matVehDetailId = matVehDetailId;
	}

	public int getMatVehHeaderId() {
		return matVehHeaderId;
	}

	public void setMatVehHeaderId(int matVehHeaderId) {
		this.matVehHeaderId = matVehHeaderId;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public int getUomId() {
		return uomId;
	}

	public void setUomId(int uomId) {
		this.uomId = uomId;
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
		return "MatIssueVehDetail [matVehDetailId=" + matVehDetailId + ", matVehHeaderId=" + matVehHeaderId
				+ ", quantity=" + quantity + ", itemId=" + itemId + ", rate=" + rate + ", value=" + value + ", uomId="
				+ uomId + ", delStatus=" + delStatus + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exVar1="
				+ exVar1 + ", exVar2=" + exVar2 + ", exDate1=" + exDate1 + ", exBool1=" + exBool1 + "]";
	}

}
