package com.shivshambhuwebapi.master.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_item")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private int itemId;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "item_code")
	private String itemCode;

	@Column(name = "item_image")
	private String itemImage;

	@Column(name = "item_type")
	private int itemType;

	@Column(name = "plant_id")
	private int plantId;

	@Column(name = "item_rate1")
	private float itemRate1;

	@Column(name = "item_rate2")
	private float itemRate2;

	@Column(name = "item_rate3")
	private float itemRate3;

	@Column(name = "item_rate4")
	private float itemRate4;

	@Column(name = "tax_id")
	private int taxId;

	@Column(name = "uom_id")
	private int uomId;

	@Column(name = "actual_weight")
	private float actualWeight;

	@Column(name = "base_weight")
	private float baseWeight;

	@Column(name = "short_name")
	private String shortName;

	@Column(name = "dispatch_limit")
	private float dispatchLimit;

	@Column(name = "is_critical")
	private int isCritical;

	@Column(name = "item_is_used")
	private int itemIsUsed;

	@Column(name = "min_stock")
	private float minStock;

	@Column(name = "max_stock")
	private float maxStock;

	@Column(name = "rol_stock")
	private float rolStock;

	@Column(name = "plant_min_stock")
	private float plantMinStock;

	@Column(name = "plant_max_stock")
	private float plantMaxStock;

	@Column(name = "plant_rol_stock")
	private float plantRolStock;

	@Column(name = "vendor_ids")
	private String vendorIds;

	@Column(name = "del_status")
	private int delStatus;

	@Column(name = "ex_int1")
	private int exInt1;

	@Column(name = "ex_int2")
	private int exInt2;

	@Column(name = "ex_int3")
	private int exInt3;

	@Column(name = "ex_var1")
	private String exVar1;

	@Column(name = "ex_var2")
	private String exVar2;

	@Column(name = "ex_var3")
	private String exVar3;

	@Column(name = "ex_date1")
	private String exDate1;

	@Column(name = "ex_date2")
	private String exDate2;

	@Column(name = "ex_bool1")
	private int exBool1;

	@Column(name = "ex_bool2")
	private int exBool2;

	@Column(name = "ex_bool3")
	private int exBool3;

	@Column(name = "sort_no")
	private int sortNo;

	@Column(name = "length")
	private float length;

	@Column(name = "height")
	private float height;

	@Column(name = "width")
	private float width;

	@Column(name = "item_location")
	private String itemLocation;

	@Column(name = "royalty_rate")
	private float royalty_rate;

	@Column(name = "freight_rate")
	private float freight_rate;

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

	public float getRoyalty_rate() {
		return royalty_rate;
	}

	public void setRoyalty_rate(float royalty_rate) {
		this.royalty_rate = royalty_rate;
	}

	public float getFreight_rate() {
		return freight_rate;
	}

	public void setFreight_rate(float freight_rate) {
		this.freight_rate = freight_rate;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemCode=" + itemCode + ", itemImage="
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
				+ ", royalty_rate=" + royalty_rate + ", freight_rate=" + freight_rate + "]";
	}

}
