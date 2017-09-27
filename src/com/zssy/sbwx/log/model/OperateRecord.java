package com.zssy.sbwx.log.model;

import java.io.Serializable;
import java.util.Date;

public class OperateRecord implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;//id号
	private String operator;//操作人名称
	private String operatorId;//操作人id
	private String operation;//操作
	private String operateTable;//操作表名
	private Date operateTime;//操作时间
	private String operateedId;//被操作记录的id
	private String operateBeforeOne;//操作前的字段值1
	private String operateAfterOne;//操作后的字段值1
	private String operateBeforeTwo;//操作前的字段值2
	private String operateAfterTwo;//操作后的字段值2
	private String operateBeforeThree;//操作前的字段值3
	private String operateAfterThree;//操作后的字段值3
	
	public OperateRecord(){
		
	}
	
	//插入类型的构造函数
	public OperateRecord(String operator,String operatorId,String operateTable,String operateedId,String operation){
		this.operator = operator;
		this.operatorId = operatorId;
		this.operateTable = operateTable;
		this.operateedId = operateedId;
		this.operation = operation;
		this.operateTime = new Date();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}
	public String getOperateAfterOne() {
		return operateAfterOne;
	}
	public void setOperateAfterOne(String operateAfterOne) {
		this.operateAfterOne = operateAfterOne;
	}
	public String getOperateAfterThree() {
		return operateAfterThree;
	}
	public void setOperateAfterThree(String operateAfterThree) {
		this.operateAfterThree = operateAfterThree;
	}
	public String getOperateAfterTwo() {
		return operateAfterTwo;
	}
	public void setOperateAfterTwo(String operateAfterTwo) {
		this.operateAfterTwo = operateAfterTwo;
	}
	public String getOperateBeforeOne() {
		return operateBeforeOne;
	}
	public void setOperateBeforeOne(String operateBeforeOne) {
		this.operateBeforeOne = operateBeforeOne;
	}
	public String getOperateBeforeThree() {
		return operateBeforeThree;
	}
	public void setOperateBeforeThree(String operateBeforeThree) {
		this.operateBeforeThree = operateBeforeThree;
	}
	public String getOperateBeforeTwo() {
		return operateBeforeTwo;
	}
	public void setOperateBeforeTwo(String operateBeforeTwo) {
		this.operateBeforeTwo = operateBeforeTwo;
	}
	public String getOperateedId() {
		return operateedId;
	}
	public void setOperateedId(String operateedId) {
		this.operateedId = operateedId;
	}
	public String getOperateTable() {
		return operateTable;
	}
	public void setOperateTable(String operateTable) {
		this.operateTable = operateTable;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
}
