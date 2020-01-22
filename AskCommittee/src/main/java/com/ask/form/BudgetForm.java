package com.ask.form;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class BudgetForm implements Serializable{
	
	@NotBlank(message = "目的が未入力です")
	private String purpose;
	
	private String day;
	private int numPeople;
	private String budgetInfo;
	private int amount;
	private String payee;
	private String remark;
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public int getNumPeople() {
		return numPeople;
	}
	public void setNumPeople(int numPeople) {
		this.numPeople = numPeople;
	}
	public String getBudgetInfo() {
		return budgetInfo;
	}
	public void setBudgetInfo(String budgetInfo) {
		this.budgetInfo = budgetInfo;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getPayee() {
		return payee;
	}
	public void setPayee(String payee) {
		this.payee = payee;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}