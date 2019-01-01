package com.shivshambhuwebapi.master.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetExistingItemDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_detail_id")
	private int itemDetailId;

	@Column(name = "item_id")
	private int itemId;

	@Column(name = "rm_type")
	private int rmType;

	@Column(name = "rm_id")
	private int rmId;

	@Column(name = "rm_name")
	private String rmName;

	@Column(name = "rm_uom_id")
	private int rmUomId;

	@Column(name = "rm_qty")
	private float rmQty;

	@Column(name = "rm_weight")
	private float rmWeight;

	@Column(name = "no_pieces_per_item")
	private float noPiecesPerItem;

	@Column(name = "del_status")
	private int delStatus;

	@Column(name = "ex_int1")
	private int int1;

	@Column(name = "ex_int2")
	private int int2;

	@Column(name = "ex_var1")
	private String exVar1;

	@Column(name = "boll1")
	private int boll1;

	@Column(name = "boll2")
	private int boll2;

	private String uomName;

	private String catDesc;

	public int getItemDetailId() {
		return itemDetailId;
	}

	public void setItemDetailId(int itemDetailId) {
		this.itemDetailId = itemDetailId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getRmType() {
		return rmType;
	}

	public void setRmType(int rmType) {
		this.rmType = rmType;
	}

	public int getRmId() {
		return rmId;
	}

	public void setRmId(int rmId) {
		this.rmId = rmId;
	}

	public String getRmName() {
		return rmName;
	}

	public void setRmName(String rmName) {
		this.rmName = rmName;
	}

	public int getRmUomId() {
		return rmUomId;
	}

	public void setRmUomId(int rmUomId) {
		this.rmUomId = rmUomId;
	}

	public float getRmQty() {
		return rmQty;
	}

	public void setRmQty(float rmQty) {
		this.rmQty = rmQty;
	}

	public float getRmWeight() {
		return rmWeight;
	}

	public void setRmWeight(float rmWeight) {
		this.rmWeight = rmWeight;
	}

	public float getNoPiecesPerItem() {
		return noPiecesPerItem;
	}

	public void setNoPiecesPerItem(float noPiecesPerItem) {
		this.noPiecesPerItem = noPiecesPerItem;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getInt1() {
		return int1;
	}

	public void setInt1(int int1) {
		this.int1 = int1;
	}

	public int getInt2() {
		return int2;
	}

	public void setInt2(int int2) {
		this.int2 = int2;
	}

	public String getExVar1() {
		return exVar1;
	}

	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}

	public int getBoll1() {
		return boll1;
	}

	public void setBoll1(int boll1) {
		this.boll1 = boll1;
	}

	public int getBoll2() {
		return boll2;
	}

	public void setBoll2(int boll2) {
		this.boll2 = boll2;
	}

	public String getUomName() {
		return uomName;
	}

	public void setUomName(String uomName) {
		this.uomName = uomName;
	}

	public String getCatDesc() {
		return catDesc;
	}

	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}

	@Override
	public String toString() {
		return "GetExistingItemDetail [itemDetailId=" + itemDetailId + ", itemId=" + itemId + ", rmType=" + rmType
				+ ", rmId=" + rmId + ", rmName=" + rmName + ", rmUomId=" + rmUomId + ", rmQty=" + rmQty + ", rmWeight="
				+ rmWeight + ", noPiecesPerItem=" + noPiecesPerItem + ", delStatus=" + delStatus + ", int1=" + int1
				+ ", int2=" + int2 + ", exVar1=" + exVar1 + ", boll1=" + boll1 + ", boll2=" + boll2 + ", uomName="
				+ uomName + ", catDesc=" + catDesc + "]";
	}

}
