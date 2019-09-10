package com.manifest.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manifest.hibernate.model.Student;
import com.manifest.hibernate.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	// Create a student
	public Student createStudent(Student student) {
		Student newStudent = studentRepository.save(student);
		return newStudent;
	}
	
	// Get all students
	public List<Student> getAllStudents() {
		List<Student> students = studentRepository.findAll();
		return students;
	}
	
	// Get student by ID
	
	// Update student by ID
	
	// Delete student by ID
	
}
