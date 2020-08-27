package com.sapient.models;

import java.math.BigDecimal;

public class Datum {
	
	private String city;
	private String country;
	private String gender;
	private String currency;
	private BigDecimal avgIncome;
	private BigDecimal avgIncomeInUsd;
	
	public BigDecimal getAvgIncomeInUsd() {
		return avgIncomeInUsd;
	}
	public void setAvgIncomeInUsd(BigDecimal avgIncomeInUsd) {
		this.avgIncomeInUsd = avgIncomeInUsd;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public BigDecimal getAvgIncome() {
		return avgIncome;
	}
	public void setAvgIncome(BigDecimal avgIncome) {
		this.avgIncome = avgIncome;
	}
	
	
	

}
