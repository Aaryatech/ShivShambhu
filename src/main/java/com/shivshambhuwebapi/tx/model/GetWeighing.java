package com.shivshambhuwebapi.tx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetWeighing {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "weigh_id")
	private int weighId;

	@Column(name = "veh_id")
	private int vehId;

	@Column(name = "poklen_id")
	private int poklenId;

	@Column(name = "contra_id")
	private int contraId;

	@Column(name = "cont_rate")
	private float contRate;

	@Column(name = "quantity")
	private float quantity;

	@Column(name = "photo1")
	private String photo1;

	@Column(name = "photo2")
	private String photo2;

	@Column(name = "remark")
	private String remark;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "date")
	private String date;

	@Column(name = "veh_km")
	private float vehKm;

	@Column(name = "poklen_km")
	private float poklenKm;

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

	private String vehicleName;
	private String vehicleNo;
	private String pokeName;
	private String pokeNo;
	private String contrName;

	public int getWeighId() {
		return weighId;
	}

	public void setWeighId(int weighId) {
		this.weighId = weighId;
	}

	public int getVehId() {
		return vehId;
	}

	public void setVehId(int vehId) {
		this.vehId = vehId;
	}

	public int getPoklenId() {
		return poklenId;
	}

	public void setPoklenId(int poklenId) {
		this.poklenId = poklenId;
	}

	public int getContraId() {
		return contraId;
	}

	public void setContraId(int contraId) {
		this.contraId = contraId;
	}

	public float getContRate() {
		return contRate;
	}

	public void setContRate(float contRate) {
		this.contRate = contRate;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public String getPhoto1() {
		return photo1;
	}

	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}

	public String getPhoto2() {
		return photo2;
	}

	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getVehKm() {
		return vehKm;
	}

	public void setVehKm(float vehKm) {
		this.vehKm = vehKm;
	}

	public float getPoklenKm() {
		return poklenKm;
	}

	public void setPoklenKm(float poklenKm) {
		this.poklenKm = poklenKm;
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

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getPokeName() {
		return pokeName;
	}

	public void setPokeName(String pokeName) {
		this.pokeName = pokeName;
	}

	public String getContrName() {
		return contrName;
	}

	public void setContrName(String contrName) {
		this.contrName = contrName;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getPokeNo() {
		return pokeNo;
	}

	public void setPokeNo(String pokeNo) {
		this.pokeNo = pokeNo;
	}

	@Override
	public String toString() {
		return "GetWeighing [weighId=" + weighId + ", vehId=" + vehId + ", poklenId=" + poklenId + ", contraId="
				+ contraId + ", contRate=" + contRate + ", quantity=" + quantity + ", photo1=" + photo1 + ", photo2="
				+ photo2 + ", remark=" + remark + ", userId=" + userId + ", date=" + date + ", vehKm=" + vehKm
				+ ", poklenKm=" + poklenKm + ", delStatus=" + delStatus + ", exInt1=" + exInt1 + ", exInt2=" + exInt2
				+ ", exInt3=" + exInt3 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", exVar3=" + exVar3
				+ ", exDate1=" + exDate1 + ", exDate2=" + exDate2 + ", exBool1=" + exBool1 + ", exBool2=" + exBool2
				+ ", vehicleName=" + vehicleName + ", vehicleNo=" + vehicleNo + ", pokeName=" + pokeName + ", pokeNo="
				+ pokeNo + ", contrName=" + contrName + "]";
	}

}
