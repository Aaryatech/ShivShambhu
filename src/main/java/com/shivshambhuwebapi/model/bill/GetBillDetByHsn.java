package com.shivshambhuwebapi.model.bill;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetBillDetByHsn {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "hsn_code")
	private String hsnCode;

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

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
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

	@Override
	public String toString() {
		return "GetBillDetByHsn [hsnCode=" + hsnCode + ", cgstPer=" + cgstPer + ", sgstPer=" + sgstPer + ", igstPer="
				+ igstPer + ", cgstAmt=" + cgstAmt + ", sgstAmt=" + sgstAmt + ", igstAmt=" + igstAmt + ", taxAmt="
				+ taxAmt + ", discPer=" + discPer + ", discAmt=" + discAmt + ", taxableAmt=" + taxableAmt
				+ ", totalAmt=" + totalAmt + "]";
	}

}
