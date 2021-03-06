package com.shivshambhuwebapi.master.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_vehicle")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vehicle_id")
	private int vehicleId;

	@Column(name = "vehicle_name")
	private String vehicleName;
	


	@Column(name = "veh_comp_name")
	private String vehCompName;

	@Column(name = "load_capacity")
	private float loadCapacity;

	@Column(name = "uom_id")
	private int uomId;

	@Column(name = "veh_no")
	private String vehNo;

	@Column(name = "veh_doc1")
	private String vehDoc1;

	@Column(name = "veh_doc2")
	private String vehDoc2;

	@Column(name = "veh_doc3")
	private String vehDoc3;

	@Column(name = "veh_doc4")
	private String vehDoc4;

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

	@Column(name = "ex_date1")
	private String exDate1;

	@Column(name = "ex_date2")
	private String exDate2;

	@Column(name = "ex_bool1")
	private int exBool1;

	@Column(name = "ex_bool2")
	private int exBool2;

	@Column(name = "vehicle_type")
	private int vehicleType;

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehCompName() {
		return vehCompName;
	}

	public void setVehCompName(String vehCompName) {
		this.vehCompName = vehCompName;
	}

	public float getLoadCapacity() {
		return loadCapacity;
	}

	public void setLoadCapacity(float loadCapacity) {
		this.loadCapacity = loadCapacity;
	}

	public int getUomId() {
		return uomId;
	}

	public void setUomId(int uomId) {
		this.uomId = uomId;
	}

	public String getVehNo() {
		return vehNo;
	}

	public void setVehNo(String vehNo) {
		this.vehNo = vehNo;
	}

	public String getVehDoc1() {
		return vehDoc1;
	}

	public void setVehDoc1(String vehDoc1) {
		this.vehDoc1 = vehDoc1;
	}

	public String getVehDoc2() {
		return vehDoc2;
	}

	public void setVehDoc2(String vehDoc2) {
		this.vehDoc2 = vehDoc2;
	}

	public String getVehDoc3() {
		return vehDoc3;
	}

	public void setVehDoc3(String vehDoc3) {
		this.vehDoc3 = vehDoc3;
	}

	public String getVehDoc4() {
		return vehDoc4;
	}

	public void setVehDoc4(String vehDoc4) {
		this.vehDoc4 = vehDoc4;
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

	public int getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(int vehicleType) {
		this.vehicleType = vehicleType;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleName=" + vehicleName + ", vehCompName=" + vehCompName
				+ ", loadCapacity=" + loadCapacity + ", uomId=" + uomId + ", vehNo=" + vehNo + ", vehDoc1=" + vehDoc1
				+ ", vehDoc2=" + vehDoc2 + ", vehDoc3=" + vehDoc3 + ", vehDoc4=" + vehDoc4 + ", delStatus=" + delStatus
				+ ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exInt3=" + exInt3 + ", exVar1=" + exVar1
				+ ", exVar2=" + exVar2 + ", exDate1=" + exDate1 + ", exDate2=" + exDate2 + ", exBool1=" + exBool1
				+ ", exBool2=" + exBool2 + ", vehicleType=" + vehicleType + "]";
	}

}
