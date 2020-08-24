package com.sapient.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.sapient.dao.TransactionDAO;
import com.sapient.model.Transaction;
import com.sapient.util.Date;
import com.sapient.util.Filename;
import com.sapient.util.Reader;
import com.sapient.util.Writer;

public class TransactionDAO {

	private ArrayList<Transaction> transactions;
	private Reader reader;

	public TransactionDAO() {
		this.transactions = new ArrayList<>();
		this.reader = new Reader();
	}

	public ArrayList<Transaction> getAllTransactions() {
		return this.transactions;
	}

	public void readTransactionsFromFile(String file) {

		String fileExtension = Filename.getFileExtension(file);

		switch (fileExtension) {
		case "csv":
			ArrayList<String[]> entries = new ArrayList<>();
			entries = reader.readCSVFile(file);
			for (String[] entry : entries) {
				Transaction transaction = new Transaction();
				transaction.setTransactionId(entry[0]);
				transaction.setClientId(entry[1]);
				transaction.setSecurityId(entry[2]);
				transaction.setTransactionType(entry[3]);
				transaction.setTransactionDate(Date.formatDate(entry[4]));
				transaction.setMarketValue(Float.parseFloat(entry[5]));
				transaction.setIsHighPriority(entry[6].equals("Y"));
				this.transactions.add(transaction);
			}
			System.out.println("Read all data from file");
			break;

		default:
			break;
		}
	}
	
	public void sortTransactions() {
		Comparator<Transaction> comparator = new Comparator<Transaction>() {

			@Override
			public int compare(Transaction o1, Transaction o2) {
				return o1.getClientId().compareTo(o2.getClientId());
			}
			
		};
		Collections.sort(this.transactions,  comparator);
	}

	public void exportReportToFile(String file, String fileType) {

		switch (fileType.toLowerCase()) {
		case "csv":
			this.sortTransactions();
			String header = "ClientId, Transaction Type, Transaction Date, Priority, Processing Fee";
			Writer.writeToCsv(file,header, this.transactions);
			System.out.println("Wrote result to result.csv");
			break;

		default:
			break;
		}

	}

}
