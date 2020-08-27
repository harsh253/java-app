package com.sapient.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.sapient.models.Datum;

public class Writer {
	
	public static void writeToCsv(String file, String header, ArrayList<Datum> list ) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file+".csv"));
			bw.write(header);
			bw.newLine();
			for (Datum datum: list) {
				String country = datum.getCountry();
				String gender = datum.getGender();
				String avgIncome = datum.getAvgIncomeInUsd().toString();
				String line = String.format("%s, %s, %s", country, gender, avgIncome);
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
