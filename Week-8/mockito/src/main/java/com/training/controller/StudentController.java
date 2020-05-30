package com.training.controller;

import com.training.exceptions.NameNotValidException;
import com.training.model.Student;
import com.training.service.StudentService;

public class StudentController {
	
	StudentService service;
	
	public Student insertStudent(Student student) throws NameNotValidException {
		service = new StudentService();
		return service.insertStudent(student);
	}

}
