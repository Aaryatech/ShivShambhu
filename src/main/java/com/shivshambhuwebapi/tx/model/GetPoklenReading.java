package com.shivshambhuwebapi.tx.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetPoklenReading {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int readingId;

	private int poklenId;

	private String startDate;

	private String endDate;

	private int pokType;

	private int shiftType;

	private float startReading;

	private float endReading;

	private String startTime;

	private String endTime;

	private int delStatus;

	private int exInt1;

	private int exInt2;

	private String exVar1;

	private String exVar2;

	private String exDate1;

	private int exBool1;

	private String vehNo;
	private String vehicleName;

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getPokType() {
		return pokType;
	}

	public void setPokType(int pokType) {
		this.pokType = pokType;
	}

	public int getShiftType() {
		return shiftType;
	}

	public void setShiftType(int shiftType) {
		this.shiftType = shiftType;
	}

	public float getStartReading() {
		return startReading;
	}

	public void setStartReading(float startReading) {
		this.startReading = startReading;
	}

	public float getEndReading() {
		return endReading;
	}

	public void setEndReading(float endReading) {
		this.endReading = endReading;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
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

	public String getVehNo() {
		return vehNo;
	}

	public void setVehNo(String vehNo) {
		this.vehNo = vehNo;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public int getReadingId() {
		return readingId;
	}

	public void setReadingId(int readingId) {
		this.readingId = readingId;
	}

	public int getPoklenId() {
		return poklenId;
	}

	public void setPoklenId(int poklenId) {
		this.poklenId = poklenId;
	}

	@Override
	public String toString() {
		return "GetPoklenReading [readingId=" + readingId + ", poklenId=" + poklenId + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", pokType=" + pokType + ", shiftType=" + shiftType + ", startReading="
				+ startReading + ", endReading=" + endReading + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", delStatus=" + delStatus + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exVar1=" + exVar1
				+ ", exVar2=" + exVar2 + ", exDate1=" + exDate1 + ", exBool1=" + exBool1 + ", vehNo=" + vehNo
				+ ", vehicleName=" + vehicleName + "]";
	}

}
