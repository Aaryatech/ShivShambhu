package com.shivshambhuwebapi.master.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GetUser {

	@Id
	private int userId;

	private String usrName;

	private String userPass;

	private String usrMob;

	private int deptId;

	private int companyId;

	private int plantId;

	private String usrEmail;

	private String usrDob;

	private int roleId;

	private int sortNo;

	private int delStatus;

	private String deviceToken;

	private int exInt1;

	private int exInt2;

	private String exVar1;

	private String exVar2;

	private String exDate1;

	private String exDate2;

	private String plantName;
	private String compName;
	private String deptname;

}
