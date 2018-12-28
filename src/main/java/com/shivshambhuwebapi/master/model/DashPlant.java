package com.shivshambhuwebapi.master.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DashPlant {

	@Id
	private float totalBillAmount;
	private float contrExpenses;
	private float vehExpenses;

	public float getTotalBillAmount() {
		return totalBillAmount;
	}

	public void setTotalBillAmount(float totalBillAmount) {
		this.totalBillAmount = totalBillAmount;
	}

	public float getContrExpenses() {
		return contrExpenses;
	}

	public void setContrExpenses(float contrExpenses) {
		this.contrExpenses = contrExpenses;
	}

	public float getVehExpenses() {
		return vehExpenses;
	}

	public void setVehExpenses(float vehExpenses) {
		this.vehExpenses = vehExpenses;
	}

	@Override
	public String toString() {
		return "DashPlant [totalBillAmount=" + totalBillAmount + ", contrExpenses=" + contrExpenses + ", vehExpenses="
				+ vehExpenses + "]";
	}

}
