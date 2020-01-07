package com.shivshambhuwebapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetPoChallan {
	@Id
	private String id;
	private int orderDetailId;
	private String itemDesc;
	private String poNo;
	private Date poDate;
	private float poQty;
	private float poChallanQty;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public String getPoNo() {
		return poNo;
	}
	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getPoDate() {
		return poDate;
	}
	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}
	public float getPoQty() {
		return poQty;
	}
	public void setPoQty(float poQty) {
		this.poQty = poQty;
	}
	
	public float getPoChallanQty() {
		return poChallanQty;
	}
	public void setPoChallanQty(float poChallanQty) {
		this.poChallanQty = poChallanQty;
	}
	public int getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	@Override
	public String toString() {
		return "GetPoChallan [id=" + id + ", orderDetailId=" + orderDetailId + ", itemDesc=" + itemDesc + ", poNo="
				+ poNo + ", poDate=" + poDate + ", poQty=" + poQty + ", poChallanQty=" + poChallanQty + "]";
	}
	
}
