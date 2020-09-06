package com.sapient.dtcspring.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.dtc.utils.Date;
import com.sapient.dtcspring.model.History;
import com.sapient.dtcspring.model.Option;
import com.sapient.dtcspring.repository.HistoryRepository;
import com.sapient.dtcspring.repository.OptionRepository;
import com.sapient.dtcspring.services.DTCService;


@RestController
@RequestMapping("/api")
public class Calculator {
	
	@Autowired
	private OptionRepository optionRepository;
	private DTCService service;
	private HistoryRepository historyRepository;
	
	@PostMapping("/options")
	public Option addOption(@RequestBody Option option) {
		return optionRepository.save(option);
	}
	
	@GetMapping("/options")
	public List<Option> getAllOptions(){
		return optionRepository.findAll();
	}
	
	@PostMapping("/option/subtractTwoDates")
	public String subtractTwoDates(@RequestBody String date1, @RequestBody String date2){
		LocalDate dateA = Date.formatDate(date1);
		LocalDate dateB = Date.formatDate(date2);
		String result = service.subtractTwoDates(dateA, dateB);
		History history = new History();
		history.addDate(dateA);
		history.addDate(dateB);
		history.setOperationName("Subtract Two Dates");
		history.setResult(result);
		historyRepository.save(history);
		return result;
	}
	
	@PostMapping("/option/addNDays")
	public String addNDays(@RequestBody String date, @RequestBody Integer manipulator ) {
		LocalDate newDate = Date.formatDate(date);
		LocalDate result = service.addDaysToDate(newDate, manipulator);
		History history = new History();
		history.addDate(newDate);
		history.setManipulator(manipulator);
		history.setOperationName("Add N Days");
		history.setResult(result.toString());
		historyRepository.save(history);
		return result.toString();
	}
	
	@PostMapping("/option/subtractNMonths")
	public String subtractNMonths(@RequestBody String date, @RequestBody Integer manipulator ) {
		LocalDate newDate = Date.formatDate(date);
		LocalDate result = service.subtractMonthsFromDate(newDate, manipulator);
		History history = new History();
		history.addDate(newDate);
		history.setManipulator(manipulator);
		history.setOperationName("Subtract N Months");
		history.setResult(result.toString());
		historyRepository.save(history);
		return result.toString();
	}

}
