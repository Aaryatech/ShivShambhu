package com.shivshambhuwebapi.model.prodrm;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class ProdReportDetail {

	@Id
	private int productionDetailId;

	private Date productionDate;

	private int itemId;

	private String itemName;
	private String itemCode;
	private float planQty;
	private float productionQty;

	private int status;

	private String uomName;

	private String productionBatch;

	public int getProductionDetailId() {
		return productionDetailId;
	}

	public void setProductionDetailId(int productionDetailId) {
		this.productionDetailId = productionDetailId;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
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

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public float getPlanQty() {
		return planQty;
	}

	public void setPlanQty(float planQty) {
		this.planQty = planQty;
	}

	public float getProductionQty() {
		return productionQty;
	}

	public void setProductionQty(float productionQty) {
		this.productionQty = productionQty;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUomName() {
		return uomName;
	}

	public void setUomName(String uomName) {
		this.uomName = uomName;
	}

	public String getProductionBatch() {
		return productionBatch;
	}

	public void setProductionBatch(String productionBatch) {
		this.productionBatch = productionBatch;
	}

	@Override
	public String toString() {
		return "ProdReportDetail [productionDetailId=" + productionDetailId + ", productionDate=" + productionDate
				+ ", itemId=" + itemId + ", itemName=" + itemName + ", itemCode=" + itemCode + ", planQty=" + planQty
				+ ", productionQty=" + productionQty + ", status=" + status + ", uomName=" + uomName
				+ ", productionBatch=" + productionBatch + "]";
	}

}
