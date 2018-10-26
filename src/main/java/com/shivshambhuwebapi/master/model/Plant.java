package com.shivshambhuwebapi.master.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_plant")
public class Plant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "plant_id")
	private int plant_id;

	@Column(name = "plant_name")
	private String plant_name;
	
	@Column(name = "company_id")
	private int company_id;

	@Column(name = "sort_no")
	private int sortNo;

	@Column(name = "is_used")
	private int isUsed;

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

	@Column(name = "ex_date2")
	private String exDate2;

	@Column(name = "ex_bool1")
	private int exBool1;

	@Column(name = "ex_bool2")
	private int exBool2;

}
