package com.training.tests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.training.exceptions.NameNotValidException;
import com.training.model.Student;
import com.training.service.StudentService;

@RunWith(MockitoJUnitRunner.class)
public class StudentTest {

	Student student = mock(Student.class);
	StudentService service = mock(StudentService.class);
	
	@Before
	public void setUp() throws Exception {
		student = new Student(1, "John Doe");
	}

	@Test
	public void test() throws NameNotValidException {
		when(service.insertStudent(student)).thenReturn(student);
	}

}
