package com.manifest.hibernate.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.manifest.hibernate.model.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {
	
	@InjectMocks
	Student student;
	
	@Mock
	StudentService studentService;
	
	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void createStudentTest() {
		Student jane = new Student(1, "Jane", "Doe", "jd123@gmail.com", 3.95);
		studentService.createStudent(jane);
		verify(studentService, times(1)).createStudent(jane);
	}
	
	@Test
	public void getAllStudentsTest() {
		List<Student> students = new ArrayList<Student>();
		Student jane = new Student(1, "Jane", "Doe", "jd123@gmail.com", 3.95);
		Student dane = new Student(1, "Dane", "Joe", "dj123@gmail.com", 1.54);
		students.add(jane);
		students.add(dane);
		
		when(studentService.getAllStudents()).thenReturn(students);
		
		List<Student> allStudents = studentService.getAllStudents();
		assertEquals(2, allStudents.size());
		verify(studentService, times(1)).getAllStudents();
	}
	
	// Read a student
	
	// Update a student
	
	// Delete a student
	
}
