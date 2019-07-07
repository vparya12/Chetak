package com.vparya12.bean;

import java.util.Date;

public class Dth {
	private int id;
	private Long mobileNumber;
	private Long dthNumber;
	private String network;
	private String userName;
	private Long alternativeNumber;
	private Date lastRechargedDate;
	private Integer paidBalance;
	private Integer validDays;
	private Integer balance;
	private Integer rechargeAmount;
	private int remainingDays;
	private Date nextRechargeDate;
	
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getAlternativeNumber() {
		return alternativeNumber;
	}
	public void setAlternativeNumber(Long alternativeNumber) {
		this.alternativeNumber = alternativeNumber;
	}
	public Date getLastRechargedDate() {
		return lastRechargedDate;
	}
	public void setLastRechargedDate(Date lastRechargedDate) {
		this.lastRechargedDate = lastRechargedDate;
	}
	public Integer getPaidBalance() {
		return paidBalance;
	}
	public void setPaidBalance(Integer paidBalance) {
		this.paidBalance = paidBalance;
	}
	public Integer getValidDays() {
		return validDays;
	}
	public void setValidDays(Integer validDays) {
		this.validDays = validDays;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public Long getDthNumber() {
		return dthNumber;
	}
	public void setDthNumber(Long dthNumber) {
		this.dthNumber = dthNumber;
	}
	public Integer getRechargeAmount() {
		return rechargeAmount;
	}
	public void setRechargeAmount(Integer rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}
	public int getRemainingDays() {
		return remainingDays;
	}
	public void setRemainingDays(int remainingDays) {
		this.remainingDays = remainingDays;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getNextRechargeDate() {
		return nextRechargeDate;
	}
	public void setNextRechargeDate(Date nextRechargeDate) {
		this.nextRechargeDate = nextRechargeDate;
	}
	
	
}
