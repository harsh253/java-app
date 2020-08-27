package com.sapient;

import com.sapient.dao.DatumDAO;

public class App {
	
	public static void main(String[] args) {
		DatumDAO dao = new DatumDAO();
		dao.readDataFromFile("./sampleFiles\\Sample input file Assignment 3.csv");
		dao.generatePerCapitaIncomeGroup(dao.groupByGenderAndCountry());
		dao.exportReportToFile("./sampleFiles\\Output", "csv");
	}

}
