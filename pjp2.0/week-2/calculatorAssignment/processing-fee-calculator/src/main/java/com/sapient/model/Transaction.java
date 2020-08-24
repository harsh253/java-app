package com.sapient.model;

import java.time.LocalDate;

public class Transaction {
	
	private String transactionId;
	private String clientId;
	private String securityId;
	private String transactionType;
	private LocalDate transactionDate;
	private float marketValue;
	private boolean isHighPriority;
	private Float transactionFee;
	
	
	public Transaction() {
		
	}


	public String getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}


	public String getClientId() {
		return clientId;
	}


	public void setClientId(String clientId) {
		this.clientId = clientId;
	}


	public String getSecurityId() {
		return securityId;
	}


	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}


	public String getTransactionType() {
		return transactionType;
	}


	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}


	public LocalDate getTransactionDate() {
		return transactionDate;
	}


	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}


	public float getMarketValue() {
		return marketValue;
	}


	public void setMarketValue(float marketValue) {
		this.marketValue = marketValue;
	}


	public boolean isHighPriority() {
		return isHighPriority;
	}


	public void setIsHighPriority(boolean priorityFlag) {
		this.isHighPriority = priorityFlag;
	}
	
	public void setTransactionFee(Float transactionFee) {
		this.transactionFee = transactionFee;
	}
	
	public Float getTransactionFee() {
		return this.transactionFee;
	}
	
	
	
	

}
