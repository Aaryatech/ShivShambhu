package com.shivshambhuwebapi.master.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_item")
public class RawMatItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private int itemId;

	@Column(name = "item_code")
	private String itemCode;

	@Column(name = "item_desc")
	private String itemDesc;

	@Column(name = "item_desc2")
	private String itemDesc2;

	@Column(name = "item_desc3")
	private String itemDesc3;

	@Column(name = "item_uom")
	private String itemUom;

	@Column(name = "item_uom2")
	private String itemUom2;

	@Column(name = "cat_id")
	private int catId;

	@Column(name = "grp_id")
	private int grpId;

	@Column(name = "sub_grp_id")
	private int subGrpId;

	@Column(name = "item_op_qty")
	private int itemOpQty;

	@Column(name = "item_cl_rate")
	private float itemClRate;

	@Column(name = "item_op_rate")
	private float itemOpRate;

	@Column(name = "item_cl_qty")
	private int itemClQty;

	@Column(name = "item_date")
	private String itemDate;

	@Column(name = "item_wt")
	private float itemWt;

	@Column(name = "item_min_level")
	private int itemMinLevel;

	@Column(name = "item_max_level")
	private int itemMaxLevel;

	@Column(name = "item_rod_level")
	private int itemRodLevel;

	@Column(name = "item_location")
	private String itemLocation;

	@Column(name = "item_abc")
	private String itemAbc;

	@Column(name = "item_is_critical")
	private int itemIsCritical;

	@Column(name = "item_is_cons")
	private int itemIsCons;

	@Column(name = "item_is_capital")
	private int itemIsCapital;

	@Column(name = "item_schd")
	private String itemSchd;

	@Column(name = "item_life")
	private String itemLife;

	private int isUsed;

	private int createdIn;
	private int deletedIn;

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

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getItemDesc2() {
		return itemDesc2;
	}

	public void setItemDesc2(String itemDesc2) {
		this.itemDesc2 = itemDesc2;
	}

	public String getItemDesc3() {
		return itemDesc3;
	}

	public void setItemDesc3(String itemDesc3) {
		this.itemDesc3 = itemDesc3;
	}

	public String getItemUom() {
		return itemUom;
	}

	public void setItemUom(String itemUom) {
		this.itemUom = itemUom;
	}

	public String getItemUom2() {
		return itemUom2;
	}

	public void setItemUom2(String itemUom2) {
		this.itemUom2 = itemUom2;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public int getGrpId() {
		return grpId;
	}

	public void setGrpId(int grpId) {
		this.grpId = grpId;
	}

	public int getSubGrpId() {
		return subGrpId;
	}

	public void setSubGrpId(int subGrpId) {
		this.subGrpId = subGrpId;
	}

	public int getItemOpQty() {
		return itemOpQty;
	}

	public void setItemOpQty(int itemOpQty) {
		this.itemOpQty = itemOpQty;
	}

	public float getItemClRate() {
		return itemClRate;
	}

	public void setItemClRate(float itemClRate) {
		this.itemClRate = itemClRate;
	}

	public float getItemOpRate() {
		return itemOpRate;
	}

	public void setItemOpRate(float itemOpRate) {
		this.itemOpRate = itemOpRate;
	}

	public int getItemClQty() {
		return itemClQty;
	}

	public void setItemClQty(int itemClQty) {
		this.itemClQty = itemClQty;
	}

	public String getItemDate() {
		return itemDate;
	}

	public void setItemDate(String itemDate) {
		this.itemDate = itemDate;
	}

	public float getItemWt() {
		return itemWt;
	}

	public void setItemWt(float itemWt) {
		this.itemWt = itemWt;
	}

	public int getItemMinLevel() {
		return itemMinLevel;
	}

	public void setItemMinLevel(int itemMinLevel) {
		this.itemMinLevel = itemMinLevel;
	}

	public int getItemMaxLevel() {
		return itemMaxLevel;
	}

	public void setItemMaxLevel(int itemMaxLevel) {
		this.itemMaxLevel = itemMaxLevel;
	}

	public int getItemRodLevel() {
		return itemRodLevel;
	}

	public void setItemRodLevel(int itemRodLevel) {
		this.itemRodLevel = itemRodLevel;
	}

	public String getItemLocation() {
		return itemLocation;
	}

	public void setItemLocation(String itemLocation) {
		this.itemLocation = itemLocation;
	}

	public String getItemAbc() {
		return itemAbc;
	}

	public void setItemAbc(String itemAbc) {
		this.itemAbc = itemAbc;
	}

	public int getItemIsCritical() {
		return itemIsCritical;
	}

	public void setItemIsCritical(int itemIsCritical) {
		this.itemIsCritical = itemIsCritical;
	}

	public int getItemIsCons() {
		return itemIsCons;
	}

	public void setItemIsCons(int itemIsCons) {
		this.itemIsCons = itemIsCons;
	}

	public int getItemIsCapital() {
		return itemIsCapital;
	}

	public void setItemIsCapital(int itemIsCapital) {
		this.itemIsCapital = itemIsCapital;
	}

	public String getItemSchd() {
		return itemSchd;
	}

	public void setItemSchd(String itemSchd) {
		this.itemSchd = itemSchd;
	}

	public String getItemLife() {
		return itemLife;
	}

	public void setItemLife(String itemLife) {
		this.itemLife = itemLife;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	public int getCreatedIn() {
		return createdIn;
	}

	public void setCreatedIn(int createdIn) {
		this.createdIn = createdIn;
	}

	public int getDeletedIn() {
		return deletedIn;
	}

	public void setDeletedIn(int deletedIn) {
		this.deletedIn = deletedIn;
	}

	@Override
	public String toString() {
		return "RawMatItem [itemId=" + itemId + ", itemCode=" + itemCode + ", itemDesc=" + itemDesc + ", itemDesc2="
				+ itemDesc2 + ", itemDesc3=" + itemDesc3 + ", itemUom=" + itemUom + ", itemUom2=" + itemUom2
				+ ", catId=" + catId + ", grpId=" + grpId + ", subGrpId=" + subGrpId + ", itemOpQty=" + itemOpQty
				+ ", itemClRate=" + itemClRate + ", itemOpRate=" + itemOpRate + ", itemClQty=" + itemClQty
				+ ", itemDate=" + itemDate + ", itemWt=" + itemWt + ", itemMinLevel=" + itemMinLevel + ", itemMaxLevel="
				+ itemMaxLevel + ", itemRodLevel=" + itemRodLevel + ", itemLocation=" + itemLocation + ", itemAbc="
				+ itemAbc + ", itemIsCritical=" + itemIsCritical + ", itemIsCons=" + itemIsCons + ", itemIsCapital="
				+ itemIsCapital + ", itemSchd=" + itemSchd + ", itemLife=" + itemLife + ", isUsed=" + isUsed
				+ ", createdIn=" + createdIn + ", deletedIn=" + deletedIn + "]";
	}

}
