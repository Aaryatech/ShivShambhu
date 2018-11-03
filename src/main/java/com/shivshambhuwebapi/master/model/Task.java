package com.shivshambhuwebapi.master.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_task")
public class Task 
{
@Id	
@Column(name="task_id")
private int taskId;

@Column(name="task_name")
private String taskName;

@Column(name="task_desc")
private String taskDesc;

@Column(name="dept_id")
private Integer deptId;

@Column(name="del_status")
private Integer delStatus;

@Column(name="sort_no")
private Integer sortNo;

@Column(name="is_used")
private Integer isUsed;


@Column(name="ex_int1")
private Integer exInt1;

@Column(name="ex_int2")
private Integer exInt2;

@Column(name="ex_var1")
private String exVar1;

@Column(name="ex_var2")
private String exVar2;

@Column(name="ex_date1")
private String exDate1;

@Column(name="ex_date2")
private String exDate2;

@Column(name="ex_bool1")
private Integer exBool1;

@Column(name="ex_bool2")
private Integer exBool2;



public String getTaskDesc() {
	return taskDesc;
}
public void setTaskDesc(String taskDesc) {
	this.taskDesc = taskDesc;
}
public Integer getDeptId() {
	return deptId;
}
public void setDeptId(Integer deptId) {
	this.deptId = deptId;
}
public Integer getDelStatus() {
	return delStatus;
}
public void setDelStatus(Integer delStatus) {
	this.delStatus = delStatus;
}
public Integer getSortNo() {
	return sortNo;
}
public void setSortNo(Integer sortNo) {
	this.sortNo = sortNo;
}
public Integer getIsUsed() {
	return isUsed;
}
public void setIsUsed(Integer isUsed) {
	this.isUsed = isUsed;
}
public Integer getExInt1() {
	return exInt1;
}
public void setExInt1(Integer exInt1) {
	this.exInt1 = exInt1;
}
public Integer getExInt2() {
	return exInt2;
}
public void setExInt2(Integer exInt2) {
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
public String getExDate2() {
	return exDate2;
}
public void setExDate2(String exDate2) {
	this.exDate2 = exDate2;
}
public Integer getExBool1() {
	return exBool1;
}
public void setExBool1(Integer exBool1) {
	this.exBool1 = exBool1;
}
public Integer getExBool2() {
	return exBool2;
}
public void setExBool2(Integer exBool2) {
	this.exBool2 = exBool2;
}

public int getTaskId() {
	return taskId;
}
public void setTaskId(int taskId) {
	this.taskId = taskId;
}
public String getTaskName() {
	return taskName;
}
public void setTaskName(String taskName) {
	this.taskName = taskName;
}

@Override
public String toString() {
	return "Task [taskId=" + taskId + ", taskName=" + taskName + ", taskDesc=" + taskDesc + ", deptId=" + deptId
			+ ", delStatus=" + delStatus + ", sortNo=" + sortNo + ", isUsed=" + isUsed + ", exInt1=" + exInt1
			+ ", exInt2=" + exInt2 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", exDate1=" + exDate1 + ", exDate2="
			+ exDate2 + ", exBool1=" + exBool1 + ", exBool2=" + exBool2 + "]";
}

}
