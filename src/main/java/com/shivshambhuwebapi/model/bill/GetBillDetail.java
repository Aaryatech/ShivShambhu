package com.shivshambhuwebapi.model.bill;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetBillDetail implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bill_detail_id")
	private int billDetailId;

	@Column(name = "bill_head_id")
	private int billHeadId;

	@Column(name = "item_id")
	private int itemId;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "short_name")
	private String shortName;

	@Column(name = "uom_name")
	private String uomName;

	@Column(name = "qty")
	private float qty;

	@Column(name = "hsn_code")
	private String hsnCode;

	@Column(name = "rate")
	private float rate;

	@Column(name = "cgst_per")
	private float cgstPer;

	@Column(name = "sgst_per")
	private float sgstPer;

	@Column(name = "igst_per")
	private float igstPer;

	@Column(name = "cgst_amt")
	private float cgstAmt;

	@Column(name = "sgst_amt")
	private float sgstAmt;

	@Column(name = "igst_amt")
	private float igstAmt;

	@Column(name = "tax_amt")
	private float taxAmt;

	@Column(name = "disc_per")
	private float discPer;

	@Column(name = "disc_amt")
	private float discAmt;

	@Column(name = "taxable_amt")
	private float taxableAmt;

	@Column(name = "total_amt")
	private float totalAmt;

	@Column(name = "ex_int1")
	private int exInt1;

	@Column(name = "ex_int2")
	private int exInt2;

	@Column(name = "ex_float1")
	private float exFloat1;

	@Column(name = "ex_float2")
	private float exFloat2;

	@Column(name = "ex_var1")
	private String exVar1;

	@Column(name = "ex_var2")
	private String exVar2;

	@Column(name = "del_status")
	private int delStatus;

	private int company_id;

	private String comp_name;

	private String comp_office_add;

	private String contact_no1;

	private String email1;

	// private int plantId;

	private String plantName;

	private String orderNo;

	private String refNo;

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getUomName() {
		return uomName;
	}

	public void setUomName(String uomName) {
		this.uomName = uomName;
	}

	public int getBillDetailId() {
		return billDetailId;
	}

	public void setBillDetailId(int billDetailId) {
		this.billDetailId = billDetailId;
	}

	public int getBillHeadId() {
		return billHeadId;
	}

	public void setBillHeadId(int billHeadId) {
		this.billHeadId = billHeadId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getQty() {
		return qty;
	}

	public void setQty(float qty) {
		this.qty = qty;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public float getCgstPer() {
		return cgstPer;
	}

	public void setCgstPer(float cgstPer) {
		this.cgstPer = cgstPer;
	}

	public float getSgstPer() {
		return sgstPer;
	}

	public void setSgstPer(float sgstPer) {
		this.sgstPer = sgstPer;
	}

	public float getIgstPer() {
		return igstPer;
	}

	public void setIgstPer(float igstPer) {
		this.igstPer = igstPer;
	}

	public float getCgstAmt() {
		return cgstAmt;
	}

	public void setCgstAmt(float cgstAmt) {
		this.cgstAmt = cgstAmt;
	}

	public float getSgstAmt() {
		return sgstAmt;
	}

	public void setSgstAmt(float sgstAmt) {
		this.sgstAmt = sgstAmt;
	}

	public float getIgstAmt() {
		return igstAmt;
	}

	public void setIgstAmt(float igstAmt) {
		this.igstAmt = igstAmt;
	}

	public float getTaxAmt() {
		return taxAmt;
	}

	public void setTaxAmt(float taxAmt) {
		this.taxAmt = taxAmt;
	}

	public float getDiscPer() {
		return discPer;
	}

	public void setDiscPer(float discPer) {
		this.discPer = discPer;
	}

	public float getDiscAmt() {
		return discAmt;
	}

	public void setDiscAmt(float discAmt) {
		this.discAmt = discAmt;
	}

	public float getTaxableAmt() {
		return taxableAmt;
	}

	public void setTaxableAmt(float taxableAmt) {
		this.taxableAmt = taxableAmt;
	}

	public float getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(float totalAmt) {
		this.totalAmt = totalAmt;
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

	public float getExFloat1() {
		return exFloat1;
	}

	public void setExFloat1(float exFloat1) {
		this.exFloat1 = exFloat1;
	}

	public float getExFloat2() {
		return exFloat2;
	}

	public void setExFloat2(float exFloat2) {
		this.exFloat2 = exFloat2;
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

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	public String getComp_name() {
		return comp_name;
	}

	public void setComp_name(String comp_name) {
		this.comp_name = comp_name;
	}

	public String getComp_office_add() {
		return comp_office_add;
	}

	public void setComp_office_add(String comp_office_add) {
		this.comp_office_add = comp_office_add;
	}

	public String getContact_no1() {
		return contact_no1;
	}

	public void setContact_no1(String contact_no1) {
		this.contact_no1 = contact_no1;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	/*
	 * public int getPlantId() { return plantId; }
	 * 
	 * public void setPlantId(int plantId) { this.plantId = plantId; }
	 */

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	@Override
	public String toString() {
		return "GetBillDetail [billDetailId=" + billDetailId + ", billHeadId=" + billHeadId + ", itemId=" + itemId
				+ ", itemName=" + itemName + ", shortName=" + shortName + ", uomName=" + uomName + ", qty=" + qty
				+ ", hsnCode=" + hsnCode + ", rate=" + rate + ", cgstPer=" + cgstPer + ", sgstPer=" + sgstPer
				+ ", igstPer=" + igstPer + ", cgstAmt=" + cgstAmt + ", sgstAmt=" + sgstAmt + ", igstAmt=" + igstAmt
				+ ", taxAmt=" + taxAmt + ", discPer=" + discPer + ", discAmt=" + discAmt + ", taxableAmt=" + taxableAmt
				+ ", totalAmt=" + totalAmt + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exFloat1=" + exFloat1
				+ ", exFloat2=" + exFloat2 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", delStatus=" + delStatus
				+ ", company_id=" + company_id + ", comp_name=" + comp_name + ", comp_office_add=" + comp_office_add
				+ ", contact_no1=" + contact_no1 + ", email1=" + email1 + ", plantName=" + plantName + ", orderNo="
				+ orderNo + ", refNo=" + refNo + "]";
	}

	/*
	 * @Override public String toString() { return "GetBillDetail [billDetailId=" +
	 * billDetailId + ", billHeadId=" + billHeadId + ", itemId=" + itemId +
	 * ", itemName=" + itemName + ", uomName=" + uomName + ", qty=" + qty +
	 * ", hsnCode=" + hsnCode + ", rate=" + rate + ", cgstPer=" + cgstPer +
	 * ", sgstPer=" + sgstPer + ", igstPer=" + igstPer + ", cgstAmt=" + cgstAmt +
	 * ", sgstAmt=" + sgstAmt + ", igstAmt=" + igstAmt + ", taxAmt=" + taxAmt +
	 * ", discPer=" + discPer + ", discAmt=" + discAmt + ", taxableAmt=" +
	 * taxableAmt + ", totalAmt=" + totalAmt + ", exInt1=" + exInt1 + ", exInt2=" +
	 * exInt2 + ", exFloat1=" + exFloat1 + ", exFloat2=" + exFloat2 + ", exVar1=" +
	 * exVar1 + ", exVar2=" + exVar2 + ", delStatus=" + delStatus + ", company_id="
	 * + company_id + ", comp_name=" + comp_name + ", comp_office_add=" +
	 * comp_office_add + ", contact_no1=" + contact_no1 + ", email1=" + email1 +
	 * ", plantId=" + plantId + ", plantName=" + plantName + ", orderNo=" + orderNo
	 * + ", refNo=" + refNo + "]"; }
	 */

}
