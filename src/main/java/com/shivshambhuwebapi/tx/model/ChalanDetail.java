package com.shivshambhuwebapi.tx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.transaction.TransactionScoped;

@Entity
@Table(name="t_chalan_detail")
public class ChalanDetail {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "chalan_detail_id")
	private int chalanDetailId;
	
	private int chalanId;
	
	private int itemId;
	
	private int itemUom;
	
	private float itemQty;
	
	private float itemLengthPlant;
	private float itemWidthPlant;
	private float itemHeightPlant;
	
	private float itemTotalPlant;
	
	@Transient
	private float itemQtyBeforeEdit;
	
	
	public float getItemQtyBeforeEdit() {
		return itemQtyBeforeEdit;
	}
	public void setItemQtyBeforeEdit(float itemQtyBeforeEdit) {
		this.itemQtyBeforeEdit = itemQtyBeforeEdit;
	}
	public float getItemTotalPlant() {
		return itemTotalPlant;
	}
	public void setItemTotalPlant(float itemTotalPlant) {
		this.itemTotalPlant = itemTotalPlant;
	}



	private float itemLengthSite;
	private float itemWidthSite;
	private float itemHeightSite;
	
	private float itemTotalSite;
	
	private int status;
	private int delStatus;
	
	private int exInt1;
	private float exFloat1;
	private String exVar1;
	private String exVar2;
	private String exDate1;
	
	private int orderDetailId;
	
	public int getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public int getChalanDetailId() {
		return chalanDetailId;
	}
	public void setChalanDetailId(int chalanDetailId) {
		this.chalanDetailId = chalanDetailId;
	}
	public int getChalanId() {
		return chalanId;
	}
	public void setChalanId(int chalanId) {
		this.chalanId = chalanId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getItemUom() {
		return itemUom;
	}
	public void setItemUom(int itemUom) {
		this.itemUom = itemUom;
	}
	public float getItemQty() {
		return itemQty;
	}
	public void setItemQty(float itemQty) {
		this.itemQty = itemQty;
	}
	public float getItemLengthPlant() {
		return itemLengthPlant;
	}
	public void setItemLengthPlant(float itemLengthPlant) {
		this.itemLengthPlant = itemLengthPlant;
	}
	public float getItemWidthPlant() {
		return itemWidthPlant;
	}
	public void setItemWidthPlant(float itemWidthPlant) {
		this.itemWidthPlant = itemWidthPlant;
	}
	public float getItemHeightPlant() {
		return itemHeightPlant;
	}
	public void setItemHeightPlant(float itemHeightPlant) {
		this.itemHeightPlant = itemHeightPlant;
	}
	public float getItemLengthSite() {
		return itemLengthSite;
	}
	public void setItemLengthSite(float itemLengthSite) {
		this.itemLengthSite = itemLengthSite;
	}
	public float getItemWidthSite() {
		return itemWidthSite;
	}
	public void setItemWidthSite(float itemWidthSite) {
		this.itemWidthSite = itemWidthSite;
	}
	public float getItemHeightSite() {
		return itemHeightSite;
	}
	public void setItemHeightSite(float itemHeightSite) {
		this.itemHeightSite = itemHeightSite;
	}
	public float getItemTotalSite() {
		return itemTotalSite;
	}
	public void setItemTotalSite(float itemTotalSite) {
		this.itemTotalSite = itemTotalSite;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	public float getExFloat1() {
		return exFloat1;
	}
	public void setExFloat1(float exFloat1) {
		this.exFloat1 = exFloat1;
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
	
	
	
	@Override
	public String toString() {
		return "ChalanDetail [chalanDetailId=" + chalanDetailId + ", chalanId=" + chalanId + ", itemId=" + itemId
				+ ", itemUom=" + itemUom + ", itemQty=" + itemQty + ", itemLengthPlant=" + itemLengthPlant
				+ ", itemWidthPlant=" + itemWidthPlant + ", itemHeightPlant=" + itemHeightPlant + ", itemTotalPlant="
				+ itemTotalPlant + ", itemQtyBeforeEdit=" + itemQtyBeforeEdit + ", itemLengthSite=" + itemLengthSite
				+ ", itemWidthSite=" + itemWidthSite + ", itemHeightSite=" + itemHeightSite + ", itemTotalSite="
				+ itemTotalSite + ", status=" + status + ", delStatus=" + delStatus + ", exInt1=" + exInt1
				+ ", exFloat1=" + exFloat1 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", exDate1=" + exDate1
				+ ", orderDetailId=" + orderDetailId + "]";
	}
	
}
