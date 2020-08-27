package com.sapient.dao;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.sapient.models.Datum;
import com.sapient.utils.Writer;
import com.sapient.utils.Filename;
import com.sapient.utils.Reader;
import static com.sapient.utils.Constants.FX_USD;

public class DatumDAO {

	private ArrayList<Datum> data;
	private ArrayList<Datum> groupedData;

	public DatumDAO() {
		super();
		this.data = new ArrayList<Datum>();
		this.groupedData = new ArrayList<>();
	}

	public void readDataFromFile(String file) {

		String fileExtension = Filename.getFileExtension(file);

		switch (fileExtension) {
		case "csv":
			ArrayList<String[]> entries = new ArrayList<>();
			entries = Reader.readCSVFile(file);
			for (String[] entry : entries) {
				Datum datum = new Datum();
				datum.setCity(entry[0]);
				datum.setCountry(entry[1]);
				datum.setGender(entry[2]);
				datum.setCurrency(entry[3]);
				datum.setAvgIncome(new BigDecimal(entry[4]));
				datum.setAvgIncomeInUsd(new BigDecimal(Float.parseFloat(entry[4]) / FX_USD.get(datum.getCurrency())));
				this.data.add(datum);
			}
			System.out.println("Read all data from file");
			break;

		default:
			break;
		}
	}

	public Map<Object, Map<Object, String>> groupByGenderAndCountry() {
		Map<Object, Map<Object, String>> group = this.data.stream().filter(d -> !d.getCountry().equals(""))
				.collect(Collectors.groupingBy(d -> d.getCountry(), Collectors.groupingBy(d -> d.getGender(),
						Collectors.mapping(d -> d.getAvgIncomeInUsd().toString(), Collectors.joining(", ")))));
		
		Set<Datum> cityList = this.data.stream().filter(d -> d.getCountry().equals("")).collect(Collectors.toSet());
		
		for (Datum d : cityList) {
			Map<Object, String> innerMap = this.data.stream().filter(p -> p.getCity().equals(d.getCity()))
					.collect(Collectors.groupingBy(p -> p.getGender(),
							Collectors.mapping(p -> p.getAvgIncomeInUsd().toString(), Collectors.joining(", "))));
			group.put(d.getCity(), innerMap);
		}
		return group;
	}

	
	public void generatePerCapitaIncomeGroup(Map<Object, Map<Object, String>> group){
		for(Map.Entry<Object, Map<Object,String>> entry : group.entrySet()) {
			String country = entry.getKey().toString();
			Map<Object,String> genderMap = entry.getValue();
			for(Map.Entry<Object, String> gender : genderMap.entrySet()) {
				String[] income = gender.getValue().split(", ");
				Datum datum = new Datum();
				datum.setCountry(country);
				datum.setGender(gender.getKey().toString());
				Double sum = 0.0;
				for(int i=0; i<income.length; i++) {
					sum += Double.parseDouble(income[i]);
				}
				BigDecimal avg = new BigDecimal(sum/income.length);
				datum.setAvgIncomeInUsd(avg);
				this.groupedData.add(datum);
			}
		}
	}
	
	public void exportReportToFile(String file, String fileType) {
		switch (fileType.toLowerCase()) {
		case "csv":
			String header = "City/Country, Gender, Average Income(in USD)";
			Writer.writeToCsv(file,header, this.groupedData);
			System.out.println("Wrote result to result.csv");
			break;

		default:
			break;
		}

	}

}
