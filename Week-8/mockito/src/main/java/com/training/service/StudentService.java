package com.training.service;

import com.training.dao.StudentDao;
import com.training.exceptions.NameNotValidException;
import com.training.interfaces.IStudentService;
import com.training.model.Student;

public class StudentService implements IStudentService{

	public Student insertStudent(Student student) throws NameNotValidException{
		if(student.getName().length() < 4) {
			throw new NameNotValidException("Length should be greater than 4");
		}else {
			StudentDao.insertStudentToDB(student);
			return student;
		}
	}
}
