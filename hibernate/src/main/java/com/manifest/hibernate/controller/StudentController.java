package com.manifest.hibernate.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manifest.hibernate.model.Student;
import com.manifest.hibernate.service.StudentService;


@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	// Create a students
	@PostMapping("/students")
	public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
		Student newStudent = studentService.createStudent(student);	
		return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
	}
	
	// Get all students
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents() {
		return ResponseEntity.ok(studentService.getAllStudents());
	}
	
	// Get student by ID
	
	// Update student by ID
	
	// Delete student by ID
	
	
}
