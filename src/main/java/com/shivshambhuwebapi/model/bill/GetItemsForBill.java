package com.shivshambhuwebapi.model.bill;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetItemsForBill implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "chalan_detail_id")
	private int chalanDetailId;

	@Column(name = "chalan_id")
	private int chalanId;

	@Column(name = "chalan_no")
	private String chalanNo;

	@Column(name = "chalan_date")
	private String chalanDate;

	@Column(name = "item_id")
	private int itemId;

	@Column(name = "item_code")
	private String itemCode;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "item_uom")
	private String itemUom;

	@Column(name = "uom_id")
	private int uomId;

	@Column(name = "hsn_code")
	private String hsnCode;

	@Column(name = "item_qty")
	private float itemQty;

	@Column(name = "order_rate")
	private float orderRate;

	@Column(name = "order_Id")
	private int orderId;

	@Column(name = "cgst_per")
	private float cgstPer;

	@Column(name = "sgst_per")
	private float sgstPer;

	@Column(name = "igst_per")
	private float igstPer;

	@Column(name = "po_term_id")
	private int poTermId;

	@Column(name = "delivery_term")
	private String deliveryTerm;

	private int isTaxIncluding;
	
	@Column(name = "po_rate")
	private float poRate;

	public int getIsTaxIncluding() {
		return isTaxIncluding;
	}

	public void setIsTaxIncluding(int isTaxIncluding) {
		this.isTaxIncluding = isTaxIncluding;
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

	public String getChalanNo() {
		return chalanNo;
	}

	public void setChalanNo(String chalanNo) {
		this.chalanNo = chalanNo;
	}

	public String getChalanDate() {
		return chalanDate;
	}

	public void setChalanDate(String chalanDate) {
		this.chalanDate = chalanDate;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemUom() {
		return itemUom;
	}

	public void setItemUom(String itemUom) {
		this.itemUom = itemUom;
	}

	public int getUomId() {
		return uomId;
	}

	public void setUomId(int uomId) {
		this.uomId = uomId;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public float getItemQty() {
		return itemQty;
	}

	public void setItemQty(float itemQty) {
		this.itemQty = itemQty;
	}

	public float getOrderRate() {
		return orderRate;
	}

	public void setOrderRate(float orderRate) {
		this.orderRate = orderRate;
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

	public int getPoTermId() {
		return poTermId;
	}

	public void setPoTermId(int poTermId) {
		this.poTermId = poTermId;
	}

	public String getDeliveryTerm() {
		return deliveryTerm;
	}

	public void setDeliveryTerm(String deliveryTerm) {
		this.deliveryTerm = deliveryTerm;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public float getPoRate() {
		return poRate;
	}

	public void setPoRate(float poRate) {
		this.poRate = poRate;
	}

	@Override
	public String toString() {
		return "GetItemsForBill [chalanDetailId=" + chalanDetailId + ", chalanId=" + chalanId + ", chalanNo=" + chalanNo
				+ ", chalanDate=" + chalanDate + ", itemId=" + itemId + ", itemCode=" + itemCode + ", itemName="
				+ itemName + ", itemUom=" + itemUom + ", uomId=" + uomId + ", hsnCode=" + hsnCode + ", itemQty="
				+ itemQty + ", orderRate=" + orderRate + ", orderId=" + orderId + ", cgstPer=" + cgstPer + ", sgstPer="
				+ sgstPer + ", igstPer=" + igstPer + ", poTermId=" + poTermId + ", deliveryTerm=" + deliveryTerm
				+ ", isTaxIncluding=" + isTaxIncluding + ", poRate=" + poRate + "]";
	}

	
	
}
