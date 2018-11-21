package com.shivshambhuwebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetPoDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "po_detail_id")
	private int poDetailId;

	@Column(name = "po_id")
	private int poId;
 
	@Column(name = "item_id")
	private int itemId;

	@Column(name = "po_rate")
	private float poRate; 
	
	@Column(name = "po_qty")
	private float poQty;

	@Column(name = "po_consume_qty")
	private float poConsumeQty;

	@Column(name = "po_remaining_qty")
	private float poRemainingQty;
 
	@Column(name = "status")
	private int status;

	@Column(name = "remark")
	private String remark;

	@Column(name = "tax_amt")
	private float taxAmt;
	
	@Column(name = "tax_per")
	private float taxPer;
	
	@Column(name = "taxable_amt")
	private float taxableAmt;
	
	@Column(name = "other_charges")
	private float otherCharges;
	
	@Column(name = "total")
	private float total;
	
	@Column(name = "qu_detail_id")
	private int quDetailId;
	
	@Column(name = "varchar1")
	private String varchar1;
	
	@Column(name = "varchar2")
	private String varchar2;
	
	@Column(name = "extra1")
	private int extra1;
	
	@Column(name = "extra2")
	private int extra2;
	
	@Column(name = "item_name")
	private String itemName;

	public int getPoDetailId() {
		return poDetailId;
	}

	public void setPoDetailId(int poDetailId) {
		this.poDetailId = poDetailId;
	}

	public int getPoId() {
		return poId;
	}

	public void setPoId(int poId) {
		this.poId = poId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public float getPoRate() {
		return poRate;
	}

	public void setPoRate(float poRate) {
		this.poRate = poRate;
	}

	public float getPoQty() {
		return poQty;
	}

	public void setPoQty(float poQty) {
		this.poQty = poQty;
	}

	public float getPoConsumeQty() {
		return poConsumeQty;
	}

	public void setPoConsumeQty(float poConsumeQty) {
		this.poConsumeQty = poConsumeQty;
	}

	public float getPoRemainingQty() {
		return poRemainingQty;
	}

	public void setPoRemainingQty(float poRemainingQty) {
		this.poRemainingQty = poRemainingQty;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public float getTaxAmt() {
		return taxAmt;
	}

	public void setTaxAmt(float taxAmt) {
		this.taxAmt = taxAmt;
	}

	public float getTaxPer() {
		return taxPer;
	}

	public void setTaxPer(float taxPer) {
		this.taxPer = taxPer;
	}

	public float getTaxableAmt() {
		return taxableAmt;
	}

	public void setTaxableAmt(float taxableAmt) {
		this.taxableAmt = taxableAmt;
	}

	public float getOtherCharges() {
		return otherCharges;
	}

	public void setOtherCharges(float otherCharges) {
		this.otherCharges = otherCharges;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getQuDetailId() {
		return quDetailId;
	}

	public void setQuDetailId(int quDetailId) {
		this.quDetailId = quDetailId;
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

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Override
	public String toString() {
		return "GetPoDetail [poDetailId=" + poDetailId + ", poId=" + poId + ", itemId=" + itemId + ", poRate=" + poRate
				+ ", poQty=" + poQty + ", poConsumeQty=" + poConsumeQty + ", poRemainingQty=" + poRemainingQty
				+ ", status=" + status + ", remark=" + remark + ", taxAmt=" + taxAmt + ", taxPer=" + taxPer
				+ ", taxableAmt=" + taxableAmt + ", otherCharges=" + otherCharges + ", total=" + total + ", quDetailId="
				+ quDetailId + ", varchar1=" + varchar1 + ", varchar2=" + varchar2 + ", extra1=" + extra1 + ", extra2="
				+ extra2 + ", itemName=" + itemName + "]";
	}
	
	

}
