package com.sapient.bo;

import java.util.ArrayList;
import java.util.HashMap;

import com.sapient.model.Transaction;

public class TransactionBO {

	private HashMap<String, ArrayList<HashMap<Boolean, Float>>> charges;
	private HashMap<String, Transaction> store;
	private static final Float INTRA_DAY_CHARGE = (float) 10;

	public TransactionBO() {
		this.charges = new HashMap<>();
		this.store = new HashMap<String, Transaction>();
		this.initializeCharges();
	}

	public void getTotalFees(ArrayList<Transaction> transactions) {
		for (Transaction transaction : transactions) {

			this.chargeNominalFee(transaction);

			String identifier = (transaction.getClientId() + transaction.getSecurityId()
					+ transaction.getTransactionDate()).toString();
			this.store.put(identifier + transaction.getTransactionType(), transaction);

			if (transaction.getTransactionType().equals("BUY") || transaction.getTransactionType().equals("SELL")) {
				this.checkAndAddIntraDay(transaction, identifier);
			}
		}
	}
	
	public void chargeNominalFee(Transaction transaction) {
		String transactionType;
		transactionType = transaction.isHighPriority() ? "ANY" :  transaction.getTransactionType();
		int requiredIndex = 0;
		transaction.setTransactionFee(this.charges.get(transactionType).get(requiredIndex).get(transaction.isHighPriority()));
	}

	private void checkAndAddIntraDay(Transaction transaction, String identifier) {
		String counterType;
		counterType = transaction.getTransactionType().equals("BUY") ? "SELL" : "BUY";

		String key = identifier + counterType;
		if (this.store.containsKey(key)) {
			Transaction tr = this.store.get(key);
			tr.setTransactionFee(tr.getTransactionFee() + INTRA_DAY_CHARGE);
			transaction.setTransactionFee(transaction.getTransactionFee() + INTRA_DAY_CHARGE);
		}

	}

	private void addCharge(Boolean isHighPriority, String transactionType, Float value) {
		HashMap<Boolean, Float> innerMap = new HashMap<>();
		innerMap.put(isHighPriority, value);
		ArrayList<HashMap<Boolean, Float>> list = this.charges.get(transactionType);
		if (list == null) {
			list = new ArrayList<>();
		}
		list.add(innerMap);
		this.charges.put(transactionType, list);
	}

	private void initializeCharges() {
		this.addCharge(true, "ANY", (float) 500);
		this.addCharge(false, "SELL", (float) 100);
		this.addCharge(false, "WITHDRAW", (float) 100);
		this.addCharge(false, "BUY", (float) 50);
		this.addCharge(false, "DEPOSIT", (float) 50);
	}
	
	public void showFinalFees(ArrayList<Transaction> transactions) {
		for (Transaction transaction : transactions) {			
			System.out.println(transaction.getTransactionFee());
		}
	}

}
