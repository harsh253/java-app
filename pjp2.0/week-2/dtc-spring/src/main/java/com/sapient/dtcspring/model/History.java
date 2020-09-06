package com.sapient.dtcspring.model;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="histories")
public class History {
	
	private long id;
	private ArrayList<LocalDate> dates;
	private String operationName;
	private String result;
	private Integer manipulator;
	
	
	public History() {
		super();
		this.dates = new ArrayList<>();
	}
	
	@Column(name="operation_name", nullable=false)
	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	@Column(name="result", nullable=false)
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Column(name="manipulator")
	public Integer getManipulator() {
		return manipulator;
	}

	public void setManipulator(Integer manipulator) {
		if(manipulator == null) {
			throw new IllegalArgumentException();
		}
		this.manipulator = manipulator;
	}
	
	public void addDate(LocalDate date) {
		this.dates.add(date);
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	

	public ArrayList<LocalDate> getDates() {
		return dates;
	}

	public void setDates(ArrayList<LocalDate> dates) {
		this.dates = dates;
	}

	public String showResult() {
		String output = "";
		output+="Operation: " + this.operationName + "\n" + "Date(s): ";
		for(LocalDate date: this.dates) {
			output+= date + " ";
		}
		output+="\n";
		if(this.manipulator != null) {
			output+="Manipulated by: " + this.manipulator + "\n";
		}
		output+="Result: " + this.result + "\n";
		return output;
	}

}
