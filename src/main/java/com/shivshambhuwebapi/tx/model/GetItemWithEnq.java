package com.shivshambhuwebapi.tx.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GetItemWithEnq {

	@Id
	private int itemId;

	private String itemName;

	private String itemCode;

	private String itemImage;

	private int itemType;

	private int plantId;

	private float itemRate1;

	private float itemRate2;

	private float itemRate3;

	private float itemRate4;

	private int taxId;

	private int uomId;

	private float actualWeight;

	private float baseWeight;

	private String shortName;

	private float dispatchLimit;

	private int isCritical;

	private int itemIsUsed;

	private float minStock;

	private float maxStock;

	private float rolStock;

	private float plantMinStock;

	private float plantMaxStock;

	private float plantRolStock;

	private String vendorIds;

	private int delStatus;

	private int exInt1;

	private int exInt2;

	private int exInt3;

	private String exVar1;

	private String exVar2;

	private String exVar3;

	private String exDate1;

	private String exDate2;

	private int exBool1;

	private int exBool2;

	private int exBool3;

	private int sortNo;

	private float length;

	private float height;

	private float width;

	private String itemLocation;

	private float royaltyRate;

	private float freightRate;

	private String taxName;
	private String hsnCode;
	private String uomName;
	private String plantName;

	private float enqQty;

	private float enqUomId;

	private String enqUomName;

	private float otherCostAfterTax;// 19-11-18
	private float transCost;// 19-11-18
	private float otherCost;// 19-11-18
	private float quotQty;// 19-11-18

	private float taxableValue;// 19-11-18
	private float taxValue;// 19-11-18
	private float finalTotal;// 19-11-18

	private int quotDetailId;// 2019/01/01

	public float getTaxableValue() {
		return taxableValue;
	}

	public void setTaxableValue(float taxableValue) {
		this.taxableValue = taxableValue;
	}

	public float getTaxValue() {
		return taxValue;
	}

	public void setTaxValue(float taxValue) {
		this.taxValue = taxValue;
	}

	public float getFinalTotal() {
		return finalTotal;
	}

	public void setFinalTotal(float finalTotal) {
		this.finalTotal = finalTotal;
	}

	private float totalTaxPer;

	private float cgst;

	private float igst;

	private float sgst;

	private float cess;

	public float getQuotQty() {
		return quotQty;
	}

	public void setQuotQty(float quotQty) {
		this.quotQty = quotQty;
	}

	public float getTotalTaxPer() {
		return totalTaxPer;
	}

	public void setTotalTaxPer(float totalTaxPer) {
		this.totalTaxPer = totalTaxPer;
	}

	public float getCgst() {
		return cgst;
	}

	public void setCgst(float cgst) {
		this.cgst = cgst;
	}

	public float getIgst() {
		return igst;
	}

	public void setIgst(float igst) {
		this.igst = igst;
	}

	public float getSgst() {
		return sgst;
	}

	public void setSgst(float sgst) {
		this.sgst = sgst;
	}

	public float getCess() {
		return cess;
	}

	public void setCess(float cess) {
		this.cess = cess;
	}

	public String getEnqUomName() {
		return enqUomName;
	}

	public void setEnqUomName(String enqUomName) {
		this.enqUomName = enqUomName;
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

	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	public int getItemType() {
		return itemType;
	}

	public void setItemType(int itemType) {
		this.itemType = itemType;
	}

	public int getPlantId() {
		return plantId;
	}

	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}

	public float getItemRate1() {
		return itemRate1;
	}

	public void setItemRate1(float itemRate1) {
		this.itemRate1 = itemRate1;
	}

	public float getItemRate2() {
		return itemRate2;
	}

	public void setItemRate2(float itemRate2) {
		this.itemRate2 = itemRate2;
	}

	public float getItemRate3() {
		return itemRate3;
	}

	public void setItemRate3(float itemRate3) {
		this.itemRate3 = itemRate3;
	}

	public float getItemRate4() {
		return itemRate4;
	}

	public void setItemRate4(float itemRate4) {
		this.itemRate4 = itemRate4;
	}

	public int getTaxId() {
		return taxId;
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	public int getUomId() {
		return uomId;
	}

	public void setUomId(int uomId) {
		this.uomId = uomId;
	}

	public float getActualWeight() {
		return actualWeight;
	}

	public void setActualWeight(float actualWeight) {
		this.actualWeight = actualWeight;
	}

	public float getBaseWeight() {
		return baseWeight;
	}

	public void setBaseWeight(float baseWeight) {
		this.baseWeight = baseWeight;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public float getDispatchLimit() {
		return dispatchLimit;
	}

	public void setDispatchLimit(float dispatchLimit) {
		this.dispatchLimit = dispatchLimit;
	}

	public int getIsCritical() {
		return isCritical;
	}

	public void setIsCritical(int isCritical) {
		this.isCritical = isCritical;
	}

	public int getItemIsUsed() {
		return itemIsUsed;
	}

	public void setItemIsUsed(int itemIsUsed) {
		this.itemIsUsed = itemIsUsed;
	}

	public float getMinStock() {
		return minStock;
	}

	public void setMinStock(float minStock) {
		this.minStock = minStock;
	}

	public float getMaxStock() {
		return maxStock;
	}

	public void setMaxStock(float maxStock) {
		this.maxStock = maxStock;
	}

	public float getRolStock() {
		return rolStock;
	}

	public void setRolStock(float rolStock) {
		this.rolStock = rolStock;
	}

	public float getPlantMinStock() {
		return plantMinStock;
	}

	public void setPlantMinStock(float plantMinStock) {
		this.plantMinStock = plantMinStock;
	}

	public float getPlantMaxStock() {
		return plantMaxStock;
	}

	public void setPlantMaxStock(float plantMaxStock) {
		this.plantMaxStock = plantMaxStock;
	}

	public float getPlantRolStock() {
		return plantRolStock;
	}

	public void setPlantRolStock(float plantRolStock) {
		this.plantRolStock = plantRolStock;
	}

	public String getVendorIds() {
		return vendorIds;
	}

	public void setVendorIds(String vendorIds) {
		this.vendorIds = vendorIds;
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

	public int getExInt3() {
		return exInt3;
	}

	public void setExInt3(int exInt3) {
		this.exInt3 = exInt3;
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

	public String getExVar3() {
		return exVar3;
	}

	public void setExVar3(String exVar3) {
		this.exVar3 = exVar3;
	}

	public String getExDate1() {
		return exDate1;
	}

	public void setExDate1(String exDate1) {
		this.exDate1 = exDate1;
	}

	public String getExDate2() {
		return exDate2;
	}

	public void setExDate2(String exDate2) {
		this.exDate2 = exDate2;
	}

	public int getExBool1() {
		return exBool1;
	}

	public void setExBool1(int exBool1) {
		this.exBool1 = exBool1;
	}

	public int getExBool2() {
		return exBool2;
	}

	public void setExBool2(int exBool2) {
		this.exBool2 = exBool2;
	}

	public int getExBool3() {
		return exBool3;
	}

	public void setExBool3(int exBool3) {
		this.exBool3 = exBool3;
	}

	public int getSortNo() {
		return sortNo;
	}

	public void setSortNo(int sortNo) {
		this.sortNo = sortNo;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public String getItemLocation() {
		return itemLocation;
	}

	public void setItemLocation(String itemLocation) {
		this.itemLocation = itemLocation;
	}

	public float getRoyaltyRate() {
		return royaltyRate;
	}

	public void setRoyaltyRate(float royaltyRate) {
		this.royaltyRate = royaltyRate;
	}

	public float getFreightRate() {
		return freightRate;
	}

	public void setFreightRate(float freightRate) {
		this.freightRate = freightRate;
	}

	public String getTaxName() {
		return taxName;
	}

	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public String getUomName() {
		return uomName;
	}

	public void setUomName(String uomName) {
		this.uomName = uomName;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public float getEnqQty() {
		return enqQty;
	}

	public void setEnqQty(float enqQty) {
		this.enqQty = enqQty;
	}

	public float getEnqUomId() {
		return enqUomId;
	}

	public void setEnqUomId(float enqUomId) {
		this.enqUomId = enqUomId;
	}

	public float getOtherCostAfterTax() {
		return otherCostAfterTax;
	}

	public void setOtherCostAfterTax(float otherCostAfterTax) {
		this.otherCostAfterTax = otherCostAfterTax;
	}

	public float getTransCost() {
		return transCost;
	}

	public void setTransCost(float transCost) {
		this.transCost = transCost;
	}

	public float getOtherCost() {
		return otherCost;
	}

	public void setOtherCost(float otherCost) {
		this.otherCost = otherCost;
	}

	public int getQuotDetailId() {
		return quotDetailId;
	}

	public void setQuotDetailId(int quotDetailId) {
		this.quotDetailId = quotDetailId;
	}

	@Override
	public String toString() {
		return "GetItemWithEnq [itemId=" + itemId + ", itemName=" + itemName + ", itemCode=" + itemCode + ", itemImage="
				+ itemImage + ", itemType=" + itemType + ", plantId=" + plantId + ", itemRate1=" + itemRate1
				+ ", itemRate2=" + itemRate2 + ", itemRate3=" + itemRate3 + ", itemRate4=" + itemRate4 + ", taxId="
				+ taxId + ", uomId=" + uomId + ", actualWeight=" + actualWeight + ", baseWeight=" + baseWeight
				+ ", shortName=" + shortName + ", dispatchLimit=" + dispatchLimit + ", isCritical=" + isCritical
				+ ", itemIsUsed=" + itemIsUsed + ", minStock=" + minStock + ", maxStock=" + maxStock + ", rolStock="
				+ rolStock + ", plantMinStock=" + plantMinStock + ", plantMaxStock=" + plantMaxStock
				+ ", plantRolStock=" + plantRolStock + ", vendorIds=" + vendorIds + ", delStatus=" + delStatus
				+ ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exInt3=" + exInt3 + ", exVar1=" + exVar1
				+ ", exVar2=" + exVar2 + ", exVar3=" + exVar3 + ", exDate1=" + exDate1 + ", exDate2=" + exDate2
				+ ", exBool1=" + exBool1 + ", exBool2=" + exBool2 + ", exBool3=" + exBool3 + ", sortNo=" + sortNo
				+ ", length=" + length + ", height=" + height + ", width=" + width + ", itemLocation=" + itemLocation
				+ ", royaltyRate=" + royaltyRate + ", freightRate=" + freightRate + ", taxName=" + taxName
				+ ", hsnCode=" + hsnCode + ", uomName=" + uomName + ", plantName=" + plantName + ", enqQty=" + enqQty
				+ ", enqUomId=" + enqUomId + ", enqUomName=" + enqUomName + ", otherCostAfterTax=" + otherCostAfterTax
				+ ", transCost=" + transCost + ", otherCost=" + otherCost + ", quotQty=" + quotQty + ", taxableValue="
				+ taxableValue + ", taxValue=" + taxValue + ", finalTotal=" + finalTotal + ", quotDetailId="
				+ quotDetailId + ", totalTaxPer=" + totalTaxPer + ", cgst=" + cgst + ", igst=" + igst + ", sgst=" + sgst
				+ ", cess=" + cess + "]";
	}

}
