package com.sapient;

import com.sapient.bo.TransactionBO;
import com.sapient.dao.TransactionDAO;

public class App {

	public static void main(String[] args) {
		TransactionDAO dao = new TransactionDAO();
		dao.readTransactionsFromFile("./sampleFiles\\Sample_Data_Fee_Calculator.csv");
		
		TransactionBO bo = new TransactionBO();
		bo.getTotalFees(dao.getAllTransactions());
		
		dao.exportReportToFile("./sampleFiles\\result", "csv");

	}

}
