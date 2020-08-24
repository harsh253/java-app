package com.sapient.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.sapient.model.Transaction;

public class Writer {
	
	public static void writeToCsv(String file, String header, ArrayList<Transaction> list ) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file+".csv"));
			bw.write(header);
			bw.newLine();
			for (Transaction transaction : list) {
				String clientId = transaction.getClientId();
				String type = transaction.getTransactionType();
				String date = transaction.getTransactionDate().format(Date.getDatePattern());
				String priority = transaction.isHighPriority() ? "Y" : "N";
				String fee = transaction.getTransactionFee().toString();
				String line = String.format("%s, %s, %s, %s, %s", clientId, type,date,priority,fee);
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
