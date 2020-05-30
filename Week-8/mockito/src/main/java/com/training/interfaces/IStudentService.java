package com.training.interfaces;

import com.training.exceptions.NameNotValidException;
import com.training.model.Student;

public interface IStudentService {
	public Student insertStudent(Student student) throws NameNotValidException;

}
