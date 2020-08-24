package com.sapient.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {
	
	public ArrayList<String[]> readCSVFile(String csvFile){
		final String delimiter = ",";
		ArrayList<String[]> entries = new ArrayList<>();

		try {
			File file = new File(csvFile);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			br.readLine(); // to skip header in csv
			while((line = br.readLine()) != null) {
				 line = line.replace("\"", "");
				entries.add(line.split(delimiter));
			}
			br.close();
			return entries;
		}catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
