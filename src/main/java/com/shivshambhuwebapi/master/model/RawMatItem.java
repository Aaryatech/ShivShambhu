package com.shivshambhuwebapi.master.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_rm_item")
public class RawMatItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rm_id")
	private int rmId;

	@Column(name = "cat_id")
	private int catId;

	@Column(name = "rm_code")
	private String rmCode;

	@Column(name = "rm_name")
	private String rmName;

	@Column(name = "uom_id")
	private int uomId;

	@Column(name = "tax_id")
	private int taxId;

	@Column(name = "item_life")
	private int itemLife;

	@Column(name = "is_critical")
	private int isCritical;

	@Column(name = "item_schedule_days")
	private int itemScheduleDays;

	@Column(name = "location")
	private String location;

	@Column(name = "min_level")
	private float minLevel;

	@Column(name = "max_level")
	private float maxLevel;

	@Column(name = "reorder_level")
	private float reorderLevel;

	@Column(name = "item_rate")
	private float itemRate;

	@Column(name = "del_status")
	private int delStatus;

	@Column(name = "ex_int1")
	private int exInt1;

	@Column(name = "ex_int2")
	private int exInt2;

	@Column(name = "ex_var1")
	private String exVar1;

	@Column(name = "ex_var2")
	private String exVar2;

	@Column(name = "ex_date1")
	private String exDate1;

	@Column(name = "ex_bool1")
	private int exBool1;

	public int getRmId() {
		return rmId;
	}

	public void setRmId(int rmId) {
		this.rmId = rmId;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getRmCode() {
		return rmCode;
	}

	public void setRmCode(String rmCode) {
		this.rmCode = rmCode;
	}

	public String getRmName() {
		return rmName;
	}

	public void setRmName(String rmName) {
		this.rmName = rmName;
	}

	public int getUomId() {
		return uomId;
	}

	public void setUomId(int uomId) {
		this.uomId = uomId;
	}

	public int getTaxId() {
		return taxId;
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	public int getItemLife() {
		return itemLife;
	}

	public void setItemLife(int itemLife) {
		this.itemLife = itemLife;
	}

	public int getIsCritical() {
		return isCritical;
	}

	public void setIsCritical(int isCritical) {
		this.isCritical = isCritical;
	}

	public int getItemScheduleDays() {
		return itemScheduleDays;
	}

	public void setItemScheduleDays(int itemScheduleDays) {
		this.itemScheduleDays = itemScheduleDays;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public float getMinLevel() {
		return minLevel;
	}

	public void setMinLevel(float minLevel) {
		this.minLevel = minLevel;
	}

	public float getMaxLevel() {
		return maxLevel;
	}

	public void setMaxLevel(float maxLevel) {
		this.maxLevel = maxLevel;
	}

	public float getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(float reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public float getItemRate() {
		return itemRate;
	}

	public void setItemRate(float itemRate) {
		this.itemRate = itemRate;
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

	public int getExBool1() {
		return exBool1;
	}

	public void setExBool1(int exBool1) {
		this.exBool1 = exBool1;
	}

	@Override
	public String toString() {
		return "RawMatItem [rmId=" + rmId + ", catId=" + catId + ", rmCode=" + rmCode + ", rmName=" + rmName
				+ ", uomId=" + uomId + ", taxId=" + taxId + ", itemLife=" + itemLife + ", isCritical=" + isCritical
				+ ", itemScheduleDays=" + itemScheduleDays + ", location=" + location + ", minLevel=" + minLevel
				+ ", maxLevel=" + maxLevel + ", reorderLevel=" + reorderLevel + ", itemRate=" + itemRate
				+ ", delStatus=" + delStatus + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exVar1=" + exVar1
				+ ", exVar2=" + exVar2 + ", exDate1=" + exDate1 + ", exBool1=" + exBool1 + "]";
	}

}
