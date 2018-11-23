package com.shivshambhuwebapi.master.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private int orderId;

	@Column(name = "plant_id")
	private int plantId;

	@Column(name = "cust_id")
	private int custId;

	@Column(name = "po_id")
	private int poId;

	@Column(name = "proj_id")
	private int projId;

	@Column(name = "delivery_date")
	private String deliveryDate;

	@Column(name = "order_date")
	private String orderDate;

	@Column(name = "prod_date")
	private String prodDate;

	@Column(name = "order_value")
	private float orderValue;

	@Column(name = "order_no")
	private String orderNo;

	@Column(name = "total")
	private float total;

	@Column(name = "is_tax_including")
	private int isTaxIncluding;

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
	
	
	private int status;
	
	
	
	
	
	


}
